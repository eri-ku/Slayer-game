package Nepriatelia;
/**
 * Táto trieda Ork predstavuje potomka triedy nepriatela.
 */
public class Ork extends Nepriatel {
    public static final int MAX_ZIVOTY_ORK = 50;
    public static final int SILA_UTOKU_ORK = 10;
    public static final int ODMENA_ORK = 50;
    public static final String NAZOV_ORK = "Ork";

    /**
     * Konštruktor, ktorý nastaví nepriateľa podľa daných konštánt
     */
    public Ork() {
        super(NAZOV_ORK, MAX_ZIVOTY_ORK, SILA_UTOKU_ORK, ODMENA_ORK);
    }
}
