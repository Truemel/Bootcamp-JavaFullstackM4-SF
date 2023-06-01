import java.util.Scanner;

public class VisitaEnTerreno {

    private int identVisita;
    private int rutCliente;
    private String dia; //debe ser desplegado con el formato DD/MM/AAAA
    private String hora; //debe ser una hora válida del día, en formato HH:MM (hora desde 0 a 23, minutos entre 0 y 59)
    private String lugar; //mínimo 10 caracteres, máximo 50
    private String comentarios; //máximo 100 caracteres

    public VisitaEnTerreno(){
        identVisita = rutCliente = 0;
        dia = "01/01/0001";
        hora = "00:00";
        lugar = "Melipilla1";
        comentarios = "";
    }

    public  VisitaEnTerreno(int identVisita, int rutCliente, String dia, String hora, String lugar, String comentarios, Scanner sc){
        this.identVisita = identVisita;
        this.rutCliente = rutCliente;
        setDia(dia);
        setHora(hora);
        setLugar(lugar, sc);
        setComentarios(comentarios);
    }

    public int getIdentVisita() {
        return identVisita;
    }

    public void setIdentVisita(int identVisita) {
        this.identVisita = identVisita;
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
        if(dia.matches("^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$"))
            this.dia = dia;
        else {
            System.out.println("Error, fecha fué mal ingresada, será reemplazado por 01/01/2001");
            this.dia = "01/01/2001";
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        if(comentarios.length() <= 100)
            this.comentarios = comentarios;
        else {
            System.out.println("Error, comentarios mal ingresado, será reemplazado por sin comentarios");
            this.comentarios = "Sin comentarios";
        }
    }

    @Override
    public String toString() {
        return "VisitaEnTerreno{" +
                "identVisita=" + identVisita +
                ", rutCliente=" + rutCliente +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}