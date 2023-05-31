public class Cliente extends Usuario {

    private int edad; //número mayor o igual a cero, y menor a 150
    private int rut; //menor a 99.999.999
    private String direccion; //máximo 70 caracteres
    private String comuna; //máximo 50 caracteres
    private int sysSalud; //1 (Fonasa) o 2 (Isapre),
    private String afp; //mínimo 4 caracteres, máximo 30
    private int telefono;
    private String nombres; //mínimo 5 caracteres, máximo 30
    private String apellidos; //mínimo 5 caracteres, máximo 30

    public Cliente(){
        super();
        direccion = "";
        sysSalud = 1;
        edad = 1;
        nombres = "abcde";
        apellidos = "fghij";
        afp = "afps";
        telefono = 1;
        comuna = "";
        rut = 1;
    }

    public Cliente(int edad, int rut, String direccion, String comuna, int sysSalud, String afp, int telefono,
                   String nombres, String apellidos, int run, String nombre, String fechaNaci){
        super(run, nombre, fechaNaci);
        this.telefono = telefono;
        setComuna(comuna);
        setAfp(afp);
        setRut(rut);
        setNombres(nombres);
        setApellidos(apellidos);
        setEdad(edad);
        setDireccion(direccion);
        setSysSalud(sysSalud);
    }

    public String obtenerNombre(){
        return nombres+" "+ apellidos;
    }

    public void obtenerSistemaSalud(){
        if(sysSalud == 1)
            System.out.println("Tipo de sistema de salud: Fonasa");
        else
            System.out.println("Tipo de sistema de salud: Isapre");
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        do{
            if(nombres.length() >= 5 && nombres.length() <= 30)
                this.nombres = nombres;
            else {
                System.out.println("Error, nombres mal ingresado, debe tener entre 5 y 30 caracteres");
                //this.nombres = "fghij";
            }
        }while (nombres.length() < 5 || nombres.length() > 30);
    }

    public int getSysSalud() {
        return sysSalud;
    }

    public void setSysSalud(int sysSalud) {
        do{
            if(sysSalud == 1 || sysSalud == 2)
                this.sysSalud = sysSalud;
            else
                System.out.println("Error, sistema salud mal ingresado, valor debe ser 1 (fonasa) o 2 (isapre)");
        }while(sysSalud != 1 && sysSalud != 2);
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        if(rut < 99999999)
            this.rut = rut;
        else {
            System.out.println("Error, rut mal ingresado, será reemplazado por 0");
            this.rut = 0;
        }
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        if(comuna.length() <= 50)
            this.comuna = comuna;
        else {
            System.out.println("Error, comuna mal ingresada, será reemplazada por Melipilla");
            this.comuna = "Melipilla";
        }
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        if(afp.length() >= 4 && afp.length() <= 30)
            this.afp = afp;
        else {
            System.out.println("Error, afp mal ingresado, será reemplazado por AFPS");
            this.afp = "AFPS";
        }
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        do{
            if(apellidos.length() >= 5 && apellidos.length() <= 30)
                this.apellidos = apellidos;
            else {
                System.out.println("Error, apellidos mal ingresado, debe tener entre 5 y 30 caracteres");
                //this.apellidos = "fghij";
            }
        }while (apellidos.length() < 5 || apellidos.length() > 30);
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Direccion: "+direccion);
        System.out.println("Comuna: "+comuna);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        do{
            if(edad >= 0 && edad < 150)
                this.edad = edad;
            else {
                System.out.println("Error, edad mal ingresada, valor debe estar entre 0 y 149");
                //this.edad = 1;
            }
        }while(edad < 0 || edad >= 150);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if(direccion.length() <= 70)
            this.direccion = direccion;
        else {
            System.out.println("Error, direccion mal ingresada, será reemplazada por Calle 1");
            this.direccion = "Calle 1";
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "edad=" + edad +
                ", rut=" + rut +
                ", direccion='" + direccion + '\'' +
                ", comuna='" + comuna + '\'' +
                ", sysSalud=" + sysSalud +
                ", afp='" + afp + '\'' +
                ", telefono=" + telefono +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
