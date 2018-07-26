package pl.edu.agh.wiet.sr.banking.bank.account;

import com.zeroc.Ice.Current;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.agh.wiet.sr.banking.bank.Config;
import pl.edu.agh.wiet.sr.banking.generated.model.Account;
import pl.edu.agh.wiet.sr.banking.generated.services.BalanceResponse;
import pl.edu.agh.wiet.sr.banking.generated.services.PermissionDeniedException;
import pl.edu.agh.wiet.sr.banking.generated.services.StandardAccountOperationsService;

public class StandardAccountOperationsServiceI implements StandardAccountOperationsService {
    private static final Logger log = LoggerFactory.getLogger(StandardAccountOperationsServiceI.class);
    protected final Account account;

    public StandardAccountOperationsServiceI(Account account) {
        this.account = account;
    }

    @Override
    public BalanceResponse getBalance(String password, Current current) throws PermissionDeniedException {
        log.info("Balance request from " + account.owner.firstName + " " + account.owner.surname);
        AuthUtils.checkPassword(password, account.password);
        return new BalanceResponse(Config.BASE_CURRENCY_ICE, account.balance);
    }

    @Override
    public boolean checkAccess(String password, Current current) {
        return account.password != null && account.password.equals(password);
    }
}
