package model;

public class Mossa {

	private String nome;
	private int danno;
	private String tipo;
	
	public Mossa(String nome, int danno, String tipo) {
		this.nome = nome;
		this.danno = danno;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDanno() {
		return danno;
	}

	public void setDanno(int danno) {
		this.danno = danno;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
