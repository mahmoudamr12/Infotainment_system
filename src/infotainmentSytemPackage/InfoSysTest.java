package infotainmentSytemPackage;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import java.awt.Color;

public class InfoSysTest {

    


	@Test
	public void testDisableSystem() {
		InfoSys	infotainmentSystem = new InfoSys();
		   
        infotainmentSystem.btnPower.setEnabled(true);
        infotainmentSystem.lblInfoSys.setBackground(Color.WHITE); // Assuming it's initially a different color
        infotainmentSystem.lblMute.setVisible(true);
        infotainmentSystem.btnIgnite.setText("Ignite: OFF");
        infotainmentSystem.btnIgnite.setForeground(Color.GREEN);
        infotainmentSystem.rdbtnDay.setEnabled(true);
        infotainmentSystem.rdbtnNight.setEnabled(true);
        infotainmentSystem.DisableSystem();
        assertFalse(infotainmentSystem.btnPower.isEnabled());
        assertEquals(Color.BLACK, infotainmentSystem.lblInfoSys.getBackground());
        assertFalse(infotainmentSystem.lblMute.isVisible());
        assertEquals("Ignite: ON", infotainmentSystem.btnIgnite.getText());
        assertEquals(Color.RED, infotainmentSystem.btnIgnite.getForeground());
        assertFalse(infotainmentSystem.rdbtnDay.isEnabled());
        assertFalse(infotainmentSystem.rdbtnNight.isEnabled());
	}

	@Test
	public void testEnableSystem() {
		InfoSys	infotainmentSystem = new InfoSys();
		 // Assuming that the initial state is a disabled system (all disabled)
        infotainmentSystem.btnPower.setEnabled(false);
        infotainmentSystem.lblMute.setVisible(false);
        infotainmentSystem.btnIgnite.setText("Ignite: ON");
        infotainmentSystem.btnIgnite.setForeground(Color.RED);
        infotainmentSystem.rdbtnDay.setEnabled(false);
        infotainmentSystem.rdbtnNight.setEnabled(false);

        // Call EnableSystem method
        infotainmentSystem.EnableSystem();

        // Check if the system is enabled
        assertTrue(infotainmentSystem.btnPower.isEnabled());
        assertTrue(infotainmentSystem.lblMute.isVisible());
        assertEquals("Ignite: OFF", infotainmentSystem.btnIgnite.getText());
        assertEquals(Color.GREEN, infotainmentSystem.btnIgnite.getForeground());
        assertTrue(infotainmentSystem.rdbtnDay.isEnabled());
        assertTrue(infotainmentSystem.rdbtnNight.isEnabled());

	}

	@Test
	public void testSystemOff() {
		InfoSys	infotainmentSystem = new InfoSys();
		// Assuming that the initial state is an enabled system (all enabled)
        infotainmentSystem.igniteStatus = Ign.ON;
        infotainmentSystem.btnPower.setEnabled(true);
        infotainmentSystem.lblInfoSys.setBackground(Color.WHITE); // You can set it to any color other than black
        infotainmentSystem.lblMute.setVisible(true);
        infotainmentSystem.btnIgnite.setText("Ignite: OFF");
        infotainmentSystem.btnIgnite.setForeground(Color.GREEN);
        infotainmentSystem.rdbtnDay.setEnabled(true);
        infotainmentSystem.rdbtnNight.setEnabled(true);
        infotainmentSystem.textTLong.setEnabled(true);
        infotainmentSystem.textTShort.setEnabled(true);
        infotainmentSystem.textDay_DC.setEnabled(true);
        infotainmentSystem.textNight_DC.setEnabled(true);

        // Call SystemOff method
        infotainmentSystem.SystemOff();
        
        // Check if the system is turned off and components are disabled
        assertEquals(Ign.OFF, infotainmentSystem.igniteStatus);
        assertFalse(infotainmentSystem.btnPower.isEnabled());
        assertEquals(Color.BLACK, infotainmentSystem.lblInfoSys.getBackground());
        assertFalse(infotainmentSystem.lblMute.isVisible());
        assertEquals("Ignite: ON", infotainmentSystem.btnIgnite.getText());
        assertEquals(Color.RED, infotainmentSystem.btnIgnite.getForeground());
        assertFalse(infotainmentSystem.rdbtnDay.isEnabled());
        assertFalse(infotainmentSystem.rdbtnNight.isEnabled());
        assertFalse(infotainmentSystem.textTLong.isEnabled());
        assertFalse(infotainmentSystem.textTShort.isEnabled());
        assertFalse(infotainmentSystem.textDay_DC.isEnabled());
        assertFalse(infotainmentSystem.textNight_DC.isEnabled());
        assertEquals("System: ON", infotainmentSystem.btnSystem.getText());
        assertEquals(Color.RED, infotainmentSystem.btnSystem.getForeground());
        assertFalse(infotainmentSystem.btnIgnite.isEnabled());
        assertEquals("", infotainmentSystem.textAreaDTC.getText());
	}
	
