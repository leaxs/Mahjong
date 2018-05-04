package mahjong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Plateau {

    private Tuile[][] plateau;
    private final int NOMBRE_LIGNE = 12;
    private final int NOMBRE_COLONNE = 12;
    private TypePlateau typeDePlateau;
    private Tuile tuilesSelectionnee;
    private final ArrayList<Coup> coups;
    private final int[][] EMPLACEMENT_AJOUTABLE = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public Plateau() {
        tuilesSelectionnee = null;
        plateau = new Tuile[NOMBRE_LIGNE][NOMBRE_COLONNE];
        coups = new ArrayList<>();
    }

    /**
     * Genere un nouveau plateau de jeu de manière aléatoire
     *
     * @param seed : graine de génération du terrain
     * @param typeDePlateau : gestion de la "physique" du terrain
     */
    public void genererNouveauPlateau(long seed, TypePlateau typeDePlateau) {
        Random random = new Random(seed);
        ArrayList<Tuile[]> listeDePaires = genererTableDePaireDeTuile();
        Collections.shuffle(listeDePaires, random);

        ArrayList<int[]> emplacementPossible = new ArrayList<>();
        emplacementPossible.add(new int[]{6, 6});
        plateau = new Tuile[NOMBRE_LIGNE][NOMBRE_COLONNE];

        System.out.println(listeDePaires.size());
        while (listeDePaires.size() > 0) {
            Tuile[] paires = listeDePaires.remove(0);
            System.out.println(paires[0] + " " + paires[1]);

            System.out.println("Nombre d'emplacement possible : " + emplacementPossible.size());
            ajouterTuile(emplacementPossible,
                    (int) (random.nextDouble() * emplacementPossible.size()),
                    paires[0]);

            System.out.println("Nombre d'emplacement possible : " + emplacementPossible.size());
            ajouterTuile(emplacementPossible,
                    (int) (random.nextDouble() * emplacementPossible.size()),
                    paires[1]);
            afficherTerrainSurConsole();
        }
        this.typeDePlateau = typeDePlateau;
    }

    public void ajouterTuile(ArrayList<int[]> emplacementPossible, int index, Tuile tuile) {
        int ligneTuile = emplacementPossible.get(index)[0];
        int colonneTuile = emplacementPossible.get(index)[1];

        plateau[ligneTuile][colonneTuile] = tuile;
        plateau[ligneTuile][colonneTuile].setCoordonnees(ligneTuile, colonneTuile);

        emplacementPossible.remove(index);
        for (int[] emplacement : EMPLACEMENT_AJOUTABLE) {
            if (ligneTuile + emplacement[0] >= 0 && ligneTuile + emplacement[0] < NOMBRE_LIGNE) {
                if (colonneTuile + emplacement[1] >= 0 && colonneTuile + emplacement[1] < NOMBRE_COLONNE) {
                    int[] nouvelleEmplacement = new int[]{ligneTuile + emplacement[0], colonneTuile + emplacement[1]};
                    if (emplacementPossible(emplacementPossible, nouvelleEmplacement)) {
                        emplacementPossible.add(nouvelleEmplacement);
                    }
                }
            }
        }
    }

    public boolean emplacementPossible(ArrayList<int[]> emplacementPossible, int[] nouvelleEmplacement) {
        boolean plateauLibreEmplacement = plateau[nouvelleEmplacement[0]][nouvelleEmplacement[1]] == null;
        int i = 0;
        while (plateauLibreEmplacement && i < emplacementPossible.size()) {
            plateauLibreEmplacement
                    = !(emplacementPossible.get(i)[0] == nouvelleEmplacement[0]
                    && emplacementPossible.get(i)[1] == nouvelleEmplacement[1]);
            i++;
        }
        return plateauLibreEmplacement;
    }

    /**
     * Genere une liste de tuilles apairées afin d'etre placer sur le plateau
     * @return liste de tuile apairés
     */
    public ArrayList<Tuile[]> genererTableDePaireDeTuile() {
        ArrayList<Tuile[]> listeDePaire = new ArrayList<>();
        for (FamilleDeTuile famille : FamilleDeTuile.values()) {
            if (famille.getNombrePairesTuile() != 0) {  
                //Tuile != de fleur ou saison
                for (int idTuile = 0; idTuile < famille.getNombreTuileDifferente(); idTuile++) {
                    for (int i = 0; i < famille.getNombrePairesTuile(); i++) {
                        listeDePaire.add(new Tuile[]{new Tuile(famille, idTuile), new Tuile(famille, idTuile)});
                    }
                }
            } else {
                listeDePaire.add(new Tuile[]{new Tuile(famille, 0), new Tuile(famille, 1)});
                listeDePaire.add(new Tuile[]{new Tuile(famille, 2), new Tuile(famille, 3)});
            }
        }
        return listeDePaire;
    }

    /**
     * Selectionne une tuile et tente de jouer un coup
     *
     * @param indexLigne : index de la tuile sur une ligne
     * @param indexColonne : index de la ligne sur une colonne
     */
    public void jouer(int indexLigne, int indexColonne) {
        if (tuilesSelectionnee == null) {
            tuilesSelectionnee = getTuile(indexLigne, indexColonne);
        } else if (tuilesSelectionnee == plateau[indexLigne][indexColonne]) {
            tuilesSelectionnee = null;
        } else {
            Tuile tuile = getTuile(indexLigne, indexColonne);
            if (tuile != null) {
                if (verifierCoupJouable()) {
                    Coup coup = new Coup(new Tuile[]{tuilesSelectionnee, tuile});
                    //On retire les references des objets de la selection et du plateau
                    tuilesSelectionnee = null;
                    plateau[coup.getTuiles()[0].getCoordonnees()[0]][coup.getTuiles()[0].getCoordonnees()[1]] = null;
                    plateau[coup.getTuiles()[1].getCoordonnees()[0]][coup.getTuiles()[1].getCoordonnees()[1]] = null;

                    coups.add(coup);

                    typeDePlateau.traitementTerrainPostCoup(plateau);
                }
            }
        }
    }

    /**
     * Verifier si un chemin valide est trouver entre les tuiles selectionnee
     *
     * @return vrai si le coup est jouable, faux sinon
     */
    public boolean verifierCoupJouable() {
        //TODO verifier via le path finding (Antoine)
        return true;
    }

    public boolean partieGagnee() {
        return 144 - 2 * coups.size() <= 0;
    }

    public Tuile getTuilesSelectionnee() {
        return tuilesSelectionnee;
    }

    public Tuile getTuile(int indexLigne, int indexColonne) {
        Tuile tuile = null;
        if ((0 <= indexLigne && indexLigne < this.NOMBRE_COLONNE)
                && (0 <= indexColonne && indexColonne < this.NOMBRE_LIGNE)) {
            tuile = plateau[indexLigne][indexColonne];
        }
        return tuile;
    }

    /**
     * Affiche le plateau directement dans la console
     */
    public void afficherTerrainSurConsole() {
        System.out.println("Mahjong");
        for (int indexLigne = 0; indexLigne < NOMBRE_LIGNE; indexLigne++) {
            for (int indexColonne = 0; indexColonne < NOMBRE_COLONNE; indexColonne++) {
                if (plateau[indexLigne][indexColonne] != null) {
                    System.out.print(plateau[indexLigne][indexColonne].toString() + " ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

    }
}