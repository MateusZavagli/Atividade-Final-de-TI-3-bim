package dao;

import beansclass.conscientizašao;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class conscientizašaoDAO {
    private Conexao conexao;
    private Connection conn;
    
    public conscientizašaoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(conscientizašao conscientizašao){
        String sql = "INSERT INTO coinscientizašao (cidade, cidadeconscientizada) VALUES (?,?)";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, conscientizašao.getcidade());
            stmt.setString(2, conscientizašao.getcidadeconscientizada());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
    public void alterar(conscientizašao conscientizašao){
        String sql = "UPDATE conscientizašao SET cidade=?, cidadeconscientizada? WHERE id=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, conscientizašao.getcidade());
            stmt.setString(2, conscientizašao.getcidadeconscientizada());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao atualizar dados: "+ e.getMessage());
        }
    }
    public void excluir(int id){
        String sql = "DELETE FROM conscientizašao WHERE id = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            stmt.execute();          
        }catch(Exception e){
            System.out.println("Erro ao excluir dados: "+ e.getMessage());
        }
    }
    public conscientizašao getconscientizašao(int id){
        String sql = "SELECT * FROM conscientizašao Where id =?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            conscientizašao conscientizašao = new conscientizašao();
            rs.next();
            conscientizašao.setId(rs.getInt("id"));
            conscientizašao.setcidade(rs.getString("cidade"));
            conscientizašao.setcidadeconscientizada(rs.getString("cidadeconscientizada"));
            return conscientizašao;
        }catch(Exception e){
            System.out.println("Erro ao acessar problemas: "+ e.getMessage());
        }return null;
    }
    public List<conscientizašao> getconscientizašao(){
        String sql = "SELECT * FROM conscientizašao";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            ResultSet rs = stmt.executeQuery();
            List<conscientizašao> listaconscientizašao = new ArrayList<>();
            while(rs.next()){
                conscientizašao c = new conscientizašao();
                c.setId(rs.getInt("id"));
                c.setcidade(rs.getString("cidade"));
                c.setcidadeconscientizada(rs.getString("cidadeconscientizada"));
                listaconscientizašao.add(c);
            }
            return listaconscientizašao;
        }catch(Exception e){
            return null;
        }
    }
}
   