	@Test
	public void testSystemOn() {
		InfoSys	infotainmentSystem = new InfoSys();
		// Assuming that the initial state is a disabled system (all disabled)
        infotainmentSystem.textTLong.setEnabled(false);
        infotainmentSystem.textTShort.setEnabled(false);
        infotainmentSystem.textDay_DC.setEnabled(false);
        infotainmentSystem.textNight_DC.setEnabled(false);
        infotainmentSystem.btnSystem.setText("System: ON");
        infotainmentSystem.btnSystem.setForeground(Color.RED);
        infotainmentSystem.btnIgnite.setEnabled(false);

        // Call SystemOn method
        infotainmentSystem.SystemOn();

        // Check if the system is turned on and components are enabled
        assertTrue(infotainmentSystem.textTLong.isEnabled());
        assertTrue(infotainmentSystem.textTShort.isEnabled());
        assertTrue(infotainmentSystem.textDay_DC.isEnabled());
        assertTrue(infotainmentSystem.textNight_DC.isEnabled());
        assertEquals("System: OFF", infotainmentSystem.btnSystem.getText());
        assertEquals(Color.GREEN, infotainmentSystem.btnSystem.getForeground());
        assertTrue(infotainmentSystem.btnIgnite.isEnabled());
        // Add more assertions based on your class's state after calling SystemOn
	}

	@Test
	public void testResetRadioButtons() {
		InfoSys	infotainmentSystem = new InfoSys();
		// Assuming that initially, rdbtnDay and rdbtnNight are not selected
        infotainmentSystem.rdbtnDay.setSelected(false);
        infotainmentSystem.rdbtnNight.setSelected(false);

        // Call resetRadioButtons method
        infotainmentSystem.resetRadioButtons();

        // Check if the radio buttons are reset to their initial state
        assertTrue(infotainmentSystem.rdbtnDay.isSelected());
        assertTrue(infotainmentSystem.rdbtnNight.isSelected());
        // Add more assertions based on your class's state after calling resetRadioButtons
	}

	@Test
    public void toggleIgniteOnOffWhenSystemIsOffAndIgniteIsOnShouldToggleIgnite() {
        InfoSys infoSys = new InfoSys();
        infoSys.systemStatus = Sys.OFF;
        infoSys.igniteStatus = Ign.ON;

        infoSys.ToggleIgniteOnOff();

        assertEquals(Ign.ON, infoSys.igniteStatus);
        assertTrue(infoSys.systemStatus == Sys.OFF);
    }

    @Test
    public void toggleIgniteOnOffWhenSystemIsOffAndIgniteIsOffShouldToggleIgniteAndEnableSystem() {
        InfoSys infoSys = new InfoSys();
        infoSys.systemStatus = Sys.OFF;
        infoSys.igniteStatus = Ign.OFF;

        infoSys.ToggleIgniteOnOff();

        assertEquals(Ign.ON, infoSys.igniteStatus);
        assertTrue(infoSys.systemStatus == Sys.ON);
    }

    @Test
    public void toggleIgniteOnOffWhenSystemIsOnAndIgniteIsOnShouldToggleIgniteAndDisableSystem()
    {
        InfoSys infoSys = new InfoSys();
        infoSys.systemStatus = Sys.ON;
        infoSys.igniteStatus = Ign.ON;

        infoSys.ToggleIgniteOnOff();

        assertEquals(Ign.OFF, infoSys.igniteStatus);
        assertTrue(infoSys.systemStatus == Sys.OFF);
    }
    
    @Test
    public void toggleIgniteOnOffWhenSystemIsOnAndIgniteIsOffShouldToggleIgniteAndEnableSystem() 
    {
        InfoSys infoSys = new InfoSys();
        infoSys.systemStatus = Sys.ON;
        infoSys.igniteStatus = Ign.OFF;

        infoSys.ToggleIgniteOnOff();

        assertEquals(Ign.ON, infoSys.igniteStatus);
        assertTrue(infoSys.systemStatus == Sys.ON);

    }
    
	@Test
	public void testToggleSystemOnOff() {
		 InfoSys infoSys = new InfoSys();
		 infoSys.systemStatus = Sys.ON;
		 infoSys.ToggleSystemOnOff();
		 assertEquals(Sys.OFF, infoSys.systemStatus);
	}
	@Test
	public void testToggleSystemOnOff_systemstatus_off() {
		 InfoSys infoSys = new InfoSys();
		 infoSys.systemStatus = Sys.OFF;
		 infoSys.ToggleSystemOnOff();
		 assertEquals(Sys.ON, infoSys.systemStatus);
	}
	


