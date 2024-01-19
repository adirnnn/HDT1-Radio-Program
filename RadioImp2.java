public class RadioImp2 implements Radio {
    private static final double MIN_AM_FREQUENCY = 530.0;
    private static final double MAX_AM_FREQUENCY = 1610.0;
    private static final double AM_TUNING_STEP = 10.0;
    private static final double MIN_FM_FREQUENCY = 87.9;
    private static final double MAX_FM_FREQUENCY = 107.9;
    private static final double FM_TUNING_STEP = 0.2;
    private static final int NUM_PRESETS = 12;
    private static final int DEFAULT_VOLUME = 50;

    private boolean powerState;
    private boolean frequencyAM;
    private double stationFrequency;
    private double[] stationPresets;
    private int volumeLevel;

    public RadioImp2() {
        powerState = false;
        frequencyAM = true;
        stationFrequency = MIN_AM_FREQUENCY;
        stationPresets = new double[NUM_PRESETS];
        volumeLevel = DEFAULT_VOLUME;
    }

    @Override
    public void turnOn() {
        powerState = true;
        System.out.println("The radio is now activated in RadioImp2.");
    }

    @Override
    public void turnOff() {
        powerState = false;
        System.out.println("The radio has been deactivated in RadioImp2.");
    }

    @Override
    public void switchFrequency() {
        frequencyAM = !frequencyAM;
        System.out.println("Switched the frequency to " + (frequencyAM ? "AM" : "FM") + " in RadioImp2.");
    }

    @Override
    public void tuneUp() {
        if (frequencyAM) {
            stationFrequency = Math.min(MAX_AM_FREQUENCY, stationFrequency + AM_TUNING_STEP);
        } else {
            stationFrequency = Math.min(MAX_FM_FREQUENCY, stationFrequency + FM_TUNING_STEP);
        }
        System.out.println("Adjusted to a higher frequency: " + stationFrequency + " " + (frequencyAM ? "AM" : "FM") + " in RadioImp2.");
    }

    @Override
    public void tuneDown() {
        if (frequencyAM) {
            stationFrequency = Math.max(MIN_AM_FREQUENCY, stationFrequency - AM_TUNING_STEP);
        } else {
            stationFrequency = Math.max(MIN_FM_FREQUENCY, stationFrequency - FM_TUNING_STEP);
        }
        System.out.println("Adjusted to a lower frequency: " + stationFrequency + " " + (frequencyAM ? "AM" : "FM") + " in RadioImp2.");
    }

    
    /** 
     * @param button
     */
    @Override
    public void saveStation(int button) {
        stationPresets[button - 1] = stationFrequency;
        System.out.println("Stored current station on button " + button + " in RadioImp2.");
    }

    @Override
    public void selectStation(int button) {
        stationFrequency = stationPresets[button - 1];
        System.out.println("Selected station stored on button " + button + ": " + stationFrequency + " in RadioImp2.");
    }

    @Override
    public void volumeUp() {
        volumeLevel = Math.min(100, volumeLevel + 2);
        System.out.println("Increased volume to " + volumeLevel + " in RadioImp2.");
    }

    @Override
    public void volumeDown() {
        volumeLevel = Math.max(1, volumeLevel - 2);
        System.out.println("Decreased volume to " + volumeLevel + " in RadioImp2.");
    }
}
