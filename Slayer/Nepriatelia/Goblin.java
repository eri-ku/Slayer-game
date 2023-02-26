package Nepriatelia;
/**
 * Táto trieda Goblin predstavuje potomka triedy nepriatel.
 */
public class Goblin extends Nepriatel {
    public static final int MAX_ZIVOTY_GOBLIN = 30;
    public static final int SILA_UTOKU_GOBLIN = 5;
    public static final int ODMENA_GOBLIN = 20;
    public static final String NAZOV_GOBLIN = "Goblin";
    /**
     * Konštruktor, ktorý nastaví nepriateľa podľa daných konštánt
     */
    public Goblin() {
        super(NAZOV_GOBLIN, MAX_ZIVOTY_GOBLIN, SILA_UTOKU_GOBLIN, ODMENA_GOBLIN);
    }
}
