package AAdminListening;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class ListeningInpuut {
	public static void main(String[] args) {

		String filepath = "C:\\Users\\Administrator\\Desktop\\img\\kimvoice2.wav";
		PlayMusic1(filepath);
		JOptionPane.showMessageDialog(null, "리스닝을 멈추기 위해 OK를 눌러주세요.");

	}

	public static void PlayMusic1(String location) {
		try {
			File MusicPath = new File(location);

			if (MusicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(MusicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			} else {

				System.out.println("Can't find file");
			}
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	private static void PlayMusic(String filepath) {
		// TODO Auto-generated method stub

	}

}
