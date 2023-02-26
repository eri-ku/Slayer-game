package Manazeri;
import javax.swing.*;
import java.util.ArrayList;
import src.*;

/**
 * Táto Trieda slúži na zobrazovanie Swing komponentov - src.GUI.
 */
public class ManazerZobrazenia {
    private GUI gui;
    private boolean zvacsiOkno;

    /**
     * Konštuktor, ktorý inicializuje atribút src.GUI.
     *
     * @param gui reprezentuje parameter, na ktorý sa nastaví atribút gui.
     */
    public ManazerZobrazenia(GUI gui) {
        this.gui = gui;
    }

    /**
     * Táto metóda zobrazí panel, ktorý drží komponenty pre scénu novej hry.
     */
    public void zobrazNovuHru() {
        this.vypniVsetko();
        this.gui.getPanely().get(0).setVisible(true);
    }

    /**
     * Táto metóda zobrazí panel, ktorý drží komponenty pre scénu tvorby mena.
     */
    public void zobrazTvorbuMena() {
        this.vypniVsetko();
        this.gui.getTextMeno().setVisible(true);
        this.gui.getPanely().get(1).setVisible(true);

    }

    /**
     * Táto metóda zobrazí panel, ktorý drží komponenty pre scénu tvorby povolania.
     */
    public void zobrazTvorbuPovolania() {
        this.vypniVsetko();

        this.gui.getPanely().get(2).setVisible(true);
    }

    /**
     * Táto metóda zobrazí panel, ktorý drží komponenty pre scénu lesa.
     */
    private void zobrazLes() {
        this.vypniVsetko();
        this.zobrazStatusHUD(true);
        this.gui.getPanely().get(5).setVisible(true);
    }

    /**
     * Táto metóda zobrazí panel, ktorý drží komponenty pre scénu hlbokov v lese.
     */
    public void hlbokoVLese() {
        this.vypniVsetko();
        this.zobrazStatusHUD(true);
        this.gui.getPanely().get(6).setVisible(true);
    }

    /**
     * Táto metóda zobrazí panel, ktorý drží komponenty pre scénu pred jaskynou.
     */
    private void zobrazPredJaskynou() {
        this.vypniVsetko();
        this.zobrazStatusHUD(true);
        this.gui.getPanely().get(8).setVisible(true);
    }

    /**
     * Táto metóda zobrazí panel, ktorý drží komponenty pre scénu v jaskyni.
     */
    private void zobrazVJaskyni() {
        this.vypniVsetko();
        this.zobrazStatusHUD(true);
        this.gui.getPanely().get(9).setVisible(true);
    }

    /**
     * Táto metóda zobrazí panel, ktorý drží komponenty pre scénu smrti hráča.
     */
    public void zobrazSmrt() {
        this.vypniVsetko();
        this.gui.getPanely().get(10).setVisible(true);
        this.zvacsiOkno = false;
        this.gui.getOkno().setSize(1000, 800);
        this.zobrazStatusHUD(false);
        this.gui.getTextMeno().setText("");
    }

    /**
     * Táto metóda zobrazí panel, ktorý drží komponenty pre scénu výhry hráča.
     */
    public void zobrazVyhru() {
        this.vypniVsetko();
        this.gui.getPanely().get(11).setVisible(true);
        this.gui.getOkno().setSize(1000, 800);
        this.zobrazStatusHUD(false);
        this.zvacsiOkno = false;
        this.gui.getTextMeno().setText("");
    }

    /**
     * Táto metóda zobrazí panel, ktorý drží komponenty pre scénu lúky s obchodníkom.
     */
    public void zobrazLukuSObchodnikom() {
        this.vypniVsetko();
        this.zobrazStatusHUD(true);
        this.gui.getPanely().get(12).setVisible(true);
        this.gui.getHlavnyText().setText("Ocitol si sa na lúke, na obzore je chalúpka s obchodnikom! Klikni pre zobrazenie jeho ponuky");
    }

    /**
     * Táto metóda zobrazí panel, ktorý drží komponenty pre scénu obchodnej ponuky.
     */
    public void zobrazPonuku() {
        this.vypniVsetko();
        this.zobrazStatusHUD(true);
        this.gui.getPanely().get(13).setVisible(true);
        this.gui.getHlavnyText().setText("Chceš nakúpiť?");
    }

    /**
     * Táto metóda zobrazí panel, ktorý drží komponenty status HUD.
     *
     * @param zobraz , ak je parameter pravdivý a zároveň je atribút zvacsiOkno nepravdivý, tak zväčší okno a nastaví atribút zvacsiOkno na pravdu.
     */
    public void zobrazStatusHUD(boolean zobraz) {
        if (!this.zvacsiOkno && zobraz) {
            this.zvacsiOkno = true;
            this.gui.getOkno().setSize(1350, 800);
        }
        this.gui.getPanely().get(4).setVisible(zobraz);
        this.gui.getPanely().get(7).setVisible(zobraz);
    }

