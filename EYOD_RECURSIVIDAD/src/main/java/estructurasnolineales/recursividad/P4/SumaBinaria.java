//CASO1:8 1 2 3 4 5 6 7 8
//CASO2:5 10 20 30 40 50
//CASO3:3 7 -2 5
package estructurasnolineales.recursividad.P4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumaBinaria {
    // FastReader class for efficient input8
    int n;
    int[] data;
    FastReader reader = new FastReader();

    static class FastReader {
        // BufferedReader to read input
        BufferedReader b;
        // StringTokenizer to tokenize input
        StringTokenizer s; 

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }

        // Method to read the next token as an integer
        int nextInt() { 
                return Integer.parseInt(next()); 
        }

        // Method to read Char
        char nextChar() {
            return next().charAt(0);
        }

        // Method to read the next token as a long
        long nextLong() { 
            return Long.parseLong(next()); 
        }

        // Method to read the next token as a double
        double nextDouble() { 
            return Double.parseDouble(next()); 
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
            return str;
        }
    }


    // Entrada: primero n (tamano) y luego los n numeros del arreglo
    public void leerDatos() {
        n = reader.nextInt();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        System.out.print("Arreglo: ");
        mostrarArreglo(data);
        System.out.println("Suma:    " + binarySum(data, 0, n - 1));
    }

    // Recursion binaria: cada llamada se divide en DOS llamadas (mitad izquierda y derecha)
    public int binarySum(int[] data, int low, int high) {
        if (low > high) {                           // arreglo vacio
            return 0;
        } else if (low == high) {                   // caso base: un solo elemento
            return data[low];
        } else {
            int mid = (low + high) / 2;             // punto medio
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }

    // Muestra el arreglo con el formato [a, b, c]
    public void mostrarArreglo(int[] datos) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < datos.length; i++) {
            sb.append(datos[i]);
            if (i < datos.length - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        SumaBinaria id = new SumaBinaria();

        id.leerDatos();
        id.resuelve();
    }
}