package Povolania;

/**
 * Táto trieda Lukostrelec predstavuje potomka triedy charakter.
 */
public class Lukostrelec extends Postava {
    public static final int MAX_ZIVOTY_LUKOSTRELEC = 105;
    public static final int ZAKLAD_PENIAZE_LUKOSTRELEC = 20;
    public static final int ZAKLAD_SILA_UTOKU_LUKOSTRELEC = 15;
    public static final int ZAKLAD_ENERGIA_LUKOSTRELEC = 10;
    public static final int ZAKLAD_SILA_LIECENIA_LUKOSTRELEC = 10;

    /**
     * Konštruktor, ktorý nastaví postavu podľa daných konštánt
     */
    public Lukostrelec() {
        super(MAX_ZIVOTY_LUKOSTRELEC, ZAKLAD_PENIAZE_LUKOSTRELEC, ZAKLAD_SILA_UTOKU_LUKOSTRELEC, ZAKLAD_ENERGIA_LUKOSTRELEC, ZAKLAD_SILA_LIECENIA_LUKOSTRELEC);
    }
}
