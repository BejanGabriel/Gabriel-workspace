
public class Main {
	public static void main(String[] args) {
		
		Studente stud = new Studente();
		stud.setNome("Dario");
		stud.setCognome("Menillo");
		stud.setCodFiscale("DSGSER3RFSD");
		stud.setCorsoIscritto("JAVA");
		
		GenericDAO<Studente> gdS = new StudenteDAOImpl();
		
		gdS.create(stud);
	}
}
