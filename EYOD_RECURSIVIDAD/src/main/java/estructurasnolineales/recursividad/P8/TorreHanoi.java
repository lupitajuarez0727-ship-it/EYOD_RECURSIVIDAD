//CASO1:1
//CASO2:3
//CASO3:2
package estructurasnolineales.recursividad.P8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TorreHanoi {
    // FastReader class for efficient input
    int n;
    long movimientos = 0;
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


    // Entrada: el numero de discos
    public void leerDatos() {
        n = reader.nextInt();
    }

    public void resuelve() {
        torreHanoi(n, 'A', 'C', 'B');
        System.out.println("Total de movimientos: " + movimientos);
    }

    // Mueve n discos de from a to usando aux  (recursion multiple: 2 llamadas por llamada)
    public void torreHanoi(int n, char from, char to, char aux) {
        if (n == 0) {                               // caso base: no hay discos
            return;
        }
        torreHanoi(n - 1, from, aux, to);           // 1) mueve n-1 discos a la varilla auxiliar
        System.out.println("Mover disco " + n + " de la varilla " + from + " a la varilla " + to);
        movimientos++;
        torreHanoi(n - 1, aux, to, from);           // 2) mueve los n-1 discos encima del disco n
    }

    public static void main(String[] args) {
        TorreHanoi id = new TorreHanoi();

        id.leerDatos();
        id.resuelve();
    }
}