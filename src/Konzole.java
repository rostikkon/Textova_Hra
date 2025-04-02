import Prikaz.*;
import Postavy.*;
import Svet.*;
import java.util.HashMap;
import java.util.Scanner;

public class Konzole {
    private boolean exit = false;
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Prikaz> prikazy = new HashMap<>();
    private SvetovaMapa svet;
    private Inventar inventar;
    private Hrac hrac;
    private Pirat pirat;

    public void inicializace() {
        prikazy.put("jdi", new Pohyb(svet, hrac, inventar));
        prikazy.put("konec", new Konec());
        prikazy.put("pomoc", new Pomoc());
        prikazy.put("napoveda", new Napoveda());
        prikazy.put("vezmi", new Vzit(inventar, svet));
        prikazy.put("poloz", new Polozit(inventar, svet));
        prikazy.put("pouzij", new Pouzit(inventar));
        prikazy.put("mluv", new Mluvit(svet));
        prikazy.put("prozkoumej", new Prozkoumat(svet));
        prikazy.put("stav", new Stav(hrac, inventar));
        prikazy.put("utok", new Utok(hrac, pirat, inventar));
        prikazy.put("unik", new Unik(hrac));
    }

    private void nastavPopisyLokaci() {
        svet.getLokace(0).setPopis(
                "Hlavní velitelské centrum lodi Aurora.\n" +
                        "Všechny systémy fungují normálně kromě poškozeného hyperpohonu.\n" +
                        "Na panelech blikají varovné kontrolky."
        );
        svet.getLokace(1).setPopis(
                "Pouštní planeta se starověkými ruinami.\n" +
                        "Písečné bouře zde vytvořily podivné skalní útvary.\n" +
                        "Teplota dosahuje 50°C."
        );
        svet.getLokace(2).setPopis(
                "Ledový svět s podzemními jeskyněmi.\n" +
                        "Teplota klesá pod -120°C. Světlo pochází\n" +
                        "z bioluminescentních rostlin."
        );
        svet.getLokace(3).setPopis(
                "Opuštěná hornická stanice na asteroidu.\n" +
                        "Vzduch je zde řídký a stanice je poškozená.\n" +
                        "V rozbitých chodbách se ozývá skřípění kovu."
        );
        svet.getLokace(4).setPopis(
                "Hlukem pulzující vesmírné tržiště.\n" +
                        "Stovky obchodníků z celé galaxie zde nabízejí\n" +
                        "své zboží za různé ceny."
        );
        svet.getLokace(5).setPopis(
                "Hrozivá černá díra pohlcující vše kolem.\n" +
                        "Gravitace zde deformuje časoprostor.\n" +
                        "Lodní systémy blikají varováním."
        );
        svet.getLokace(6).setPopis(
                "Vědecká laboratoř na měsíci.\n" +
                        "Všechny přístroje vypadají vyspěle.\n" +
                        "Vzduch voní po sterilizaci."
        );
        svet.getLokace(7).setPopis(
                "Trosečník neznámého původu.\n" +
                        "Stěny jsou pokryty podivnými symboly.\n" +
                        "Cítíte, že zde něco není v pořádku."
        );
    }

