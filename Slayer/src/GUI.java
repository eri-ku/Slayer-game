package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import Manazeri.*;

/**
 * Táto trieda reprezentuje Graphical User Interface.
 */
public class GUI {
    private JFrame okno;
    private ArrayList<JPanel> panely;
    private ArrayList<JLabel> labely;
    private ArrayList<JButton> tlacidla;
    private JTextArea hlavnyText;
    private JTextField textMeno;

    /**
     * Konštanty, ktoré reprezentujú predvolené píslo a jeho farbu.
     */
    public static final Font ZAKLADNY_FONT = new Font("Sans Serif", Font.BOLD, 20);
    public static final Color FARBA_PISMA_DEFAULT = Color.WHITE;

    /**
     * Konštruktor, v ktorom sa inicializuje atribút okno - JFrame, špecifikujú sa jeho vlastnosti.
     * Inicializjú sa i atribúty typu ArrayList , ktoré budú obsahovat JPanel-y, JLabel-y a JButton-y.
     */
    public GUI() {
        String path = "." + File.separator + "src" + File.separator + "sk" + File.separator + "uniza" + File.separator + "fri" + File.separator + "Obrazky" + File.separator + "HIcona.png" + File.separator;
        ImageIcon icon = new ImageIcon(path);

        this.okno = new JFrame();
        this.okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.okno.setTitle("SLAYER");
        this.okno.setIconImage(icon.getImage());
        this.okno.setSize(1000, 800);
        this.okno.getContentPane().setBackground(Color.DARK_GRAY);
        this.okno.setLayout(null);
        this.okno.setResizable(false);
        this.okno.setLocationRelativeTo(null);

        this.panely = new ArrayList<>();
        this.labely = new ArrayList<>();
        this.tlacidla = new ArrayList<>();

    }

    /**
     * Táto metóda vytvorí grafické prvky hlavného menu.
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void vytvorHlavneMenu(ManazerTlacidiel manazerTlacidiel) {

        this.panely.add(0, new JPanel());
        this.nastavPanelDefault(this.panely.get(0));
        this.okno.add(this.panely.get(0));

        this.labely.add(0, new JLabel("Vitajte v hre Slayer"));
        this.labely.get(0).setBounds(150, 100, 650, 100);
        this.labely.get(0).setOpaque(false);
        this.nastavLabelNadpis(this.labely.get(0));

        this.labely.add(1, new JLabel());
        this.nastavPozadieLabel(this.labely.get(1), "Obrazky/rsz_lich-4275895_1280.png");

        this.tlacidla.add(0, new JButton("NOVA HRA"));
        this.tlacidla.get(0).setBounds(350, 300, 250, 70);
        this.nastavButtonDefault(this.tlacidla.get(0), this.panely.get(0), manazerTlacidiel, false);
        this.menuTlacidlo(this.tlacidla.get(0));

        this.panely.get(0).add(this.labely.get(0));
        this.panely.get(0).add(this.labely.get(1));
        this.vytvorMeno(manazerTlacidiel);

        this.tvorbaGUIOstatne(manazerTlacidiel);
    }

    /**
     * Táto metóda vytvorí grafické prvky tvorby mena .
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */

