public class Quicksort {

    public void generarNumeros(int listaOriginal[]) {
        int number;
        System.out.println("Lista original:");
        for (int i = 0; i < listaOriginal.length; i++) {
            number = (int) (Math.random() * 50 + 1);
            listaOriginal[i] = number;
            System.out.println(listaOriginal[i]);
        }
    }

    public void ordenarQuicksort(int listaOriginal[], int inferior, int superior) {
        int i, j, central;
        double pivote;
        central = (inferior + superior) / 2;
        pivote = listaOriginal[central];
        i = inferior;
        j = superior;

        System.out.println("Limites que se analizan. Inferior: " + i + " Superior: " + j + " Pivote: " + pivote);

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

    public void intercambiar(int listaOriginal[], int i, int j) {
        int aux = listaOriginal[i];
        listaOriginal[i] = listaOriginal[j];
        listaOriginal[j] = aux;
    }

    public int buscar(int listaOriginal[], int valorBuscado, int inferior, int superior) {
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

    public void mostrarLista(int listaOriginal[]) {
        for (int i = 0; i < listaOriginal.length; i++) {
            System.out.print(listaOriginal[i] + " ");
        }
        System.out.println();
    }
}