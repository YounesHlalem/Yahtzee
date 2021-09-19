package be.kdg.Yahtzee.model;

import be.kdg.Yahtzee.view.board.BoardPresenter;
import be.kdg.Yahtzee.view.board.BoardView;
import be.kdg.Yahtzee.view.einde.EindePresenter;
import be.kdg.Yahtzee.view.einde.EindeView;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.io.*;
import java.util.Optional;
import java.util.Random;

/**
 * Created by Younes & Edvin on 11/02/2017.
 */
public class Board {
    private int aantalSpelers;
    private boolean tegenAI;
    private int aantalRondes;
    private int spelerAanBeurt = 1;
    private boolean eindeSpel = false;
    private static final int MAX_AANTAL_OGEN = 6;
    private static final int AANTAL_STENEN = 5;
    private Random random = new Random();
    private int[] waardeSteen = new int[6];
    private boolean[] steenCheck = new boolean[6];
    private int aantalThrows = 3;
    private boolean werpKnop = false;
    private int[] punten = new int[15];
    private boolean[] puntAangeduid = new boolean[14];
    private int[] punten2 = new int[15];
    private boolean[] puntAangeduid2 = new boolean[14];
    private int[] punten3 = new int[15];
    private boolean[] puntAangeduid3 = new boolean[14];
    private int[] aantalZelfde = new int[7];
    private boolean[] waardeAanwezig = new boolean[7];
    private String[] gegevens = new String[110];
    private Random aiRandom = new Random();
    private int aiAanduiden = 1;

    private String[] namen;

    public void initialiseerGame(int spelers, int rondes) {
        if (spelers == 0) {
            aantalSpelers = 2;
            tegenAI = true;
        } else {
            aantalSpelers = spelers;
            tegenAI = false;
        }
        aantalRondes = rondes;
    }

