package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Authenticator {
    public User authenticate(String username, String password) 
    {
        User result = null;
        boolean exist = false;
        //System.out.println("nombre="+username+" password="+password);
        //System.out.println("SELECT id,username,nombre,appaterno,apmaterno,telefono,correo,contrasenia FROM persona WHERE username=\""+username+"\" and contrasenia=\""+password+"\"");
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection
               ("jdbc:mysql://localhost:3306/course", "root", "admin");
            Statement stmt = conn.createStatement();
            String consulta = "SELECT * FROM persona WHERE username=\"" +
                            username+"\" AND contrasenia=\""+password+"\"";
            ResultSet rs = 
                    stmt.executeQuery(consulta);
            
            String usernameDB=null;
            String passwordDB=null;  
            String nombreDB=null;
            String appaternoDB=null;
            String apmaternoDB=null;
            String telefonoDB=null;
            String correoDB=null;
            while (rs.next())
            {
              ///int id = rs.getInt("id");
              usernameDB = rs.getString("username");
              nombreDB = rs.getString("nombre");
              passwordDB = rs.getString("contrasenia");
              appaternoDB = rs.getString("appaterno");
              apmaternoDB = rs.getString("apmaterno");
              telefonoDB = rs.getString("telefono");
              correoDB = rs.getString("correo");
              exist = true;
            }
            if (exist==true)
            {
                result = new User();
                result.setUsername(usernameDB);
                result.setPassword(passwordDB);
                result.setNombre(nombreDB);
                result.setApPaterno(appaternoDB);
                result.setApMaterno(apmaternoDB);
                result.setTelefono(telefonoDB);
                result.setCorreo(correoDB);
            }
            System.out.println("nombre="+usernameDB+" passwordDB="+passwordDB);
            stmt.close();
            conn.close();
        }
        catch(Exception ioe)
        {
            ioe.printStackTrace();
        }
        
        return result;
    }
    
    
    
}