    /**
     * Táto metóda vypína všetky prvky hry.
     */
    private void vypniVsetko() {
        this.gui.getPanely().get(0).setVisible(false);
        this.gui.getPanely().get(1).setVisible(false);
        this.gui.getTextMeno().setVisible(false);
        this.gui.getPanely().get(2).setVisible(false);
        this.gui.getPanely().get(5).setVisible(false);
        this.gui.getPanely().get(6).setVisible(false);
        this.gui.getPanely().get(8).setVisible(false);
        this.gui.getPanely().get(9).setVisible(false);
        this.gui.getPanely().get(10).setVisible(false);
        this.gui.getPanely().get(11).setVisible(false);
        this.gui.getPanely().get(12).setVisible(false);
        this.zobrazStatusHUD(false);
        this.gui.getPanely().get(13).setVisible(false);
    }

    /**
     * Táto metóda zobrazuje Goblin nepriateľa .
     *
     * @param uzRazPorazeny, ak je pravdivý, tak nepriateľ sa nezobrazí. Slúži pri cestovaní naspäť v hre.
     */
    public void zobrazGoblin(boolean uzRazPorazeny) {
        this.zobrazLes();
        this.gui.getTlacidla().get(5).setVisible(false);
        this.gui.getTlacidla().get(6).setVisible(true);
        this.gui.getTlacidla().get(22).setVisible(false);
        if (uzRazPorazeny) {
            this.gui.getTlacidla().get(6).setVisible(false);
            this.gui.getTlacidla().get(5).setVisible(false);
            this.gui.getTlacidla().get(22).setVisible(true);
        }
    }

    /**
     * Táto metóda zobrazí smrt Goblina.
     */
    public void smrtGoblina() {
        this.zobrazLes();
        this.gui.getTlacidla().get(5).setVisible(true);
        this.gui.getTlacidla().get(6).setVisible(false);
    }

    /**
     * Táto metóda zobrazuje Ork nepriateľa .
     *
     * @param uzRazPorazeny, ak je pravdivý, tak nepriateľ sa nezobrazí. Slúži pri cestovaní naspäť v hre.
     */
    public void zobrazOrka(boolean uzRazPorazeny) {
        this.hlbokoVLese();
        this.gui.getTlacidla().get(7).setVisible(true);
        this.gui.getTlacidla().get(8).setVisible(false);
        this.gui.getTlacidla().get(9).setVisible(false);
        this.gui.getTlacidla().get(21).setVisible(false);
        this.gui.getTlacidla().get(24).setVisible(false);
        if (uzRazPorazeny) {
            this.gui.getTlacidla().get(7).setVisible(false);
            this.gui.getTlacidla().get(8).setVisible(false);
            this.gui.getTlacidla().get(9).setVisible(true);
            this.gui.getTlacidla().get(24).setVisible(true);
            this.gui.getTlacidla().get(21).setVisible(true);
        }
    }

    /**
     * Táto metóda zobrazí smrt Orka.
     */
    public void smrtOrka() {
        this.hlbokoVLese();
        this.gui.getTlacidla().get(8).setVisible(true);
        this.gui.getTlacidla().get(9).setVisible(true);
        this.gui.getTlacidla().get(7).setVisible(false);
        this.gui.getTlacidla().get(21).setVisible(true);

    }

    /**
     * Táto metóda zobrazuje Cerberus nepriateľa .
     *
     * @param uzRazPorazeny, ak je pravdivý, tak nepriateľ sa nezobrazí. Slúži pri cestovaní naspäť v hre.
     */
    public void zobrazCerberusa(boolean uzRazPorazeny) {
        this.zobrazPredJaskynou();
        this.gui.getTlacidla().get(16).setVisible(true);
        this.gui.getTlacidla().get(17).setVisible(false);
        this.gui.getTlacidla().get(23).setVisible(false);
        if (uzRazPorazeny) {
            this.gui.getTlacidla().get(16).setVisible(false);
            this.gui.getTlacidla().get(17).setVisible(true);
            this.gui.getTlacidla().get(23).setVisible(true);
        }
    }

    /**
     * Táto metóda zobrazí smrt Cerberusa.
     */
    public void smrtCerberusa() {
        this.zobrazPredJaskynou();
        this.gui.getTlacidla().get(16).setVisible(false);
        this.gui.getTlacidla().get(17).setVisible(true);
        this.gui.getTlacidla().get(23).setVisible(true);
    }

    /**
     * Táto metóda zobrazuje Lich nepriateľa.
     */
    public void zobrazLich() {
        this.zobrazVJaskyni();
        this.gui.getTlacidla().get(18).setVisible(true);
    }

    /**
     * @return Táto metóda vráti ArrayList tlačidiel.
     */
    public ArrayList<JButton> dajZoznamTlacidiel() {
        return this.gui.getTlacidla();
    }

    /**
     * @return Táto metóda vráti ArrayList labelov.
     */
    public ArrayList<JLabel> dajZoznamLabelov() {
        return this.gui.getLabely();
    }

    /**
     * Táto metóda nastaví hlavný text hry podľa parametra.
     *
     * @param zmena predstavuje zmenu textu.
     */
    public void zmenaHlavnehoTextu(String zmena) {
        this.gui.getHlavnyText().setText(zmena);
    }

    /**
     * Táto metóda vracia meno, ktoré zadal hráč pri zadávaní mena. Ak hráč nezadal meno, nastavý sa na "noName".
     *
     * @return vráti meno postavy hráča.
     */
    public String getMeno() {
        if (this.gui.getTextMeno().getText().equals("")) {
            return "noName";
        } else {
            return this.gui.getTextMeno().getText();
        }
    }
}
