package dao;

import beansclass.login;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginDAO {
    private Conexao conexao;
    private Connection conn;
    
    public loginDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(login login){
        String sql = "INSERT INTO login (senha, usuario) VALUES (?,?)";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, login.getsenha());
            stmt.setString(2, login.getusuario());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao fazer login: " + e.getMessage());
        }
    }
}
