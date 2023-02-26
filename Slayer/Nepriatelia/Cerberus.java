package Nepriatelia;
/**
 * Táto trieda Cerberus predstavuje potomka triedy nepriatel.
 */
public class Cerberus extends Nepriatel {
    public static final int MAX_ZIVOTY_CERBERUS = 70;
    public static final int SILA_UTOKU_CERBERUS = 15;
    public static final int ODMENA_CERBERUS = 60;
    public static final String NAZOV_CERBERUS = "Cerberus";

    /**
     * Konštruktor, ktorý nastaví nepriateľa podľa daných konštánt
     */
    public Cerberus() {
        super(NAZOV_CERBERUS, MAX_ZIVOTY_CERBERUS, SILA_UTOKU_CERBERUS, ODMENA_CERBERUS);
    }
}
