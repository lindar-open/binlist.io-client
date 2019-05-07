package lindar.binlistio.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BinListIoCardDetails {
    private String paymentSystem;
    private String cardType;
    private String cardLevel;

    private String countryName;

    @SerializedName("bank_issuer")
    private String bankName;
}
