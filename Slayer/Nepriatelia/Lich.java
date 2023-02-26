package Nepriatelia;
/**
 * Táto trieda Lich predstavuje potomka triedy nepriatel.
 */
public class Lich extends Nepriatel {
    public static final int MAX_ZIVOTY_LICH = 90;
    public static final int SILA_UTOKU_LICH = 20;
    public static final int ODMENA_LICH = 100;
    public static final String NAZOV_LICH = "Lich";

    /**
     * Konštruktor, ktorý nastaví nepriateľa podľa daných konštánt
     */
    public Lich() {
        super(NAZOV_LICH, MAX_ZIVOTY_LICH, SILA_UTOKU_LICH, ODMENA_LICH);
    }
}
