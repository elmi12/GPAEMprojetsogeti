package groupe.com.aem;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class CommandeTest {
    @Mock
    Caisse caisse;
    @Mock
    ProduitAlimentaire produitAlimentaire;
    @Mock
    ProduitElectronique produitElectronique;
    @InjectMocks
    Commande commande;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetterCode() {
        commande.setCode("BA40");
        assertEquals(commande.getCode(), "BA40");
    }

    @Test
    public void dateDecembre31() {
        commande.setDate(2020, 12, 31);
        assertEquals(commande.getDate(), LocalDate.of(2020, 12, 31));
    }

    @Test(expected = DateTimeException.class)
    public void dateFevrier31Exception() {
        commande.setDate(2020, 2, 31);
    }

    @Test(expected = DateTimeException.class)
    public void dateAvril31Exception() {
        commande.setDate(2020, 4, 31);
    }
}