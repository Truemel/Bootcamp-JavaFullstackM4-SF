import java.util.Scanner;

public class Revision {

    private int identRev;
    private int identVisita;
    private String nombreAlusivo; //mínimo 10 caracteres, máximo 50
    private String detalle; //máximo 100 caracteres
    private int estado; //1 (sin problemas), 2 (con observaciones), 3 (no aprueba)

    public Revision(){
        identRev = identVisita = 0;
        nombreAlusivo = "Nombramiento Alusivo";
        detalle = "";
        estado = 1;
    }

    public Revision(int identRev, int identVisita, String nombreAlusivo, String detalle, int estado, Scanner sc){
        this.identRev = identRev;
        this.identVisita = identVisita;
        setNombreAlusivo(nombreAlusivo, sc);
        setDetalle(detalle);
        setEstado(estado, sc);
    }

    public int getIdentRev() {
        return identRev;
    }

    public void setIdentRev(int identRev) {
        this.identRev = identRev;
    }

    public int getIdentVisita() {
        return identVisita;
    }

    public void setIdentVisita(int identVisita) {
        this.identVisita = identVisita;
    }

    public String getNombreAlusivo() {
        return nombreAlusivo;
    }

    public void setNombreAlusivo(String nombreAlusivo, Scanner sc) {
        do{
            if(nombreAlusivo.length() >= 10 && nombreAlusivo.length() <= 50)
                this.nombreAlusivo = nombreAlusivo;
            else {
                System.out.println("Error, nombre alusivo mal ingresado, debe tener entre 10 y 50 caracteres");
                nombreAlusivo = sc.nextLine();
            }
        }while(nombreAlusivo.length() < 10 || nombreAlusivo.length() > 50);
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        if(detalle.length() <= 100)
            this.detalle = detalle;
        else {
            System.out.println("Error, detalle mal ingresado, será reemplazado por detalle");
            this.detalle = "detalle";
        }
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado, Scanner sc) {
        do{
            if(estado >= 1 && estado <= 3)
                this.estado = estado;
            else {
                System.out.println("Error, estado mal ingresado, debe ingresar un valor de 1 a 3");
                System.out.println("1 (sin problemas), 2 (con observaciones), 3 (no aprueba)");
                estado = sc.nextInt();
            }
        }while(estado < 1 || estado > 3);
    }

    @Override
    public String toString() {
        return "Revision{" +
                "identRev=" + identRev +
                ", identVisita=" + identVisita +
                ", nombreAlusivo='" + nombreAlusivo + '\'' +
                ", detalle='" + detalle + '\'' +
                ", estado=" + estado +
                '}';
    }
}
