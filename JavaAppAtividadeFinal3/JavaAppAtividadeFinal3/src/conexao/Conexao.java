package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * @author mateus.zlcarmo
 */
public class Conexao {
    public Connection getConexao(){
    try{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsciencecompany",
                "root",
                "");
        return conn;
    }catch(Exception e){
        System.out.println("Erro de conexão" + e.getMessage());
         return null;
    }
     
    }
    
}
