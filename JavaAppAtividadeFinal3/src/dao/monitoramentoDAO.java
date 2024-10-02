package dao;

import beansclass.monitoramento;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public void alterar(monitoramento monitoramento){
        String sql = "UPDATE monitoramento SET cidade=?, qualidade=? WHERE id=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, monitoramento.getcidade());
            stmt.setString(2, monitoramento.getqualidade());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao atualizar dados: "+ e.getMessage());
        }
    }
    public void excluir(int id){
        String sql = "DELETE FROM monitoramento WHERE id = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            stmt.execute();          
        }catch(Exception e){
            System.out.println("Erro ao excluir dados: "+ e.getMessage());
        }
    }
    public monitoramento getmonitoramento(int id){
        String sql = "SELECT * FROM monitoramento Where id =?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            monitoramento monitoramento = new monitoramento();
            rs.next();
            monitoramento.setId(rs.getInt("id"));
            monitoramento.setcidade(rs.getString("cidade"));
            monitoramento.setqualidade(rs.getString("qualidade"));
            return monitoramento;
        }catch(Exception e){
            System.out.println("Erro ao acessar problemas: "+ e.getMessage());
        }return null;
    }
    public List<monitoramento> getmonitoramento(){
        String sql = "SELECT * FROM monitoramento";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            ResultSet rs = stmt.executeQuery();
            List<monitoramento> listamonitoramento = new ArrayList<>();
            while(rs.next()){
                monitoramento m = new monitoramento();
                m.setId(rs.getInt("id"));
                m.setcidade(rs.getString("cidade"));
                m.setqualidade(rs.getString("qualidade"));
                listamonitoramento.add(m);
            }
            return listamonitoramento;
        }catch(Exception e){
            return null;
        }
    }

    public List<monitoramento> getmoniotramento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
   
