package lindar.binlistio.model;

import lombok.Data;

@Data
public class PaymentCardDetails {
    private Long   bin;
    private String paymentSystem;
    private String cardType;
    private String cardLevel;

    private String countryName;

    private String bankIssuer;
}
