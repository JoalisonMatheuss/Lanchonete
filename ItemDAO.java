

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author
 */
public class ItemDAO {

    public ItemDAO(){
        
    }
    

    public void adcionarItem(Item item) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO Item_Venda VALUES(?,?,?,?)");
            stmt.setInt(1, item.getProduto().getCodProduto());
            stmt.setInt(2, item.getNumComanda());
            stmt.setDouble(3, item.getValorUnitario());
            stmt.setInt(4, item.getQtd());
            

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    


    public List<Item> listarItem() {
        ProdutoDAO produtoDao = new ProdutoDAO();
        List<Item> item = new LinkedList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Item_Venda ORDER BY CodProduto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = produtoDao.getProdutoPeloCodigo(rs.getInt("CodProduto"));
                Item i = new Item(p,
                         rs.getInt("NumComanda"), rs.getInt("Qtd"));
                item.add(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return item;
    }

	
	

    public Item getItemPeloCodigo(int codigo) {
        ProdutoDAO produtoDao = new ProdutoDAO();
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Item_Venda WHERE CodProduto=?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Produto p = produtoDao.getProdutoPeloCodigo(rs.getInt("CodProduto"));
            	Item i = new Item(p,
                         rs.getInt("NumComanda"),rs.getInt("Qtd"));
                return i;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return null;
    }

    
    

    public void AtualizarItem(Item item) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE Item_Venda SET  NumComanda=?, ValorUnitario=?, Qtd=? WHERE CodProduto=?");
            stmt.setInt(1, item.getProduto().getCodProduto());
            stmt.setInt(2, item.getNumComanda());
            stmt.setDouble(3, item.getValorUnitario());
            stmt.setInt(4, item.getQtd());
            

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }

    
    
    
    public void deletarItem(Produto produto) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM ITEM WHERE CodProduto=?");
            stmt.setInt(1, produto.getCodProduto());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    
    public void deletarItens(Comanda comanda) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM ITEM WHERE NumComanda=?");
            stmt.setInt(1, comanda.getNumComanda());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
}



	
