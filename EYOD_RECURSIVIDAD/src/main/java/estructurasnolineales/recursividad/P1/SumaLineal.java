//CASO1:5 4 3 6 2 8
//CASO2: 3 10 20 30
package estructurasnolineales.recursividad.P1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumaLineal {
    // FastReader class for efficient input
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
        System.out.println("Suma:    " + linearSum(data, n));
    }

    // Recursion lineal: suma los primeros n elementos del arreglo
    public int linearSum(int[] data, int n) {
        if (n == 0) {                               // caso base: no hay elementos
            return 0;
        }
        return linearSum(data, n - 1) + data[n - 1]; // suma el resto + el ultimo
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
        SumaLineal id = new SumaLineal();

        id.leerDatos();
        id.resuelve();
    }
}
