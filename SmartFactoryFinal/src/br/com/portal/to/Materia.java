package br.com.portal.to;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Materia implements Serializable{

	private int codigoMateria;
	private String nomeMateria;
	private String cor;
	private double valorMateria;
	private int quantidade;
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getCodigoMateria() {
		return codigoMateria;
	}
	public void setCodigoMateria(int codigoMateria) {
		this.codigoMateria = codigoMateria;
	}
	public String getNomeMateria() {
		return nomeMateria;
	}
	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public double getValorMateria() {
		return valorMateria;
	}
	public void setValorMateria(double valorMateria) {
		this.valorMateria = valorMateria;
	}
	
}
