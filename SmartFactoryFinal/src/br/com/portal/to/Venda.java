package br.com.portal.to;

import java.io.Serializable;
import java.util.HashMap;

@SuppressWarnings("serial")
public class Venda implements Serializable{

	private int codigoVenda;
	private String dataEmissao;
	private Cliente codigoCliente;
	private HashMap<Integer, ItemVenda> itens;
	private double total;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCodigoVenda() {
		return codigoVenda;
	}
	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
	public String getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public Cliente getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Cliente codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public HashMap<Integer, ItemVenda> getItens() {
		return itens;
	}
	public void setItens(HashMap<Integer, ItemVenda> itens) {
		this.itens = itens;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
