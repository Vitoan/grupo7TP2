import java.util.Scanner;

public class Main {

    public static void mostrarPaises(JuegosOlimpicos[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + "\n");
        }
    }

    public static void main(String[] args) {
        JuegosOlimpicos[] paisesJugadores = new JuegosOlimpicos[33];
        carga(paisesJugadores);

        Scanner sc = new Scanner(System.in);
        menu(sc, paisesJugadores);
    }

    public static void menu(Scanner scanner, JuegosOlimpicos[] paisesJugadores) {
        int eleccion = 0;

        while (eleccion != 4) {
            System.out.println("\nSeleccione el metodo de ordenamiento:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Shell Sort");
            System.out.println("4. Salir");
            eleccion = scanner.nextInt();

            long startTime = System.nanoTime();

            switch (eleccion) {
                case 1:
                    System.out.println("Estado original del array pre bubble sort:");
                    mostrarPaises(paisesJugadores);

                    JuegosOlimpicos.bubbleSort(paisesJugadores);
                    System.out.println("Metodo bubble");

                    System.out.println("Estado del array post metodo de bubble sort:");
                    mostrarPaises(paisesJugadores);
                    break;

                case 2:
                    System.out.println("Estado original del array pre insertion sort:");
                    mostrarPaises(paisesJugadores);

                    JuegosOlimpicos.insertionSort(paisesJugadores);
                    System.out.println("Metodo insertionSort");

                    System.out.println("Estado del array post metodo de insertion sort:");
                    mostrarPaises(paisesJugadores);
                    break;

                case 3:
                    System.out.println("Estado original del array pre shell sort:");
                    mostrarPaises(paisesJugadores);

                    JuegosOlimpicos.shellSort(paisesJugadores);
                    System.out.println("Metodo shell Sort");

                    System.out.println("Estado del array post metodo de shell sort:");
                    mostrarPaises(paisesJugadores);
                    break;

                case 4:
                    System.out.println("Adios!");
                    break;

                default:
                    System.out.println("Error, reintente nuevamente.");
                    continue;
            }

            if (eleccion != 4) {
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000000;

            //    System.out.println("\nPaises ordenados:");
             //   mostrarPaises(paisesJugadores);
                System.out.println("Tiempo de ejecucion para el ordenamiento: " + duration + " ms");

                // Restaurar el array a su estado original post ordenamiento
                carga(paisesJugadores);
            }
        }
    }

    public static void carga(JuegosOlimpicos[] paisesJugadores) {
        paisesJugadores[0] = new JuegosOlimpicos("Bolivia", 2, 5, 7, 4);
        paisesJugadores[1] = new JuegosOlimpicos("Argentina", 4, 5, 7, 1);
        paisesJugadores[2] = new JuegosOlimpicos("Brasil", 2, 5, 7, 4);
        paisesJugadores[3] = new JuegosOlimpicos("Chile", 3, 6, 8, 2);
        paisesJugadores[4] = new JuegosOlimpicos("Ecuador", 1, 4, 6, 3);
        paisesJugadores[5] = new JuegosOlimpicos("Perú", 5, 6, 3, 5);
        paisesJugadores[6] = new JuegosOlimpicos("Uruguay", 2, 3, 4, 6);
        paisesJugadores[7] = new JuegosOlimpicos("Colombia", 4, 2, 5, 7);
        paisesJugadores[8] = new JuegosOlimpicos("Paraguay", 1, 1, 2, 8);
        paisesJugadores[9] = new JuegosOlimpicos("Venezuela", 3, 5, 6, 9);
        paisesJugadores[10] = new JuegosOlimpicos("México", 6, 8, 5, 4);
        paisesJugadores[11] = new JuegosOlimpicos("Estados Unidos", 9, 7, 8, 3);
        paisesJugadores[12] = new JuegosOlimpicos("Canadá", 7, 6, 4, 5);
        paisesJugadores[13] = new JuegosOlimpicos("España", 4, 9, 3, 7);
        paisesJugadores[14] = new JuegosOlimpicos("Francia", 8, 4, 6, 2);
        paisesJugadores[15] = new JuegosOlimpicos("Italia", 5, 3, 9, 6);
        paisesJugadores[16] = new JuegosOlimpicos("Alemania", 9, 8, 7, 4);
        paisesJugadores[17] = new JuegosOlimpicos("Reino Unido", 6, 7, 5, 8);
        paisesJugadores[18] = new JuegosOlimpicos("Australia", 7, 4, 6, 9);
        paisesJugadores[19] = new JuegosOlimpicos("Japón", 5, 6, 4, 7);
        paisesJugadores[20] = new JuegosOlimpicos("China", 8, 7, 9, 5);
        paisesJugadores[21] = new JuegosOlimpicos("India", 4, 5, 6, 8);
        paisesJugadores[22] = new JuegosOlimpicos("Sudáfrica", 6, 7, 8, 4);
        paisesJugadores[23] = new JuegosOlimpicos("Noruega", 3, 6, 4, 7);
        paisesJugadores[24] = new JuegosOlimpicos("Suecia", 5, 8, 6, 3);
        paisesJugadores[25] = new JuegosOlimpicos("Portugal", 4, 6, 5, 3);
        paisesJugadores[26] = new JuegosOlimpicos("Grecia", 7, 4, 2, 6);
        paisesJugadores[27] = new JuegosOlimpicos("Turquía", 6, 5, 8, 4);
        paisesJugadores[28] = new JuegosOlimpicos("Irán", 3, 7, 6, 5);
        paisesJugadores[29] = new JuegosOlimpicos("Arabia Saudita", 5, 3, 4, 6);
        paisesJugadores[30] = new JuegosOlimpicos("Emiratos Árabes Unidos", 8, 2, 7, 4);
        paisesJugadores[31] = new JuegosOlimpicos("Israel", 4, 6, 3, 7);
        paisesJugadores[32] = new JuegosOlimpicos("Pakistán", 2, 5, 8, 4);
    }
}
