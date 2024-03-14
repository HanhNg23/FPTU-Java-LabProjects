import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*Recommended you go to search " youtube audio library" and then
 * download file mp3 then convert it into file ".wav"
 * link to search more https://www.geeksforgeeks.org/play-audio-file-using-java/ */
public class Audio_java {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Scanner scanner = new Scanner(System.in);
		File file = new File("C:\\Users\\HOANGANH\\Documents\\Java\\Java beginning\\Java beginner\\Java Audio\\Tell Me That I Can't (Clean) - NEFFEX.wav");
		
		//create an object of AudioInputStream by using AudioSystem.getAudioInputStream(File file)
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        //Get a clip reference object from AudioSystem.
		Clip clip = AudioSystem.getClip();
		//open audioInputStream to the clip
		clip.open(audioStream);

		String response = " ";
		//clip.loop(0); for loop with number of times
		
		while(!response.equals("Q")) {
			System.out.println(" P --> play || S --> Stop || R --> Reset || Q --> Quit");
			System.out.println(" Input: ");
			response = scanner.nextLine();
			response = response.toUpperCase();
			
			switch(response) {
			case "Q": clip.close();
			break;
			case "R": {
				clip.setMicrosecondPosition(0);
				clip.start();
			}
			break;
			case "S": clip.stop();
			break;
			case "P": clip.start();
			break;
			default: System.out.println("Not a valid response!");
		
			}
		}	
	}
}
