package Manazeri;

import Povolania.*;
import Nepriatelia.*;


/**
 * Táto trieda predstavuje manažéra hrania hry.
 */
public class ManazerHrania {
    private ManazerZobrazenia manazerZobrazenia;
    private Postava postava;
    private Nepriatel nepriatel;
    private boolean nepriatelZije;
    private String povolanie;

    /**
     * Konštruktor, ktorý nastaví atribút manazerZobrazenia podľa prijatého parametra.
     *
     * @param manazerZobrazenia reprezentuje prijatý parameter.
     */
    public ManazerHrania(ManazerZobrazenia manazerZobrazenia) {
        this.manazerZobrazenia = manazerZobrazenia;
    }

    /**
     * Táto metóda nastavý vybraté povolanie a meno hráča.
     *
     * @param meno      reprezentuje meno hráča.
     * @param povolanie reprezentuje povolanie hráča.
     */
    public void vytvorPociatocnyStav(String meno, String povolanie) {
        this.povolanie = povolanie;
        if (this.povolanie.equals("BOJOVNIK")) {
            this.postava = new Bojovnik();
        } else if (this.povolanie.equals("LUKOSTRELEC")) {
            this.postava = new Lukostrelec();
        } else {
            this.postava = new Kuzelnik();
        }
        this.manazerZobrazenia.dajZoznamLabelov().get(7).setText("MENO: " + meno);
        this.aktualizujHUD();
    }

    /**
     * Táto metóda nastavý nepriateľa podľa prijatého int parametra.
     *
     * @param cislo reprezentuje číselnú reprezentáciu nepriateľa.
     */
    public void nastavNepriatela(int cislo) {
        if (cislo == 1) {
            this.nepriatel = new Goblin();
        } else if (cislo == 2) {
            this.nepriatel = new Ork();
        } else if (cislo == 3) {
            this.nepriatel = new Cerberus();
        } else if (cislo == 4) {
            this.nepriatel = new Lich();
        }
        if (cislo != 4) {
            this.manazerZobrazenia.zmenaHlavnehoTextu("Pred tebou stoji " + this.nepriatel.getNazovNepriatela() + " zaútoč kým sa spamätá");
        } else {
            this.manazerZobrazenia.zmenaHlavnehoTextu("Pred tebou stoji " + this.nepriatel.getNazovNepriatela() + " stojíš ako prikovaný, spamätaj sa, lebo zomrieš !");
        }
    }

    /**
     * Metóda, ktorá reprezentuje boj s nepriateľom.
     */
    public void bojSNepriatelom() {
        this.nepriatelZije = true;
        this.nepriatel.znizZivoty(this.postava.getSilaUtoku());
        if (this.nepriatel.getZivoty() <= 0) {
            this.smrtNepriatela(this.nepriatel);
            this.manazerZobrazenia.zmenaHlavnehoTextu("Zabil si " + this.nepriatel.getNazovNepriatela() + "a!");
        } else {
            this.postava.znizZivoty(this.nepriatel.getSilaUtoku());
            this.manazerZobrazenia.zmenaHlavnehoTextu("Udrel si " + this.nepriatel.getNazovNepriatela() + "a za " + this.postava.getSilaUtoku() + " zivota, " + "on ti vratil uder za " +
                    this.nepriatel.getSilaUtoku() + " zivota!");
        }
        this.screenSmrti();
        this.postava.zvysEnergiu(1);
        this.vyresetujSily(true, false);
        this.aktualizujHUD();
    }

    /**
     * Metóda, ktorá reprezentuje smrť nepriateľom.
     *
     * @param nepriatel predstavuje nepriateľa, ktorý zomrel.
     */
    public void smrtNepriatela(Nepriatel nepriatel) {
        this.vyresetujSily(false, false);
        this.postava.nastavPlnuEnergiu();
        switch (nepriatel.getNazovNepriatela()) {
            case "Goblin" -> {
                this.nepriatelZije = false;
                this.manazerZobrazenia.smrtGoblina();
            }
            case "Ork" -> {
                this.nepriatelZije = false;
                this.manazerZobrazenia.smrtOrka();
            }
            case "Cerberus" -> {
                this.nepriatelZije = false;
                this.manazerZobrazenia.smrtCerberusa();
            }
            case "Lich" -> {
                this.nepriatelZije = false;
                this.manazerZobrazenia.zobrazVyhru();
            }
        }
        this.postava.zvysPeniaze(this.nepriatel.getOdmena());
        this.aktualizujHUD();
    }

