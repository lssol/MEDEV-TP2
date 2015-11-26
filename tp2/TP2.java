/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seti
 */
public class TP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ModelePGM lena = new ModelePGM("lena.pgm");
            lena.test_lireMatrice();
        } catch (IOException ex) {
            Logger.getLogger(TP2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
