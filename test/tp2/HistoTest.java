/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oriane école
 */
public class HistoTest {
    
    public HistoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of genereModelePGM method, of class Histo.
     */
    @Test
    public void testGenereModelePGM() {
        System.out.println("genereModelePGM");
        
        // on crée l'histogramme à tester ayant 10 pixels de chaque teinte ( de 0 à 255 )
        int[] val = new int[256];
        Histo instance = new Histo(val);
        for (int i = 0; i < val.length; i++) {
            val[i]=10;            
        }
        
        // on crée une matrice représentant l'image attendues : un histogramme plat ayant 10 pixels noirs pour chaque valeur en abscisse
        int[][] mat = new int[256][10];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j]=0;                
            }
        }
        
        // on génére les ModelePGM à comparer
        ModelePGM expResult = new ModelePGM(mat);
        ModelePGM result = instance.genereModelePGM();
        
        // on copare des ModelePGM
        // FIXME ne fonctionne pas ainsi
        // il manque peut etre la méthode equals dans ModelePGM ??
        assertEquals(expResult, result);

    }
    
}
