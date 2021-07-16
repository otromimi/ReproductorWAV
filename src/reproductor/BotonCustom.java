/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Guillermo Leiro Arroyo & Ivan Orosa Gilarranz
 */
public class BotonCustom extends JButton implements ActionListener{
    
    public BotonCustom(String name){
        super();
        setApariencia(name);
        addActionListener(this);
        setEnabled(false);
    }
    
    private void setApariencia(String name){
        try{
            Image img = ImageIO.read(getClass().getResource("../images/"+name+".png"));
            setIcon(new ImageIcon(img));
            setContentAreaFilled(false);
            setBorderPainted(false);
        }catch(Exception e){
            setText(name);
            //setFocusPainted(false);
        }
        setFocusPainted(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void paintComponents(Graphics g){
        g.fillRoundRect(this.getX(), this.getY(), this.getWidth(), this.getHeight(), 10, 10);
    }
}
