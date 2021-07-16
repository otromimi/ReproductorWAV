/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import javax.swing.JSlider;

/**
 *
 * @author Guillermo Leiro Arroyo & Ivan Orosa Gilarranz
 */
public class SliderCustom extends JSlider{
    
    public SliderCustom(){
        super();
        this.setMajorTickSpacing(25);
        this.setMinorTickSpacing(5);
        this.setPaintTicks(true);
        this.setValue(0);
        //this.setCursor(Cursor.);
        //this.setPaintLabels(true);
    }
    
}
