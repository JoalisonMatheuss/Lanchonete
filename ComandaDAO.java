

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 
 */
public class ComandaDAO {

    public ComandaDAO(){
        
    }
    

    public void adcionarComanda(Comanda c ) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO Comanda VALUES(?,?,?)");
            stmt.setInt(1, c.getNumComanda());
            stmt.setDouble(2, c.getValorTotalVenda());
            stmt.setInt(3, c.getCodCliente());
            stmt.executeUpdate();
            
            stmt = conexao.prepareStatement("INSERT INTO Item_Venda VALUES(?,?,?)");
            for (int i = 0; i < Comanda.getLenItens(); i++) {
            	 stmt.setInt(1, c.getNumComanda());
                 stmt.setDouble(2, c.getValorTotalVenda());
                 stmt.setInt(3, c.getCodCliente());
       
                 stmt.executeUpdate();
                 
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    


    public void listarItens() {
        List<Item> comanda = new LinkedList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Comanda ORDER BY NumComanda");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Comanda c = new Comanda(rs.getInt("NumComanda"), rs.getInt("codCliente"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }

   
    }
    
    
    public void updateComanda(Comanda comanda) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        ItemDAO itemDAO = new ItemDAO();
        try {
            itemDAO.deletarItens(comanda);
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE Comanda SET NumComanda=?, ValorTotalVenda=? WHERE codCliente=?");
            stmt.setInt(1, comanda.getNumComanda());
            stmt.setDouble(2, comanda.getValorTotalVenda());
            stmt.setInt(3, comanda.getCodCliente());          

            stmt.executeUpdate();
            
            stmt = conexao.prepareStatement("INSERT INTO Item_Venda VALUES(?,?,?)");
            for (int i = 0; i < comanda.getLenItens(); i++) {
            	 stmt.setInt(1, comanda.getNumComanda());
                 stmt.setDouble(2, comanda.getValorTotalVenda());
                 stmt.setInt(3, comanda.getCodCliente());
                 
                 stmt.executeUpdate();
                 
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
      
    
    public void deletarComanda(int numComanda) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM Comanda WHERE NumComanda=?");
            stmt.setInt(1, numComanda);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
}