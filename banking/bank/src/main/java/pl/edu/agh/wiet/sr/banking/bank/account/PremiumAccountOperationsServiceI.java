package pl.edu.agh.wiet.sr.banking.bank.account;

import com.zeroc.Ice.Current;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.agh.wiet.sr.banking.bank.Config;
import pl.edu.agh.wiet.sr.banking.bank.currency.CurrencyServiceClient;
import pl.edu.agh.wiet.sr.banking.generated.model.Account;
import pl.edu.agh.wiet.sr.banking.generated.services.*;

public class PremiumAccountOperationsServiceI extends StandardAccountOperationsServiceI implements PremiumAccountOperationsService {

    private static final Logger log = LoggerFactory.getLogger(PremiumAccountOperationsServiceI.class);
    private final CurrencyServiceClient currencyClient;

    public PremiumAccountOperationsServiceI(Account account, CurrencyServiceClient currencyClient) {
        super(account);
        this.currencyClient = currencyClient;
    }

    @Override
    public CreditEnquiryResponse askForCredit(CreditRequest request, String password, Current current)
            throws PermissionDeniedException {
        log.info("Credit request from " + account.owner.firstName + " " + account.owner.surname);
        AuthUtils.checkPassword(password, account.password);
        final double rate = currencyClient.getRateValue(request.currency);
        double valueInCreditCurrency = request.value;
        double commissionInCreditCurrency = Config.COMMISION_COEFF * request.value * request.installmentsNumber / 12;
        return new CreditEnquiryResponse(
                Config.BASE_CURRENCY_ICE,
                rate * valueInCreditCurrency,
                rate * commissionInCreditCurrency,
                request.currency,
                valueInCreditCurrency,
                commissionInCreditCurrency);
    }
}
