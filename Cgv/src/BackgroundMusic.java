
import javazoom.jl.player.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class BackgroundMusic extends Thread {
	
	private Player player;
	private boolean isLoop;//음악이 어떠한 방식으로 진행될지에 대해
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public BackgroundMusic( boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File("C:\\Users\\USER\\Desktop\\자바실습대체과제\\Cgv\\introMusic.mp3");
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {//노래를 종료 시킬 때
		isLoop = false;
		player.close();
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
