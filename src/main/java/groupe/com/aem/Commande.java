package groupe.com.aem;

import java.time.LocalDate;


public class Commande {
	
	Caisse caisse;
    private String code;
    private LocalDate date;
    ProduitAlimentaire produitAlimentaire;
    ProduitElectronique produitElectronique;

    public Commande(ProduitAlimentaire produitAlimentaire, ProduitElectronique produitElectronique, Caisse caisse, String code, LocalDate date) {
        this.caisse = caisse;

        this.date = date;
        this.code = code;

        this.produitAlimentaire = produitAlimentaire;
        this.produitElectronique = produitElectronique;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDate(int annee, int mois, int jourDuMois) {
        this.date = LocalDate.of(annee, mois, jourDuMois);
    }

    public LocalDate getDate() {
        return date;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public ProduitAlimentaire getProduitAlimentaire() {
        return produitAlimentaire;
    }

    public void setProduitAlimentaire(ProduitAlimentaire produitAlimentaire) {
        this.produitAlimentaire = produitAlimentaire;
    }

    public ProduitElectronique getProduitElectronique() {
        return produitElectronique;
    }

    public void setProduitElectronique(ProduitElectronique produitElectronique) {
        this.produitElectronique = produitElectronique;
    }
}
