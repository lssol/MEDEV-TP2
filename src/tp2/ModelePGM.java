/*		
 * To change this license header, choose License Headers in Project Properties.		
 * To change this template file, choose Tools | Templates		
 * and open the template in the editor.		
 */		
package tp2;		
		
import java.io.BufferedReader;		
import java.io.BufferedWriter;		
import java.io.File;		
import java.io.FileNotFoundException;		
import java.io.FileReader;		
import java.io.FileWriter;		
import java.io.IOException;		
import java.io.PrintWriter;		
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
     *		
     * @param mat La matrice du fichier PGM		
     */		
    public ModelePGM(int[][] mat) {		
        width = mat[0].length;		
        height = mat.length;		
		
        matrice = mat;		
    }		
		
    /**		
     * Le constructeur de la classe réalise l'importation du fichier source A		
     * savoir : une fois les lignes du début ecrite, les sauts de ligne ne sont		
     * plus d'aucune importance		
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
        matrice = new int[height][width];		
		
        int i = 0; // ligne dans la matrice		
        int j = 0; // colonne dans la matrice		
		
        while (ligne != null && i < height) {		
            StringTokenizer tok = new StringTokenizer(ligne, "\t");		
		
            while (tok.hasMoreTokens()) {		
                // Lorsqu'on a finis une ligne		
                if (j == width) {		
                    i++;		
                    j = 0;		
                }		
                matrice[i][j] = Integer.parseInt(tok.nextToken());		
                j++;		
            }		
            // on passe à la ligne suivante du fichier		
            ligne = fichier.readLine();		
        }		
        fichier.close();		
    }		
		
    /**		
     * Crée un fichier sous format PGM		
     *		
     * @param nomFichier Le nom du fichier (sans l'extension		
     */		
    public void ecrire(String nomFichier) {		
        File f = new File(nomFichier + ".pgm");		
        try {		
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));		
            pw.println("P2");		
            pw.println("#");		
            pw.println(width + " " + height);		
            pw.println("255");		
		
            int i;		
            int j;		
            for (i = 0; i < height; i++) {		
                for (j = 0; j < width; j++) {		
                    pw.print(matrice[i][j] + " ");		
                }		
                pw.print("\n");		
            }		
            pw.close();		
        } catch (IOException exception) {		
            System.out.println("Erreur lors de l'ecrituree : " + exception.getMessage());		
        }		
    }		
    /**		
     * Utilise la classe Histo pour générer l'histogramme de la photo courante		
     * @param nom Nom du fichier générer sans l'extension		
     */		
    public void genererHisto(String nom){		
        Histo histo = new Histo(this);		
        ModelePGM histoPGM = histo.genereModelePGM();		
        histoPGM.ecrire(nom);		
    }		
		
    public void test_lireMatrice() {		
        int i;		
        int j;		
        for (i = 0; i < height; i++) {		
            for (j = 0; j < width; j++) {		
                System.out.print(matrice[i][j] + " ");		
            }		
            System.out.println("\n");		
        }		
    }		
}