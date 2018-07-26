package pl.edu.agh.wiet.sr.banking.bank;

import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.agh.wiet.sr.banking.bank.account.AccountServiceI;
import pl.edu.agh.wiet.sr.banking.bank.currency.CurrencyServiceClient;


import static pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.*;

public class Bank {
    private static final Logger log = LoggerFactory.getLogger(Bank.class);

    public static void main(String[] args) {
        int port = 10000;
        if(args.length >= 1) {
            port = Integer.parseInt(args[0]);
            log.info("Using port " + args[0] + " for ICE adapter");
        } else {
            log.info("No port provided, using default value...");
        }

        Configurator.setRootLevel(Level.INFO);
        CurrencyServiceClient currencyClient = new CurrencyServiceClient("localhost", 50051);
        startCurrencyListeners(currencyClient);
        startBankingServices(Config.HOST, port, currencyClient);
    }

    private static void startCurrencyListeners(CurrencyServiceClient currencyClient) {
        currencyClient.listenOnCurrency(Currency.USD);
        currencyClient.listenOnCurrency(Currency.EUR);
        currencyClient.listenOnCurrency(Currency.CHF);
    }

    private static void startBankingServices(String host, int port, CurrencyServiceClient currencyClient) {
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize())
        {
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("AccountServiceAdapter",
                    String.format("tcp -h %s -p %d:udp -h %s -p %d", host, port, host, port));
            com.zeroc.Ice.Object accountService = new AccountServiceI(adapter, currencyClient);
            adapter.add(accountService, new Identity("AccountService", "services"));
            adapter.activate();
            communicator.waitForShutdown();
        }
    }
}
