/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;


import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Guillermo Leiro Arroyo & Ivan Orosa Gilarranz
 */
public class Reproductor{

    /**
     * El mail es feo y gordo por ahorrarme una clase
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame aplicacion = new JFrame("Reproductor");
        Reproductor este = new Reproductor();
        este.ponImagen(aplicacion);//Explicacion el el metodo
        aplicacion.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        aplicacion.add(new PanelContenido());
        aplicacion.pack();
        aplicacion.setResizable(false);
        aplicacion.setVisible(true);
        aplicacion.setLocationRelativeTo(null);
        
    }
    
    /***
     * He hecho esta guarreria ya que si no, no deja inbocar al getClass() desde una clase sin instanciar
     * @param jf 
     */
    private void ponImagen(JFrame jf){
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/reproductor.png")));
    }
    
}
