import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int listaOriginal[] = new int[20];
        boolean generado = false;
        boolean ordenado = false;
        int opcion;

        do {
            System.out.println("\nOrdenamiento y Búsqueda de datos");
            System.out.println("1. Generar arreglo de 20 números aleatorios");
            System.out.println("2. Ordenar arreglo");
            System.out.println("3. Buscar un número");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    generarNumeros(listaOriginal);
                    generado = true;
                    ordenado = false;
                    break;

                case 2:
                    if (!generado) {
                        System.out.println("Arreglo aun no generado");
                    } else {
                        System.out.println("\n Proceso de Ordenamiento Quicksort");
                        ordenarQuicksort(listaOriginal, 0, listaOriginal.length - 1);
                        ordenado = true;
                        System.out.println("\nLista ordenada de menor a mayor:");
                        mostrarArreglo(listaOriginal);
                    }
                    break;

                case 3:
                    if (!generado) {
                        System.out.println("Arreglo aun no generado");
                    } else {
                        if (!ordenado) {
                            System.out.println("Ordenando el arreglo automáticamente antes de realizar la búsqueda binaria...");
                            ordenarQuicksort(listaOriginal, 0, listaOriginal.length - 1);
                            ordenado = true;
                            System.out.println("\nLista ordenada:");
                            mostrarArreglo(listaOriginal);
                        }
                        System.out.print("\nIngrese el número que desea buscar: ");
                        int valorBuscado = scanner.nextInt();
                        int posicion = buscar(listaOriginal, valorBuscado, 0, listaOriginal.length - 1);

                        if (posicion == -1) {
                            System.out.println("El número " + valorBuscado + " no se encuentró en el arreglo");
                        } else {
                            int mitad = (listaOriginal.length - 1) / 2;
                            String lado;
                            if (posicion < mitad) {
                                lado = "lado izquierdo";
                            } else if (posicion > mitad) {
                                lado = "lado derecho";
                            } else {
                                lado = "centro exacto (mitad izquierda)";
                            }
                            System.out.println("Número " + valorBuscado + " encontrado en el índice [" + posicion + "] -> Se ubica en el " + lado + " del arreglo.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 4);

        scanner.close();
    }

    public static void generarNumeros(int listaOriginal[]) {
        int number;
        System.out.println("\nLista original:");
        for (int i = 0; i < listaOriginal.length; i++) {
            number = (int) (Math.random() * 50 + 1);
            listaOriginal[i] = number;
            System.out.println("Índice [" + i + "]: " + listaOriginal[i]);
        }
    }

    public static void ordenarQuicksort(int listaOriginal[], int inferior, int superior) {
        int i, j, central;
        double pivote;
        central = (inferior + superior) / 2;
        pivote = listaOriginal[central];
        i = inferior;
        j = superior;

        System.out.println("Límites que se analizan. Inferior: " + i + " Superior: " + j + " Pivote: " + pivote);

        do {
            while (listaOriginal[i] < pivote) i++;
            while (listaOriginal[j] > pivote) j--;
            if (i <= j) {
                intercambiar(listaOriginal, i, j);
                i++;
                j--;
            }
        } while (i <= j);

        if (inferior < j) {
            ordenarQuicksort(listaOriginal, inferior, j);
        }
        if (i < superior) {
            ordenarQuicksort(listaOriginal, i, superior);
        }
    }

    public static void intercambiar(int listaOriginal[], int i, int j) {
        int aux = listaOriginal[i];
        listaOriginal[i] = listaOriginal[j];
        listaOriginal[j] = aux;
    }

    public static int buscar(int listaOriginal[], int valorBuscado, int inferior, int superior) {
        int central;
        if (inferior > superior) {
            return -1;
        } else {
            central = (inferior + superior) / 2;
            if (listaOriginal[central] == valorBuscado) {
                return central;
            } else if (listaOriginal[central] < valorBuscado) {
                return buscar(listaOriginal, valorBuscado, central + 1, superior);
            } else {
                return buscar(listaOriginal, valorBuscado, inferior, central - 1);
            }
        }
    }

    public static void mostrarArreglo(int listaOriginal[]) {
        for (int i = 0; i < listaOriginal.length; i++) {
            System.out.print("[" + i + "]:" + listaOriginal[i] + "  ");
        }
        System.out.println();
    }
}