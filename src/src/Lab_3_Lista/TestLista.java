package Lab_3_Lista;
import java.util.Scanner;

public class TestLista {

    public static void main(String [] args) {
        Lista l = new Lista();

        Scanner tec = new Scanner(System.in);

        System.out.println("Ingrese un dato: ");
        int a = tec.nextInt();
        l.InsertaInicio(a);
        System.out.println("Ingrese un dato: ");
        int b = tec.nextInt();
        l.InsertaInicio(b);
        System.out.println("Ingrese un dato: ");
        int c = tec.nextInt();
        l.InsertaFinal(c);
        System.out.println("Ingrese un dato: ");
        int d = tec.nextInt();
        int promedio = l.Promedio();
        l.InsertaFinal(d);
        l.getMayores(promedio);
        l.Print();
        System.out.println(" ");
        System.out.println("Promedio: " + promedio);

    }
}