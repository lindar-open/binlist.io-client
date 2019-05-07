package lindar.binlistio.api;

import lindar.binlistio.model.BinListIoCardDetails;

import java.util.Optional;

public class BinListIoClient {

    private BinListIoLookupResource lookupResource;

    public BinListIoClient(String nonce) {
        BinListIoLookupResource lookupResource = new BinListIoLookupResource(nonce);
        this.lookupResource = lookupResource;
    }

    public Optional<BinListIoCardDetails> lookupBinNumberIo(String binNumber) {
        return lookupResource.lookupBinNumberIo(binNumber);
    }

    public void updateNonceValue(String nonce) {
        lookupResource.setNonceValue(nonce);
    }

}
