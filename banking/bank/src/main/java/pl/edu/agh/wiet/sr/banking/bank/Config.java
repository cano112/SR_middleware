package pl.edu.agh.wiet.sr.banking.bank;

import static pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.*;

public class Config {
    public static Currency BASE_CURRENCY_GRPC = Currency.PLN;
    public static pl.edu.agh.wiet.sr.banking.generated.model.Currency BASE_CURRENCY_ICE =
            pl.edu.agh.wiet.sr.banking.generated.model.Currency.PLN;

    public static double PREMIUM_DECLARED_INCOME_LIMIT = 100000.0;
    public static double COMMISION_COEFF = 0.01;

    public static String HOST = "localhost";
}