    public void vytvorMeno(ManazerTlacidiel manazerTlacidiel) {
        this.panely.add(1, new JPanel());
        this.nastavPanelDefault(this.panely.get(1));

        this.labely.add(2, new JLabel("Zadaj meno postavy: "));
        this.labely.get(2).setBounds(100, 200, 350, 200);
        this.nastavLabel(this.labely.get(2));

        this.labely.add(3, new JLabel());
        this.nastavPozadieLabel(this.labely.get(3), "Obrazky/rsz_old-books-436498_1280.png");

        this.textMeno = new JTextField();
        this.textMeno.setBounds(400, 290, 260, 30);
        this.textMeno.setBackground(Color.WHITE);
        this.textMeno.setForeground(Color.BLACK);
        this.textMeno.setFont(ZAKLADNY_FONT);
        this.textMeno.setEditable(true);

        this.tlacidla.add(new JButton("Potvrdenie"));
        this.tlacidla.get(1).setBounds(680, 290, 150, 30);
        this.tlacidla.get(1).setFont(ZAKLADNY_FONT);
        this.tlacidla.get(1).setBackground(Color.BLACK);
        this.tlacidla.get(1).setForeground(FARBA_PISMA_DEFAULT);
        this.tlacidla.get(1).setFocusable(false);
        this.tlacidla.get(1).setFocusPainted(false);
        this.tlacidla.get(1).addActionListener(manazerTlacidiel);

        this.panely.get(1).add(this.textMeno);
        this.panely.get(1).add(this.tlacidla.get(1));
        this.panely.get(1).add(this.labely.get(2));
        this.panely.get(1).add(this.labely.get(3));
        this.vyberPovolaniaScreen(manazerTlacidiel);

    }

    /**
     * Táto metóda vytvorí grafické prvky výberu povolia .
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void vyberPovolaniaScreen(ManazerTlacidiel manazerTlacidiel) {
        this.panely.add(2, new JPanel());
        this.nastavPanelDefault(this.panely.get(2));

        this.labely.add(4, new JLabel());

        this.nastavPozadieLabel(this.labely.get(4), "Obrazky/rsz_1rsz_2rsz_helmet-4222117_1280.png");

        this.labely.add(5, new JLabel("Tvojim povolanim bude "));
        this.nastavLabel(this.labely.get(5));
        this.labely.get(5).setBounds(300, 330, 400, 70);

        this.panely.add(3, new JPanel());
        this.panely.get(3).setBounds(50, 400, 850, 70);
        this.panely.get(3).setLayout(new FlowLayout());
        this.panely.get(3).setOpaque(false);


        this.tlacidla.add(2, new JButton("BOJOVNIK"));
        this.nastavButtonDefault(this.tlacidla.get(2), this.panely.get(3), manazerTlacidiel, false);
        this.tlacidla.add(3, new JButton("LUKOSTRELEC"));
        this.nastavButtonDefault(this.tlacidla.get(3), this.panely.get(3), manazerTlacidiel, false);
        this.tlacidla.add(4, new JButton("KUZELNIK"));
        this.nastavButtonDefault(this.tlacidla.get(4), this.panely.get(3), manazerTlacidiel, false);


        this.panely.get(2).add(this.panely.get(3));
        this.panely.get(2).add(this.labely.get(5));
        this.panely.get(2).add(this.labely.get(4));


    }

    /**
     * Táto metóda vytvorí grafické prvky HUD, ktoré predstavuje aktuálny stav postavy.
     */
    public void statusHUD() {
        this.panely.add(4, new JPanel());
        this.panely.get(4).setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        this.panely.get(4).setBounds(15, 690, 945, 70);

        this.panely.get(4).setOpaque(false);
        this.okno.add(this.panely.get(4));

        for (int i = 0; i < 7; i++) {
            this.labely.add(6 + i, new JLabel());
            this.nastavLabelHUD(this.labely.get(6 + i));
            this.panely.get(4).add(this.labely.get(6 + i));
        }
    }

