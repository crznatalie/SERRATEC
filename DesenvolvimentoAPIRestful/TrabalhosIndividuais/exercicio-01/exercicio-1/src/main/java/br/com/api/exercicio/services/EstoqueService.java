package br.com.api.exercicio.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.api.exercicio.domain.Estoque;

@Service
	public class EstoqueService {
	
		private List<Estoque> lista = new ArrayList<>();
				
		public List<Estoque> bancoProdutos() {
			if (lista.isEmpty()) {
				lista.add(new Estoque(2401001L, "Vestido", "Vestido em seda longo de alça com fenda lateral", 150.00, true, 4));
				lista.add(new Estoque(2401002L, "Saia", "Saia godê midi em seda com estampa florida", 70.00, true, 7));
				lista.add(new Estoque(2401003L, "Blusa", "Blusa em linho com botões e mangas curtas", 100.00, false, 0));
				lista.add(new Estoque(2401004L, "Short", "Short em linho e bolsos tipo faca ", 90.00, false, 0));
				lista.add(new Estoque(2402001L, "Sobretudo", "Sobretudo de lã com bolsos", 300.00, true, 2));
				lista.add(new Estoque(2402002L, "Calça", "Calça de brim tipo pantalona", 180.00, true, 8));
				lista.add(new Estoque(2402003L, "Blusa", "Blusa em lã de mangas longas e gola alta", 75.00, true, 5));
				lista.add(new Estoque(2402004L, "Blazer", "Blazer em lã e detalhes bordados", 200.00, false, 0));
				
			}
			return lista;
		}
		
		public Estoque buscarProduto(Long ref) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getRef().equals(ref)) {
					return lista.get(i);
				}
			}
			return null;
		}
		
		
		public Estoque cadastrarProduto(Estoque produto) {
			if(buscarProduto(produto.getRef()) == null) {
				lista.add(produto);
				return produto;
			}
			return null;
		}
		
		public Estoque atualizarProduto(Estoque produtoAtualizado, Long ref) {
			Estoque produtoAntigo = buscarProduto(ref);
			if(buscarProduto(ref) !=null) {
				produtoAntigo.setRef(produtoAtualizado.getRef());
				produtoAntigo.setProduto(produtoAtualizado.getProduto());
				produtoAntigo.setDescricao(produtoAtualizado.getDescricao());
				produtoAntigo.setPreco(produtoAtualizado.getPreco());
				//produtoAntigo.setEmEstoque(produtoAtualizado.isEmEstoque());
				produtoAntigo.setQuantidade(produtoAtualizado.getQuantidade());
				if (produtoAntigo.getQuantidade() != 0) {
					produtoAntigo.setEmEstoque(true);
				}
				else if (produtoAntigo.getQuantidade() == 0) {
					produtoAntigo.setEmEstoque(false);
				}
			}
			return null;
		}
		
		public void deletarProduto(Long ref) {
			Estoque produto = buscarProduto(ref);
			if(produto.isEmEstoque()) {
				produto.setQuantidade(0);
				produto.setEmEstoque(false);
			}
		}
	}


