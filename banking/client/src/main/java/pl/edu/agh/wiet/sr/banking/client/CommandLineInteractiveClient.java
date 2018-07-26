package pl.edu.agh.wiet.sr.banking.client;

import com.zeroc.Ice.ObjectNotExistException;
import com.zeroc.Ice.ObjectPrx;
import pl.edu.agh.wiet.sr.banking.generated.model.AccountType;
import pl.edu.agh.wiet.sr.banking.generated.model.Currency;
import pl.edu.agh.wiet.sr.banking.generated.services.*;

import java.util.Scanner;

public class CommandLineInteractiveClient {

    private final String[] args;
    private final  Scanner in = new Scanner(System.in);
    private final String host;
    private final int port;

    private StandardAccountOperationsServicePrx accountOperationsService;
    private String password;

    public CommandLineInteractiveClient(String[] args, String host, int port) {
        this.args = args;
        this.host = host;
        this.port = port;
    }

    public void run() {
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args)) {
            LOOP: while(true) {
                try {
                    if(accountOperationsService == null) {
                        // NOT LOGGED IN
                        printFirstLevelMenu();
                        String op = in.nextLine();
                        switch(op) {
                            case "1":
                                openAccountOperation(communicator);
                                break;
                            case "2":
                                logIntoAccountOperation(communicator);
                                break;
                            case "x":
                                break LOOP;
                            default:
                        }
                    } else {
                        // LOGGED IN
                        printSecondLevelMenu();
                        String op = in.nextLine();
                        switch (op) {
                            case "1":
                                checkBalanceOperation();
                                break;
                            case "2":
                                creditOperation();
                                break;
                            case "l":
                                logoutOperation();
                                break;
                            case "x":
                                break LOOP;
                            default:
                        }
                    }
                } catch(Exception e) {
                    System.err.println("Error occurred: " + e.getClass().getName());
                }
            }
        }
    }

    private void printFirstLevelMenu() {
        System.out.println("----------------");
        System.out.println("[1] Open account");
        System.out.println("[2] Log into account");
        System.out.println("[x] Exit");
        System.out.println("----------------");
    }

    private void printSecondLevelMenu() {
        System.out.println("----------------");
        System.out.println("[1] Check balance");
        if(isPremiumAccount()) System.out.println("[2] Credit");
        System.out.println("[l] Logout");
        System.out.println("[x] Exit");
        System.out.println("----------------");
    }

    private void checkBalanceOperation() {
        if(accountOperationsService == null || this.password == null) {
            System.err.println("You are not logged in!");
        }

        try {
            BalanceResponse response = accountOperationsService.getBalance(this.password);
            System.out.println("Your balance is: " + response.balance + " " + response.currency.name());
        } catch (PermissionDeniedException e) {
            System.err.println("Your password is incorrect!");
        }
    }

    private void logoutOperation() {
        this.accountOperationsService = null;
        this.password = null;
    }

    private void creditOperation() {
        if(!isPremiumAccount()) {
            System.err.println("Premium account required");
        }

        PremiumAccountOperationsServicePrx service = (PremiumAccountOperationsServicePrx) accountOperationsService;

        System.out.print("Currency [PLN/USD/CHF/EUR]:");
        Currency currency = Currency.valueOf(in.nextLine());

        System.out.print("Value:");
        final double value = Double.parseDouble(in.nextLine());

        System.out.print("Installments number:");
        final int installmentsNumber = Integer.parseInt(in.nextLine());

        CreditRequest request = new CreditRequest(currency, value, installmentsNumber);
        try {
            CreditEnquiryResponse response = service.askForCredit(request, password);
            System.out.println("Value: " + response.valueInCreditCurrency + " " + response.creditCurrency
                    + " (" + response.valueInBaseCurrency + " " + response.baseCurrency + ")");
            System.out.println("Commission: " + response.commissionInCreditCurrency + " " + response.creditCurrency
                    + " (" + response.commissionInBaseCurrency + " " + response.baseCurrency + ")");
        } catch (PermissionDeniedException e) {
            System.err.println("Your password is incorrect!");
        }
    }

    private void openAccountOperation(com.zeroc.Ice.Communicator communicator) {
        AccountServicePrx accountService = getAccountService(host, port, communicator);

        final String firstName;
        final String surname;
        final String pesel;
        final double declaredIncome;

        System.out.print("First name: ");
        firstName = in.nextLine();

        System.out.print("Surname: ");
        surname = in.nextLine();

        System.out.print("PESEL: ");
        pesel = in.nextLine();

        System.out.print("Declared income: ");
        declaredIncome = Double.parseDouble(in.nextLine());


        AccountOpenRequest request = new AccountOpenRequest(firstName, surname, pesel, declaredIncome);
        try {
            AccountOpenResponse response = accountService.openAccount(request);
            System.out.println("Account with id: " + response.userId + " created.");
            System.out.println("Account type: " + response.accountType.name());
            System.out.println("Password: " + response.password);

        } catch (BadRequestException e) {
            System.err.println("Cannot create account: " + e.reason);
        } catch (Exception e) {
            System.err.println("Cannot create account: " + e.getClass().getName());
        }
    }

    private void logIntoAccountOperation(com.zeroc.Ice.Communicator communicator) {
        System.out.print("Account type [S/P]: ");
        final AccountType accountType = in.nextLine().equals("P") ? AccountType.PREMIUM : AccountType.STANDARD;

        System.out.print("PESEL: ");
        final String pesel = in.nextLine();

        System.out.print("Password: ");
        final String password = in.nextLine();

        try {
            accountOperationsService = getAccountOperationsService(host, port, communicator, accountType, pesel, password);
            System.out.println("You have logged in");
            this.password = password;
        } catch (BadRequestException e) {
           System.err.println("Cannot log in: " + e.reason);
        } catch (ObjectNotExistException e) {
            System.err.println("Cannot log in: no such account registered");
        }
    }

    private AccountServicePrx getAccountService(String host, int port, com.zeroc.Ice.Communicator communicator) {
        ObjectPrx base = communicator.stringToProxy("services/AccountService:" +
                String.format("tcp -h %s -p %d:udp -h %s -p %d", host, port, host, port));
        AccountServicePrx accountServiceProxy = AccountServicePrx.checkedCast(base);
        if (accountServiceProxy == null) {
            throw new Error("Invalid proxy");
        }
        return accountServiceProxy;
    }

    private StandardAccountOperationsServicePrx getAccountOperationsService(
            String host,
            int port,
            com.zeroc.Ice.Communicator communicator,
            AccountType accountType,
            String pesel,
            String password) throws BadRequestException {
        ObjectPrx base = communicator.stringToProxy(accountType.name() + "/" + pesel + ":" +
                String.format("tcp -h %s -p %d:udp -h %s -p %d", host, port, host, port));
        StandardAccountOperationsServicePrx proxy;
        if(accountType == AccountType.STANDARD) {
           proxy  = StandardAccountOperationsServicePrx.checkedCast(base);
        } else {
            proxy = PremiumAccountOperationsServicePrx.checkedCast(base);
        }
        if (proxy == null) {
            throw new Error("Invalid proxy");
        }

        if(!proxy.checkAccess(password)) {
            throw new BadRequestException("Incorrect password");
        }
        return proxy;
    }

    private boolean isPremiumAccount() {
        return accountOperationsService != null && accountOperationsService instanceof PremiumAccountOperationsServicePrx;
    }
}
