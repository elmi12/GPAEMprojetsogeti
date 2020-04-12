package groupe.com.aem;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProduitElectroniqueTest {
    ProduitElectronique produitElectronique;

    @Before
    public void setUp() {
        this.produitElectronique = new ProduitElectronique("J0209", "Machine à laver", "A");
    }

    @Test
    public void getType() {
        assertEquals(TypeEnergetique.Economique, produitElectronique.getType());
    }

    @Test
    public void setCodeEnergetique() {
        produitElectronique.setCodeEnergetique("C");
        assertEquals(TypeEnergetique.Modere, produitElectronique.getType());
    }

    @Test
    public void setCodeEnergetiqueInvalid() {
        produitElectronique.setCodeEnergetique("fez");
        assertEquals(TypeEnergetique.Abuse, produitElectronique.getType());
    }
}