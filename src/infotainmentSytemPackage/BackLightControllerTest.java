package infotainmentSytemPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class BackLightControllerTest {
	 @Test
	    public void testResetBackLightController() {
	        BackLightController backLightController = new BackLightController();
	        backLightController.setDay_DC(50);
	        backLightController.setNight_DC(150);
	        backLightController.setBackLightStatus(BackLightMode.NIGHT);
	        backLightController.resetBackLightController();
	        assertEquals(100, backLightController.getDay_DC(), 0.01);
	        assertEquals(200, backLightController.getNight_DC(), 0.01);
	        assertEquals(BackLightMode.DAY, backLightController.getBackLightStatus());
	    }


}
