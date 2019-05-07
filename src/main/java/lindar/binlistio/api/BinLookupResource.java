package lindar.binlistio.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lindar.wellrested.WellRestedRequest;
import com.lindar.wellrested.vo.WellRestedResponse;
import lindar.acolyte.util.UrlAcolyte;
import lindar.acolyte.vo.Pair;
import lindar.binlistio.model.PaymentCardDetails;

import java.util.Optional;

public class BinLookupResource {
    private static final String BIN_LIST_IO_URL = "https://binlist.io/wp-json/binlist/v1/{bin}";
    private static final String NONCE_PARAM     = "_wpnonce";

    private String nonceValue;
    private Gson   gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    public Optional<PaymentCardDetails> lookupBinNumber(String binNumber) {
        String url = UrlAcolyte.replacePathParamsByName(BIN_LIST_IO_URL, Pair.of("bin", binNumber));
        url = UrlAcolyte.addParam(url, NONCE_PARAM, nonceValue);

        WellRestedRequest request = WellRestedRequest.builder()
                                                     .url(url)
                                                     .disableCookiesForAuthRequests()
                                                     .build();
        WellRestedResponse response = request.get().submit();

        try {
            return Optional.of(gson.fromJson(response.getServerResponse(), PaymentCardDetails.class));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public void setNonceValue(String nonceValue) {
        this.nonceValue = nonceValue;
    }

}
