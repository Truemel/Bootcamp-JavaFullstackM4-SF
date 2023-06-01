import java.util.Scanner;

public class Administrativo extends Usuario {

    private String area; //mínimo 5 caracteres, máximo 20
    private String expPrevia; //máximo 100 caracteres

    public Administrativo(){
        super();
        area = "";
        expPrevia = "0";
    }

    public Administrativo(String area, String expPrevia, int run, String nombre, String fechaNaci, Scanner sc){
        super(run, nombre, fechaNaci, sc);
        setArea(area, sc);
        setExpPrevia(expPrevia);
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Area: "+area);
        System.out.println("Años de experiencia previa: "+expPrevia);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area, Scanner sc) {
        do{
            if(area.length() >= 5 && area.length() <= 20)
                this.area = area;
            else {
                System.out.println("Error, area mal ingresada, debe tener entre 5 y 20 caracteres");
                area = sc.nextLine();
            }
        }while (area.length() < 5 || area.length() > 20);
    }

    public String getExpPrevia() {
        return expPrevia;
    }

    public void setExpPrevia(String expPrevia) {
        if(expPrevia.length() <= 100)
            this.expPrevia = expPrevia;
        else {
            System.out.println("Error, experiencia previa fue mal ingresada, debe tener un máximo de 100 caracteres");
            this.expPrevia = "0 exp";
        }
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "area='" + area + '\'' +
                ", expPrevia='" + expPrevia + '\'' +
                '}';
    }
}
