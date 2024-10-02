package dao;

import beansclass.gestão;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class gestãoDAO {
    private Conexao conexao;
    private Connection conn;
    
    public gestãoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(gestão gestão){
        String sql = "INSERT INTO gestão (cidade, comites, camaras, caixasdagua) VALUES (?,?,?,?)";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, gestão.getcidade());
            stmt.setInt(2, gestão.getcomites());
            stmt.setInt(3, gestão.getcamaras());
            stmt.setInt(4, gestão.getcaixasdagua());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
}
   
