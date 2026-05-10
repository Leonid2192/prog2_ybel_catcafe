public class CatCafe {
    private int katzenanzahl = 0;

    public void addCat(Cat cat) {
        katzenanzahl++;
    }

    public int getKatzenanzahl() {
        return katzenanzahl;
    }
    public void removeCat() {
        if (katzenanzahl > 0) {
            katzenanzahl--;
        }
    }

    public void resetCafe() {
        this.katzenanzahl = 0;
    }
}
