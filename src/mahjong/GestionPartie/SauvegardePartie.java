package mahjong.GestionPartie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mahjong.GestionJoueur.Joueur;

/**
 * Classe gérant la sauvegarde de la partie
 *
 * @author axelp
 */
public class SauvegardePartie {

    private Partie partie;
    private Joueur joueur;

    public SauvegardePartie() {
    }

    public SauvegardePartie(Partie partie, Joueur joueur) {
        this.partie = partie;
        this.joueur = joueur;
    }

    public Partie getPartie() {
        return partie;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void sauvegarder(String path) {
        FileWriter fichier;
        try {
            fichier = new FileWriter(path);
            fichier.write(joueur.getNom() + "\n");
            this.partie.save(fichier);
            fichier.close();
        } catch (IOException ex) {
            Logger.getLogger(SauvegardePartie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void charger(String path) {
        if (path.endsWith(".mprt")) {
            BufferedReader fichier;
            try {
                fichier = new BufferedReader(new FileReader(path));
                String nomJoueur = fichier.readLine();
                this.partie = new Partie();
                this.partie.charger(fichier);
                this.joueur = new Joueur(nomJoueur);

                fichier.close();
            } catch (IOException ex) {
                Logger.getLogger(SauvegardePartie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
