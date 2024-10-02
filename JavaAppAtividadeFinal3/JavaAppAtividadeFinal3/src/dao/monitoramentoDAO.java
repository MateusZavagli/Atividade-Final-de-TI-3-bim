package dao;

import beansclass.monitoramento;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class monitoramentoDAO {
    private Conexao conexao;
    private Connection conn;
    
    public monitoramentoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(monitoramento monitoramento){
        String sql = "INSERT INTO monitoramento (cidade, qualidade) VALUES (?,?)";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, monitoramento.getcidade());
            stmt.setString(2, monitoramento.getqualidade());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
}
   
