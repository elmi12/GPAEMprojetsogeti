package groupe.com.aem;

import java.time.DateTimeException;
import java.time.LocalDate;

public class ProduitAlimentaire {

    private LocalDate dateDeFabrication;
    private LocalDate dateLimiteDeConsommation;
    private String libelle;
    final static public String MESSAGE_ERREUR_DATE = "La Date Limite de CONSOMMATION ne peut pas être avant la Date de FABRICATION";


    public ProduitAlimentaire(LocalDate dateDeFabrication, LocalDate dateLimiteDeConsommation, String libelle) {
        this.dateDeFabrication = dateDeFabrication;
        this.setDateLimiteDeConsommation(dateLimiteDeConsommation);
        this.libelle = libelle;
    }

    public LocalDate getDateDeFabrication() {
        return dateDeFabrication;
    }

    public void setDateDeFabrication(LocalDate dateDeFabrication) {
        if( this.getDateLimiteDeConsommation().isBefore(dateDeFabrication)) {
            throw new DateTimeException(MESSAGE_ERREUR_DATE);
        }
        this.dateDeFabrication = dateDeFabrication;
    }

    public void setDateDeFabrication(int annee, int mois, int jourDuMois) {
        this.setDateDeFabrication(LocalDate.of(annee, mois, jourDuMois));
    }

    public LocalDate getDateLimiteDeConsommation() {
        return dateLimiteDeConsommation;
    }

    public void setDateLimiteDeConsommation(LocalDate dateLimiteDeConsommation) {
        if( dateLimiteDeConsommation.isBefore(this.getDateDeFabrication())) {
            throw new DateTimeException(MESSAGE_ERREUR_DATE);
        }
        this.dateLimiteDeConsommation = dateLimiteDeConsommation;
    }

    public void setDateLimiteDeConsommation(int annee, int mois, int jourDuMois) {
        this.setDateLimiteDeConsommation(LocalDate.of(annee, mois, jourDuMois));
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
