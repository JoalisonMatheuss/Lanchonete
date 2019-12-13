
public class Principal {

	public static void main(String[] args) {
            
                ClienteDAO clienteDAO = new ClienteDAO();
                
                Cliente c1 = new Cliente(1, "Pp");
                Cliente c2 = new Cliente(2, "Ppp");
                
                clienteDAO.adicionarCliente(c1);
                clienteDAO.adicionarCliente(c2);
                clienteDAO.listarClientes();           
                //clienteDAO.deletarCliente(1);
                
               
                ComandaDAO comandaDAO = new ComandaDAO();
                
                Comanda com = new Comanda(1, 1);
                Comanda com2 = new Comanda(2, 2);
                comandaDAO.adcionarComanda(com);
                comandaDAO.adcionarComanda(com2);
                //comandaDAO.deletarComanda(1);
                
                
                ProdutoDAO produtoDAO = new ProdutoDAO();
                
                Produto prod1 = new Produto(1, "Coxinha", "fritura", 2.20);
                produtoDAO.adcionarProduto(prod1);
                
                ItemDAO itemDAO = new ItemDAO();
                
                Item item1 = new Item(prod1, 1, 5);
                itemDAO.adcionarItem(item1);
	}

}