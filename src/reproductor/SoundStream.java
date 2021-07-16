/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

/**
 *Si no se cuenta el Timer solo se usan dos hilos.
 * @author Guillermo Leiro Arroyo & Ivan Orosa Gilarranz
 */


public class SoundStream implements Runnable {
    
    PanelContenido controles;
    Clip clip;
    Timer metronomo;
    

    public SoundStream(File pista, PanelContenido controles) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(pista));
        this.controles= controles;
    }

    @Override
    public void run() {
        metronomo = new Timer(400,new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(clip.getFramePosition()==clip.getFrameLength())
                    //stop();
                    controles.stopActions();
                else{
                    if(clip.isActive()){
                        controles.descuento.setText(((clip.getMicrosecondLength()-clip.getMicrosecondPosition())/1000000)+" seg");
                        controles.progressBar.setValue(clip.getFramePosition()/(clip.getFrameLength() / 100));
                    }
                }
            }
        });
        metronomo.start();
    }
    
    public void pausa(){
        clip.stop();
    }

    public void play() {
        clip.setFramePosition((clip.getFrameLength() / 100) * controles.progressBar.getValue());
        clip.start();
    }

    public void stop(){
        this.pausa();
        clip.setFramePosition(0);
        controles.progressBar.setValue(0);
        controles.descuento.setText(" "+(clip.getMicrosecondLength()/1000000)+" seg");
    }
}