    @Test
    public void testBothTextFieldsNonEmpty() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textTShort.setText("100");
        infoSys.textTLong.setText("200");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        assertEquals(100, infoSys.infoButton.getTSHORT());
        assertEquals(200, infoSys.infoButton.getTLONG());
    }
    @Test
    public void testBothTextFieldsNonEmptyAndLongLessThanShort() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textTShort.setText("200");
        infoSys.textTLong.setText("100");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        assertEquals(100, infoSys.infoButton.getTSHORT());
        assertEquals(200, infoSys.infoButton.getTLONG());
    }
    @Test
    public void testTextTShortEmpty() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textTShort.setText("");
        infoSys.textTLong.setText("200");

        infoSys.ToggleSystemOnOff();;

    }
    @Test
    public void testTextTShortEmptyandTextTlongBig() {
        InfoSys infoSys = new InfoSys();
        InfoButton infoButton =new InfoButton();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textTShort.setText("");
        infoSys.textTLong.setText(Long.toString(infoButton.getTSHORT()+5));
        infoSys.ToggleSystemOnOff();;

    }
    @Test
    public void testTextTLongEmpty() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textTShort.setText("100");
        infoSys.textTLong.setText("");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TLONG was set as expected and TSHORT remains unchanged
    }

    @Test
    public void testBothTextFieldsEmpty() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textTShort.setText("");
        infoSys.textTLong.setText("");
        infoSys.ToggleSystemOnOff();;

    }
    @Test
    public void testExceptionHandling() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;
    	
        // Set text values that will cause an exception during parsing
        infoSys.textTShort.setText("abc"); // Invalid Long value
        infoSys.textTLong.setText("def");  // Invalid Long value
        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        infoSys.ToggleSystemOnOff();;
     // Reset System.out
        System.setOut(System.out);
    
    }
    @Test
    public void testExceptionHandling2() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;
    	
        // Set text values that will cause an exception during parsing
        infoSys.textTShort.setText("abc"); // Invalid Long value
        infoSys.textTLong.setText("");  // Invalid Long value
        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        infoSys.ToggleSystemOnOff();;
     // Reset System.out
        System.setOut(System.out);
    
    }
    @Test
    public void testExceptionHandling3() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;
    	
        // Set text values that will cause an exception during parsing
        infoSys.textTShort.setText(""); // Invalid Long value
        infoSys.textTLong.setText("abc");  // Invalid Long value
        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        infoSys.ToggleSystemOnOff();;
     // Reset System.out
        System.setOut(System.out);
    
    }


    @Test
    public void testBothtextDaysNonEmpty() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textDay_DC.setText("30");
        infoSys.textNight_DC.setText("70");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }
    @Test
    public void testtextDayGreaterThanNightDayNonEmpty() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textDay_DC.setText("70");
        infoSys.textNight_DC.setText("30");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }
    @Test
    public void testBothtextDaysNonEmptyAndTextDayLessThanZero() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textDay_DC.setText("-1");
        infoSys.textNight_DC.setText("70");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }
    @Test
    public void testBothtextDaysNonEmptyAndTextDayGreaterThanHundred() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textDay_DC.setText("100");
        infoSys.textNight_DC.setText("120");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }
    @Test
    public void testBothtextDaysNonEmptyAndTextNightGreaterThanHundred() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textDay_DC.setText("10");
        infoSys.textNight_DC.setText("101");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }
    @Test
    public void testNightDayEmpty() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textDay_DC.setText("30");
        infoSys.textNight_DC.setText("");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }
    @Test
    public void testNightDayEmptyAndDayisTooLarge() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textDay_DC.setText("10000");
        infoSys.textNight_DC.setText("");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }
    @Test
    public void testNightDayEmptyAndDayisTooSmall() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textDay_DC.setText("0");
        infoSys.textNight_DC.setText("");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }
    @Test
    public void testNightDayEmptyAndDayisHundredandLessThanBackLight() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;
    	infoSys.backLightController.setNight_DC(1000);
        infoSys.textDay_DC.setText("100");
        infoSys.textNight_DC.setText("");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }
    @Test
    public void testDayEmpty() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;

        infoSys.textDay_DC.setText("");
        infoSys.textNight_DC.setText("30000");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }
    @Test
    public void testDayEmpty2() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;
    	infoSys.backLightController.setDay_DC(200);
        infoSys.textDay_DC.setText("");
        infoSys.textNight_DC.setText("10");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }
    @Test
    public void testDayEmpty3() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;
    	infoSys.backLightController.setDay_DC(-100);
        infoSys.textDay_DC.setText("");
        infoSys.textNight_DC.setText("10");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }

    @Test
    public void testDayEmpty4() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;
    	infoSys.backLightController.setDay_DC(-100);
        infoSys.textDay_DC.setText("");
        infoSys.textNight_DC.setText("0");

        infoSys.ToggleSystemOnOff();;

        // Assert the expected outcomes
        // For example, check that infoButton's TSHORT and TLONG were set as expected
        // Assert the expected values after successful parsing and validation
        assertEquals(76.5, infoSys.backLightController.getNight_DC(), 0.01);
        assertEquals(38.25, infoSys.backLightController.getDay_DC(), 0.01);
      }
    @Test
    public void testExceptionHandling4() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;
    	
        // Set text values that will cause an exception during parsing
        infoSys.textDay_DC.setText("abc"); // Invalid Long value
        infoSys.textNight_DC.setText("abc");  // Invalid Long value
        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        infoSys.ToggleSystemOnOff();;
     // Reset System.out
        System.setOut(System.out);
    
    }
    @Test
    public void testExceptionHandling5() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;
    	
        // Set text values that will cause an exception during parsing
        infoSys.textDay_DC.setText(""); // Invalid Long value
        infoSys.textNight_DC.setText("abc");  // Invalid Long value
        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        infoSys.ToggleSystemOnOff();;
     // Reset System.out
        System.setOut(System.out);
    
    }
    @Test
    public void testExceptionHandling6() {
        InfoSys infoSys = new InfoSys();
    	infoSys.systemStatus = Sys.OFF;
    	
        // Set text values that will cause an exception during parsing
        infoSys.textDay_DC.setText("abc"); // Invalid Long value
        infoSys.textNight_DC.setText("");  // Invalid Long value
        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        infoSys.ToggleSystemOnOff();;
     // Reset System.out
        System.setOut(System.out);
    
    }    
	@Test
	public void testDayMode() {
		InfoSys	infotainmentSystem = new InfoSys();
		infotainmentSystem.rdbtnDay.setSelected(true);
		infotainmentSystem.rdbtnNight.setEnabled(false);
	     infotainmentSystem.DayMode();
	     assertTrue(infotainmentSystem.rdbtnDay.isSelected());
	     assertEquals(BackLightMode.DAY, infotainmentSystem.backLightController.getBackLightStatus());
	}
	
	@Test
	public void testDayMode_faluse() {
		InfoSys	infotainmentSystem = new InfoSys();
		infotainmentSystem.rdbtnDay.setSelected(false);
		infotainmentSystem.rdbtnNight.setEnabled(true);
	    infotainmentSystem.DayMode();
	    assertEquals(BackLightMode.DAY, infotainmentSystem.backLightController.getBackLightStatus());
		
		
	}

	@Test
	public void testNightMode() {
		InfoSys	infotainmentSystem = new InfoSys();
        infotainmentSystem.rdbtnNight.setSelected(true);
        infotainmentSystem.rdbtnDay.setSelected(true);
        infotainmentSystem.NightMode();
        assertTrue(infotainmentSystem.rdbtnDay.isSelected());
        assertEquals(BackLightMode.DAY, infotainmentSystem.backLightController.getBackLightStatus());
	}
	@Test
	public void testNightMode_faluse() {
		InfoSys	infotainmentSystem = new InfoSys();
        infotainmentSystem.rdbtnNight.setSelected(false);
        infotainmentSystem.rdbtnDay.setSelected(false);
        infotainmentSystem.NightMode();
        assertEquals(BackLightMode.DAY, infotainmentSystem.backLightController.getBackLightStatus());
	}
	

	@Test
	public void testInitSystem() {
		InfoSys	infotainmentSystem = new InfoSys();
		// Assuming initial conditions where systemStatus is OFF, igniteStatus is ON
        infotainmentSystem.systemStatus = Sys.OFF;
        infotainmentSystem.igniteStatus = Ign.ON;
        infotainmentSystem.InitSystem();
        assertEquals(Ign.OFF, infotainmentSystem.igniteStatus);
        assertEquals(Sys.ON, infotainmentSystem.systemStatus);
        assertNotNull(infotainmentSystem.dtc);
        assertEquals(StatusCode.CONFIRMED_AND_FAILED, infotainmentSystem.dtc.getDTC("B91212"));
        assertNotNull(infotainmentSystem.infoButton);
        assertNotNull(infotainmentSystem.backLightController);
        assertTrue(infotainmentSystem.rdbtnDay.isSelected());
        assertTrue(infotainmentSystem.rdbtnNight.isSelected());
        assertFalse(infotainmentSystem.btnPower.isEnabled());
        assertEquals(Color.BLACK, infotainmentSystem.lblInfoSys.getBackground());
        assertFalse(infotainmentSystem.lblMute.isVisible());
        assertEquals("Ignite: ON", infotainmentSystem.btnIgnite.getText());
        assertEquals(Color.RED, infotainmentSystem.btnIgnite.getForeground());
        assertFalse(infotainmentSystem.rdbtnDay.isEnabled());
        assertFalse(infotainmentSystem.rdbtnNight.isEnabled());
	}

}