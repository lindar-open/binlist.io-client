package lindar.binlistio.api;

import lindar.binlistio.model.BinListIoCardDetails;

import java.util.Optional;

public class BinListIoClient {

    private BinListIoLookupResource lookupResource;

    public BinListIoClient() {
        BinListIoLookupResource lookupResource = new BinListIoLookupResource();

        this.lookupResource = lookupResource;
    }

    public Optional<BinListIoCardDetails> lookupBinNumberIo(String binNumber) {
        return lookupResource.lookupBinNumberIo(binNumber);
    }

}
