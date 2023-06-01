import java.util.Scanner;

public class Capacitacion {

    private int ident;
    private int rutCliente;
    private String dia; //lunes a Domingo
    private String hora; //debe ser una hora válida del día, en formato HH:MM (hora desde 0 a 23, minutos entre 0 y 59)
    private String lugar; //mínimo 10 caracteres, máximo 50
    private String duracion; //máximo 70 caracteres
    private int cantAsist; //menor que 1000

    public Capacitacion(){
        ident = 0;
        rutCliente = 0;
        dia = "lunes";
        hora = "00:00";
        lugar = "Calle 2489";
        duracion = "0";
        cantAsist = 0;
    }

    public Capacitacion(int ident, int rutCliente, String dia, String hora, String lugar, String duracion,
                        int cantAsist, Scanner sc){
        this.ident = ident;
        this.rutCliente = rutCliente;
        setDia(dia);
        setHora(hora);
        setLugar(lugar, sc);
        setDuracion(duracion);
        setCantAsist(cantAsist, sc);
    }

    public String mostrarDetalle(){
        return "La capacitación será en "+lugar+" a las "+hora.substring(0, hora.indexOf(':'))+" del día "+dia+
                ", y durará "+hora.substring(hora.indexOf(':')+1, hora.length())+" minutos";
    }

    public int getIdent() {
        return ident;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        if(dia.matches("^lunes$|^martes$|^miercoles$|^jueves$|^domingo$"))
            this.dia = dia;
        else {
            System.out.println("Error, dia mal ingresado, será reemplazado por lunes");
            this.dia = "lunes";
        }
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if(hora.matches("^[0-1][0-9]:[0-5][0-9]$|^2[0-3]:[0-5][0-9]$"))
            this.hora = hora;
        else {
            System.out.println("Error, hora mal ingresada, será reemplazada por 00:00");
            this.hora = "00:00";
        }
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar, Scanner sc) {
        do{
            if(lugar.length() >= 10 && lugar.length() <= 50)
                this.lugar = lugar;
            else {
                System.out.println("Error, lugar mal ingresado, debe tener entre 10 y 50 caracteres");
                lugar = sc.nextLine();
            }
        }while(lugar.length() < 10 || lugar.length() > 50);
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        if(duracion.length() <= 70)
            this.duracion = duracion;
        else {
            System.out.println("Error, duración mal ingresada, será reemplazada por 1 hora");
            this.duracion = "1 hora";
        }
    }

    public int getCantAsist() {
        return cantAsist;
    }

    public void setCantAsist(int cantAsist, Scanner sc) {
        do{
            if(cantAsist < 1000)
                this.cantAsist = cantAsist;
            else {
                System.out.println("Error, cantidad de asistentes mal ingresada, valor debe ser menor a 1000");
                cantAsist = Integer.parseInt(sc.nextLine());
            }
        }while (cantAsist >= 1000);
    }

    @Override
    public String toString() {
        return "Capacitacion{" +
                "ident=" + ident +
                ", rutCliente=" + rutCliente +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                ", duracion='" + duracion + '\'' +
                ", cantAsist=" + cantAsist +
                '}';
    }
}