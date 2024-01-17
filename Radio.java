public interface Radio { // Interfaz del radio
    void turnOn();
    void turnOff();
    void switchFrequency();
    void tuneUp();
    void tuneDown();
    void saveStation(int button);
    void selectStation(int button);
    void volumeUp();
    void volumeDown();
}