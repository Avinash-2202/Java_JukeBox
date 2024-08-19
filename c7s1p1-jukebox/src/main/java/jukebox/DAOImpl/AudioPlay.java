package jukebox.DAOImpl;
import jukebox.model.song;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AudioPlay {
    public static void playList(ArrayList<song> list){
        Scanner scanner = new Scanner(System.in);
        Iterator<song> i= list.iterator();
        song song=null;
        String response = "";

        try {
            while (!(response.equalsIgnoreCase("s")||response.equalsIgnoreCase("n"))) {

                while (i.hasNext() && !(response.equalsIgnoreCase("s") && !(response.equalsIgnoreCase("n") ) )) {
                    song=i.next();
                    File file = new File(song.geturl());
                    if (file.exists()) {
                        AudioInputStream audioinput = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioinput);
                        clip.start();
                        do {
                            System.out.println("\tP:play songs & Resume Song \tPa:pause\tr:Replay songs\tn:next\tS:stop songs");
                            response = scanner.next();
                            switch (response) {
                                case ("p") : clip.start();
                                    break;
                                case ("pa") :clip.stop();
                                    break;
                                case ("s") : clip.stop();
                                    break;
                                case ("n") :clip.stop();
                                    break;
                                case ("r") : clip.setMicrosecondPosition(0);
                                    break;
                                default :System.out.println("Enter valid response ");
                            }


                        } while (!response.equalsIgnoreCase("s")&&!response.equalsIgnoreCase("n"));
                    }
                    else{
                        System.out.println("OOPS...file missing!!!...");}
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void playSong(ArrayList<song> list, int a){
        Scanner scanner = new Scanner(System.in);
        Iterator<song> i= list.iterator();
        song song=null;
        String response = "";
        try {
            while (i.hasNext() && (!(response.equalsIgnoreCase("s"))) ) {
                song=i.next();
                if (a==(song.getSongId())){

                    File file = new File(song.geturl());
                    if (file.exists()) {
                        AudioInputStream audioinput = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioinput);

                        do {
                            System.out.println("\tP:play songs\tPa:pause\tr:reset songs\tS:stop songs");
                            response = scanner.next();
                            switch (response) {
                                case ("p") : clip.start();
                                    break;
                                case ("pa") :clip.stop();
                                    break;
                                case ("s") : clip.stop();
                                    break;
                                case ("n") :clip.stop();
                                    break;
                                case ("r") : clip.setMicrosecondPosition(0);
                                    break;
                                default :System.out.println("Enter valid response ");
                            }
                        } while (!(response.equalsIgnoreCase("S")));
                    }
                    else{
                        System.out.println("OOPS...file missing!!!...");}
                }}
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