    private void nastavPostavyAPredmety() {
        svet.getLokace(0).nastavPostavu(new Vedec(svet, inventar) {
            @Override
            public String interakce() {
                if (inventar.maPredmet("Hyperionový krystal") &&
                        inventar.maPredmet("Plazmový generátor") &&
                        inventar.maPredmet("Ionizační palivo")) {
                    hrac.setHyperpohonOpraven(true);
                    return "Dr. Novák: 'Všechny součástky jsou tu! Hyperpohon je opraven! Teď můžeš letět zpátky na Základnu.'";
                }
                return "Dr. Novák: 'Potřebujeme 3 komponenty pro opravu hyperpohonu:\n" +
                        "1. Hyperionový krystal (Zephyria)\n" +
                        "2. Plazmový generátor (Nixus)\n" +
                        "3. Ionizační palivo (Vrak lodi)'";
            }
        });
        svet.getLokace(0).pridejPredmet(new Palivo());
        svet.getLokace(0).pridejPredmet(new AmuletPravdy("Amulet pravdy"));

        svet.getLokace(1).nastavPostavu(new Strazce(svet, inventar) {
            @Override
            public String interakce() {
                if (inventar.maPredmet("Amulet pravdy")) {
                    return "Strážce: 'Můžeš projít, cizinče. Tvoje srdce je čisté.'";
                }
                return "Strážce: 'Bez amuletu pravdy tě nepustím dál!'";
            }
        });
        svet.getLokace(1).pridejPredmet(new NavigacniCip());
        svet.getLokace(1).pridejPredmet(Surovina.hyperionovyKrystal());

        svet.getLokace(2).nastavPostavu(new Mimozemstan(svet, inventar) {
            @Override
            public String interakce() {
                if (inventar.maPredmet("Jídlo")) {
                    inventar.odebratZInventare(new Surovina("Jídlo"));
                    svet.getLokace(2).pridejPredmet(new Surovina("Plazmový generátor"));
                    return "Mimozemšťan: 'Děkuji za jídlo! Předávám ti plazmový generátor.'";
                }
                return "Mimozemšťan: 'My dát plazmový generátor... za jídlo...'";
            }
        });
        svet.getLokace(2).pridejPredmet(new Predmet("Jídlo") {
            @Override
            public String pouzit() {
                return "Použil jsi jídlo k obchodu s mimozemšťanem.";
            }
        });

        svet.getLokace(3).nastavPostavu(new Postava("Starý horník", svet, inventar, 100) {
            @Override
            public String interakce() {
                if (inventar.maPredmet("Energoprojektor")) {
                    return "Starý horník: 'Vidím, že jsi našel mou zbraň. Dobrej vyběr!'";
                }
                return "Starý horník: 'Tady je spousta zbraní, pokud víš, jak je použít. Ale musíš mi nejdřív pomoci s jednou věcí...'";
            }
        });
        svet.getLokace(3).pridejPredmet(new Zbran("Energoprojektor", 15));
        svet.getLokace(3).pridejPredmet(new Palivo());

        svet.getLokace(4).nastavPostavu(new Obchodnik(svet, inventar) {
            @Override
            public String interakce() {
                if (inventar.maPredmet("Hyperionový krystal")) {
                    inventar.odebratZInventare(new Surovina("Hyperionový krystal"));
                    inventar.pridatDoInventare(new NavigacniCip());
                    return "Obchodník Zorx: 'Dobrá výměna! Teď máš navigační čip.'";
                } else if (inventar.maPredmet("Palivo")) {
                    inventar.odebratZInventare(new Palivo());
                    inventar.pridatDoInventare(new Zbran("Laserová zbraň", 10));
                    return "Obchodník Zorx: 'Palivo za laserovou zbraň? To se dá udělat.'";
                }
                return "Obchodník Zorx: 'Co chceš koupit nebo prodat? Mám Hyperionový krystal a Laserovou zbraň.'";
            }
        });
        svet.getLokace(4).pridejPredmet(new Palivo());
        svet.getLokace(4).pridejPredmet(new Zbran("Laserová zbraň", 10));

        svet.getLokace(4).pridejPredmet(new Predmet("Speciální štít") {
            @Override
            public String pouzit() {
                return "Aktivován štít pro ochranu před černou dírou.";
            }
        });

        svet.getLokace(5).pridejPredmet(Surovina.ionizacniPalivo());

        svet.getLokace(6).nastavPostavu(new Vedec(svet, inventar) {
            @Override
            public String interakce() {
                if (inventar.maPredmet("Hyperionový krystal") &&
                        inventar.maPredmet("Plazmový generátor") &&
                        inventar.maPredmet("Ionizační palivo")) {
                    hrac.setHyperpohonOpraven(true);
                    return "Dr. Velkar: 'Všechny součástky jsou tu! Hyperpohon je opraven!'";
                }
                return "Dr. Velkar: 'Potřebuji všechny tři suroviny pro opravu.'";
            }
        });

        svet.getLokace(7).pridejPredmet(new Predmet("Tajemný artefakt") {
            @Override
            public String pouzit() {
                return "Artefakt obsahuje starobylé znalosti mimozemšťanů.";
            }
        });
    }

    public void start() {
        svet = new SvetovaMapa();
        svet.nactiMapu();
        inventar = new Inventar();
        hrac = new Hrac(svet, inventar);
        svet.setHrac(hrac);

        nastavPopisyLokaci();
        nastavPostavyAPredmety();
        inicializace();

        System.out.println("Vítejte v textové hře Galaktický průzkumník!");
        System.out.println(svet.getAktualniPozice().getZakladniPopis());
        System.out.println("Napište 'pomoc' pro seznam příkazů");

        while (!exit) {
            System.out.print("\n> ");
            String vstup = scanner.nextLine().trim().toLowerCase();
            vykonejPrikaz(vstup);
            kontrolaVyhry();
        }
    }

    private void kontrolaVyhry() {
        if (svet.getAktualniPozice().getId() == 0 && hrac.isHyperpohonOpraven()) {
            System.out.println("Gratulujeme! Úspěšně jste opravili hyperpohon a vrátili se na základnu!");
            exit = true;
        }
    }

    private void vykonejPrikaz(String prikaz) {
        if (prikazy.containsKey(prikaz)) {
            String vysledek = prikazy.get(prikaz).vykonej();
            if (vysledek.contains("Musíš bojovat")) {
                prikazy.put("utok", new Utok(hrac, new Pirat(svet, inventar), inventar));
                prikazy.put("unik", new Unik(hrac));
            }
            System.out.println(vysledek);
            exit = prikazy.get(prikaz).ukoncit();
            if (hrac.isPiratiVUtoku() && (prikaz.equals("utok") || prikaz.equals("unik"))) {
                hrac.setPiratiVUtoku(false);
            } else {
                System.out.println("Neznámý příkaz. Napiš 'pomoc' pro seznam příkazů.");
            }
        }
    }
}
