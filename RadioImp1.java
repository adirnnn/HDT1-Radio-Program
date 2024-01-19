/** 
 * Authors: Fernando Mendoza / Adrian López
 * Description: Clase que implementa la interfaz Radio y sobreescrib/contiene  los métodos necesarios
 * para ejecutar las funciones del radio 
 */

public class RadioImp1 implements Radio {
    private boolean isOn;         // Indica si el radio está encendido
    private boolean isAM;         // Indica si la frecuencia actual es AM
    private double currentStation; // Almacena la estación actual
    private double[] presets;      // Almacena las estaciones guardadas en los botones
    private int volume;            // Almacena el nivel de volumen

    /** 
     * Constructor
     */
    public RadioImp1() {
        isOn = false;              // Inicialmente, el radio está apagado
        isAM = true;               // Inicialmente, la frecuencia es AM
        currentStation = 530.0;    // Inicialmente, la estación es 530.0
        presets = new double[12];  // Inicializa el arreglo de estaciones guardadas
        volume = 50;               // Inicialmente, el volumen está en 50
    }

    /** 
     * @param
     * Mensaje cuando se enciende el radio
     */
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Radio is now ON.");
    }

    /** 
     * @param
     * Mensaje cuando se apaga el radio
     */
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Radio is now OFF.");
    }

    /** 
     * @param
     * Mensaje indicando la frecuencia actual después del cambio
     */
    @Override
    public void switchFrequency() {
        isAM = !isAM;
        System.out.println("Switched to " + (isAM ? "AM" : "FM") + " frequency.");
    }

    /** 
     * @param
     * Sintoniza hacia arriba dependiendo de la frecuencia actual (AM o FM)
     */
    @Override
    public void tuneUp() {
        if (isAM) {
            currentStation += 10.0;
            if (currentStation > 1610.0) {
                currentStation = 1610.0; // Ajusta a la frecuencia máxima si se excede
            }
        } else {
            currentStation += 0.2;
            if (currentStation > 107.9) {
                currentStation = 107.9; // Ajusta a la frecuencia máxima si se excede
            }
        }
        System.out.println("Tuned to " + currentStation + " " + (isAM ? "AM" : "FM"));
        // Mensaje indicando la estación sintonizada
    }

    /** 
     * @param
     * Sintoniza hacia abajo dependiendo de la frecuencia actual (AM o FM)
     */
    @Override
    public void tuneDown() {
        if (isAM) {
            currentStation -= 10.0;
            if (currentStation < 530.0) {
                currentStation = 530.0; // Ajusta a la frecuencia mínima si se excede
            }
        } else {
            currentStation -= 0.2;
            if (currentStation < 87.9) {
                currentStation = 87.9; // Ajusta a la frecuencia mínima si se excede
            }
        }
        System.out.println("Tuned to " + currentStation + " " + (isAM ? "AM" : "FM"));
        // Mensaje indicando la estación sintonizada
    }

    /** 
     * @param button
     * Mensaje indicando que la estación se ha guardado en un botón específico
     */
    @Override
    public void saveStation(int button) {
        presets[button - 1] = currentStation;
        System.out.println("Station saved on button " + button);
    }

    /** 
     * @param button
     * Mensaje indicando que se ha seleccionado una estación desde un botón específico
     */
    @Override
    public void selectStation(int button) {
        currentStation = presets[button - 1];
        System.out.println("Selected station from button " + button + ": " + currentStation);
    }

    /** 
     * Mensaje indicando el nuevo nivel de volumen después de aumentar
     */
    @Override
    public void volumeUp() {
        volume += 2;
        if (volume > 100) {
            volume = 100; // Ajusta al volumen máximo si se excede
        }
        System.out.println("Volume increased to " + volume);
    }

    /** 
     * Mensaje indicando el nuevo nivel de volumen después de disminuir
     */
    @Override
    public void volumeDown() {
        volume -= 2;
        if (volume < 1) {
            volume = 1; // Ajusta al volumen mínimo si se excede
        }
        System.out.println("Volume decreased to " + volume);
    }

    /** 
     * Getter para isOn
     */
    public boolean isOn() {
        return isOn;
    }

    /** 
     * Getter para isAM
     */
    public boolean isAM() {
        return isAM;
    }

    /** 
     * Getter para getCurrentStation
     */
    public double getCurrentStation() {
        return currentStation;
    }

    /** 
     * Getter para getPresets
     */
    public double[] getPresets() {
        return presets;
    }
    
    /** 
     * Getter para getVolume
     */
    public int getVolume() {
        return volume;
    }
}