
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TheEnd extends JFrame{

	public TheEnd()
	{
		ImageIcon icon;
		icon = new ImageIcon("C:\\Users\\USER\\Desktop\\�ڹٽǽ���ü����\\Cgv\\TheEnd.jpg");

		//JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("C:\\Users\\USER\\Desktop\\�ڹٽǽ���ü����\\Cgv\\menuBar.png")));
		
		JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(icon.getImage(), 0, 0, 1200,700,null);
                // Approach 2: Scale image to size of component
                // Dimension d = getSize();
                // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                // Approach 3: Fix the image position in the scroll pane
                // Point p = scrollPane.getViewport().getViewPosition();
                // g.drawImage(icon.getImage(), p.x, p.y, null);
                setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
                super.paintComponent(g);
            }
        };
    	setSize(1200,700);
		setTitle("2019110729�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);				 // ũ�� ���� �Ұ�
		add(background);
		
	}
	
}
