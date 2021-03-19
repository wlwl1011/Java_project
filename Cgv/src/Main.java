

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
	public Main(){
		ImageIcon icon;
		icon = new ImageIcon("C:\\Users\\USER\\Desktop\\자바실습대체과제\\Cgv\\main.jpg");

		//JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("C:\\Users\\USER\\Desktop\\자바실습대체과제\\Cgv\\menuBar.png")));
		
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
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };
    	setSize(1200,700);
		setTitle("2019110729김민지");
		BackgroundMusic introMusic = new BackgroundMusic( true);
		
		introMusic.start();
		
		//introMusic.close();
		Font font = new Font("08서울남산체 B",Font.PLAIN,45);
										// cgv 글자를 red로 바꿔줌
		
		RoundedButton button1 = new RoundedButton("START");
		background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
    	button1.setAlignmentX(CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0, 30)));
		button1.setBounds(0, 0, 140, 30);
		button1.setFont(font);
	    background.add(Box.createRigidArea(new Dimension(0, 540)));

		background.add(button1);
		
		//main 창에 접속하기를 누르면, 예약하기 예약확인 영화정보 기타 등의 서비스 이용가능하다.
		
//		RoundedButton button2 = new RoundedButton("예약 확인");
//		RoundedButton button3 = new RoundedButton("영화 정보");
//		RoundedButton button4 = new RoundedButton("기타");							// widget들 절대좌표 지정해줌
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
		setResizable(false);				 // 크기 조절 불가
		add(background);
		
		
		
		button1.addActionListener(new ActionListener() { 						// 영화 예매 버튼 이벤트리스너
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				new Contents().show();
				
				// ticketframe을 보여줌
				Main.this.dispose();										// mainframe은 dispose함
			
			}
		});
//		button2.addActionListener(new ActionListener() { 						// 예매 확인 버튼 이벤트 리스너
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				new CheckTicketFrame().show(); 									// checkTicketFrame 을 보여줌
//				MainFrame.this.dispose(); 										// mainframe은 dispose해줌
//			}
//		});
//		
	}
	
	

	public static void main(String args[]) {
		new Main().show();
		//new movie().show();
	}
}

