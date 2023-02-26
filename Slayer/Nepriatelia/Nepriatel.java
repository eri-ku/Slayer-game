package Nepriatelia;
/**
 * Táto trieda predstavuje rodiča nepriateľov.
 */
public class Nepriatel {
    private String nazovNepriatela;
    private int zivoty;
    private int silaUtoku;
    private int odmena;

    /**
     * Konštruktor, ktorý nastaví atribúty postavy podľa parametrov.
     * @param nazovNepriatela reprezentuje názov nepriateľa.
     * @param maximalneZivoty reprezentuje maximálne životy nepriateľa.
     * @param silaUtoku reprezentuje silu útoku nepriateľa.
     * @param odmena reprezentuje odmenu za porazenie nepriateľa.
     */
    public Nepriatel(String nazovNepriatela, int maximalneZivoty, int silaUtoku, int odmena) {
        this.nazovNepriatela = nazovNepriatela;
        this.zivoty = maximalneZivoty;
        this.silaUtoku = silaUtoku;
        this.odmena = odmena;
    }

    /**
     * @return Táto metóda vráti aktuálne životy nepriateľa.
     */
    public int getZivoty() {
        return this.zivoty;
    }

    /**
     * Táto metóda zníži aktuálne životy nepriateľa
     * @param hodnota predstavuje hodnotu o koľko sa znížia aktuálne životy nepriaľa
     */
    public void znizZivoty(int hodnota) {
        this.zivoty -= hodnota;
    }
    /**
     * @return Táto metóda vráti pomenovanie nepriateľa.
     */
    public String getNazovNepriatela() {
        return this.nazovNepriatela;
    }
    /**
     * @return Táto metóda vráti silu nepriateľa.
     */
    public int getSilaUtoku() {
        return this.silaUtoku;
    }
    /**
     * @return Táto metóda vráti odmenu za nepriateľa.
     */
    public int getOdmena() {
        return this.odmena;
    }


}