    public void rol() {
        //Random waarde toewijzen aan dobbelstenen
        for (int i = 1; i <= AANTAL_STENEN; i++) {
            if (!(steenCheck[i])) {
                waardeSteen[i] = random.nextInt(MAX_AANTAL_OGEN) + 1;
            }
        }

        //aantal worpen verlagen en knop onbruikbaar maken
        aantalThrows -= 1;
        if (aantalThrows == 0) {
            werpKnop = true;
        }

        //punten en waardes resetten
        for (int i = 1; i <= 13; i++) {
            if (!(puntAangeduid[i])) {
                punten[i] = 0;
            }
            if (!(puntAangeduid2[i])) {
                punten2[i] = 0;
            }
            if (!(puntAangeduid3[i])) {
                punten3[i] = 0;
            }
        }
        for (int i = 1; i <= MAX_AANTAL_OGEN; i++) {
            aantalZelfde[i] = 0;
            waardeAanwezig[i] = false;
        }

        //Simpele combinaties bv: Ones, Twos, ...
        for (int i = 1; i <= AANTAL_STENEN; i++) {
            for (int j = 1; j <= MAX_AANTAL_OGEN; j++) {
                if (spelerAanBeurt == 1) {
                    if (waardeSteen[i] == j && !(puntAangeduid[j])) {
                        punten[j] += j;
                    }
                } else if (spelerAanBeurt == 2) {
                    if (waardeSteen[i] == j && !(puntAangeduid2[j])) {
                        punten2[j] += j;
                    }
                } else if (spelerAanBeurt == 3) {
                    if (waardeSteen[i] == j && !(puntAangeduid3[j])) {
                        punten3[j] += j;
                    }
                }
                //Tellen hoe vaak een waarde voorkomt
                if (waardeSteen[i] == j) {
                    aantalZelfde[j] += 1;
                }
            }
        }

        // 3 of a kind combinatie
        for (int i = 1; i <= MAX_AANTAL_OGEN; i++) {
            if (aantalZelfde[i] == 3 || aantalZelfde[i] == 4 || aantalZelfde[i] == 5) {
                if (spelerAanBeurt == 1 && !(puntAangeduid[7])) {
                    punten[7] = i * 3;
                }
                if (spelerAanBeurt == 2 && !(puntAangeduid2[7])) {
                    punten2[7] = i * 3;
                }
                if (spelerAanBeurt == 3 && !(puntAangeduid3[7])) {
                    punten3[7] = i * 3;
                }
            }
        }


        // 4 of a kind combinatie

        for (int i = 1; i <= MAX_AANTAL_OGEN; i++) {
            if (aantalZelfde[i] == 4 || aantalZelfde[i] == 5) {
                if (spelerAanBeurt == 1 && !(puntAangeduid[8])) {
                    punten[8] = i * 4;
                }
                if (spelerAanBeurt == 2 && !(puntAangeduid2[8])) {
                    punten2[8] = i * 4;
                }
                if (spelerAanBeurt == 3 && !(puntAangeduid3[8])) {
                    punten3[8] = i * 4;
                }
            }
        }

        // Full house combinatie
        for (int i = 1; i <= MAX_AANTAL_OGEN; i++) {
            if (aantalZelfde[i] == 3) {
                for (int j = 1; j <= MAX_AANTAL_OGEN; j++) {
                    if (aantalZelfde[j] == 2) {
                        if (spelerAanBeurt == 1 && !(puntAangeduid[9])) {
                            punten[9] = 25;
                        }
                        if (spelerAanBeurt == 2 && !(puntAangeduid2[9])) {
                            punten2[9] = 25;
                        }
                        if (spelerAanBeurt == 3 && !(puntAangeduid3[9])) {
                            punten3[9] = 25;
                        }
                    }
                }
            }
        }

        // Nakijken welke waardes er wel zijn
        for (int aantal : waardeSteen) {
            for (int i = 1; i <= MAX_AANTAL_OGEN; i++) {
                if (aantal == i) {
                    waardeAanwezig[i] = true;
                }
            }
        }

        // Small straight combo
        for (int i = 1; i <= 3; i++) {
            if ((waardeAanwezig[i] && waardeAanwezig[i + 1] && waardeAanwezig[i + 2] && waardeAanwezig[i + 3])) {
                if (spelerAanBeurt == 1 && !(puntAangeduid[10])) {
                    punten[10] = 30;
                }
                if (spelerAanBeurt == 2 && !(puntAangeduid2[10])) {
                    punten2[10] = 30;
                }
                if (spelerAanBeurt == 3 && !(puntAangeduid2[10])) {
                    punten3[10] = 30;
                }
            }
        }

        // Large straight combo
        for (int i = 1; i <= 2; i++) {
            if ((waardeAanwezig[i] && waardeAanwezig[i + 1] && waardeAanwezig[i + 2] && waardeAanwezig[i + 3] && waardeAanwezig[i + 4])) {
                if (spelerAanBeurt == 1 && !(puntAangeduid[11])) {
                    punten[11] = 40;
                }
                if (spelerAanBeurt == 2 && !(puntAangeduid2[11])) {
                    punten2[11] = 40;
                }
                if (spelerAanBeurt == 3 && !(puntAangeduid2[11])) {
                    punten3[11] = 40;
                }
            }
        }

        // Chance combo
        int puntenChance = 0;
        for (int ogen : waardeSteen) {
            puntenChance += ogen;
        }
        if (spelerAanBeurt == 1 && !(puntAangeduid[12])) {
            punten[12] = puntenChance;
        }
        if (spelerAanBeurt == 2 && !(puntAangeduid2[12])) {
            punten2[12] = puntenChance;
        }
        if (spelerAanBeurt == 3 && !(puntAangeduid3[12])) {
            punten3[12] = puntenChance;
        }


        // Yahtzee combo
        boolean yahtzeeCheck;
        int volgende = 2;
        do {
            if (waardeSteen[1] == waardeSteen[volgende]) {
                yahtzeeCheck = true;
            } else {
                yahtzeeCheck = false;
            }
            volgende += 1;
        } while (yahtzeeCheck && volgende <= AANTAL_STENEN);

        if (yahtzeeCheck && !(puntAangeduid[13])) {
            punten[13] = 50;
        }
        if (yahtzeeCheck && !(puntAangeduid2[13])) {
            punten2[13] = 50;
        }
        if (yahtzeeCheck && !(puntAangeduid3[13])) {
            punten3[13] = 50;
        }

        TotaalBerekenen();

        for (int i = 0; i < MAX_AANTAL_OGEN; i++) {
            aantalZelfde[i] = 0;
            waardeAanwezig[i] = false;
        }

    }

    private void TotaalBerekenen() {
        //total punten resetten en berekenen
        punten[14] = 0;
        punten2[14] = 0;
        punten3[14] = 0;
        for (int i = 1; i <= 13; i++) {
            if (puntAangeduid[i]) {
                punten[14] += punten[i];
            }
            if (puntAangeduid2[i]) {
                punten2[14] += punten2[i];
            }
            if (puntAangeduid3[i]) {
                punten3[14] += punten3[i];
            }
        }
    }

    public void DiceClick(int nummer) {
        if (!(aantalThrows == 3)) {
            steenCheck[nummer] = !(steenCheck[nummer]);
        }
    }

