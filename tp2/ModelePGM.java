/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represente le fichier PGM
 * @author seti
 */
public class ModelePGM {
    private String source;
    private BufferedReader fichier;
    private int width;
    private int height;
    /**
     * Désigne la matrice qui represente le fichier : chaque ligne represente une ligne réèlle de l'image
     */
    private int[][] matrice;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    /**
     * Le constructeur de la classe réalise l'importation du fichier source
     * @param source est le lien vers le fichier à importer 
     */
    public ModelePGM(String source) {
        
    }
    /**
     * Crée un fichier sous format PGM
     * @param nomFichier Le nom du fichier
     */
    public void ecrire(String nomFichier){
        
    }
}