    /**
     * Metóda nakupovania u obchodníka. Príjma parameter String, ktorý reprezentuje príkaz akcie tlačítka.
     *
     * @param nakup predstavuje akciu tlačítka.
     */
    public void nakupovanie(String nakup) {
        switch (nakup) {
            case "Zvýš svoje životy o 5 | CENA je 20" -> {
                if (this.postava.getPeniaze() - 20 >= 0) {
                    this.postava.zvysMaximalneZivoty(5);
                    this.postava.zvysZivoty(5);
                    this.postava.znizPeniaze(20);
                    this.manazerZobrazenia.zmenaHlavnehoTextu("Zvýšil si svoje životy o 5 za cenu  20 peňazí");
                    break;
                }
                this.manazerZobrazenia.zmenaHlavnehoTextu("Nemaš dosť peňazí !");
            }
            case "Zvýš svoje životy o 10 | CENA je 40" -> {
                if (this.postava.getPeniaze() - 40 >= 0) {
                    this.postava.zvysMaximalneZivoty(10);
                    this.postava.zvysZivoty(10);
                    this.postava.znizPeniaze(40);
                    this.manazerZobrazenia.zmenaHlavnehoTextu("Zvýšil si svoje životy o +é za cenu  40 peňazí");
                    break;
                }
                this.manazerZobrazenia.zmenaHlavnehoTextu("Nemaš dosť peňazí !");
            }
        }
        this.aktualizujHUD();
    }

    /**
     * Metóda reprezentuje liečenie hráča.
     */
    public void vyliecSa() {
        if (this.nepriatelZije) {
            if (this.postava.getZivotyAktualne() + this.postava.getSilaLiecenia() < this.postava.getMaxZivoty()) {
                this.postava.zvysZivoty(this.postava.getSilaLiecenia());
                this.manazerZobrazenia.zmenaHlavnehoTextu("Vyliečil si sa za " + this.postava.getSilaLiecenia() + " života následne  ti dal ale " + this.nepriatel.getNazovNepriatela() + " úder za " +
                        this.nepriatel.getSilaUtoku() + " života!");

            } else {
                this.postava.nastavPlneZivoty();
                this.manazerZobrazenia.zmenaHlavnehoTextu("Vyliečil si sa do plného života, následne ti dal ale Goblin úder za " +
                        this.nepriatel.getSilaUtoku() + " zivota!");
            }

            this.postava.znizZivoty(this.nepriatel.getSilaUtoku());


        } else {
            this.manazerZobrazenia.zmenaHlavnehoTextu("Liečba je možná iba v boji! ");
        }
        this.screenSmrti();
        this.postava.zvysEnergiu(1);
        this.vyresetujSily(false, true);
        this.aktualizujHUD();

    }

    /**
     * Metóda slúži na zvyšovanie síl hráča.
     *
     * @param actionCommand reprezentuje príkaz akcie tlačidla
     */
    public void zvysovanieSil(String actionCommand) {
        if (this.nepriatelZije) {
            switch (actionCommand) {
                case "Vylieč+" -> {
                    this.postava.zvysSiluLiecenia(5);
                    this.postava.znizEnergiu(1);
                    this.manazerZobrazenia.zmenaHlavnehoTextu("Zvyšil si si silu liečenia o 5, zároveň ti bola ubraná energia v hodnote 1");
                }
                case "Vylieč++" -> {
                    this.postava.zvysSiluLiecenia(10);
                    this.postava.znizEnergiu(2);
                    this.manazerZobrazenia.zmenaHlavnehoTextu("Zvyšil si si silu liečenia o 10, zároveň ti bola ubraná energia v hodnote 2");
                }
                case "UTOK+" -> {
                    this.postava.zvysSiluUtoku(5);
                    this.postava.znizEnergiu(1);
                    this.manazerZobrazenia.zmenaHlavnehoTextu("Zvyšil si si silu útoku o 5, zároveň ti bola ubraná energia v hodnote 1");
                }
                case "UTOK++" -> {
                    this.postava.zvysSiluUtoku(10);
                    this.postava.znizEnergiu(2);
                    this.manazerZobrazenia.zmenaHlavnehoTextu("Zvyšil si si silu útoku o 10, zároveň ti bola ubraná energia v hodnote 2");
                }
                case "UTOK+++" -> {
                    this.postava.zvysSiluUtoku(15);
                    this.postava.znizEnergiu(3);
                    this.manazerZobrazenia.zmenaHlavnehoTextu("Zvyšil si si silu útoku o 15, zároveň ti bola ubraná energia v hodnote 3");
                }
            }

            this.aktualizujHUD();
        } else {
            this.manazerZobrazenia.zmenaHlavnehoTextu("Zvysovanie je možné iba v boji! ");
        }
    }

