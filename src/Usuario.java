import java.time.LocalDate;

public abstract class Usuario implements Asesoria {

    private int run; //menor a 99.999.999
    protected String nombre; //mínimo 10 caracteres, máximo 50
    private String fechaNaci; //debe ser desplegado con el formato DD/MM/AAAA

    public Usuario(){
        run = 0;
        nombre = "abcdefghij";
        fechaNaci = "01/01/0001";
    }

    public Usuario(int run, String nombre, String fechaNaci){
        setNombre(nombre);
        setRun(run);
        setFechaNaci(fechaNaci);
    }

    @Override
    public void analizarUsuario() {
        System.out.println("Nombre: "+nombre);
        System.out.println("RUN: "+run);
    }

    public String mostrarEdad(){
        int year = Integer.parseInt(fechaNaci.substring(fechaNaci.lastIndexOf('/')+1));
        return "El usuario tiene "+(LocalDate.now().getYear()-year)+" años";
    }

    public String getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(String fechaNaci) {
        do{
            if(fechaNaci.matches("^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$"))
                this.fechaNaci = fechaNaci;
            else {
                System.out.println("Error, fecha fué mal ingresada,debe seguir este formato 01/01/2001");
                //this.fechaNaci = "01/01/2001";
            }
        }while(!fechaNaci.matches("^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$"));
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        if(run < 99999999)
            this.run = run;
        else {
            System.out.println("Error, run mal ingresado, será reemplazado por 0");
            this.run = 0;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        do{
            if(nombre.length() >= 10 && nombre.length() <= 50)
                this.nombre = nombre;
            else{
                System.out.println("Error, nombre mal ingresado, debe tener entre 10 y 50 caracteres");
                //this.nombre = "abcdefghij";
            }
        }while(nombre.length() < 10 || nombre.length() > 50);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "run=" + run +
                ", nombre='" + nombre + '\'' +
                ", fechaNaci='" + fechaNaci + '\'' +
                '}';
    }
}
