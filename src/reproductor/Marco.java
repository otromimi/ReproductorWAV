/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Liam
 */
public class Marco extends JFrame{
    public Marco(String titulo){
        super(titulo);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/reproductor.png")));
        add(new PanelContenido());
        
    }
}
