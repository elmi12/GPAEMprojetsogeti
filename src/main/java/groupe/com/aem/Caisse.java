package groupe.com.aem;

public class Caisse {

	private int prixA;

	private int prixE;

	public Caisse(int a, int b) {

		this.prixA = a;

		this.prixE = b;

	}

	public int getPrixA() {
		return prixA;
	}

	public void setPrixA(int prixA) {
		this.prixA = prixA;
	}

	public int getPrixE() {
		return prixE;
	}

	public void setPrixE(int prixE) {
		this.prixE = prixE;
	}

}