    public void Lock(int nummer) {
        if (!(aantalThrows == 3)) {
            if (spelerAanBeurt == 1 && !(puntAangeduid[nummer])) {
                puntAangeduid[nummer] = true;
                aantalThrows = 3;
                werpKnop = false;
                for (int i = 1; i <= AANTAL_STENEN; i++) {
                    steenCheck[i] = false;
                }
            } else if (spelerAanBeurt == 2 && !(puntAangeduid2[nummer])) {
                puntAangeduid2[nummer] = true;
                aantalThrows = 3;
                werpKnop = false;
                for (int i = 1; i <= AANTAL_STENEN; i++) {
                    steenCheck[i] = false;
                }
            } else if (spelerAanBeurt == 3 && !(puntAangeduid3[nummer])) {
                puntAangeduid3[nummer] = true;
                aantalThrows = 3;
                werpKnop = false;
                for (int i = 1; i <= AANTAL_STENEN; i++) {
                    steenCheck[i] = false;
                }
            }
            TotaalBerekenen();
            volgendeSpeler();
        }
    }

    private void volgendeRonde() {
        if (aantalRondes > 1) {
            aantalRondes -= 1;
        } else {
            eindeSpel = true;
        }
    }

    private void volgendeSpeler() {
        if (spelerAanBeurt < aantalSpelers) {
            spelerAanBeurt += 1;
        } else if (spelerAanBeurt == aantalSpelers) {
            spelerAanBeurt = 1;
            volgendeRonde();
        }
    }

    public void saveHuidig() {
        gegevens[0] = String.valueOf(aantalSpelers);
        gegevens[1] = String.valueOf(aantalRondes);
        gegevens[2] = String.valueOf(spelerAanBeurt);
        for (int i = 1; i <= 5; i++) {
            gegevens[i + 2] = String.valueOf(waardeSteen[i]);
        }
        for (int i = 1; i <= 5; i++) {
            gegevens[i + 7] = String.valueOf(steenCheck[i]);
        }
        gegevens[13] = String.valueOf(aantalThrows);
        for (int i = 1; i <= 14; i++) {
            gegevens[i + 13] = String.valueOf(punten[i]);
        }
        for (int i = 1; i <= 13; i++) {
            gegevens[i + 27] = String.valueOf(puntAangeduid[i]);
        }
        for (int i = 1; i <= 14; i++) {
            gegevens[i + 40] = String.valueOf(punten2[i]);
        }
        for (int i = 1; i <= 13; i++) {
            gegevens[i + 54] = String.valueOf(puntAangeduid2[i]);
        }
        for (int i = 1; i <= 14; i++) {
            gegevens[i + 67] = String.valueOf(punten3[i]);
        }
        for (int i = 1; i <= 13; i++) {
            gegevens[i + 81] = String.valueOf(puntAangeduid3[i]);
        }
    }

