import java.util.Scanner;

public class Ejercicio3_invertida {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una cadena de texto: ");
        String textoIngresado = scanner.nextLine();

        InversorCadena inversor = new InversorCadena(textoIngresado);
        String textoInvertido = inversor.invertir();

        System.out.println("Texto invertido: " + textoInvertido);

    }
}
