import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Aquí se puede reemplazar RadioImp1 con otras implementaciones.
        Radio radio = new RadioImp1();

        boolean isRadioOn = false;

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Opción para encender el radio
                    if (!isRadioOn) {
                        radio.turnOn();
                        isRadioOn = true;
                    } else {
                        System.out.println("¡El radio ya está encendido!");
                    }
                    break;
                case 2:
                    // Opción para cambiar entre AM y FM
                    if (isRadioOn) {
                        radio.switchFrequency();
                    } else {
                        System.out.println("Encienda el radio primero.");
                    }
                    break;
                case 3:
                    // Opción para sintonizar hacia arriba
                    if (isRadioOn) {
                        radio.tuneUp();
                    } else {
                        System.out.println("Encienda el radio primero.");
                    }
                    break;
                case 4:
                    // Opción para sintonizar hacia abajo
                    if (isRadioOn) {
                        radio.tuneDown();
                    } else {
                        System.out.println("Encienda el radio primero.");
                    }
                    break;
                case 5:
                    // Opción para guardar una estación en un botón
                    if (isRadioOn) {
                        System.out.print("Ingrese el número de botón (1-12): ");
                        int button = scanner.nextInt();
                        radio.saveStation(button);
                    } else {
                        System.out.println("Encienda el radio primero.");
                    }
                    break;
                case 6:
                    // Opción para seleccionar una estación desde un botón
                    if (isRadioOn) {
                        System.out.print("Ingrese el número de botón (1-12): ");
                        int button = scanner.nextInt();
                        radio.selectStation(button);
                    } else {
                        System.out.println("Encienda el radio primero.");
                    }
                    break;
                case 7:
                    // Opción para subir el volumen
                    if (isRadioOn) {
                        radio.volumeUp();
                    } else {
                        System.out.println("Encienda el radio primero.");
                    }
                    break;
                case 8:
                    // Opción para bajar el volumen
                    if (isRadioOn) {
                        radio.volumeDown();
                    } else {
                        System.out.println("Encienda el radio primero.");
                    }
                    break;
                case 9:
                    // Opción para apagar el radio
                    if (isRadioOn) {
                        radio.turnOff();
                        isRadioOn = false;
                    } else {
                        System.out.println("¡El radio ya está apagado!");
                    }
                    break;
                case 10:
                    // Opción para salir del programa
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 10.");
            }
        }
    }

    private static void printMenu() {
        // Método para imprimir el menú
        System.out.println("Menú:");
        System.out.println("1. Encender el radio");
        System.out.println("2. Cambiar AM/FM");
        System.out.println("3. Sintonizar hacia arriba");
        System.out.println("4. Sintonizar hacia abajo");
        System.out.println("5. Guardar estación en un botón");
        System.out.println("6. Seleccionar estación desde un botón");
        System.out.println("7. Subir volumen");
        System.out.println("8. Bajar volumen");
        System.out.println("9. Apagar el radio");
        System.out.println("10. Salir del programa");
        System.out.print("Ingrese su elección: ");
    }
}