

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
	public Main(){
		ImageIcon icon;
		icon = new ImageIcon("C:\\Users\\USER\\Desktop\\�ڹٽǽ���ü����\\Cgv\\main.jpg");

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
		BackgroundMusic introMusic = new BackgroundMusic( true);
		
		introMusic.start();
		
		//introMusic.close();
		Font font = new Font("08���ﳲ��ü B",Font.PLAIN,45);
										// cgv ���ڸ� red�� �ٲ���
		
		RoundedButton button1 = new RoundedButton("START");
		background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
    	button1.setAlignmentX(CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0, 30)));
		button1.setBounds(0, 0, 140, 30);
		button1.setFont(font);
	    background.add(Box.createRigidArea(new Dimension(0, 540)));

		background.add(button1);
		
		//main â�� �����ϱ⸦ ������, �����ϱ� ����Ȯ�� ��ȭ���� ��Ÿ ���� ���� �̿밡���ϴ�.
		
//		RoundedButton button2 = new RoundedButton("���� Ȯ��");
//		RoundedButton button3 = new RoundedButton("��ȭ ����");
//		RoundedButton button4 = new RoundedButton("��Ÿ");							// widget�� ������ǥ ��������
//		button2.setBounds(0, 10, 140, 30);
//		button2.setFont(font);
//		button3.setBounds(0, 20, 140, 30);
//		button3.setFont(font);
//		button4.setBounds(0, 30, 140, 30);
//		button4.setFont(font);
//		
//		background.add(button2);
//		background.add(button3);
//		background.add(button4);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);				 // ũ�� ���� �Ұ�
		add(background);
		
		
		
		button1.addActionListener(new ActionListener() { 						// ��ȭ ���� ��ư �̺�Ʈ������
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				new Contents().show();
				
				// ticketframe�� ������
				Main.this.dispose();										// mainframe�� dispose��
			
			}
		});
//		button2.addActionListener(new ActionListener() { 						// ���� Ȯ�� ��ư �̺�Ʈ ������
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				new CheckTicketFrame().show(); 									// checkTicketFrame �� ������
//				MainFrame.this.dispose(); 										// mainframe�� dispose����
//			}
//		});
//		
	}
	
	

	public static void main(String args[]) {
		new Main().show();
		//new movie().show();
	}
}

