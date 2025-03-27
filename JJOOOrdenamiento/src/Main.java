
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author GalaxyBook31
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JJOO[] paisesJugadores = cargarPaises();

        try (Scanner sc = new Scanner(System.in)) {
            mostrarMenu(sc, paisesJugadores);
        }
    }

    public static void mostrarMenu(Scanner scanner, JJOO[] paisesJugadores) {
        int eleccion = 0;

        while (eleccion != 4) {
            System.out.println("\nSeleccione el metodo de ordenamiento:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Shell Sort");
            System.out.println("4. Salir");

            try {
                eleccion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (eleccion) {
                case 1 -> ejecutarOrdenamiento("Bubble Sort", paisesJugadores, JJOO::bubbleSort);
                case 2 -> ejecutarOrdenamiento("Insertion Sort", paisesJugadores, JJOO::insertionSort);
                case 3 -> ejecutarOrdenamiento("Shell Sort", paisesJugadores, JJOO::shellSort);
                case 4 -> System.out.println("¡Adio3s!");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void ejecutarOrdenamiento(String metodo, JJOO[] paisesJugadores, Ordenador ordenador) {
        System.out.println("\nEstado original del array:");
        JJOO.mostrarArray(paisesJugadores);

        long startTime = System.nanoTime();
        ordenador.ordenar(paisesJugadores);
        long duration = (System.nanoTime() - startTime) / 1_000_000;

        System.out.println("\nEstado del array despues de " + metodo + ":");
        JJOO.mostrarArray(paisesJugadores);
        System.out.println("\nTiempo de ejecucion: " + duration + " ms");

        paisesJugadores = cargarPaises();
    }

    private static JJOO[] cargarPaises() {
        return new JJOO[] {
            new JJOO("Argentina", 4, 5, 7, 1),
            new JJOO("Brasil", 2, 5, 7, 2),
            new JJOO("Chile", 3, 6, 8, 3),
            new JJOO("Uruguay", 2, 3, 4, 4),
            new JJOO("Paraguay", 1, 1, 2, 5),
            new JJOO("Bolivia", 2, 5, 7, 6)
        };
    }

    @FunctionalInterface
    interface Ordenador {
        void ordenar(JJOO[] array);
    }
}

