package Lab_1_ClaseDate_TimeDate;
import java.time.LocalDate;
import java.util.Date;

public class Fecha{

    // Data = 32
    // año = 0,11----------12 bits
    // mes = 12,15--------- 4 bits
    // dia = 16,20--------- 5 bits
    // hora = 21,25-------- 5 bits
    // minuto= 26,31------- 6 bits

    private int bits;
    private static Fecha Instance = null;
    public static Fecha getInstance(){
        if(Instance==null){
            Instance=new Fecha();
        }
        return Instance;
    }

    public Fecha(){
        bits=0;

    }

    public int getMinuto(){
        int Minuto =(bits << 26) >>>26;
        return Minuto;
    }

    public int getHora(){
        int Hora =(bits << 21) >>> 27;
        return Hora;
    }

    public int getDia(){
        int Dia =(bits << 16) >>> 27;
        return Dia;

    }

    public int getMes(){
        int Mes =(bits << 12) >>> 28;
        return Mes;

    }

    public int getAño(){
        int Año =bits >>> 20 ;
        return Año;

    }

    public void setMinuto(int Minuto){
        if(Minuto >= 0 && Minuto < 60){
            int Mask = 2147483521 | (1 << 31);
            bits = (bits & Mask) | (Minuto << 0);
            System.out.println("bits= " + Long.toBinaryString(bits));
        }else{
            System.out.println("El MINUTO ingresada es invalido");
        }
    }

    public void setHora(int Hora){
        if(Hora >= 0 && Hora < 24){
            int Mask = 2147481663 | (1 << 31);
            bits = (bits & Mask) | (Hora << 6);
            System.out.println("bits= " + Long.toBinaryString(bits));
        }else{
            System.out.println("La HORA ingresada es invalido");
        }
    }

    public void setDia(int Dia){
        if(Dia >= 1 && Dia < 32){
            int Mask = 2147420159 | (1 << 31);
            bits = (bits & Mask) | (Dia << 11);
            System.out.println("Bits= " + Long.toBinaryString(bits));
        }else{
            System.out.println("El DIA ingresado es invalido");
        }
    }

    public void setMes(int Mes){
        if(Mes >= 1 && Mes < 13){
            int Mask = 2146500607 | (1 << 31);
            bits= (bits & Mask) | (Mes << 16);
            System.out.println("Bits= " + Long.toBinaryString(bits));
        }else{
            System.out.println("El MES ingresado es invalido");
        }

    }

    public void setAño(int Año){
        if(Año >= 0 && Año < 4096){
            int Mask =1048575;
            bits= (bits & Mask) | (Año << 20);
            System.out.println("Bits= " + Long.toBinaryString(bits));
        }else{
            System.out.println("El AÑO ingresado es invalido");
        }
    }

    @Override
    public String toString(){
        return   getDia() + "/" + getMes() + "/" + getAño()+ " " + getHora() + ":" + getMinuto();
    }

    public boolean sameDate (Fecha t){
        if(this.getAño()==t.getAño()){
            if(this.getMes()== t.getMes()){
                if(this.getDia()==t.getDia()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBefore (Fecha t){
        int nro1, nro2;
        nro1 = (getAño() << 9) | (getMes() << 5) | (getDia());
        nro2 = (t.getAño() << 9) | (t.getMes() << 5) | (t.getDia());
        return nro1 < nro2;

    }

    public boolean isAfter (Fecha t){
        int nro1, nro2;
        nro1 = (getAño() << 9) | (getMes() << 5) | (getDia());
        nro2 = (t.getAño() << 9) | (t.getMes() << 5) | (t.getDia());
        return nro1 > nro2;
    }
}