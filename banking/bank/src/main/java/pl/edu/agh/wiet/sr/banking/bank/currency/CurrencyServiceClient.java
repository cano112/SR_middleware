package pl.edu.agh.wiet.sr.banking.bank.currency;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceGrpc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pl.edu.agh.wiet.sr.banking.bank.Config;

import static pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.*;

public class CurrencyServiceClient {

    private static final Logger log = LoggerFactory.getLogger(CurrencyServiceClient.class);
    private final ManagedChannel channel;
    private final CurrencyServiceGrpc.CurrencyServiceStub asyncStub;
    private final Map<Currency, Rate> rateMap;

    public CurrencyServiceClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext(true));
    }

    public CurrencyServiceClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        asyncStub = CurrencyServiceGrpc.newStub(channel);
        rateMap = initializeRateMap();
    }


    private Map<Currency, Rate> initializeRateMap() {
        Map<Currency, Rate> rateMap = new ConcurrentHashMap<>();
        rateMap.put(Config.BASE_CURRENCY_GRPC, Rate.newBuilder().setValue(1.0).build());
        for(Currency currency : Currency.values()) {
            if(currency != Config.BASE_CURRENCY_GRPC) {
                rateMap.put(currency, Rate.newBuilder().setValue(-1.0).build());
            }
        }
        return rateMap;
    }

    public void listenOnCurrency(Currency currency) {
        CurrencyRequest request = CurrencyRequest
                .newBuilder()
                .setCurrencyFrom(currency)
                .setCurrencyTo(Config.BASE_CURRENCY_GRPC)
                .build();

        StreamObserver<Rate> rateObserver = new StreamObserver<Rate>() {
            @Override
            public void onNext(Rate value) {
                log.info("New rate for " + currency.name() + ": " + value.getValue());
                rateMap.put(currency, value);
            }

            @Override
            public void onError(Throwable t) {
                log.error("Currency service failed for: " + currency.name(), t);
            }

            @Override
            public void onCompleted() {
                log.warn("Currency service for " + currency.name() + " has completed");
            }
        };
        asyncStub.getCurrencyRate(request, rateObserver);
        log.info("Started listening on currency: " + currency.name());
    }

    public double getRateValue(pl.edu.agh.wiet.sr.banking.generated.model.Currency currency) {
        return this.rateMap.get(Currency.valueOf(currency.name())).getValue();
    }
}
