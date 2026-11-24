//CASO1: 3 5 1 2 3 4 5
//CASO2: 3 4 1 2 3 4
//CASO3: 2 4 1 2 3 4
package estructurasnolineales.recursividad.P7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RecursionMultiple {
    // FastReader class for efficient input
    int k;
    List<Integer> U = new ArrayList<>();            // elementos que aun no se usan
    List<Integer> S = new ArrayList<>();            // secuencia que se va armando
    int soluciones = 0;
    int intentos = 0;
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


    // Entrada: k (largo de la secuencia), m (cuantos elementos) y los m elementos
    public void leerDatos() {
        k = reader.nextInt();
        int m = reader.nextInt();
        for (int i = 0; i < m; i++) {
            U.add(reader.nextInt());
        }
    }

    public void resuelve() {
        System.out.println("Buscando secuencias de " + k + " elementos donde la suma de los primeros "
                + (k - 1) + " sea igual al ultimo:");
        puzzleSolve(k, S, U);
        System.out.println("Soluciones: " + soluciones);
        System.out.println("Secuencias probadas: " + intentos);
    }

    // Recursion multiple: cada llamada hace VARIAS llamadas (una por cada elemento de U)
    public void puzzleSolve(int k, List<Integer> S, List<Integer> U) {
        for (int i = 0; i < U.size(); i++) {
            int e = U.remove(i);                    // saca e de U
            S.add(e);                               // lo agrega a S
            if (k == 1) {                           // caso base: S ya tiene k elementos
                intentos++;
                if (esSolucion(S)) {
                    soluciones++;
                    System.out.println(S);
                }
            } else {
                puzzleSolve(k - 1, S, U);           // sigue armando la secuencia
            }
            S.remove(S.size() - 1);                 // regresa e a U (backtracking)
            U.add(i, e);
        }
    }

    // La secuencia es solucion si la suma de todos menos el ultimo es igual al ultimo
    boolean esSolucion(List<Integer> S) {
        int suma = 0;
        for (int i = 0; i < S.size() - 1; i++) {
            suma += S.get(i);
        }
        return suma == S.get(S.size() - 1);
    }

    public static void main(String[] args) {
        RecursionMultiple id = new RecursionMultiple();

        id.leerDatos();
        id.resuelve();
    }
}