package dao;

import beansclass.problemas;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class problemasDAO {
    private Conexao conexao;
    private Connection conn;
    
    public problemasDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(problemas problemas){
        String sql = "INSERT INTO problemas (cidade, usuario, questao) VALUES (?,?)";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, problemas.getcidade());
            stmt.setString(2, problemas.getusuario());
            stmt.setString(3, problemas.getquestao());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
    public void alterar(problemas problemas){
        String sql = "UPDATE problemas SET cidade=?, usuario=?, questao=? WHERE id=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, problemas.getcidade());
            stmt.setString(2, problemas.getusuario());
            stmt.setString(3, problemas.getquestao());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao atualizar dados: "+ e.getMessage());
        }
    }
    public void excluir(int id){
        String sql = "DELETE FROM problemas WHERE id = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            stmt.execute();          
        }catch(Exception e){
            System.out.println("Erro ao excluir dados: "+ e.getMessage());
        }
    }
    public problemas getproblemas(int id){
        String sql = "SELECT * FROM problemas Where id =?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            problemas problemas = new problemas();
            rs.next();
            problemas.setId(rs.getInt("id"));
            problemas.setcidade(rs.getString("cidade"));
            problemas.setusuario(rs.getString("usuario"));
            problemas.setquestao(rs.getString("questao"));
            return problemas;
        }catch(Exception e){
            System.out.println("Erro ao acessar problemas: "+ e.getMessage());
        }return null;
    }
    public List<problemas> getproblemas(){
        String sql = "SELECT * FROM problemas";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            ResultSet rs = stmt.executeQuery();
            List<problemas> listaproblemas = new ArrayList<>();
            while(rs.next()){
                problemas p = new problemas();
                p.setId(rs.getInt("id"));
                p.setcidade(rs.getString("cidade"));
                p.setusuario(rs.getString("usuario"));
                p.setquestao(rs.getString("questao"));
                listaproblemas.add(p);
            }
            return listaproblemas;
        }catch(Exception e){
            return null;
        }
    }
}
