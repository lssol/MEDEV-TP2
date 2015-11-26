/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represente le fichier PGM
 *
 * @author seti
 */
public class ModelePGM {

    private String source;
    private BufferedReader fichier;
    private int width;
    private int height;
    /**
     * Désigne la matrice qui represente le fichier : chaque ligne represente
     * une ligne réèlle de l'image
     */
    private int[][] matrice;


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrice() {
        return matrice;
    }
    /**
     * Ce constructeur permet la construction de modèle PGM par d'autres classes
     * @param mat La matrice du fichier PGM
     */
    public ModelePGM(int[][] mat){
        width = mat[0].length;
        height = mat.length;
        
        matrice = mat;       
    }
    /**
     * Le constructeur de la classe réalise l'importation du fichier source
     * A savoir : une fois les lignes du début ecrite, les sauts de ligne ne sont plus d'aucune importance
     *
     * @param source est le lien vers le fichier à importer
     */
    public ModelePGM(String source) throws IOException {
        this.source = source;
        try {
            this.fichier = new BufferedReader(new FileReader(source));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModelePGM.class.getName()).log(Level.SEVERE, null, ex);
        }

        String delimiteur = " ";
        String ligne;
        // On se place à la ligne où on definit les dimensions
        ligne = fichier.readLine();
        ligne = fichier.readLine();
        ligne = fichier.readLine();

        //Initialisation de width
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteur);
        width = Integer.parseInt(tokenizer.nextToken());
        height = Integer.parseInt(tokenizer.nextToken());
        ligne = fichier.readLine();
        ligne = fichier.readLine();
        matrice = new int[width][height];

        // Compteur de mots, reviens à 0 quand on atteint width
        int compteur = 0;
        int i = 0; // ligne dans la matrice
        int j = 0; // colonne dans la matrice

        while (ligne != null) {
            StringTokenizer tok = new StringTokenizer(ligne, delimiteur);

            while (tok.hasMoreTokens()) {
                // Lorsqu'on a finis une ligne
                if (compteur == width) {
                    compteur = 0;
                    i++;
                }
                matrice[i][j] = Integer.parseInt(tok.nextToken());
                j++;
                compteur++;
            }
            // on passe à la ligne suivante du fichier
            ligne = fichier.readLine();
        }
        fichier.close();
    }

    /**
     * Crée un fichier sous format PGM
     * @param nomFichier Le nom du fichier
     */
    public void ecrire(String nomFichier){

    }
    public void test_lireMatrice(){
        int i;
        int j;
        for (i = 0; i < width; i++) {
            for(j=0; j < height ; j++)
                System.out.print(matrice[i][j] + " ");
            System.out.println("\n");
        }
    }
}
