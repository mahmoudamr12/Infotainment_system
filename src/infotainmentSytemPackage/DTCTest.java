package infotainmentSytemPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class DTCTest {

    @Test
    public void testSetDTC() {
        DTC dtc = new DTC();
        dtc.setDTC("B91212", StatusCode.CONFIRMED_AND_FAILED);
        assertEquals(StatusCode.CONFIRMED_AND_FAILED, dtc.getDTC("B91212"));
    }

    @Test
    public void testGetDTC() {
        DTC dtc = new DTC();
        dtc.setDTC("B91214", StatusCode.NO_ISSUE);
        assertEquals(StatusCode.NO_ISSUE, dtc.getDTC("B91214"));
    }

    @Test
    public void testCheckDTCWithFailure() {
        DTC dtc = new DTC();
        dtc.setDTC("B91212", StatusCode.CONFIRMED_AND_FAILED);
        assertTrue(dtc.checkDTC());
    }

    @Test
    public void testCheckDTCWithoutFailure() {
        DTC dtc = new DTC();
        dtc.setDTC("B91214", StatusCode.NO_ISSUE);
        assertFalse(dtc.checkDTC());
    }

    @Test
    public void testDisplayDTC() {
        DTC dtc = new DTC();
        dtc.setDTC("B91212", StatusCode.CONFIRMED_AND_FAILED);
        dtc.setDTC("B91214", StatusCode.NO_ISSUE);

        String expectedDisplay = "B91212: 0x9\nB91214: 0x0\n";
        assertEquals(expectedDisplay, dtc.displayDTC());
    }

    @Test
    public void testResetDTC() {
        DTC dtc = new DTC();
        dtc.setDTC("B91212", StatusCode.CONFIRMED_AND_FAILED);
        dtc.setDTC("B91214", StatusCode.CONFIRMED_AND_FAILED);
        dtc.resetDTC();
        assertEquals(StatusCode.NO_ISSUE, dtc.getDTC("B91212"));
        assertEquals(StatusCode.NO_ISSUE, dtc.getDTC("B91214"));
    }
}
