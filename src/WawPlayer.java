
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class WawPlayer {
    
    /* Prehraje alarm po dokonceni casovace. Pokud nastane chyba, vypise se do konzole */
    static void playSound(String filename) {
        try { 
            File soundFile = new File("." + File.separator + "data" + File.separator + filename);       // alokuje soubor waw
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);                          // nacte jako waw soubor
            Clip clip = AudioSystem.getClip();                                                              // nacte se jako Clip                                     
            clip.open(audioIn);                                                                             // prectou se a nactou data wav souboru
            clip.start();                                                                                   // prehraje soubor (celkem dvakrat)
            //clip.loop(1);                                                                                 // smycka o dvou opakovanich
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Nastala chyba při načítání nebo přehrávání audio souboru"); 
        }     
    }
    
}
