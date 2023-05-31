import java.util.ArrayList;

public class Contenedor {

    private ArrayList<Asesoria> listaAsesoria;
    private ArrayList<Capacitacion> listaCapacitacion;

    public Contenedor(){
        listaAsesoria = new ArrayList<Asesoria>();
        listaCapacitacion = new ArrayList<Capacitacion>();
    }

    public Contenedor(ArrayList<Asesoria> listaAsesoria, ArrayList<Capacitacion> listaCapacitacion){
        this.listaAsesoria = listaAsesoria;
        this.listaCapacitacion = listaCapacitacion;
    }

    public void almacenarCliente(Cliente cliente){
        listaAsesoria.add(cliente);
    }

    public void almacenarProfesional(Profesional profesional){
        listaAsesoria.add(profesional);
    }

    public void almacenarAdministrativo(Administrativo administrativo){
        listaAsesoria.add(administrativo);
    }

    public void almacenarCapacitacion(Capacitacion capacitacion){
        listaCapacitacion.add(capacitacion);
    }

    public void eliminarUsuario(int run){
        for(int i = 0; i < listaAsesoria.size(); i++)
            if(((Usuario)listaAsesoria.get(i)).getRun() == run){
                listaAsesoria.remove(i);
                continue;
            }
    }

    public void listarUsuarios(){
        for(int i = 0; i < listaAsesoria.size(); i++){
            ((Usuario)listaAsesoria.get(i)).toString();
            System.out.println("\n");
        }
    }

    public boolean listarUsuariosPorTipo(String tipo){
        switch (tipo.toLowerCase()){
            case "cliente": {
                for(int i = 0; i < listaAsesoria.size(); i++)
                    if(listaAsesoria.get(i).getClass() == Cliente.class){
                        ((Cliente)listaAsesoria.get(i)).toString();
                    }
                break;
            }
            case "profesional": {
                for(int i = 0; i < listaAsesoria.size(); i++)
                    if(listaAsesoria.get(i).getClass() == Profesional.class){
                        ((Profesional)listaAsesoria.get(i)).toString();
                    }
                break;
            }
            case "administrativo": {
                for(int i = 0; i < listaAsesoria.size(); i++)
                    if(listaAsesoria.get(i).getClass() == Administrativo.class){
                        ((Administrativo)listaAsesoria.get(i)).toString();
                    }
                break;
            }
            default:
                System.out.println("Error, tipo de usuario mal ingresado");
                return false;
        }
        return true;
    }

    public void listarCapacitaciones(){
        for(int i = 0; i < listaCapacitacion.size(); i++){
            listaCapacitacion.get(i).toString();
            for(int j = 0; j < listaAsesoria.size(); j++){
                if(listaAsesoria.get(j).getClass() == Cliente.class &&
                        ((Cliente)listaAsesoria.get(j)).getRut() == listaCapacitacion.get(i).getRutCliente()){
                    ((Cliente)listaAsesoria.get(j)).toString();
                }
            }
            System.out.println("\n");
        }
    }

    public ArrayList<Asesoria> getListaAsesoria() {
        return listaAsesoria;
    }

    public void setListaAsesoria(ArrayList<Asesoria> listaAsesoria) {
        this.listaAsesoria = listaAsesoria;
    }

    public ArrayList<Capacitacion> getListaCapacitacion() {
        return listaCapacitacion;
    }

    public void setListaCapacitacion(ArrayList<Capacitacion> listaCapacitacion) {
        this.listaCapacitacion = listaCapacitacion;
    }

    @Override
    public String toString() {
        return "Contenedor{" +
                "listaAsesoria=" + listaAsesoria +
                ", listaCapacitacion=" + listaCapacitacion +
                '}';
    }
}
