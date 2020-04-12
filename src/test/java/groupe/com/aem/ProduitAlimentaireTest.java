package groupe.com.aem;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ProduitAlimentaireTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    private ProduitAlimentaire produitAlimentaire;

    @Before
    public void setUp() {
    	LocalDate dateLimiteDeConsommation = LocalDate.of(2020, 2, 15);
        LocalDate dateDeFabrication = LocalDate.of(2019, 7, 20);
        

        this.produitAlimentaire = new ProduitAlimentaire(dateDeFabrication, dateLimiteDeConsommation, "Chocolat");
    }

    @Test
    public void setDateLimiteConsommationAvantFabricationAvecTypeLocalDate() {
        exceptionRule.expect(DateTimeException.class);
        exceptionRule.expectMessage(ProduitAlimentaire.MESSAGE_ERREUR_DATE);

        LocalDate dateLimiteDeConsommation = LocalDate.of(2018, 12, 31);
        produitAlimentaire.setDateLimiteDeConsommation(dateLimiteDeConsommation);
    }
    
    @Test
    public void setDateDeFabrication() {
        produitAlimentaire.setDateLimiteDeConsommation(2020, 12, 31);
        assertEquals(produitAlimentaire.getDateLimiteDeConsommation(), LocalDate.of(2020, 12, 31));
    }

    

    @Test
    public void setDateLimiteConsommationAvantFabricationAvecMethodeSimplifiee() {
        exceptionRule.expect(DateTimeException.class);
        exceptionRule.expectMessage(ProduitAlimentaire.MESSAGE_ERREUR_DATE);

        produitAlimentaire.setDateLimiteDeConsommation(2018, 12, 31);
    }

    @Test
    public void setDateDeFabricationApresLimiteDeConsommationAvecTypeLocalDate() {
        exceptionRule.expect(DateTimeException.class);
        exceptionRule.expectMessage(ProduitAlimentaire.MESSAGE_ERREUR_DATE);

        LocalDate dateLimiteDeConsommation = LocalDate.of(2020, 4, 1);
        produitAlimentaire.setDateDeFabrication(dateLimiteDeConsommation);
    }

    @Test
    public void setDateDeFabricationApresLimiteDeConsommationAvecMethodeSimplifiee() {
        exceptionRule.expect(DateTimeException.class);
        exceptionRule.expectMessage(ProduitAlimentaire.MESSAGE_ERREUR_DATE);

        produitAlimentaire.setDateDeFabrication(2020, 12, 31);
    }

    @Test(expected = DateTimeException.class)
    public void erreurDateFevrier() {
        produitAlimentaire.setDateDeFabrication(2020, 2, 31);
    }

    @Test(expected = DateTimeException.class)
    public void erreurDateAvril() {
        produitAlimentaire.setDateDeFabrication(2020, 4, 31);
    }
}