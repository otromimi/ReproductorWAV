/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;


import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *Si este se inicia y no encuentra las imagenes crea botones con las acciones en texto.
 * @author Guillermo Leiro Arroyo & Ivan Orosa Gilarranz
 */
public class PanelContenido extends JPanel{
    
    BotonCustom explore, play, pause, stop;
    SliderCustom progressBar;
    JLabel descuento;
    private JFileChooser seleccion;
    private Thread hilo=null;
    private SoundStream pista;
    
    public PanelContenido(){
        super();
        explore = new BotonCustom("explorar"){
            public void actionPerformed(ActionEvent e){
                exploreActions();
            }
        };
        play = new BotonCustom("play"){
            public void actionPerformed(ActionEvent e){
                pista.play();
                pause.setEnabled(true);
                stop.setEnabled(true);
                play.setEnabled(false);
            }
        };
        pause = new BotonCustom("pause"){
            public void actionPerformed(ActionEvent e){
                pista.pausa();
                play.setEnabled(true);
                pause.setEnabled(false);
            }
        };
        stop = new BotonCustom("stop"){
            public void actionPerformed(ActionEvent e){
                stopActions();
            }
        };
        progressBar = new SliderCustom();
        descuento = new JLabel(" --- seg");
        
        explore.setEnabled(true);
        add(explore);
        add(play);
        add(pause);
        add(stop);
        add(progressBar);
        add(descuento);
    }
    
    private void exploreActions(){
        seleccion = new JFileChooser();
        seleccion.setDialogTitle("Explorador");
        //seleccion.setCurrentDirectory();

        seleccion.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV file", "wav");
        seleccion.addChoosableFileFilter(filter);
        if(seleccion.showOpenDialog(explore)==JFileChooser.APPROVE_OPTION){
            progressBar.setValue(0);
            play.setEnabled(true);
            //pause.setEnabled(true);
            //stop.setEnabled(true);
            if(hilo!=null)//para que no se puedan reproducir dos pistas a la vez
                pista.pausa();
        }

        try {
            pista =new SoundStream(seleccion.getSelectedFile(), this);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"ERROR\n"+"Usted la ha liado parda.","ATECION",JOptionPane.ERROR_MESSAGE);
        }
        hilo = new Thread(pista);
        hilo.start();
    }
    
    public void stopActions(){
        pista.stop();
        play.setEnabled(true);
        pause.setEnabled(false);
        stop.setEnabled(false);
    }
}