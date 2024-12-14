



package Acceso_BBDD_MySQL;

public class Principal {
    public static void main(String[] args) {
        // Creamos la instancia de la clase
        Acceso acceso = new Acceso();
        // conectamos
        acceso.Conectar();
        // Consultar
        String consulta = "SELECT * FROM alumnos";

        if (consulta != null && !consulta.trim().isEmpty()) {
            // hacemos la consulta
            acceso.RealizarConsulta(consulta);
        } else {
            System.out.println("La consulta SQL está vacía o es null.");
        }
    }
}
