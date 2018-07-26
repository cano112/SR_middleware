module pl {
    module edu {
        module agh {
            module wiet {
                module sr {
                    module banking {
                        module generated {
                            module model {
                                    enum Currency {
                                        USD,
                                        EUR,
                                        PLN,
                                        CHF
                                    }

                                    enum AccountType {
                                        STANDARD,
                                        PREMIUM
                                    }

                                    struct PersonDetails {
                                        string firstName;
                                        string surname;
                                        string pesel;
                                    }

                                    class Account {
                                        long accountId;
                                        PersonDetails owner;
                                        double declaredIncome;
                                        double balance;
                                        string password;
                                    }

                                    class StandardAccount extends Account {}
                                    class PremiumAccount extends Account {}
                                }

                            module services {

                                exception ExceptionWithReason {
                                    string reason;
                                }

                                exception BadRequestException extends ExceptionWithReason {}

                                exception PermissionDeniedException extends ExceptionWithReason {}

                                struct AccountOpenRequest {
                                    string firstName;
                                    string surname;
                                    string pesel;
                                    double declaredIncome;
                                }

                                struct AccountOpenResponse {
                                    long userId;
                                    string password;
                                    model::AccountType accountType;
                                }

                                interface AccountService {
                                    AccountOpenResponse openAccount(AccountOpenRequest request) throws BadRequestException;
                                }

                                struct CreditEnquiryResponse {
                                    model::Currency baseCurrency;
                                    double valueInBaseCurrency;
                                    double commissionInBaseCurrency;
                                    model::Currency creditCurrency;
                                    double valueInCreditCurrency;
                                    double commissionInCreditCurrency;
                                }

                                struct CreditRequest {
                                    model::Currency currency;
                                    double value;
                                    int installmentsNumber;
                                }

                                struct BalanceResponse {
                                    model::Currency currency;
                                    double balance;
                                }

                                interface StandardAccountOperationsService {
                                    BalanceResponse getBalance(string password) throws PermissionDeniedException;
                                    bool checkAccess(string password);
                                }

                                interface PremiumAccountOperationsService extends StandardAccountOperationsService {
                                    CreditEnquiryResponse askForCredit(CreditRequest request, string password) throws PermissionDeniedException;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


