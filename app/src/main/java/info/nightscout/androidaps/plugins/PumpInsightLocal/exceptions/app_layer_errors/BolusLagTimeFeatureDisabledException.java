package info.nightscout.androidaps.plugins.PumpInsightLocal.exceptions.app_layer_errors;

public class BolusLagTimeFeatureDisabledException extends AppLayerErrorException {

    public BolusLagTimeFeatureDisabledException(int errorCode) {
        super(errorCode);
    }
}