    /**
     * Táto metóda vracia sily na predvolené hodnoty. Parametre slúžia na identifikáciu toho, či sa má resetovať utok, liečenie alebo obe.
     * Táto metóda sa použije pri použití útoku - iba útok sa resetne, liečnia - iba liečenie sa resetne, prechod do ďalšej scény - obe sa resetnu.
     *
     * @param ibaUtok     , ak je pravdivý, tak sa resetuje iba útok.
     * @param ibaLiecenie , ak je pravdivý, tak sa resetuje iba liečenie.
     */
    public void vyresetujSily(boolean ibaUtok, boolean ibaLiecenie) {
        if (!ibaUtok && !ibaLiecenie) {
            if (this.povolanie.equals("BOJOVNIK")) {
                this.postava.nastavSily(Bojovnik.ZAKLAD_SILA_UTOKU_BOJOVNIK, Bojovnik.ZAKLAD_SILA_LIECENIA_BOJOVNIK);
            } else if (this.povolanie.equals("LUKOSTRELEC")) {
                this.postava.nastavSily(Lukostrelec.ZAKLAD_SILA_UTOKU_LUKOSTRELEC, Lukostrelec.ZAKLAD_SILA_LIECENIA_LUKOSTRELEC);
            } else {
                this.postava.nastavSily(Kuzelnik.ZAKLAD_SILA_UTOKU_KUZELNIK, Kuzelnik.ZAKLAD_SILA_LIECENIA_KUZELNIK);
            }
        } else if (ibaUtok) {
            if (this.povolanie.equals("BOJOVNIK")) {
                this.postava.nastavSily(Bojovnik.ZAKLAD_SILA_UTOKU_BOJOVNIK, this.postava.getSilaLiecenia());
            } else if (this.povolanie.equals("LUKOSTRELEC")) {
                this.postava.nastavSily(Lukostrelec.ZAKLAD_SILA_UTOKU_LUKOSTRELEC, this.postava.getSilaLiecenia());
            } else {
                this.postava.nastavSily(Kuzelnik.ZAKLAD_SILA_UTOKU_KUZELNIK, this.postava.getSilaLiecenia());
            }
        } else {
            if (this.povolanie.equals("BOJOVNIK")) {
                this.postava.nastavSily(this.postava.getSilaUtoku(), Bojovnik.ZAKLAD_SILA_LIECENIA_BOJOVNIK);
            } else if (this.povolanie.equals("LUKOSTRELEC")) {
                this.postava.nastavSily(this.postava.getSilaUtoku(), Lukostrelec.ZAKLAD_SILA_LIECENIA_LUKOSTRELEC);
            } else {
                this.postava.nastavSily(this.postava.getSilaUtoku(), Kuzelnik.ZAKLAD_SILA_LIECENIA_KUZELNIK);
            }
        }
    }

    /**
     * Táto metóda zavolá obrazovku smrti.
     */
    public void screenSmrti() {
        if (this.postava.getZivotyAktualne() <= 0) {
            this.nepriatelZije = false;
            this.manazerZobrazenia.zobrazSmrt();
        }
    }

    /**
     * Táto metóda aktualizuje HUD. Vykonáva sa vždy po akcii v hre.
     */
    public void aktualizujHUD() {
        this.manazerZobrazenia.dajZoznamLabelov().get(6).setText("ZIVOTY: " + this.postava.getZivotyAktualne());
        this.manazerZobrazenia.dajZoznamLabelov().get(8).setText("ENERGIA: " + this.postava.getEnergia());
        this.manazerZobrazenia.dajZoznamLabelov().get(10).setText("SILA UTK: " + this.postava.getSilaUtoku());
        this.manazerZobrazenia.dajZoznamLabelov().get(11).setText("SILA LIEČ: " + this.postava.getSilaLiecenia());
        this.manazerZobrazenia.dajZoznamLabelov().get(9).setText("PENIAZE: " + this.postava.getPeniaze());
    }

    /**
     * @return Táto metóda vráti aktuálnu energiu postavy.
     */
    public int getAktulanuEnergiu() {
        return this.postava.getEnergia();
    }

}
