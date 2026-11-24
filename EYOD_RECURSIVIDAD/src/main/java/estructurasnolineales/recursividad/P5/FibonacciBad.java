//CAOS1:5
//CASO2:10
//CASO3:20
package estructurasnolineales.recursividad.P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FibonacciBad {
    // FastReader class for efficient input
    int n;
    long llamadas = 0;
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


    // Entrada: el numero n
    public void leerDatos() {
        n = reader.nextInt();
    }

    public void resuelve() {
        long t0 = System.nanoTime();
        long resultado = fibonacci(n);
        long t1 = System.nanoTime();

        System.out.println("Fibonacci(" + n + ") = " + resultado);
        System.out.println("Llamadas recursivas: " + llamadas);
        System.out.printf("Tiempo: %.4f ms%n", (t1 - t0) / 1e6);
    }

    // Recursion binaria: F(k) = F(k-1) + F(k-2)  -> dos llamadas por cada una
    public long fibonacci(int k) {
        llamadas++;
        if (k <= 1) {                               // casos base: F(0) = 0, F(1) = 1
            return k;
        }
        return fibonacci(k - 1) + fibonacci(k - 2);
    }

    public static void main(String[] args) {
        FibonacciBad id = new FibonacciBad();

        id.leerDatos();
        id.resuelve();
    }
}