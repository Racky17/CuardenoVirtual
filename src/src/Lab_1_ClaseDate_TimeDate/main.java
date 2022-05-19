package Lab_1_ClaseDate_TimeDate;
import java.util.Scanner;

public class main{
    public static void main(String[]args){

        Scanner tec = new Scanner(System.in);

        System.out.println("Ingrese el minuto: ");
        int minuto = tec.nextInt();
        Fecha.getInstance().setMinuto(minuto);

        System.out.println("Ingrese la hora: ");
        int hora = tec.nextInt();
        Fecha.getInstance().setHora(hora);

        System.out.println("Ingrese el dia: ");
        int dia = tec.nextInt();
        Fecha.getInstance().setDia(dia);

        System.out.println("Ingrese el mes: ");
        int mes = tec.nextInt();
        Fecha.getInstance().setMes(mes);

        System.out.println("Ingrese el año: ");
        int año = tec.nextInt();
        Fecha.getInstance().setAño(año);

        System.out.println(Fecha.getInstance().toString());
    }
}
