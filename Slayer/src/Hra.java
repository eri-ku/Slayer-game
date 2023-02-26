package src;

import Manazeri.*;

/**
 * Táto trieda slúži na spustenie hry a vytvorenie inštancií Manažérov a src.GUI.
 */

public class Hra {
    private GUI gui;
    private ManazerZobrazenia manazerZobrazenia;
    private ManazerTlacidiel manazerTlacidiel;

    /**
     * Konštruktor, ktorý inicializuje atribúty gui, manazerZobrazenia a manazerTlacitiek.
     * Taktiež vytvorý lokálnu premennú manazerHrania a zavolá metódu spustiHru();
     */
    public Hra() {
        this.gui = new GUI();
        this.manazerZobrazenia = new ManazerZobrazenia(this.gui);
        ManazerHrania manazerHrania = new ManazerHrania(this.manazerZobrazenia);
        this.manazerTlacidiel = new ManazerTlacidiel(this.manazerZobrazenia, manazerHrania);
        this.spustiHru();
    }

    /**
     * Metóda, ktorá spustí novú hru
     */
    public void spustiHru() {
        this.gui.vytvorHlavneMenu(this.manazerTlacidiel);
        this.gui.zobrazGUI();
        this.manazerZobrazenia.zobrazNovuHru();
    }

}
