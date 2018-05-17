/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahjong.GUI;

import java.awt.Color;
import javax.swing.JProgressBar;
import mahjong.partie.Partie;

/**
 *
 * @author aschneid
 */
public class InterfaceDeJeu extends javax.swing.JPanel {
    
    private Partie partie;

    public InterfaceDeJeu(Fenetre fenetre) 
    {
        initComponents();
        plateauGUI.setFenetre(fenetre);
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
        plateauGUI.setPlateau(partie.getPlateau());
    }

    public void changerBarTemps(int temp, Color color) {
        jProgressBarTempsRestant.setValue(temp);
        jProgressBarTempsRestant.setForeground(color);
        jProgressBarTempsRestant.repaint();         //evite le saccadement
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInfoJeu = new javax.swing.JPanel();
        jProgressBarTempsRestant = new javax.swing.JProgressBar();
        jPanelInfoJoueur = new javax.swing.JPanel();
        jLabelLabelNomJoueur = new javax.swing.JLabel();
        labelNomJoueur = new javax.swing.JLabel();
        jLabelLabelScore = new javax.swing.JLabel();
        jLabelLabelTemps = new javax.swing.JLabel();
        labelScoreJoueur = new javax.swing.JLabel();
        labelTempPartie = new javax.swing.JLabel();
        boutonMelanger = new javax.swing.JButton();
        boutonPause = new javax.swing.JButton();
        plateauGUI = new mahjong.GUI.PlateauGUI();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanelInfoJeu.setMaximumSize(new java.awt.Dimension(200, 32767));

        jProgressBarTempsRestant.setOrientation(JProgressBar.VERTICAL);

        jLabelLabelNomJoueur.setText("Joueur :");

        labelNomJoueur.setText("jLabel2");

        jLabelLabelScore.setText("Score :");

        jLabelLabelTemps.setText("Temps :");

        labelScoreJoueur.setText("0");

        labelTempPartie.setText("jLabel6");

        boutonMelanger.setText("Melanger");
        boutonMelanger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonMelangerActionPerformed(evt);
            }
        });

        boutonPause.setText("Pause");
        boutonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonPauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInfoJoueurLayout = new javax.swing.GroupLayout(jPanelInfoJoueur);
        jPanelInfoJoueur.setLayout(jPanelInfoJoueurLayout);
        jPanelInfoJoueurLayout.setHorizontalGroup(
            jPanelInfoJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(boutonMelanger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelInfoJoueurLayout.createSequentialGroup()
                .addGroup(jPanelInfoJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoJoueurLayout.createSequentialGroup()
                        .addComponent(jLabelLabelNomJoueur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNomJoueur))
                    .addGroup(jPanelInfoJoueurLayout.createSequentialGroup()
                        .addGroup(jPanelInfoJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLabelScore)
                            .addComponent(jLabelLabelTemps))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInfoJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTempPartie)
                            .addComponent(labelScoreJoueur))))
                .addGap(0, 34, Short.MAX_VALUE))
            .addComponent(boutonPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelInfoJoueurLayout.setVerticalGroup(
            jPanelInfoJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoJoueurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfoJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLabelNomJoueur)
                    .addComponent(labelNomJoueur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInfoJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLabelScore)
                    .addComponent(labelScoreJoueur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInfoJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLabelTemps)
                    .addComponent(labelTempPartie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(boutonPause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boutonMelanger))
        );

        javax.swing.GroupLayout jPanelInfoJeuLayout = new javax.swing.GroupLayout(jPanelInfoJeu);
        jPanelInfoJeu.setLayout(jPanelInfoJeuLayout);
        jPanelInfoJeuLayout.setHorizontalGroup(
            jPanelInfoJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoJeuLayout.createSequentialGroup()
                .addComponent(jPanelInfoJoueur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBarTempsRestant, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelInfoJeuLayout.setVerticalGroup(
            jPanelInfoJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBarTempsRestant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelInfoJoueur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanelInfoJeu);

        javax.swing.GroupLayout plateauGUILayout = new javax.swing.GroupLayout(plateauGUI);
        plateauGUI.setLayout(plateauGUILayout);
        plateauGUILayout.setHorizontalGroup(
            plateauGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );
        plateauGUILayout.setVerticalGroup(
            plateauGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(plateauGUI);
    }// </editor-fold>//GEN-END:initComponents

    private void boutonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonPauseActionPerformed
        if(partie.estEnPaused())
            boutonPause.setText("Pause");
        else
            boutonPause.setText("Reprendre");
        partie.changePause();
    }//GEN-LAST:event_boutonPauseActionPerformed

    private void boutonMelangerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonMelangerActionPerformed
        partie.melangerPlateau();
    }//GEN-LAST:event_boutonMelangerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonMelanger;
    private javax.swing.JButton boutonPause;
    private javax.swing.JLabel jLabelLabelNomJoueur;
    private javax.swing.JLabel jLabelLabelScore;
    private javax.swing.JLabel jLabelLabelTemps;
    private javax.swing.JPanel jPanelInfoJeu;
    private javax.swing.JPanel jPanelInfoJoueur;
    private javax.swing.JProgressBar jProgressBarTempsRestant;
    private javax.swing.JLabel labelNomJoueur;
    private javax.swing.JLabel labelScoreJoueur;
    private javax.swing.JLabel labelTempPartie;
    private mahjong.GUI.PlateauGUI plateauGUI;
    // End of variables declaration//GEN-END:variables

    public void setTailleChronometre(int tempCoup) {
        jProgressBarTempsRestant.setMaximum(tempCoup);
    }

    public void updateTempJeu(String tempsTotalDeJeu) 
    {
        labelTempPartie.setText(tempsTotalDeJeu);
    }

    public void setScore(int score) {
        labelScoreJoueur.setText(""+score);
    }

    public void bloquerPlateau(boolean b) {
        plateauGUI.bloquerPlateau(b);
    }
}
