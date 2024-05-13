package main;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL SoundURL[]= new URL[30];
    public Sound(){

        SoundURL[0] = getClass().getResource("/Schin/Sound/GameSong.wav");
        SoundURL[1] = getClass().getResource("/Schin/Sound/coin.wav");
        SoundURL[2] = getClass().getResource("/Schin/Sound/powerup.wav");
        SoundURL[3] = getClass().getResource("/Schin/Sound/unlock.wav");
        SoundURL[4] = getClass().getResource("/Schin/Sound/fanfare.wav");
        SoundURL[5] = getClass().getResource("/Schin/Sound/Usa incuiata.wav");
        SoundURL[6] = getClass().getResource("/Schin/Sound/Atomic.wav");
        SoundURL[7] = getClass().getResource("/Schin/Sound/meniu.wav");
        SoundURL[8] = getClass().getResource("/Schin/Sound/login.wav");
    }

public  void SetFile(int i){

        try {
            AudioInputStream GameSound = AudioSystem.getAudioInputStream(SoundURL[i]);//incarcam fisierul audio
            clip= AudioSystem.getClip();//creem un obiect de tip Clip
            clip.open(GameSound);//incarcam fisierul audio in obiectul de tip Clip
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }


public  void Play(){
        clip.start();//pornim clipul
    }
    public  void Stop(){
        clip.stop();//oprim clipul
    }
    public  void Loop(){
clip.loop(Clip.LOOP_CONTINUOUSLY);//pornim clipul in mod repetitiv

}
}
