package Lab_1_ClaseDate_TimeDate;
import java.util.Scanner;

public class TestFecha{
    public static void main(String[]args){

        Scanner tec = new Scanner(System.in);

        Fecha fecha_1 = new Fecha();
        Fecha fecha_2 = new Fecha();
        int x; //"x" es un numero al azar que desea ingresa de acuerdo a lo que se pide para la fecha_1
        int x2; // "x2" es igual a "x" pero en este caso es para fecha_2

        System.out.println("ingrese la fecha actual en los siguientes datos...");

        System.out.println("MINUTO: \t");
        x = tec.nextInt();
        fecha_1.setMinuto(x);

        System.out.println("HORA: \t");
        x = tec.nextInt();
        fecha_1.setHora(x);

        System.out.println("DIA: \t");
        x = tec.nextInt();
        fecha_1.setDia(x);

        System.out.println("MES: \t");
        x = tec.nextInt();
        fecha_1.setMes(x);

        System.out.println("ANO: ");
        x = tec.nextInt();
        fecha_1.setAño(x);

        System.out.println(fecha_1);
        System.out.println("");

        System.out.println("ingrese los siguiente datos segun la fecha que desea compara con la actual\n");

        System.out.println("MINUTO: \t");
        x2 = tec.nextInt();
        fecha_2.setMinuto(x2);

        System.out.println("HORA: \t");
        x2 = tec.nextInt();
        fecha_2.setHora(x2);

        System.out.println("DIA: \t");
        x2 = tec.nextInt();
        fecha_2.setDia(x2);

        System.out.println("MES: \t");
        x2 = tec.nextInt();
        fecha_2.setMes(x2);

        System.out.println("ANO: ");
        x2 = tec.nextInt();
        fecha_2.setAño(x2);

        System.out.println(fecha_2);
        System.out.println("");

        if (fecha_1.sameDate(fecha_2)) {
            System.out.println("Las fechas son iguales");
        }
        if (fecha_1.isBefore(fecha_2)) {
            System.out.println("La fecha del sistema es anterior a la ingresada");
        }
        if (fecha_1.isAfter(fecha_2)){
            System.out.println("La fecha del sistema es posterior a la ingresada");
        }
    }
}
