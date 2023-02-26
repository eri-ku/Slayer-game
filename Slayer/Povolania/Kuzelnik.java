package Povolania;
/**
 * Táto trieda Kuzelnik predstavuje potomka triedy charakter.
 */
public class Kuzelnik extends Postava {

    public static final int MAX_ZIVOTY_KUZELNIK = 80;
    public static final int ZAKLAD_PENIAZE_KUZELNIK = 15;
    public static final int ZAKLAD_SILA_UTOKU_KUZELNIK = 15;
    public static final int ZAKLAD_ENERGIA_KUZELNIK = 20;
    public static final int ZAKLAD_SILA_LIECENIA_KUZELNIK = 15;

    /**
     * Konštruktor, ktorý nastaví postavu podľa daných konštánt
     */
    public Kuzelnik() {
        super(MAX_ZIVOTY_KUZELNIK, ZAKLAD_PENIAZE_KUZELNIK, ZAKLAD_SILA_UTOKU_KUZELNIK, ZAKLAD_ENERGIA_KUZELNIK, ZAKLAD_SILA_LIECENIA_KUZELNIK);
    }

}
