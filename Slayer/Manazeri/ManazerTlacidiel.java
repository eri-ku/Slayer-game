package Manazeri;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Táto trieda implementuje Interface ActionListener, načúva akciám tlačidla - JButton .
 */
public class ManazerTlacidiel implements ActionListener {
    private ManazerHrania manazerHrania;
    private ManazerZobrazenia manazerZobrazenia;
    private String meno = "noName";
    private boolean navstivilCerberusa;

    /**
     * Konštruktor, ktorý nastaví atribúty podľa prijatých parametrov.
     *
     * @param manazerZobrazenia reprezentuje manažéra zobrazenia.
     * @param manazerHrania     eprezentuje manažéra hrania.
     */
    public ManazerTlacidiel(ManazerZobrazenia manazerZobrazenia, ManazerHrania manazerHrania) {
        this.manazerZobrazenia = manazerZobrazenia;
        this.manazerHrania = manazerHrania;
    }

    /**
     * Táto metóda je metóda, ktorú musí trieda implementovať, lebo je implementovaná Interface-om ActionListener.
     * Načúva akciám tlačidla.
     *
     * @param e predstavuje akčný event - udalosť.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        String volba = e.getActionCommand();
        if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(0)) {
            this.manazerZobrazenia.zobrazTvorbuMena();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(1)) {
            this.meno = this.manazerZobrazenia.getMeno();
            this.manazerZobrazenia.zobrazTvorbuPovolania();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(2)) {
            this.manazerHrania.vytvorPociatocnyStav(this.meno, e.getActionCommand());
            this.manazerZobrazenia.zobrazGoblin(false);
            this.manazerHrania.nastavNepriatela(1);
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(3)) {
            this.manazerHrania.vytvorPociatocnyStav(this.meno, e.getActionCommand());
            this.manazerZobrazenia.zobrazGoblin(false);
            this.manazerHrania.nastavNepriatela(1);
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(4)) {
            this.manazerHrania.vytvorPociatocnyStav(this.meno, e.getActionCommand());
            this.manazerZobrazenia.zobrazGoblin(false);
            this.manazerHrania.nastavNepriatela(1);
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(6)) {
            this.manazerHrania.bojSNepriatelom();
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(5)) {
            this.manazerZobrazenia.zobrazOrka(false);
            this.manazerHrania.nastavNepriatela(2);
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(7)) {
            this.manazerHrania.bojSNepriatelom();
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(13)) {
            this.manazerHrania.vyliecSa();
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(10)) {
            this.manazerHrania.zvysovanieSil(volba);
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(11)) {
            this.manazerHrania.zvysovanieSil(volba);
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(12)) {
            this.manazerHrania.zvysovanieSil(volba);
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(14)) {
            this.manazerHrania.zvysovanieSil(volba);
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(15)) {
            this.manazerHrania.zvysovanieSil(volba);
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(8)) {
            this.manazerZobrazenia.zobrazCerberusa(false);
            this.manazerHrania.nastavNepriatela(3);
            this.navstivilCerberusa = true;
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(16)) {
            this.manazerHrania.bojSNepriatelom();
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(17)) {
            this.manazerZobrazenia.zobrazLich();
            this.manazerHrania.nastavNepriatela(4);
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(18)) {
            this.manazerHrania.bojSNepriatelom();
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(19)) {
            this.manazerZobrazenia.zobrazTvorbuMena();
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(20)) {
            this.manazerZobrazenia.zobrazTvorbuMena();
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(21)) {
            this.manazerZobrazenia.zobrazGoblin(true);
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(22)) {
            this.manazerZobrazenia.smrtOrka();
            if (this.navstivilCerberusa) {
                this.manazerZobrazenia.zobrazOrka(true);
            }
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(23)) {
            this.manazerZobrazenia.zobrazOrka(true);
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(24)) {
            this.manazerZobrazenia.zobrazCerberusa(true);
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(9)) {
            this.manazerZobrazenia.zobrazLukuSObchodnikom();
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(26)) {
            this.manazerZobrazenia.zmenaHlavnehoTextu("");
            this.manazerZobrazenia.smrtOrka();
            if (this.navstivilCerberusa) {
                this.manazerZobrazenia.zobrazOrka(true);
            }
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(25)) {
            this.manazerZobrazenia.zobrazPonuku();
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(27)) {
            this.manazerZobrazenia.zmenaHlavnehoTextu("");
            this.manazerZobrazenia.zobrazLukuSObchodnikom();
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(28)) {
            this.manazerHrania.nakupovanie(volba);
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(29)) {
            this.manazerHrania.nakupovanie(volba);
            this.prepinajButtony();
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(30)) {
            System.exit(0);
        } else if (o == this.manazerZobrazenia.dajZoznamTlacidiel().get(31)) {
            System.exit(0);
        }
    }

    /**
     * Táto metóda zneprístupní tlačidlo, ak postava nemá dosť energie.
     */
    public void prepinajButtony() {
        if (this.manazerHrania.getAktulanuEnergiu() < 1) {
            this.manazerZobrazenia.dajZoznamTlacidiel().get(10).setEnabled(false);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(11).setEnabled(false);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(12).setEnabled(false);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(14).setEnabled(false);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(15).setEnabled(false);
        } else if (this.manazerHrania.getAktulanuEnergiu() < 2) {
            this.manazerZobrazenia.dajZoznamTlacidiel().get(10).setEnabled(true);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(11).setEnabled(false);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(14).setEnabled(true);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(12).setEnabled(false);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(15).setEnabled(false);
        } else if (this.manazerHrania.getAktulanuEnergiu() < 3) {
            this.manazerZobrazenia.dajZoznamTlacidiel().get(10).setEnabled(true);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(11).setEnabled(true);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(14).setEnabled(true);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(12).setEnabled(false);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(15).setEnabled(false);
        } else if (this.manazerHrania.getAktulanuEnergiu() < 4) {
            this.manazerZobrazenia.dajZoznamTlacidiel().get(10).setEnabled(true);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(11).setEnabled(true);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(14).setEnabled(true);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(12).setEnabled(false);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(15).setEnabled(true);
        } else if (this.manazerHrania.getAktulanuEnergiu() >= 3) {
            this.manazerZobrazenia.dajZoznamTlacidiel().get(10).setEnabled(true);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(11).setEnabled(true);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(12).setEnabled(true);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(14).setEnabled(true);
            this.manazerZobrazenia.dajZoznamTlacidiel().get(15).setEnabled(true);
        }
    }
}
