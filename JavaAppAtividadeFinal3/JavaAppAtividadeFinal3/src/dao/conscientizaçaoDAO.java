package dao;

import beansclass.conscientizaçao;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class conscientizaçaoDAO {
    private Conexao conexao;
    private Connection conn;
    
    public conscientizaçaoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(conscientizaçao conscientizaçao){
        String sql = "INSERT INTO coinscientizaçao (cidade, cidadeconscientizada) VALUES (?,?)";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, conscientizaçao.getcidade());
            stmt.setString(2, conscientizaçao.getcidadeconscientizada());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
    public void alterar(conscientizaçao conscientizaçao){
        String sql = "UPDATE conscientizaçao SET cidade=?, cidadeconscientizada? WHERE id=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, conscientizaçao.getcidade());
            stmt.setString(2, conscientizaçao.getcidadeconscientizada());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao atualizar dados: "+ e.getMessage());
        }
    }
    public void excluir(int id){
        String sql = "DELETE FROM conscientizaçao WHERE id = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            stmt.execute();          
        }catch(Exception e){
            System.out.println("Erro ao excluir dados: "+ e.getMessage());
        }
    }
    public conscientizaçao getconscientizaçao(int id){
        String sql = "SELECT * FROM conscientizaçao Where id =?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            conscientizaçao conscientizaçao = new conscientizaçao();
            rs.next();
            conscientizaçao.setId(rs.getInt("id"));
            conscientizaçao.setcidade(rs.getString("cidade"));
            conscientizaçao.setcidadeconscientizada(rs.getString("cidadeconscientizada"));
            return conscientizaçao;
        }catch(Exception e){
            System.out.println("Erro ao acessar problemas: "+ e.getMessage());
        }return null;
    }
    public List<conscientizaçao> getconscientizaçao(){
        String sql = "SELECT * FROM conscientizaçao";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            ResultSet rs = stmt.executeQuery();
            List<conscientizaçao> listaconscientizaçao = new ArrayList<>();
            while(rs.next()){
                conscientizaçao c = new conscientizaçao();
                c.setId(rs.getInt("id"));
                c.setcidade(rs.getString("cidade"));
                c.setcidadeconscientizada(rs.getString("cidadeconscientizada"));
                listaconscientizaçao.add(c);
            }
            return listaconscientizaçao;
        }catch(Exception e){
            return null;
        }
    }
}
   