    public void save() {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter((new FileWriter("files/save.txt"))))) {
            String[] opslaan = getGegevens();
            for (String gegeven : opslaan) {
                pw.write(gegeven + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load(String[] ingelezenGegevens) {
        aantalSpelers = Integer.parseInt(ingelezenGegevens[0]);
        aantalRondes = Integer.parseInt(ingelezenGegevens[1]);
        spelerAanBeurt = Integer.parseInt(ingelezenGegevens[2]);
        aantalThrows = Integer.parseInt(ingelezenGegevens[13]);
        for (int i = 1; i <= 5; i++) {
            waardeSteen[i] = Integer.parseInt(ingelezenGegevens[i + 2]);
        }
        for (int i = 1; i <= 5; i++) {
            steenCheck[i] = Boolean.parseBoolean(ingelezenGegevens[i + 7]);
        }
        for (int i = 1; i <= 14; i++) {
            punten[i] = Integer.parseInt(ingelezenGegevens[i + 13]);
        }
        for (int i = 1; i <= 13; i++) {
            puntAangeduid[i] = Boolean.parseBoolean(ingelezenGegevens[i + 27]);
        }
        for (int i = 1; i <= 14; i++) {
            punten2[i] = Integer.parseInt(ingelezenGegevens[i + 40]);
        }
        for (int i = 1; i <= 13; i++) {
            puntAangeduid2[i] = Boolean.parseBoolean(ingelezenGegevens[i + 54]);
        }
        for (int i = 1; i <= 14; i++) {
            punten3[i] = Integer.parseInt(ingelezenGegevens[i + 67]);
        }
        for (int i = 1; i <= 13; i++) {
            puntAangeduid3[i] = Boolean.parseBoolean(ingelezenGegevens[i + 81]);
        }
        tegenAI = false;
    }

    public void loadSave() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(("files/save.txt")));
            String line = br.readLine();
            int i = 0;
            String[] inlezen = new String[110];
            while (line != null) {
                inlezen[i] = line;
                i++;
                line = br.readLine();
            }
            load(inlezen);
        } catch (FileNotFoundException e) {
            //kan niet
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    public boolean sluit() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alle data die niet zijn opgeslagen zullen verloren gaan!", ButtonType.OK);
        alert.setTitle("Terug naar hoofdmenu");
        alert.setHeaderText("Ben je zeker dat je wilt stoppen?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                return true;
            }
        }
        return false;
    }

    public int aiAanduiden() {
        do {
            if (punten2[13] > 1 && !puntAangeduid2[13]) {
                aiAanduiden = 13;
            } else if (punten2[6] > 1 && !puntAangeduid2[6]) {
                aiAanduiden = 6;
            } else if (punten2[5] > 1 && !puntAangeduid2[5]) {
                aiAanduiden = 5;
            } else if (punten2[4] > 1 && !puntAangeduid2[4]) {
                aiAanduiden = 4;
            } else if (punten2[3] > 1 && !puntAangeduid2[3]) {
                aiAanduiden = 3;
            } else if (punten2[2] > 1 && !puntAangeduid2[2]) {
                aiAanduiden = 2;
            } else if (punten2[1] > 1 && !puntAangeduid2[1]) {
                aiAanduiden = 1;
            } else if (!puntAangeduid2[12]) {
                aiAanduiden = 12;
            } else {
                aiAanduiden = aiRandom.nextInt(13) + 1;
            }
        } while (puntAangeduid2[aiAanduiden]);

        return aiAanduiden;
    }

    public void inlezen() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(("files/game_start.txt")));
            String line = br.readLine();
            String[] velden = line.split("\\|");
            initialiseerGame(Integer.parseInt(velden[0]), Integer.parseInt(velden[1]));
        } catch (FileNotFoundException e) {
            initialiseerGame(1, 13);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(("files/players.txt")));
            String line = br.readLine();
            namen = line.split("\\|");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    public void Spelgedaan() {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter((new FileWriter("files/win.txt"))))) {
            pw.write(winnaar());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String winnaar() {
        int[] tussenstand = {punten3[14], punten2[14], punten[14]};
        String[] tussenstandnamen = {namen[2], namen[1], namen[0]};

        for (int j = 0; j < 2; j++) {
            for (int i = 1; i < tussenstand.length; i++) {
                int temp = 0;
                String tempnaam = "";
                if (tussenstand[i - 1] > tussenstand[i]) {
                    temp = tussenstand[i - 1];
                    tussenstand[i - 1] = tussenstand[i];
                    tussenstand[i] = temp;
                    tempnaam = tussenstandnamen[i - 1];
                    tussenstandnamen[i - 1] = tussenstandnamen[i];
                    tussenstandnamen[i] = tempnaam;
                }
            }
        }
        return tussenstandnamen[2] + "-" + tussenstand[2] + "-" + tussenstandnamen[1] + "-" + tussenstand[1] + "-" + tussenstandnamen[0] + "-" + tussenstand[0] + "-" + aantalSpelers;
    }

    public int getWaardeSteen(int nummer) {
        return waardeSteen[nummer];
    }

    public int getAantalThrows() {
        return aantalThrows;
    }

    public boolean isWerpKnop() {
        return werpKnop;
    }

    public int getPunten(int nummer) {
        return punten[nummer];
    }

    public int getPunten2(int nummer) {
        return punten2[nummer];
    }

    public int getPunten3(int nummer) {
        return punten3[nummer];
    }

    public boolean getPuntenAangeduid(int nummer) {
        return puntAangeduid[nummer];
    }

    public boolean getPuntenAangeduid2(int nummer) {
        return puntAangeduid2[nummer];
    }

    public boolean getPuntenAangeduid3(int nummer) {
        return puntAangeduid3[nummer];
    }

    public boolean getSteenCheck(int nummer) {
        return steenCheck[nummer];
    }

    public int getAantalRondes() {
        return aantalRondes;
    }

    public int getSpelerAanBeurt() {
        return spelerAanBeurt;
    }

    public boolean isEindeSpel() {
        return eindeSpel;
    }

    public String[] getGegevens() {
        return gegevens;
    }

    public boolean isTegenAI() {
        return tegenAI;
    }

    public String getNamen(int i) {
        return namen[i];
    }
}