    /**
     * Táto metóda vytvorí grafické prvky scény les .
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void les(ManazerTlacidiel manazerTlacidiel) {
        this.panely.add(5, new JPanel());
        this.nastavPanelDefault(this.panely.get(5));

        this.labely.add(12, new JLabel());
        this.nastavPozadieLabel(this.labely.get(12), "Obrazky/rsz_avenue-815297_1280.png");

        this.tlacidla.add(5, new JButton());
        this.tlacidla.get(5).setBounds(440, 30, 95, 137);
        this.nastavButtonObrazok(this.tlacidla.get(5), "Obrazky/arrowUP.png", manazerTlacidiel);

        this.tlacidla.add(6, new JButton());
        this.tlacidla.get(6).setBounds(350, 250, 242, 208);
        this.nastavButtonObrazok(this.tlacidla.get(6), "Obrazky/goblin-removebg-preview.png", manazerTlacidiel);

        this.panely.get(5).add(this.tlacidla.get(5));
        this.panely.get(5).add(this.tlacidla.get(6));

    }

    /**
     * Táto metóda nastaví príkaz akcie, ktoré posielajú tlačidla, konkrétne na akého nepriateľa sa kliká.
     */

    public void nastavNepriatelaActionCommand() {
        this.tlacidla.get(6).setActionCommand("Goblin");
        this.tlacidla.get(7).setActionCommand("Ork");
        this.tlacidla.get(16).setActionCommand("Cerberus");
    }

