import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RadioImp1Test {
    private RadioImp1 radio;

    @Before
    public void setUp() {
        radio = new RadioImp1();
    }

    @Test
    public void testTurnOn() {
        assertFalse(radio.isOn());
        radio.turnOn();
        assertTrue(radio.isOn());
    }

    @Test
    public void testTurnOff() {
        radio.turnOn();
        assertTrue(radio.isOn());
        radio.turnOff();
        assertFalse(radio.isOn());
    }

    @Test
    public void testSwitchFrequency() {
        assertTrue(radio.isAM());
        radio.switchFrequency();
        assertFalse(radio.isAM());
    }

    @Test
    public void testTuneUp() {
        double initialStation = radio.getCurrentStation();
        radio.tuneUp();
        assertTrue(radio.getCurrentStation() > initialStation);
    }

    @Test
    public void testTuneDown() {
        boolean isAm = radio.isAM();
        double initialStation = radio.getCurrentStation();
        double newValue = 0.0;
        radio.tuneDown();
        if (isAm) {
            newValue = Math.max(530.0, initialStation - 10.0);
        } else {
            newValue = Math.max(87.9, initialStation - 0.2);
        }
    
        assertEquals(newValue, radio.getCurrentStation(), 0.01);
    }

    @Test
    public void testSaveStation() {
        double station = 530.0;
        int button = 3;
        radio.saveStation(button);
        assertEquals(station, radio.getPresets()[button - 1], 0.01);
    }

    @Test
    public void testSelectStation() {
        double station = 530.0;
        int button = 5;
        radio.saveStation(button);
        radio.selectStation(button);
        assertEquals(station, radio.getCurrentStation(), 0.01);
    }

    @Test
    public void testVolumeUp() {
        int initialVolume = radio.getVolume();
        radio.volumeUp();
        assertTrue(radio.getVolume() > initialVolume);
    }

    @Test
    public void testVolumeDown() {
        int initialVolume = radio.getVolume();
        radio.volumeDown();
        assertTrue(radio.getVolume() < initialVolume);
    }
}