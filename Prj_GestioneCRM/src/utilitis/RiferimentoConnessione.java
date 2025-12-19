package utilitis;

import java.sql.Connection;

import database.DBConnection;
// Può sembrare una classe inutile, e sicuramente lo è per un progetto cosi piccolo. Ma se mai mi dovessi ampliare, o cambiare db
public abstract class RiferimentoConnessione {
	protected Connection conn = DBConnection.getInstance().getConnessione();
}
