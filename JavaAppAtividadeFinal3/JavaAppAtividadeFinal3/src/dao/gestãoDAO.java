package dao;

import beansclass.gest�o;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class gest�oDAO {
    private Conexao conexao;
    private Connection conn;
    
    public gest�oDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(gest�o gest�o){
        String sql = "INSERT INTO gest�o (cidade, comites, camaras, caixasdagua) VALUES (?,?,?,?)";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, gest�o.getcidade());
            stmt.setInt(2, gest�o.getcomites());
            stmt.setInt(3, gest�o.getcamaras());
            stmt.setInt(4, gest�o.getcaixasdagua());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
}
   
