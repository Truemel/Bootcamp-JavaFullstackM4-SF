import java.util.Scanner;

public class Profesional extends Usuario {

    private String titulo; //mínimo 10 caracteres, máximo 50
    private String fechaIngreso; //DD/MM/AAAA

    public Profesional(){
        super();
        titulo = "";
        fechaIngreso = "";
    }

    public Profesional(String titulo, String fechaIngreso, String nombre, int run, String fechaNaci, Scanner sc){
        super(run, nombre, fechaNaci, sc);
        setTitulo(titulo, sc);
        setFechaIngreso(fechaIngreso);
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Titulo: "+titulo);
        System.out.println("Fecha de ingreso: "+fechaIngreso);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo, Scanner sc) {
        do{
            if(titulo.length() >= 10 && titulo.length() <= 50)
                this.titulo = titulo;
            else {
                System.out.println("Error, titulo mal ingresado, debe tener entre 10 y 50 caracteres");
                //this.titulo = "Titulo2023";
                titulo = sc.nextLine();
            }
        }while (titulo.length() < 10 || titulo.length() > 50);
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        if(fechaIngreso.matches("^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$"))
            this.fechaIngreso = fechaIngreso;
        else {
            System.out.println("Error, fecha fué mal ingresada, será reemplazada por 01/01/2001");
            this.fechaIngreso = "01/01/2001";
        }
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "titulo='" + titulo + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                '}';
    }
}