package lindar.binlistio.model;

import lombok.Data;

@Data
public class CardNumber {

    private String  iin;
    private Long    length;
    private Boolean luhn;

}
