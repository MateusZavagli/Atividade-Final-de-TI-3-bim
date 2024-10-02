package dao;

import beansclass.conscientiza�ao;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class conscientiza�aoDAO {
    private Conexao conexao;
    private Connection conn;
    
    public conscientiza�aoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(conscientiza�ao conscientiza�ao){
        String sql = "INSERT INTO coinscientiza�ao (cidade, cidadeconscientizada) VALUES (?,?)";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, conscientiza�ao.getcidade());
            stmt.setString(2, conscientiza�ao.getcidadeconscientizada());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
    public void alterar(conscientiza�ao conscientiza�ao){
        String sql = "UPDATE conscientiza�ao SET cidade=?, cidadeconscientizada? WHERE id=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, conscientiza�ao.getcidade());
            stmt.setString(2, conscientiza�ao.getcidadeconscientizada());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao atualizar dados: "+ e.getMessage());
        }
    }
    public void excluir(int id){
        String sql = "DELETE FROM conscientiza�ao WHERE id = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            stmt.execute();          
        }catch(Exception e){
            System.out.println("Erro ao excluir dados: "+ e.getMessage());
        }
    }
    public conscientiza�ao getconscientiza�ao(int id){
        String sql = "SELECT * FROM conscientiza�ao Where id =?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            conscientiza�ao conscientiza�ao = new conscientiza�ao();
            rs.next();
            conscientiza�ao.setId(rs.getInt("id"));
            conscientiza�ao.setcidade(rs.getString("cidade"));
            conscientiza�ao.setcidadeconscientizada(rs.getString("cidadeconscientizada"));
            return conscientiza�ao;
        }catch(Exception e){
            System.out.println("Erro ao acessar problemas: "+ e.getMessage());
        }return null;
    }
    public List<conscientiza�ao> getconscientiza�ao(){
        String sql = "SELECT * FROM conscientiza�ao";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            ResultSet rs = stmt.executeQuery();
            List<conscientiza�ao> listaconscientiza�ao = new ArrayList<>();
            while(rs.next()){
                conscientiza�ao c = new conscientiza�ao();
                c.setId(rs.getInt("id"));
                c.setcidade(rs.getString("cidade"));
                c.setcidadeconscientizada(rs.getString("cidadeconscientizada"));
                listaconscientiza�ao.add(c);
            }
            return listaconscientiza�ao;
        }catch(Exception e){
            return null;
        }
    }
}
   
