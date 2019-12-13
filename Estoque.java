import java.util.List;
import java.util.ArrayList;


public class Estoque {
	List <Produto> estoque = new ArrayList <>();
	
	
	public Estoque() {
		
	}

	
	public void adcionarProduto(Produto p, int qtd){
		for(int i = 0; i < qtd; i++) {
			estoque.add(p);
		}
	}
	
	public void Pedir(Produto p, int qtd){
	
		for(int i = 0; i<qtd; i++){
			estoque.remove(p);
		}
	}
}



