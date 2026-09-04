import java.util.Scanner;

public class Ejercicio1_calculadora {
    public static void main(String[] args) {
        float Numero1 = 0;
        float Numero2 = 0;
        int ope = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        Numero1 = scanner.nextFloat();
        System.out.print("Ingrese el segundo número: ");
        Numero2 = scanner.nextFloat();
        System.out.print("Digite la operación 1:suma, 2:resta, 3:multiplicación, 4:división: ");
        ope = scanner.nextInt();

        Operaciones oper = new Operaciones(Numero1, Numero2);

    }
}
