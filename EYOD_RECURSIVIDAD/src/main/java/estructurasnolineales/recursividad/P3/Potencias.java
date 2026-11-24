//CASO1:2 5
//CASO2:2 8
//CASO3: 3 4
package estructurasnolineales.recursividad.P3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Potencias {
    // FastReader class for efficient input
    long x;
    int n;
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

    // Entrada: la base x y el exponente n
    public void leerDatos() {
        x = reader.nextLong();
        n = reader.nextInt();
    }

    public void resuelve() {
        System.out.println("Base: " + x + "  Exponente: " + n);

        // --- Metodo BAD (lineal) ---
        BigInteger bad = null;
        long t0 = System.nanoTime();
        try {
            bad = potenciaBad(x, n);
        } catch (StackOverflowError e) {
            System.out.println("BAD: StackOverflowError (demasiadas llamadas)");
        }
        long t1 = System.nanoTime();
        if (bad != null) {
            System.out.printf("BAD  : %.4f ms  -> %s%n", (t1 - t0) / 1e6, texto(bad));
        }

        // --- Metodo GOOD (por mitades) ---
        long t2 = System.nanoTime();
        BigInteger good = potenciaGood(x, n);
        long t3 = System.nanoTime();
        System.out.printf("GOOD : %.4f ms  -> %s%n", (t3 - t2) / 1e6, texto(good));
    }

    // BAD:x^n = x * x^(n-1)   -> n llamadas
    public BigInteger potenciaBad(long x, int n) {
        if (n == 0) {                           // caso base
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(x).multiply(potenciaBad(x, n - 1));
    }

    // GOOD:se calcula x^(n/2) UNA sola vez y se eleva al cuadrado   -> log n llamadas
    public BigInteger potenciaGood(long x, int n) {
        if (n == 0) {                           // caso base
            return BigInteger.ONE;
        }
        BigInteger mitad = potenciaGood(x, n / 2);
        BigInteger cuadrado = mitad.multiply(mitad);
        if (n % 2 == 0) {
            return cuadrado;
        }
        return cuadrado.multiply(BigInteger.valueOf(x));
    }

    // Si el resultado es enorme solo se muestra cuantos digitos tiene
    String texto(BigInteger r) {
        String s = r.toString();
        return s.length() <= 30 ? s : "(numero de " + s.length() + " digitos)";
    }

    public static void main(String[] args) {
        Potencias id = new Potencias();

        id.leerDatos();
        id.resuelve();
    }
}