package br.com.api.exercicio.domain;


public class Estoque {
	
	private Long ref;
	private String produto;
	private String descricao;
	private Double preco;
	private boolean emEstoque;
	private int quantidade;
	
	
	public Estoque() {
		
	}
	public Estoque(Long ref, String produto, String descricao, Double preco, boolean emEstoque, int quantidade) {
		super();
		this.ref = ref;
		this.produto = produto;
		this.descricao = descricao;
		this.preco = preco;
		this.emEstoque = emEstoque;
		this.quantidade = quantidade;
	}

	public Long getRef() {
		return ref;
	}

	public void setRef(Long id) {
		this.ref = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public boolean isEmEstoque() {
		return emEstoque;
	}
	public void setEmEstoque(boolean emEstoque) {
		this.emEstoque = emEstoque;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
		
}


