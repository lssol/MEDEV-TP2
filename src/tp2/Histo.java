/*		
 * 		
 */		
package tp2;		
		
/**		
 * histogramme associé à une image PGM, c'est à dire représentation du nombre de		
 * pixels par teinte		
 *		
 * @author oriane		
 */		
public class Histo {		
		
    /**		
     * Vecteur contenant le nombre de pixels pour chaque teinte (entre 0 et 255)		
     */		
    private int valeurs[];		
		
    /**		
     * Construit un objet Histo en fonction d'une matrice représentant une image		
     * en PGM		
     *		
     * @param m modele de données associée à l'image source		
     */		
    public Histo(ModelePGM m) {		
        // vnb de pixels pours les valeurs entre 0 et 255		
        valeurs = new int[256];		
		
        int h = m.getHeight();		
        int w = m.getWidth();		
        int k;		
        for (int i = 0; i < h; i++) {		
            for (int j = 0; j < w; j++) {		
                k = m.getMatrice()[i][j];		
                valeurs[k]++;		
            }		
        }		
		
    }		
		
    /**		
     * génère l'objet ModelePGM correspondant à l'histogramme courant		
     *		
     * @return image PGM représentant l'histogramme		
     */		
    public ModelePGM genereModelePGM() {		
        //hauteur de l'image PGM de l'histogramme		
        int max = 0;		
        for (int i = 0; i < valeurs.length; i++) {		
            if (valeurs[i] > max) {		
                max = valeurs[i];		
            }		
        }		
		
        // création de la matrice des valeurs		
        int matrice[][] = new int[max][valeurs.length];		
		
        for (int i = max - 1; i >= 0; i--) {		
            for (int j = 0; j < valeurs.length; j++) {		
                if (valeurs[j] > 0) {		
                    matrice[i][j] = 0;		
                    valeurs[j]--;		
                } else {		
                    matrice[i][j] = 255;		
                }		
            }		
        }		
		
        ModelePGM res = new ModelePGM(matrice);		
		
        return res;		
    }		
		
}