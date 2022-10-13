package webPhptravel.utils.enums;

public enum CurrencyEnum {
    GBP("GBP"),
    SAR("SAR"),
    EUR("EUR"),
    PKR("PKR"),
    JPY("JPY"),
    INR("INR"),
    CNY("CNY"),
    TRY("TRY"),
    RUB("RUB"),
    IRR("IRR"),
    MAD("MAD"),
    USD("USD");

    private String currency;

    CurrencyEnum(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