    /**
     * Táto metóda vytvorí grafické scény hlboko v lese.
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void hlbokoVLese(ManazerTlacidiel manazerTlacidiel) {
        this.panely.add(6, new JPanel());
        this.nastavPanelDefault(this.panely.get(6));

        this.labely.add(13, new JLabel());
        this.nastavPozadieLabel(this.labely.get(13), "Obrazky/pine-forest-1504687_1280.png");

        this.tlacidla.add(7, new JButton());
        this.tlacidla.get(7).setBounds(450, 450, 242, 208);
        this.nastavButtonObrazok(this.tlacidla.get(7), "Obrazky/2141920-middle.png", manazerTlacidiel);

        this.tlacidla.add(8, new JButton());
        this.tlacidla.get(8).setBounds(240, 430, 125, 101);
        this.nastavButtonObrazok(this.tlacidla.get(8), "Obrazky/arrowLeft.png", manazerTlacidiel);

        this.tlacidla.add(9, new JButton());
        this.tlacidla.get(9).setBounds(640, 430, 124, 102);
        this.nastavButtonObrazok(this.tlacidla.get(9), "Obrazky/arrowRight.png", manazerTlacidiel);


        this.panely.get(6).add(this.tlacidla.get(7));
        this.panely.get(6).add(this.tlacidla.get(8));
        this.panely.get(6).add(this.tlacidla.get(9));

    }

    /**
     * Táto metóda vytvorí grafické prvky, ktoré umožňujú vracanie scénamy.
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void chodDozaduGUI(ManazerTlacidiel manazerTlacidiel) {
        this.tlacidla.add(21, new JButton());
        this.tlacidla.get(21).setBounds(840, 530, 94, 128);
        this.nastavButtonObrazok(this.tlacidla.get(21), "Obrazky/arrowDown.png", manazerTlacidiel);
        this.panely.get(6).add(this.tlacidla.get(21));

        this.tlacidla.add(22, new JButton());
        this.tlacidla.get(22).setBounds(440, 30, 95, 137);
        this.nastavButtonObrazok(this.tlacidla.get(22), "Obrazky/arrowUP.png", manazerTlacidiel);
        this.panely.get(5).add(this.tlacidla.get(22));

        this.tlacidla.add(23, new JButton());
        this.tlacidla.get(23).setBounds(760, 530, 125, 101);
        this.nastavButtonObrazok(this.tlacidla.get(23), "Obrazky/arrowRight.png", manazerTlacidiel);
        this.panely.get(8).add(this.tlacidla.get(23));

        this.tlacidla.add(24, new JButton());
        this.tlacidla.get(24).setBounds(240, 430, 125, 101);
        this.nastavButtonObrazok(this.tlacidla.get(24), "Obrazky/arrowLeft.png", manazerTlacidiel);
        this.panely.get(6).add(this.tlacidla.get(24));


        this.panely.get(6).add(this.labely.get(13));
        this.panely.get(5).add(this.labely.get(12));
        this.panely.get(8).add(this.labely.get(15));


    }

    /**
     * Táto metóda vytvorí grafické prvky textového HUD.
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void vytvorTextHUD(ManazerTlacidiel manazerTlacidiel) {
        this.panely.add(7, new JPanel());

        this.panely.get(7).setBounds(970, 20, 360, 725);
        this.panely.get(7).setOpaque(false);
        this.panely.get(7).setLayout(null);
        this.okno.add(this.panely.get(7));


        this.labely.add(14, new JLabel());
        this.labely.get(14).setBounds(0, 0, 360, 725);
        this.nastavLabelObrazok(this.labely.get(14));

        this.hlavnyText = new JTextArea();
        this.hlavnyText.setBounds(40, 60, 260, 325);
        this.hlavnyText.setOpaque(false);
        this.hlavnyText.setLineWrap(true);
        this.hlavnyText.setWrapStyleWord(true);
        this.hlavnyText.setEditable(false);
        this.hlavnyText.setForeground(Color.WHITE);
        this.hlavnyText.setFont(new Font("Sans Serif", Font.BOLD, 22));

        this.panely.add(8, new JPanel());
        this.panely.get(8).setLayout(new GridLayout(2, 3, 3, 5));
        this.panely.get(8).setBounds(40, 475, 250, 150);
        this.panely.get(8).setOpaque(false);

        for (int i = 0; i < 6; i++) {
            this.tlacidla.add(10 + i, new JButton());
            this.panely.get(8).add(this.tlacidla.get(10 + i));
            this.nastavButtonDefault(this.tlacidla.get(10 + i), this.panely.get(8), manazerTlacidiel, true);
        }
        this.nastavTlacitkaTextACommand();

        this.panely.get(7).add(this.panely.get(8));
        this.panely.get(7).add(this.hlavnyText);
        this.panely.get(7).add(this.labely.get(14));
    }

    /**
     * Táto metóda vytvorí grafické prvky scény pred Jaskyňou.
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void predJaskynou(ManazerTlacidiel manazerTlacidiel) {
        this.panely.add(8, new JPanel());
        this.nastavPanelDefault(this.panely.get(8));

        this.labely.add(15, new JLabel());
        this.nastavPozadieLabel(this.labely.get(15), "Obrazky/rsz_bird-stove-cave-249818_1280.png");

        this.tlacidla.add(16, new JButton());
        this.tlacidla.get(16).setBounds(50, 440, 800, 250);
        this.nastavButtonObrazok(this.tlacidla.get(16), "Obrazky/268-2686120_world-of-final-fantasy-cerberus-png-download-cerberus_v2.png", manazerTlacidiel);

        this.tlacidla.add(17, new JButton());
        this.tlacidla.get(17).setBounds(440, 430, 124, 102);
        this.nastavButtonObrazok(this.tlacidla.get(17), "Obrazky/arrowRight.png", manazerTlacidiel);

        this.panely.get(8).add(this.tlacidla.get(17));
        this.panely.get(8).add(this.tlacidla.get(16));

    }

    /**
     * Táto metóda vytvorí grafické prvky scény pred Jasykňou.
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void vJaskyni(ManazerTlacidiel manazerTlacidiel) {
        this.panely.add(9, new JPanel());
        this.nastavPanelDefault(this.panely.get(9));

        this.labely.add(16, new JLabel());
        this.nastavPozadieLabel(this.labely.get(16), "Obrazky/ff75b44c6de7b0708bd19dbb0952af98.png");

        this.tlacidla.add(18, new JButton());
        this.tlacidla.get(18).setBounds(300, 70, 286, 528);
        this.nastavButtonObrazok(this.tlacidla.get(18), "Obrazky/lich-removebg-preview.png", manazerTlacidiel);

        this.panely.get(9).add(this.tlacidla.get(18));
        this.panely.get(9).add(this.labely.get(16));
    }

    /**
     * Táto metóda vytvorí grafické prvky scény lúky s obchodníkom.
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void lukaSObchodnikom(ManazerTlacidiel manazerTlacidiel) {
        this.panely.add(12, new JPanel());
        this.nastavPanelDefault(this.panely.get(12));
        this.labely.add(19, new JLabel());
        this.nastavPozadieLabel(this.labely.get(19), "Obrazky/rsz_field-5429112_1280.png");
        this.tlacidla.add(25, new JButton());
        this.tlacidla.get(25).setBounds(300, 70, 517, 482);
        this.nastavButtonObrazok(this.tlacidla.get(25), "Obrazky/52-522692_hut-clipart-peasant-house-peasant-house-clip-art-removebg-preview.png", manazerTlacidiel);
        this.panely.get(12).add(this.tlacidla.get(25));
        this.tlacidla.add(26, new JButton());
        this.tlacidla.get(26).setBounds(1, 230, 125, 101);
        this.nastavButtonObrazok(this.tlacidla.get(26), "Obrazky/arrowLeft.png", manazerTlacidiel);
        this.panely.get(12).add(this.tlacidla.get(26));


        this.panely.get(12).add(this.labely.get(19));
    }

    /**
     * Táto metóda vytvorí grafické prvky, ktoré umožňujú nákup u obchodníka.
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void menuObchodnik(ManazerTlacidiel manazerTlacidiel) {
        this.panely.add(13, new JPanel());
        this.nastavPanelDefault(this.panely.get(13));
        this.labely.add(20, new JLabel());
        this.nastavPozadieLabel(this.labely.get(20), "Obrazky/rsz_background.png");

        this.tlacidla.add(27, new JButton("Späť"));
        this.tlacidla.get(27).setBounds(10, 530, 150, 40);
        this.nastavButtonDefault(this.tlacidla.get(27), this.panely.get(13), manazerTlacidiel, false);

        this.tlacidla.add(28, new JButton("Zvýš svoje životy o 5 | CENA je 20"));
        this.tlacidla.get(28).setBounds(30, 330, 950, 40);
        this.nastavButtonDefault(this.tlacidla.get(28), this.panely.get(13), manazerTlacidiel, false);

        this.tlacidla.add(29, new JButton("Zvýš svoje životy o 10 | CENA je 40"));
        this.tlacidla.get(29).setBounds(30, 380, 950, 40);
        this.nastavButtonDefault(this.tlacidla.get(29), this.panely.get(13), manazerTlacidiel, false);
        this.panely.get(13).add(this.labely.get(20));
    }

    /**
     * Táto metóda vytvorí grafické prvky, ktoré umožňujú koniec hry.
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void vytvorKoniecTlacitka(ManazerTlacidiel manazerTlacidiel) {
        this.tlacidla.add(30, new JButton("KONIEC HRY"));
        this.tlacidla.get(30).setBounds(250, 650, 450, 50);
        this.nastavButtonDefault(this.tlacidla.get(30), this.panely.get(10), manazerTlacidiel, false);

        this.tlacidla.add(31, new JButton("KONIEC HRY"));
        this.tlacidla.get(31).setBounds(250, 650, 450, 50);
        this.nastavButtonDefault(this.tlacidla.get(31), this.panely.get(11), manazerTlacidiel, false);

        this.menuTlacidlo(this.tlacidla.get(30));
        this.menuTlacidlo(this.tlacidla.get(31));
        this.panely.get(10).add(this.labely.get(17));
        this.panely.get(11).add(this.labely.get(18));
    }

    /**
     * Táto metóda vytvorí grafické prvky, ktoré umožňujú zobraziť posmrtnú scénu.
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void smrtScreen(ManazerTlacidiel manazerTlacidiel) {
        this.panely.add(10, new JPanel());
        this.nastavPanelDefault(this.panely.get(10));
        this.labely.add(17, new JLabel());
        this.nastavPozadieLabel(this.labely.get(17), "Obrazky/rsz_ff8d0940719aee05e0cc22ea890e8b01.png");
        this.tlacidla.add(19, new JButton("NOVA HRA"));
        this.tlacidla.get(19).setBounds(350, 580, 250, 50);
        this.nastavButtonDefault(this.tlacidla.get(19), this.panely.get(10), manazerTlacidiel, false);
        this.menuTlacidlo(this.tlacidla.get(19));
    }

    /**
     * Táto metóda vytvorí grafické prvky, ktoré umožňujú zobraziť výhernú scénu.
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void vyhraScreen(ManazerTlacidiel manazerTlacidiel) {
        this.panely.add(11, new JPanel());
        this.nastavPanelDefault(this.panely.get(11));
        this.labely.add(18, new JLabel());
        this.nastavPozadieLabel(this.labely.get(18), "Obrazky/rsz_2dpcgri.png");
        this.tlacidla.add(20, new JButton("NOVA HRA"));
        this.tlacidla.get(20).setBounds(350, 580, 250, 50);
        this.nastavButtonDefault(this.tlacidla.get(20), this.panely.get(11), manazerTlacidiel, false);
        this.menuTlacidlo(this.tlacidla.get(20));
    }


    /**
     * Táto metóda nastaví príkaz akcie, ktoré posielajú tlačítká, konkrétne pre tlačítka schopností postavy.
     */
    public void nastavTlacitkaTextACommand() {
        this.tlacidla.get(10).setText("UTOK+");
        this.tlacidla.get(11).setText("UTOK++");
        this.tlacidla.get(12).setText("UTOK+++");
        this.tlacidla.get(13).setText("Vylieč sa");
        this.tlacidla.get(14).setText("Vylieč+");
        this.tlacidla.get(15).setText("Vylieč++");
    }

