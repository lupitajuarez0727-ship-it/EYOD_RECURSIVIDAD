import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class InvertirOrden_Arreglo {
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

    public void leerDatos() {
        n = reader.nextInt();
        data = new int[n];

        for(int i = 0; i < n; i++){
            data[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        // TODO
        System.out.println("Antes");
        mostrarArreglo(data);
        reverseArray(data, 0, n - 1);
        System.out.println("Despues");
        mostrarArreglo(data);
    }
    //Metodo recursivo
    public void reverseArray(int[] data, int low, int high){
        if(low < high){
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1);

        }
    }

    public void mostrarArreglo(int[] datos){
        StringBuilder sb = new StringBuilder("[");

        for(int i = 0; i < datos.length; i++){
            sb.append(datos[i]);
            if(i < datos.length - 1) sb.append(", ");
        }
        sb.append("[");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        InvertirOrden_Arreglo id  = new InvertirOrden_Arreglo();

        id.leerDatos();
        id.resuelve();
    }  
}