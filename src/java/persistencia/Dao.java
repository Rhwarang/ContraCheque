package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
    protected Connection con;
    protected ResultSet rs;
    protected PreparedStatement stmt;
    
    public void abrirConexao() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/contracheque", "root", "1234");
    }
    
    public void fecharConexao(){
        try {
            con.close();
        } catch (Exception e) {
        }
    }
}