    /**
     * Táto metóda zavolá všetky metódy tvorby grafiky PO vytvorení postavy.
     *
     * @param manazerTlacidiel je manažér tlačidiel, príjma input, na ktorý následne reaguje volaním konkrétnych metód.
     */
    public void tvorbaGUIOstatne(ManazerTlacidiel manazerTlacidiel) {
        this.statusHUD();
        this.les(manazerTlacidiel);
        this.hlbokoVLese(manazerTlacidiel);
        this.vytvorTextHUD(manazerTlacidiel);
        this.predJaskynou(manazerTlacidiel);
        this.vJaskyni(manazerTlacidiel);
        this.smrtScreen(manazerTlacidiel);
        this.vyhraScreen(manazerTlacidiel);
        this.chodDozaduGUI(manazerTlacidiel);
        this.lukaSObchodnikom(manazerTlacidiel);
        this.nastavNepriatelaActionCommand();
        this.menuObchodnik(manazerTlacidiel);
        this.vytvorKoniecTlacitka(manazerTlacidiel);
    }

    /**
     * Táto metóda vytvorí zobrazí okno, v ktorom sa zobrazuje hra.
     */
    public void zobrazGUI() {
        this.okno.setVisible(true);
    }

    /**
     * @return Táto metóda vráti hlavný text, kde sa vypisuje priebeh hry.
     */
    public JTextArea getHlavnyText() {
        return this.hlavnyText;
    }

