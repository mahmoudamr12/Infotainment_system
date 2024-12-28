package infotainmentSytemPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfoButtonTest {

	@Test
	public void testUpdateStates() {
		 InfoButton infoButton = new InfoButton();
		
	        infoButton.updateStates(60001);
	        assertEquals(Mute.NON_FUNCTIONAL, infoButton.getMuteStatus());
	        assertEquals(OnOff.NON_FUNCTIONAL, infoButton.getOnOffStatus());
	}
	@Test
	public void testUpdateStates_time_biggerthan_tlong() {
		 InfoButton infoButton = new InfoButton();
		 infoButton.setMuteStatus(Mute.NON_FUNCTIONAL);
		 infoButton.setOnOffStatus(OnOff.NON_FUNCTIONAL);

	        infoButton.updateStates(20001);
	        assertEquals(Mute.NON_FUNCTIONAL, infoButton.getMuteStatus());
	        assertEquals(Mute.FUNCTIONAL, infoButton.getMuteStatus());
	}
	@Test
	public void testUpdateStates_time_biggerthan_tlong_but_MUTE() {
		 InfoButton infoButton = new InfoButton();
		 infoButton.setMuteStatus(Mute.FUNCTIONAL);
		 infoButton.setOnOffStatus(OnOff.FUNCTIONAL);

	        infoButton.updateStates(20001);
	        assertEquals(Mute.FUNCTIONAL, infoButton.getMuteStatus());
	        assertEquals(Mute.NON_FUNCTIONAL, infoButton.getMuteStatus());
	}
	@Test
	public void testUpdateStates_time_biggerthan_tshort() {
		 InfoButton infoButton = new InfoButton();
		 infoButton.setOnOffStatus(OnOff.NON_FUNCTIONAL);
		 infoButton.setMuteStatus(Mute.NON_FUNCTIONAL);
	        infoButton.updateStates(1001);
	        assertEquals(OnOff.NON_FUNCTIONAL, infoButton.getOnOffStatus());
	        assertEquals(OnOff.FUNCTIONAL, infoButton.getOnOffStatus()); 
	}
	@Test
	public void testUpdateStates_time_biggerthan_tshort_non() {
		 InfoButton infoButton = new InfoButton();
		 infoButton.setOnOffStatus(OnOff.FUNCTIONAL);
		 infoButton.setMuteStatus(Mute.NON_FUNCTIONAL);
	        infoButton.updateStates(1001);
	        assertEquals(OnOff.FUNCTIONAL, infoButton.getOnOffStatus());
	        assertEquals(OnOff.NON_FUNCTIONAL, infoButton.getOnOffStatus());
	}
	@Test
	public void testUpdateStates_lessthan_1000() {
		InfoButton infoButton = new InfoButton();
		infoButton.setOnOffStatus(OnOff.FUNCTIONAL);
		infoButton.setMuteStatus(Mute.FUNCTIONAL);
		infoButton.updateStates(1000);
		assertEquals(OnOff.FUNCTIONAL, infoButton.getOnOffStatus());
		assertEquals(Mute.FUNCTIONAL, infoButton.getMuteStatus());
	} 
	@Test
	public void testResetInfoButton() {
		InfoButton infoButton = new InfoButton();
		infoButton.setButtonStatus(ButtonStatus.HOLD);
        infoButton.setMuteStatus(Mute.FUNCTIONAL);
    	infoButton.setOnOffStatus(OnOff.FUNCTIONAL);
    	infoButton.setTLONG(2500);
    	infoButton.setTSHORT(1500);
    	
        infoButton.resetInfoButton();
        
        assertEquals(ButtonStatus.RELEASED, infoButton.getButtonStatus());
        assertEquals(1000, infoButton.getTSHORT()); 
        assertEquals(2000, infoButton.getTLONG());



	
	


	}
	

}
