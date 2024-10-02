package dao;

import beansclass.gestão;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public void alterar(gestão gestão){
        String sql = "UPDATE gestão SET cidade=?, comites=?, camaras=?, caixasdagua=? WHERE id=?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setString(1, gestão.getcidade());
            stmt.setInt(2, gestão.getcomites());
            stmt.setInt(3, gestão.getcamaras());
            stmt.setInt(4, gestão.getcaixasdagua());
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao atualizar dados: "+ e.getMessage());
        }
    }
    public void excluir(int id){
        String sql = "DELETE FROM gestão WHERE id = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            stmt.execute();          
        }catch(Exception e){
            System.out.println("Erro ao excluir dados: "+ e.getMessage());
        }
    }
    public gestão getgestão(int id){
        String sql = "SELECT * FROM gestão Where id =?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            gestão gestão = new gestão();
            rs.next();
            gestão.setId(rs.getInt("id"));
            gestão.setcidade(rs.getString("cidade"));
            gestão.setcomites(rs.getInt("comites"));
            gestão.setcamaras(rs.getInt("camaras"));
            gestão.setcaixasdagua(rs.getInt("caixasdagua"));
            return gestão;
        }catch(Exception e){
            System.out.println("Erro ao acessar problemas: "+ e.getMessage());
        }return null;
    }
    public List<gestão> getgestão(){
        String sql = "SELECT * FROM gestão";
        try{
            PreparedStatement stmt = this.conn.prepareStatement (sql);
            ResultSet rs = stmt.executeQuery();
            List<gestão> listagestão = new ArrayList<>();
            while(rs.next()){
                gestão g = new gestão();
                g.setId(rs.getInt("id"));
                g.setcidade(rs.getString("cidade"));
                g.setcomites(rs.getInt("comites"));
                g.setcamaras(rs.getInt("camaras"));
                listagestão.add(g);
            }
            return listagestão;
        }catch(Exception e){
            return null;
        }
    }
}
   
