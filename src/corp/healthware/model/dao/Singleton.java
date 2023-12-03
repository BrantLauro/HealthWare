
package corp.healthware.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class Singleton {
    private Connection conexao;
    private static Singleton instancia = null;
    
   private Singleton()throws SQLException{
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthware?user=root&password=");//mudar porta sempre
    }
    
    public static Singleton getInstancia()throws SQLException{
        if(instancia == null)
            instancia = new Singleton();
            return instancia;
        
    }
    public Connection getConexao(){
        return conexao;
    }
    public void close()throws SQLException{
        conexao.close();
    }
}