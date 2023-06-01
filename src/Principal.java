import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();
        Scanner sc = new Scanner(System.in);
        menu(sc, contenedor);
        sc.close();
    }

    public static void menu(Scanner sc, Contenedor cont){
        int choice = 0;
        do{
            System.out.println("Ingresa una opción");
            System.out.println("(1) Almacenar cliente");
            System.out.println("(2) Almacenar profesional");
            System.out.println("(3) Almacenar administrativo");
            System.out.println("(4) Almacenar capacitacion");
            System.out.println("(5) Eliminar usuario");
            System.out.println("(6) Listar usuarios");
            System.out.println("(7) Listar usuarios por tipo");
            System.out.println("(8) Listar capacitaciones");
            System.out.println("(0) Salir");
            switch (choice = Integer.parseInt(sc.nextLine())){
                case 0: {
                    System.out.println("Bye");
                    break;
                }
                case 1: {
                    addCliente(cont, sc);
                    break;
                } case 2: {
                    addProfes(cont, sc);
                    break;
                } case 3: {
                    addAdminis(cont, sc);
                    break;
                } case 4: {
                    addCapaci(cont, sc);
                    break;
                } case 5: {
                    delUsuario(cont, sc);
                    break;
                } case 6: {
                    cont.listarUsuarios();
                    break;
                } case 7: {
                    listUsuarioTipo(cont, sc);
                    break;
                } case 8: {
                    cont.listarCapacitaciones();
                    break;
                } default:
                    System.out.println("Error, valor ingresado incorrecto");
            }
        }while (choice != 0);
        sc.close();
    }

    public static void addUsuarioData(Usuario user, Scanner sc){
        System.out.println("Ingresar nombre de usuario");
        user.setNombre(sc.nextLine(), sc);
        System.out.println("Ingresar fecha de nacimiento");
        user.setFechaNaci(sc.nextLine(), sc);
        System.out.println("Ingresar run del usuario");
        user.setRun(Integer.parseInt(sc.nextLine()));
    }

    public static void addCliente(Contenedor cont, Scanner sc){
        Cliente cliente = new Cliente();
        addUsuarioData(cliente, sc);
        System.out.println("Ingresar edad");
        cliente.setEdad(Integer.parseInt(sc.nextLine()), sc);
        System.out.println("Ingresar rut cliente");
        cliente.setRut(Integer.parseInt(sc.nextLine()));
        System.out.println("Ingresar nombres del cliente");
        cliente.setNombres(sc.nextLine(), sc);
        System.out.println("Ingresar apellidos del cliente");
        cliente.setApellidos(sc.nextLine(), sc);
        System.out.println("Ingresar comuna");
        cliente.setComuna(sc.nextLine());
        System.out.println("Ingresar dirección");
        cliente.setDireccion(sc.nextLine());
        System.out.println("Ingresar afp");
        cliente.setAfp(sc.nextLine());
        System.out.println("Ingresar sistema de salud (1) Fonasa, (2) Isapre");
        cliente.setSysSalud(Integer.parseInt(sc.nextLine()), sc);
        System.out.println("Ingresar telefono");
        cliente.setTelefono(Integer.parseInt(sc.nextLine()));
        cont.almacenarCliente(cliente);
    }

    public static void addProfes(Contenedor cont, Scanner sc){
        Profesional profe = new Profesional();
        addUsuarioData(profe, sc);
        System.out.println("Ingresar título");
        profe.setTitulo(sc.nextLine(), sc);
        System.out.println("Ingresar fecha de ingreso");
        profe.setFechaIngreso(sc.nextLine());
        cont.almacenarProfesional(profe);
    }

    public static void addAdminis(Contenedor cont, Scanner sc){
        Administrativo admin = new Administrativo();
        addUsuarioData(admin, sc);
        System.out.println("Ingresar area");
        admin.setArea(sc.nextLine(), sc);
        System.out.println("Ingresar experiecia previa");
        admin.setExpPrevia(sc.nextLine());
        cont.almacenarAdministrativo(admin);
    }

    public static void addCapaci(Contenedor cont, Scanner sc){
        Capacitacion capaci = new Capacitacion();
        System.out.println("Ingresar identificador");
        capaci.setIdent(Integer.parseInt(sc.nextLine()));
        System.out.println("Ingresar rut del cliente");
        capaci.setRutCliente(Integer.parseInt(sc.nextLine()));
        System.out.println("Ingresar lugar");
        capaci.setLugar(sc.nextLine(), sc);
        System.out.println("Ingresar día");
        capaci.setDia(sc.nextLine().toLowerCase());
        System.out.println("Ingresar hora");
        capaci.setHora(sc.nextLine());
        System.out.println("Ingresar duración");
        capaci.setDuracion(sc.nextLine());
        System.out.println("Ingresar cantidad de asistentes");
        capaci.setCantAsist(Integer.parseInt(sc.nextLine()), sc);
        cont.almacenarCapacitacion(capaci);
    }

    public static void delUsuario(Contenedor cont, Scanner sc){
        int rut = 0;
        do{
            System.out.println("Ingresa rut del usuario a eliminar");
            rut = Integer.parseInt(sc.nextLine());
            if(rut >= 99999999)
                System.out.println("Error, rut debe ser menor a 99.999.999");
        }while (rut >= 99999999);
        cont.eliminarUsuario(rut);
    }

    public static void listUsuarioTipo(Contenedor cont, Scanner sc){
        do{
            System.out.println("Ingresar tipo de usuario");
        }while (!cont.listarUsuariosPorTipo(sc.nextLine()));
    }
}