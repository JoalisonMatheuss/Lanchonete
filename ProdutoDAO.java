

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
public class ProdutoDAO {

    public ProdutoDAO(){
        
    }
    

    public void adcionarProduto(Produto produto) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO PRODUTO(CodProduto, Nome, Descricao, Custo, Preco, Lucro) VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, produto.getCodProduto());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getCusto());
            stmt.setDouble(5, produto.getPreco());
            stmt.setDouble(6, produto.getLucro());
            

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
    


    public List<Produto> listarProdutos() {
        List<Produto> estoque = new LinkedList<>();

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Produto ORDER BY CodProduto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto(rs.getInt("CodProduto"),
                        rs.getString("Nome"), rs.getString("Descricao"), rs.getDouble("Custo"), rs.getDouble("Preco"), rs.getDouble("Lucro"));
                estoque.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }

        return estoque;
    }
    
    public Produto getProdutoPeloCodigo(int codigo){
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Produto WHERE CodProduto=?");
            stmt.setInt(1,codigo);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Produto produto = new Produto(rs.getInt("CodProduto"),
                        rs.getString("Nome"),rs.getString("Descricao"),rs.getDouble("Custo"),rs.getDouble("Preco"),rs.getDouble("Lucro"));
                return produto;
            }
        }catch (SQLException e){
                e.printStackTrace();
        }finally {
               postgres.close(rs, stmt, conexao);
        }
         return null;
    }

    

    public void atualizarProduto(Produto produto, int codProd) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE Produto SET Nome=?, Custo=?, Descricao=?, Preco=?, Lucro=? WHERE CodProduto=?");
            stmt.setInt(6, produto.getCodProduto());
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getCusto());
            stmt.setDouble(4, produto.getPreco());
            stmt.setDouble(5, produto.getLucro());
            

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }

    
    
    
    
    public void deletarProduto(int codProduto) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("DELETE FROM Produto WHERE CodProduto=?");
            stmt.setInt(1, codProduto);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(null, stmt, conexao);
        }
    }
}



	
