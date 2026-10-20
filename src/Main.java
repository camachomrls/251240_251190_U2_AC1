import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int listaOriginal[] = new int[20];
        Quicksort qs = new Quicksort();
        boolean listaCreada = false;
        boolean listaOrdenada = false;
        int opcion;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Generar numeros");
            System.out.println("2. Ordenar lista");
            System.out.println("3. Buscar numero");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    qs.generarNumeros(listaOriginal);
                    listaCreada = true;
                    listaOrdenada = false;
                    break;

                case 2:
                    if (!listaCreada) {
                        System.out.println("Primero genera los numeros con la opcion 1.");
                    } else {
                        qs.ordenarQuicksort(listaOriginal, 0, listaOriginal.length - 1);
                        listaOrdenada = true;
                        System.out.println("\nLista ya ordenada:");
                        qs.mostrarLista(listaOriginal);
                    }
                    break;

                case 3:
                    if (!listaCreada) {
                        System.out.println("Primero genera los numeros con la opcion 1.");
                    } else {
                        if (!listaOrdenada) {
                            qs.ordenarQuicksort(listaOriginal, 0, listaOriginal.length - 1);
                            listaOrdenada = true;
                            System.out.println("\nLista ordenada:");
                            qs.mostrarLista(listaOriginal);
                        }
                        System.out.print("\nIngresa el numero que quieres buscar: ");
                        int valorBuscado = sc.nextInt();
                        int posicion = qs.buscar(listaOriginal, valorBuscado, 0, listaOriginal.length - 1);

                        if (posicion == -1) {
                            System.out.println("El numero " + valorBuscado + " no esta en la lista.");
                        } else {
                            int mitad = (listaOriginal.length - 1) / 2;
                            if (posicion <= mitad) {
                                System.out.println("El numero " + valorBuscado + " se encontro en la posicion " + posicion + ", del lado izquierdo.");
                            } else {
                                System.out.println("El numero " + valorBuscado + " se encontro en la posicion " + posicion + ", del lado derecho.");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);
    }
}