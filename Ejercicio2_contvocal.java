import java.util.Scanner;

public class Ejercicio2_contvocal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una palabra: ");
        String palabra = scanner.next();

        ContadorVocales contador = new ContadorVocales(palabra);

        int numVocales = contador.contarVocales();
        int numConsonantes = contador.contarConsonantes();

        System.out.println("Número de vocales: " + numVocales);
        System.out.println("Número de consonantes: " + numConsonantes);
    }
}


