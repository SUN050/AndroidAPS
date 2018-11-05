package info.nightscout.androidaps.plugins.PumpDanaRS.comm;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import info.AAPSMocker;
import info.nightscout.androidaps.MainApp;
import info.nightscout.androidaps.logging.L;
import info.nightscout.androidaps.plugins.PumpDanaR.DanaRPump;
import info.nightscout.utils.SP;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rumen on 06.08.2018.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({MainApp.class, SP.class, L.class})
public class DanaRS_Packet_Bolus_Get_Extended_Menu_Option_StateTest {

    @Test
    public void runTest() {
        AAPSMocker.mockMainApp();
        AAPSMocker.mockApplicationContext();
        AAPSMocker.mockSP();
        AAPSMocker.mockL();
        DanaRS_Packet_Bolus_Get_Extended_Menu_Option_State packet = new DanaRS_Packet_Bolus_Get_Extended_Menu_Option_State();

        // test params
        byte[] testparams = packet.getRequestParams();
        assertEquals(null, packet.getRequestParams());


        // test message decoding
        packet.handleMessage(createArray(34, (byte) 0));
        // isExtendedinprogres should be false
        DanaRPump testPump = DanaRPump.getInstance();
        assertEquals(false, testPump.isExtendedInProgress);
//        assertEquals(false, packet.failed);
        packet.handleMessage(createArray(34, (byte) 1));
        testPump = DanaRPump.getInstance();
        assertEquals(true, testPump.isExtendedInProgress);

        assertEquals("BOLUS__GET_EXTENDED_MENU_OPTION_STATE", packet.getFriendlyName());
    }

    byte[] createArray(int length, byte fillWith){
        byte[] ret = new byte[length];
        for(int i = 0; i<length; i++){
            ret[i] = fillWith;
        }
        return ret;
    }

    double[] createArray(int length, double fillWith){
        double[] ret = new double[length];
        for(int i = 0; i<length; i++){
            ret[i] = fillWith;
        }
        return ret;
    }
}
