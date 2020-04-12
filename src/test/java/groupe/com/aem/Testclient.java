package groupe.com.aem;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Testclient {

	static int i = 0;

	Client c;

	@Before
	public void setUp() {

		c = new Client("Elmi", "Masculain", "4 rue de Sinmon de Beauvoir", "0751413840", 30);
		System.out.println(++i + "avant test");

	}

	@Test
	public void test() {

		assertNotNull(c.nom);

	}

	@Test
	public void testNom() {

		// Test Unitaire

		String b = c.nom;
		String a = "Elmi";
		// assertTrue((b).equals(b.isEmpty()));

		String b1 = c.nom;
		String a1 = "45";
		// assertTrue((b1).equals(c.isInt(a1)));

		// assertTrue((b).equals(c.isName(a)));

		// assertEquals(b, c.isName(a));
	}

	@Test
	public void testSexe() {

		// Test Unitaire

		String b = c.sexe;

		String z = "Femme";
		// assertEquals(b, c.isName(z));

		// assertEquals(b, z);

		// assertSame(b, z);

	}

	@Test
	public void testAge() {

		// Test Unitaire

		int d = 30;
		// assertEquals(c.age, d);

	}

	@Test
	public void testAddress() {

		// Test Unitaire

		// String f = "14 rue viotte";
		// assertEquals(c.Adress, f);

	}

	@Test
	public void testTelp() {

		// Test Unitaire

		// String t = "0751413840";
		// assertSame(c.Telp, t);

	}

	@After
	public void fin() {

		System.out.println(+i + "apres test");

	}
}
