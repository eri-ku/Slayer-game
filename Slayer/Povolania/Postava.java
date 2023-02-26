
package Povolania;
/**
 * Táto trieda predstavuje rodiča povolaní.
 */
public class Postava {

    private int energia;
    private int maxZivoty;
    private int peniaze;
    private int silaUtoku;
    private int zivotyAktualne;
    private int silaLiecenia;
    private int maximalnaEnergia;

    /**
     * Konštruktor, ktorý nastaví atribúty postavy podľa parametrov.
     *
     * @param maxZivoty        reprezentuje základné maximálne životy postavy.
     * @param peniaze          reprezentuje základné peniaze postavy.
     * @param silaUtoku        reprezentuje základnú silu útoku postavy.
     * @param maximalnaEnergia reprezentuje základnú maximálnu energiu postavy.
     * @param silaLiecenia     reprezentuje základnú silu liečenia postavy.
     */
    public Postava(int maxZivoty, int peniaze, int silaUtoku, int maximalnaEnergia, int silaLiecenia) {
        this.maximalnaEnergia = maximalnaEnergia;
        this.maxZivoty = maxZivoty;
        this.peniaze = peniaze;
        this.silaUtoku = silaUtoku;
        this.zivotyAktualne = maxZivoty;
        this.silaLiecenia = silaLiecenia;
        this.energia = maximalnaEnergia;
    }

    /**
     * Táto metóda nastaví sily postavy podľa parametrov.
     *
     * @param silaUtoku    reprezentuje nastavovanú hodnotu sily útoku.
     * @param silaLiecenia reprezentuje nastavovanú hodnotu sily liečenia.
     */
    public void nastavSily(int silaUtoku, int silaLiecenia) {
        this.silaUtoku = silaUtoku;
        this.silaLiecenia = silaLiecenia;
    }

    /**
     * Táto metóda nastaví plnú energiu postave.
     */
    public void nastavPlnuEnergiu() {
        this.energia = this.maximalnaEnergia;
    }

    /**
     * Táto metóda nastaví plné životy postave.
     */
    public void nastavPlneZivoty() {
        this.zivotyAktualne = this.maxZivoty;
    }

    /**
     * @return Táto metóda vráti aktuálnu silu liečenia postavy.
     */
    public int getSilaLiecenia() {
        return this.silaLiecenia;
    }

    /**
     * @return Táto metóda vráti aktuálne peniaze postavy.
     */
    public int getPeniaze() {
        return this.peniaze;
    }

    /**
     * @return Táto metóda vráti aktuálnu silu útoku postavy.
     */
    public int getSilaUtoku() {
        return this.silaUtoku;
    }

    /**
     * @return Táto metóda vráti aktuálne životy postavy.
     */
    public int getZivotyAktualne() {
        return this.zivotyAktualne;
    }

    /**
     * Táto metóda zníži životy postave.
     *
     * @param hodnota reprezentuje o koľko sa atribút zníži
     */
    public void znizZivoty(int hodnota) {
        this.zivotyAktualne -= hodnota;
    }

    /**
     * Táto metóda zvýši životy postave.
     *
     * @param hodnota reprezentuje o koľko sa zvýši atribút.
     */
    public void zvysZivoty(int hodnota) {
        this.zivotyAktualne += hodnota;
    }

    /**
     * @return Táto metóda vráti hodnotu maximálnych životov.
     */
    public int getMaxZivoty() {
        return this.maxZivoty;
    }

    /**
     * Táto metóda zvyši silu liečenia postave.
     *
     * @param hodnota reprezentuje o koľko sa zvýši atribút.
     */
    public void zvysSiluLiecenia(int hodnota) {
        this.silaLiecenia += hodnota;
    }

    /**
     * Táto metóda zníši energiu postave.
     *
     * @param hodnota reprezentuje o koľko sa zníši atribút.
     */
    public void znizEnergiu(int hodnota) {
        this.energia -= hodnota;
        if (this.energia < 0) {
            this.energia = 0;
        }
    }

    /**
     * Táto metóda zvýši energiu postave.
     *
     * @param hodnota reprezentuje o koľko sa zvýši atribút.
     */
    public void zvysEnergiu(int hodnota) {
        this.energia += hodnota;
        if (this.energia > this.maximalnaEnergia) {
            this.energia = this.maximalnaEnergia;
        }
    }

    /**
     * Táto metóda zvýši silu utoku.
     *
     * @param hodnota reprezentuje o koľko sa zvýši atribút.
     */
    public void zvysSiluUtoku(int hodnota) {
        this.silaUtoku += hodnota;
    }

    /**
     * @return Táto metóda vráti atribút energie postavy.
     */
    public int getEnergia() {
        return this.energia;
    }

    /**
     * Táto metóda zvýši peniaze.
     *
     * @param hodnota reprezentuje o koľko sa zvýši atribút.
     */
    public void zvysPeniaze(int hodnota) {
        this.peniaze += hodnota;
    }

    /**
     * Táto metóda zníž peniaze.
     *
     * @param hodnota reprezentuje o koľko sa zníži atribút.
     */
    public void znizPeniaze(int hodnota) {
        this.peniaze -= hodnota;
    }

    /**
     * Táto metóda zvýši maximálne životy postave.
     *
     * @param hodnota reprezentuje o koľko sa zvýši atribút.
     */
    public void zvysMaximalneZivoty(int hodnota) {
        this.maxZivoty += hodnota;
    }
}
