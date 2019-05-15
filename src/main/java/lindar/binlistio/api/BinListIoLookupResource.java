package lindar.binlistio.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lindar.wellrested.WellRestedRequest;
import com.lindar.wellrested.vo.WellRestedResponse;
import lindar.acolyte.util.UrlAcolyte;
import lindar.acolyte.vo.Pair;
import lindar.binlistio.model.BinListIoCardDetails;

import java.util.Optional;

class BinListIoLookupResource {
    private static final String BIN_LIST_IO_URL = "https://binlist.io/lookup/{bin}";

    private Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    BinListIoLookupResource() {
    }

    Optional<BinListIoCardDetails> lookupBinNumberIo(String binNumber) {
        String url = UrlAcolyte.replacePathParamsByName(BIN_LIST_IO_URL, Pair.of("bin", binNumber));

        WellRestedRequest request = WellRestedRequest.builder()
                                                     .url(url)
                                                     .disableCookiesForAuthRequests()
                                                     .build();
        WellRestedResponse response = request.get().submit();

        try {
            return Optional.of(gson.fromJson(response.getServerResponse(), BinListIoCardDetails.class));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

}
