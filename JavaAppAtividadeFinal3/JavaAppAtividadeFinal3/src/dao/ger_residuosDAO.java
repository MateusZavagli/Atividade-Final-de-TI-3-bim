package dao;

import beansclass.ger_residuos;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ger_residuosDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ger_residuosDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(ger_residuos ger_residuos){
        String sql = "INSERT INTO ger_residuos (cidade, comunidade, n_decaixas) VALUES (?,?,?)";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, ger_residuos.getcidade());
            stmt.setString(2, ger_residuos.getcomunidade());
            stmt.setInt(3, ger_residuos.getn_decaixas());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
    public void alterar(ger_residuos ger_residuos){
        String sql = "UPDATE ger_residuos SET cidade=?, comunidade=?, n_decaixas=? WHERE id=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, ger_residuos.getcidade());
            stmt.setString(2, ger_residuos.getcomunidade());
            stmt.setInt(3, ger_residuos.getn_decaixas());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao atualizar dados: "+ e.getMessage());
        }
    }
    public void excluir(int id){
        String sql = "DELETE FROM ger_residuos WHERE id = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            stmt.execute();          
        }catch(Exception e){
            System.out.println("Erro ao excluir dados: "+ e.getMessage());
        }
    }
    public ger_residuos getger_residuos(int id){
        String sql = "SELECT * FROM ger_residuos Where id =?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            ger_residuos ger_residuos = new ger_residuos();
            rs.next();
            ger_residuos.setId(rs.getInt("id"));
            ger_residuos.setcidade(rs.getString("cidade"));
            ger_residuos.setcomunidade(rs.getString("comunidade"));
            ger_residuos.setn_decaixas(rs.getInt("n_decaixas"));
            return ger_residuos;
        }catch(Exception e){
            System.out.println("Erro ao acessar problemas: "+ e.getMessage());
        }return null;
    }
    public List<ger_residuos> getger_residuos(){
        String sql = "SELECT * FROM ger_residuos";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            ResultSet rs = stmt.executeQuery();
            List<ger_residuos> listager_residuos = new ArrayList<>();
            while(rs.next()){
                ger_residuos r = new ger_residuos();
                r.setId(rs.getInt("id"));
                r.setcidade(rs.getString("cidade"));
                r.setcomunidade(rs.getString("comunidade"));
                r.setn_decaixas(rs.getInt("n_decaixas"));
                listager_residuos.add(r);
            }
            return listager_residuos;
        }catch(Exception e){
            return null;
        }
    }
}
    
