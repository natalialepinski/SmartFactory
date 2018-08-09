package br.com.portal.to;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemVenda extends Produto implements Serializable{
	
	private int id;
	private Produto produto;
	private int quantidade;
	private double total;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getTotal() {
		this.total = this.quantidade * this.produto.getValorProduto();
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
