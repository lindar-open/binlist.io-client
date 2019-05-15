package lindar.binlistio.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BinListIoCardDetails {

    @SerializedName("scheme")
    private String paymentSystem;
    @SerializedName("type")
    private String cardType;
    @SerializedName("category")
    private String cardLevel;

    private CardCountry country;
    private CardBank    bank;
    private CardNumber  number;
}