    /**
     * @return Táto metóda vráti ArrrayList panelov.
     */
    public ArrayList<JPanel> getPanely() {
        return this.panely;
    }

    /**
     * @return Táto metóda vráti ArrrayList labelov.
     */
    public ArrayList<JLabel> getLabely() {
        return this.labely;
    }

    /**
     * @return Táto metóda vráti textové pole, kde sa píše meno postavy.
     */
    public JTextField getTextMeno() {
        return this.textMeno;
    }

    /**
     * @return Táto metóda vráti ArrrayList tlačidiel.
     */
    public ArrayList<JButton> getTlacidla() {
        return this.tlacidla;
    }

    /**
     * @return Táto metóda vráti okno hry.
     */
    public JFrame getOkno() {
        return this.okno;
    }

    /**
     * * Táto metóda nastaví label.
     *
     * @param label predstavuje konkrétny label, ktorý chceme nastaviť.
     */
    private void nastavLabel(JLabel label) {
        label.setFont(new Font("Sans Serif", Font.BOLD, 30));
        label.setForeground(Color.WHITE);
    }

    /**
     * * Táto metóda nastaví HUD label.
     *
     * @param label predstavuje konkrétny label, ktorý chceme nastaviť.
     */
    private void nastavLabelHUD(JLabel label) {
        label.setFont(new Font("Sans Serif", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
    }

    /**
     * * Táto metóda nastaví panel na predvolené vlastnosti.
     *
     * @param panel predstavuje konkrétny panel, ktorý chceme nastaviť.
     */
    private void nastavPanelDefault(JPanel panel) {
        panel.setBounds(20, 20, 945, 725);
        panel.setOpaque(false);
        panel.setLayout(null);
        this.okno.add(panel);
    }

    /**
     * Táto metóda nastaví label ako pozadie.
     *
     * @param label     predstavuje konkrétny label, ktorý chceme nastaviť.
     * @param adresaObr predstavuje adresu obrázka.
     */
    private void nastavPozadieLabel(JLabel label, String adresaObr) {
        label.setBounds(0, 0, 945, 725);
        ImageIcon pozadie = new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource(adresaObr)));
        label.setIcon(pozadie);
    }

