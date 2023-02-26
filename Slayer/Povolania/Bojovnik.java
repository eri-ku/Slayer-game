package Povolania;

/**
 * Táto trieda Bojovnik predstavuje potomka triedy charakter.
 */

public class Bojovnik extends Postava {
    public static final int MAX_ZIVOTY_BOJOVNIK = 130;
    public static final int ZAKLAD_PENIAZE_BOJOVNIK = 10;
    public static final int ZAKLAD_SILA_UTOKU_BOJOVNIK = 15;
    public static final int ZAKLAD_ENERGIA_BOJOVNIK = 15;
    public static final int ZAKLAD_SILA_LIECENIA_BOJOVNIK = 5;

    /**
     * Konštruktor, ktorý nastaví postavu podľa daných konštánt
     */
    public Bojovnik() {
        super(MAX_ZIVOTY_BOJOVNIK, ZAKLAD_PENIAZE_BOJOVNIK, ZAKLAD_SILA_UTOKU_BOJOVNIK, ZAKLAD_ENERGIA_BOJOVNIK, ZAKLAD_SILA_LIECENIA_BOJOVNIK);
    }
}
