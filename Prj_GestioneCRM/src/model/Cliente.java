package model;

public class Cliente {

	private int idCliente;
	private String nomeAzienda;
	private String refereneAzienda;
	private String categoriaMerceologica;
	private String tipologiaCliente;
	private int utenteAssociato;
	
	
	
	public Cliente(String nomeAzienda, String refereneAzienda, String categoriaMerceologica, String tipologiaCliente,
			int utenteAssociato) {
		super();
		this.nomeAzienda = nomeAzienda;
		this.refereneAzienda = refereneAzienda;
		this.categoriaMerceologica = categoriaMerceologica;
		this.tipologiaCliente = tipologiaCliente;
		this.utenteAssociato = utenteAssociato;
	}

	public Cliente() {
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeAzienda() {
		return nomeAzienda;
	}
	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}
	public String getRefereneAzienda() {
		return refereneAzienda;
	}
	public void setRefereneAzienda(String refereneAzienda) {
		this.refereneAzienda = refereneAzienda;
	}
	public String getCategoriaMerceologica() {
		return categoriaMerceologica;
	}
	public void setCategoriaMerceologica(String categoriaMerceologica) {
		this.categoriaMerceologica = categoriaMerceologica;
	}
	public String getTipologiaCliente() {
		return tipologiaCliente;
	}
	public void setTipologiaCliente(String tipologiaCliente) {
		this.tipologiaCliente = tipologiaCliente;
	}
	public int getUtenteAssociato() {
		return utenteAssociato;
	}
	public void setUtenteAssociato(int utenteAssociato) {
		this.utenteAssociato = utenteAssociato;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeAzienda=" + nomeAzienda + ", refereneAzienda="
				+ refereneAzienda + ", categoriaMerceologica=" + categoriaMerceologica + ", tipologiaCliente="
				+ tipologiaCliente + ", utenteAssociato=" + utenteAssociato + "]";
	}
	
}
