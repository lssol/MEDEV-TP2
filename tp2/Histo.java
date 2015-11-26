/*
 * 
 */
package tp2;

/**
 * histogramme associé à une image PGM, c'est à dire représentation du nombre de pixels par teinte
 * 
 * @author oriane
 */
public class Histo {
    /**
     * Vecteur contenant le nombre de pixels pour chaque teinte (entre 0 et 255)
     */
    private int valeurs[];

    /**
     * Construit un objet Histo en fonction d'une matrice représentant une image en PGM
     * @param m modele de données associée à l'image source
     */
    public Histo(ModelePGM m) {
        valeurs = new int[256];
        
        int l = m.getlenght();
        int w = m.getwdth();
        
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                int k = m[i][j];
                    valeurs[k] ++;
                }
            }
            
        }
    
    public ModelePGM genereModelPGM(){
        
        
        
        return ModelPGM;
    }
    
    
}
