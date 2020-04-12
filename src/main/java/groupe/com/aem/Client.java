package groupe.com.aem;

public class Client {

	    public String nom, sexe, adresse;

	    public int age;

	    public Client(String nom, String sexe, String adresse, String Telp,int age) {

	        this.adresse = adresse;
	        this.age = age;
	        this.nom = nom;
	        this.sexe = sexe;
	    }

	    public String Telephone;

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getSexe() {
	        return sexe;
	    }

	    public void setSexe(String sexe) {
	        this.sexe = sexe;
	    }

	    public String getAdresse() {
	        return adresse;
	    }

	    public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public String getTelephone() {
	        return Telephone;
	    }

	    public void setTelephone(String telephone) {
	        Telephone = telephone;
	    }
	}


