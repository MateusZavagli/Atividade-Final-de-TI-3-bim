package dao;

import beansclass.gest�o;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public void alterar(gest�o gest�o){
        String sql = "UPDATE gest�o SET cidade=?, comites=?, camaras=?, caixasdagua=? WHERE id=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, gest�o.getcidade());
            stmt.setInt(2, gest�o.getcomites());
            stmt.setInt(3, gest�o.getcamaras());
            stmt.setInt(4, gest�o.getcaixasdagua());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao atualizar dados: "+ e.getMessage());
        }
    }
    public void excluir(int id){
        String sql = "DELETE FROM gest�o WHERE id = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            stmt.execute();          
        }catch(Exception e){
            System.out.println("Erro ao excluir dados: "+ e.getMessage());
        }
    }
    public gest�o getgest�o(int id){
        String sql = "SELECT * FROM gest�o Where id =?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            gest�o gest�o = new gest�o();
            rs.next();
            gest�o.setId(rs.getInt("id"));
            gest�o.setcidade(rs.getString("cidade"));
            gest�o.setcomites(rs.getInt("comites"));
            gest�o.setcamaras(rs.getInt("camaras"));
            gest�o.setcaixasdagua(rs.getInt("caixasdagua"));
            return gest�o;
        }catch(Exception e){
            System.out.println("Erro ao acessar problemas: "+ e.getMessage());
        }return null;
    }
    public List<gest�o> getgest�o(){
        String sql = "SELECT * FROM gest�o";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            ResultSet rs = stmt.executeQuery();
            List<gest�o> listagest�o = new ArrayList<>();
            while(rs.next()){
                gest�o g = new gest�o();
                g.setId(rs.getInt("id"));
                g.setcidade(rs.getString("cidade"));
                g.setcomites(rs.getInt("comites"));
                g.setcamaras(rs.getInt("camaras"));
                listagest�o.add(g);
            }
            return listagest�o;
        }catch(Exception e){
            return null;
        }
    }
}
   
