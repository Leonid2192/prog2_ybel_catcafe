
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatCafeTest {

	@Test
	@DisplayName("1. Eine Katze erfolgreich hinzufügen")
	void testAddCat() {

		CatCafe cafe = new CatCafe();
		Cat minka = new Cat("Minka", "Schwarz");

		cafe.addCat(minka);

		assertEquals(1, cafe.getKatzenanzahl(), "Die Anzahl der Katzen sollte 1 sein.");
	}
	@Test
	@DisplayName("2. Zwei Katzen nacheinander hinzufügen")
	void testAddTwoCats() {

		CatCafe cafe = new CatCafe();
		Cat c1 = new Cat("Leo", "Gestreift");
		Cat c2 = new Cat("Luna", "Weiß");

		cafe.addCat(c1);
		cafe.addCat(c2);

		assertEquals(2, cafe.getKatzenanzahl(), "Die Anzahl sollte 2 sein.");
	}

	@Test
	@DisplayName("3. Eine Katze wieder entfernen")
	void testRemoveCat() {

		CatCafe cafe = new CatCafe();
		Cat minka = new Cat("Minka", "Schwarz");
		cafe.addCat(minka);

		cafe.removeCat(); // Geht davon aus, dass removeCat die Anzahl senkt

		assertEquals(0, cafe.getKatzenanzahl(), "Die Anzahl sollte nach Entfernen 0 sein.");
	}
	@Test
	@DisplayName("4. Cafe ist am Anfang leer")
	void testInitialEmpty() {

		CatCafe cafe = new CatCafe();

		assertEquals(0, cafe.getKatzenanzahl(), "Ein neues Cafe sollte 0 Katzen haben.");
	}

	@Test
	@DisplayName("5. Katze entfernen, wenn Cafe schon leer ist")
	void testRemoveFromEmpty() {

		CatCafe cafe = new CatCafe();

		cafe.removeCat();

		// Wir prüfen, ob die Anzahl bei 0 bleibt (nicht -1 wird)
		assertTrue(cafe.getKatzenanzahl() >= 0, "Die Anzahl darf nicht negativ werden.");
	}

	@Test
	@DisplayName("6. Name der Katze prüfen")
	void testCatName() {

		Cat kitty = new Cat("Findus", "Grau");

		assertEquals("Findus", kitty.getName(), "Der Name der Katze sollte Findus sein.");
	}

	@Test
	@DisplayName("7. Farbe der Katze prüfen")
	void testCatColor() {

		Cat kitty = new Cat("Findus", "Grau");

		assertEquals("Grau", kitty.getFarbe(), "Die Farbe sollte Grau sein.");
	}

	@Test
	@DisplayName("8. Cafe komplett leeren")
	void testResetCafe() {

		CatCafe cafe = new CatCafe();
		cafe.addCat(new Cat("A", "B"));
		cafe.addCat(new Cat("C", "D"));

		cafe.resetCafe(); // Methode müsste in CatCafe definiert sein (setzt Anzahl auf 0)

		assertEquals(0, cafe.getKatzenanzahl(), "Nach dem Reset sollte das Cafe leer sein.");
	}

	@Test
	@DisplayName("9. Mehrere Katzen hinzufügen erhöht den Zähler korrekt")
	void testMultipleAdd() {

		CatCafe cafe = new CatCafe();

		for (int i = 0; i < 5; i++) {
			cafe.addCat(new Cat("Katze" + i, "Farbe"));
		}

		assertEquals(5, cafe.getKatzenanzahl());
	}

	@Test
	@DisplayName("10. Objekt-Identität prüfen")
	void testCafeExists() {

		CatCafe cafe = new CatCafe();

		assertNotNull(cafe, "Das Cafe-Objekt sollte existieren.");
	}
}
