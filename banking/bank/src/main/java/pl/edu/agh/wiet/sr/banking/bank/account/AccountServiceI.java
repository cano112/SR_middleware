package pl.edu.agh.wiet.sr.banking.bank.account;

import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import pl.edu.agh.wiet.sr.banking.bank.Config;
import pl.edu.agh.wiet.sr.banking.bank.currency.CurrencyServiceClient;
import pl.edu.agh.wiet.sr.banking.generated.model.*;
import pl.edu.agh.wiet.sr.banking.generated.services.AccountService;
import pl.edu.agh.wiet.sr.banking.generated.services.BadRequestException;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class AccountServiceI implements AccountService {

    private final ObjectAdapter adapter;
    private final CurrencyServiceClient currencyClient;
    private AtomicLong lastAccountId;

    public AccountServiceI(ObjectAdapter adapter, CurrencyServiceClient currencyClient) {
        this.adapter = adapter;
        this.currencyClient = currencyClient;
        this.lastAccountId = new AtomicLong(0);
    }

    @Override
    public pl.edu.agh.wiet.sr.banking.generated.services.AccountOpenResponse openAccount(
            pl.edu.agh.wiet.sr.banking.generated.services.AccountOpenRequest request,
            Current current) throws BadRequestException {
        Account account;
        String password = UUID.randomUUID().toString();
        long accountId = lastAccountId.incrementAndGet();
        if(request.declaredIncome >= Config.PREMIUM_DECLARED_INCOME_LIMIT) {
            account = new PremiumAccount(
                    accountId,
                    new PersonDetails(request.firstName, request.surname, request.pesel),
                    request.declaredIncome,
                    0,
                    password);
            PremiumAccountOperationsServiceI object =
                    new PremiumAccountOperationsServiceI(account, currencyClient);
            adapter.add(object, new Identity(account.owner.pesel, AccountType.PREMIUM.name()));
            return new pl.edu.agh.wiet.sr.banking.generated.services.AccountOpenResponse(accountId, password, AccountType.PREMIUM);
        } else if(request.declaredIncome >= 0){
            account = new StandardAccount(
                    accountId,
                    new PersonDetails(request.firstName, request.surname, request.pesel),
                    request.declaredIncome,
                    0,
                    password);
            StandardAccountOperationsServiceI object =
                    new StandardAccountOperationsServiceI(account);
            adapter.add(object, new Identity(account.owner.pesel, AccountType.STANDARD.name()));
            return new pl.edu.agh.wiet.sr.banking.generated.services.AccountOpenResponse(accountId, password, AccountType.STANDARD);
        } else {
            throw new BadRequestException("Declared income cannot be lower than 0");
        }
    }
}
