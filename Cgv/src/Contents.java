

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Contents extends JFrame{
	public Contents(){
		
		setSize(1200,700);
		setTitle("Contents");
		ImageIcon icon;
		icon = new ImageIcon("C:\\Users\\USER\\Desktop\\자바실습대체과제\\Cgv\\background.jpg");
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
//        background.setLayout(new FlowLayout());


		Font font = new Font("08서울남산체 B",Font.PLAIN,40);
		
		//Container con = getContentPane();
	    background.add(Box.createRigidArea(new Dimension(0, 90)));

		RoundedButton button1 = new RoundedButton("예약하기");
	    background.add(Box.createRigidArea(new Dimension(0, 13)));
		button1.setFont(font);
		
    	RoundedButton button2 = new RoundedButton("예약 확인");
	    background.add(Box.createRigidArea(new Dimension(0, 13)));
    	button2.setFont(font);
    	
    	RoundedButton button3 = new RoundedButton("영화 정보");
	    background.add(Box.createRigidArea(new Dimension(0, 13)));
    	button3.setFont(font);
    	
    	RoundedButton button4 = new RoundedButton("음식 예약");	
	    background.add(Box.createRigidArea(new Dimension(0, 13)));
    	button4.setFont(font);
	 	
    	button1.setAlignmentX(CENTER_ALIGNMENT);
	 	button2.setAlignmentX(CENTER_ALIGNMENT);
	 	button3.setAlignmentX(CENTER_ALIGNMENT);
	 	button4.setAlignmentX(CENTER_ALIGNMENT);
		// 수평 정렬: BoxLayout.X_AXIS

		// 수직 정렬: BoxLayout.Y_AXIS
        background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
       
        
        
        background.add(Box.createRigidArea(new Dimension(0, 100)));
        background.add(button1);     
        background.add(Box.createRigidArea(new Dimension(0, 40)));
        background.add(button2);
        background.add(Box.createRigidArea(new Dimension(0, 40)));
        background.add(button3);
        background.add(Box.createRigidArea(new Dimension(0, 40)));
        background.add(button4);    
        background.add(Box.createRigidArea(new Dimension(0, 40)));
        
//        background.add(Box.createVerticalStrut(1));
//        background.add(Box.createRigidArea(new Dimension(0, 10)));
//        background.add(button1);     
//        background.add(Box.createHorizontalStrut(1));
//        background.add(button2);
//        background.add(Box.createHorizontalStrut(1));
//        background.add(button3);
//        background.add(Box.createHorizontalStrut(1));
//        background.add(button4);    
//        background.add(Box.createHorizontalStrut(1));

//										
					
//		
//		button1.setBounds(180, 180, 140, 30);
//		button1.setFont(font);
//		button2.setBounds(180, 340, 140, 30);
//		button2.setFont(font);
////		button3.setBounds(0, 100, 140, 30);
////		button3.setFont(font);
////		button4.setBounds(0, 150, 140, 30);
////		button4.setFont(font);
//		
//		background.add(button1);
//		background.add(button2);
////		background.add(button3);
////		background.add(button4);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);				 // 크기 조절 불가
		add(background);
		button1.addActionListener(new ActionListener() { 						// 영화 예매 버튼 이벤트리스너
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Ticketing().show(); 									// ticketframe을 보여줌
				Contents.this.dispose();										// mainframe은 dispose함
			}
		});
		button2.addActionListener(new ActionListener() { 						// 예매 확인 버튼 이벤트 리스너
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CheckTicket().show(); 									// checkTicketFrame 을 보여줌
				Contents.this.dispose(); 										// mainframe은 dispose해줌
			}
		});
	button3.addActionListener(new ActionListener() { 						// 예매 확인 버튼 이벤트 리스너
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ShowMovieContents().show(); 									// checkTicketFrame 을 보여줌
				Contents.this.dispose(); 										// mainframe은 dispose해줌
			}
		});
	button4.addActionListener(new ActionListener() { 						// 예매 확인 버튼 이벤트 리스너
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Food().show(); 									// checkTicketFrame 을 보여줌
			Contents.this.dispose(); 										// mainframe은 dispose해줌
		}
	});
//	button4.addActionListener(new ActionListener() { 						// 예매 확인 버튼 이벤트 리스너
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			new CheckTicket().show(); 									// checkTicketFrame 을 보여줌
//			Contents.this.dispose(); 										// mainframe은 dispose해줌
//		}
//	});
//		button3.addActionListener(new ActionListener() { 						// 영화 예매 버튼 이벤트리스너
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				Contents.this.dispose();
//				new MainFrame().show();
//										// mainframe은 dispose함
//			}
//		});
//		button2.addActionListener(new ActionListener() { 						// 예매 확인 버튼 이벤트 리스너
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				Contents.this.dispose(); 										// mainframe은 dispose해줌
//				new MainFrame().show(); 									// checkTicketFrame 을 보여줌
//			}
//		});
		
}
}
