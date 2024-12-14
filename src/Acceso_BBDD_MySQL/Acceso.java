package Acceso_BBDD_MySQL;

import java.sql.*;
public class Acceso{
    private Connection conexion;
    private Statement St;
    private ResultSet rs;
    public Acceso(){
    }
    public void Conectar(){
        try{
// Se carga el driver mysql de la siguiente forma:
            Class.forName("com.mysql.cj.jdbc.Driver");
// Datos para la conexión:
            String url="jdbc:mysql://localhost/clasecesur";
            String usuario="root";
            String contraseña="";

// Crear un objeto conexión:
            //Primer paso
             Connection conexion = DriverManager.getConnection (url,usuario, contraseña);
// Se crea un objeto de tipo Statement, para realizar la consulta:
            //Segundo paso
            St = conexion.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void RealizarConsulta(String consulta){
        try{
// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
            rs = St.executeQuery (consulta);
            ResultSetMetaData metadata = rs.getMetaData();

            int Columnas = metadata.getColumnCount();
            // Nombre tabla
            String nombre = metadata.getTableName(1);
            // Esquema tabla
            String esquema = metadata.getSchemaName(1);

            // Mostrar información
            System.out.println("Número de columnas: " + Columnas);
            System.out.println("Nombre de la tabla: " + nombre);
            System.out.println();

// se recuperan los datos recorriendo el ResultSet, mostrando por pantalla los resultados:
            System.out.println("Datos de la tabla alumnos con columnas");
            System.out.println("--------------------------------------");

            System.out.println("Id "+"Nombre "+ "Apellido "+"Edad");
            while (rs.next()){
                System.out.println (rs.getInt (1) + " " +
                        rs.getString (2) + " " +
                        rs.getString(3) + " " +
                        rs.getInt (4) );
            }
// Se debe cerrar la conexión con la base de datos (aquí o en otra función aparte, al finalizar todas las operaciones)
St.close();
rs.close();
conexion.close();
        }catch (Exception e ) {
            e.printStackTrace();
        }
    }
}