    /**
     * Táto metóda nastaví labelu obrázok.
     *
     * @param label predstavuje konkrétny label, ktorý chceme nastaviť.
     */
    private void nastavLabelObrazok(JLabel label) {
        ImageIcon obrazok = new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource("Obrazky/HUD.png")));
        label.setIcon(obrazok);
    }

    /**
     * * Táto metóda nastaví tlačidlo a pridá mu obrázok.
     *
     * @param button         predstavuje konkrétne tlačidlo, ktoré chceme nastaviť.
     * @param adresaObr      predstavuje adresu obrázka.
     * @param actionListener predstavuje manažéra, ktorý načuvá akciu tlačítka.
     */
    private void nastavButtonObrazok(JButton button, String adresaObr, ActionListener actionListener) {
        button.setBackground(null);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        ImageIcon obrazok = new ImageIcon(Objects.requireNonNull(this.getClass().getClassLoader().getResource(adresaObr)));
        button.setIcon(obrazok);
        button.addActionListener(actionListener);

    }

    /**
     * Táto metóda nastaví label ako nadpis.
     *
     * @param label predstavuje konkrétny label.
     */
    private void nastavLabelNadpis(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Sans Serif", Font.BOLD, 70));
    }

    /**
     * Táto metóda nastaví tlačidlo na predvolené vlastnosti.
     *
     * @param button         predstavuje konkrétne tlačidlo.
     * @param panel          predstavuje do ktorého panelu je tlačítko pridané.
     * @param actionListener predstavuje manažéra, ktorý načuvá akciu tlačídla.
     * @param malePismo      predstavuje, veľkosť písma tlačítka.
     */
    private void nastavButtonDefault(JButton button, JPanel panel, ActionListener actionListener, boolean malePismo) {
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        button.setFocusable(false);
        if (malePismo) {
            button.setFont(new Font("Sans Serif", Font.BOLD, 10));
        } else {
            button.setFont(new Font("Sans Serif", Font.BOLD, 40));
        }
        button.addActionListener(actionListener);
        panel.add(button);
    }

    /**
     * Táto metóda nastaví tlačídlo na vlastnosti tlačítka pre menu.
     *
     * @param button predstavuje konkrétne tlačítko .
     */
    private void menuTlacidlo(JButton button) {
        button.setBorderPainted(false);
        button.setBackground(null);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
    }

}
