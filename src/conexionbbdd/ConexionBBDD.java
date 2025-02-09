package conexionbbdd;

import java.sql.*;

public class ConexionBBDD {

    public static void main(String[] args) {
      // Paso 1: Establecemos la conexión con la base de datos, necesitamos
        // try-catch y el método estático getConnection de la clase DriverManager
        try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://100.29.157.29:3306/despliegue", "daw2", "1234");
            System.out.println("Conectado con la base de datos");

            // Paso 2: Generamos el statement, que será el objeto que utilizaremos para ejecutar las consultas a la BD
            Statement miStatement = miConexion.createStatement();

            // Paso 3: Creamos el ResultSet ejecutando la consulta deseada en el objeto statement
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM productos");

            // Paso 4: Recorremos el ResultSet
            while (miResultSet.next()) {
                // Al hacer next() no solo me devuelve true o false dependiendo de si hay más registros, 
                // sino que además mueve el cursor al siguiente registro (al principio apunta fuera de la tabla)
                System.out.println(miResultSet.getString("CODIGOARTICULO") + " " 
                        + miResultSet.getString("NOMBREARTICULO") + " "
                        + miResultSet.getString("PAISDEORIGEN"));
            }
            
            //paso 5: si deseo terminar el programa debo cerrar las conexiones ordenadamente
            miResultSet.close();
            miStatement.close();
            miConexion.close();

        } catch (Exception e) {
            System.out.println("Problemas al acceder a la base de datos: " + e.getMessage());
        }
    }
    
}


