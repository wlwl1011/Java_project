
import javazoom.jl.player.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class BackgroundMusic extends Thread {
	
	private Player player;
	private boolean isLoop;//������ ��� ������� ��������� ����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public BackgroundMusic( boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File("C:\\Users\\USER\\Desktop\\�ڹٽǽ���ü����\\Cgv\\introMusic.mp3");
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
	
	public void close() {//�뷡�� ���� ��ų ��
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
