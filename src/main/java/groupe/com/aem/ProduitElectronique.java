package groupe.com.aem;


public class ProduitElectronique {

    public String code, codeEnergetique, libelle;

    public ProduitElectronique(String code, String libelle, String codeEnergetique) {
        this.code = code;
        this.libelle = libelle;
        this.codeEnergetique = codeEnergetique;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setCodeEnergetique(String codeEnergetique) {
        this.codeEnergetique = codeEnergetique;
    }

    public TypeEnergetique getType() {
        switch (codeEnergetique) {
            case "A":
            case "B":
                return TypeEnergetique.Economique;
            case "C":
                return TypeEnergetique.Modere;
            case "D":
                return TypeEnergetique.Energivore;
            default:
                return TypeEnergetique.Abuse;
        }
    }
}
