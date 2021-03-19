

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
		icon = new ImageIcon("C:\\Users\\USER\\Desktop\\�ڹٽǽ���ü����\\Cgv\\background.jpg");
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
//        background.setLayout(new FlowLayout());


		Font font = new Font("08���ﳲ��ü B",Font.PLAIN,40);
		
		//Container con = getContentPane();
	    background.add(Box.createRigidArea(new Dimension(0, 90)));

		RoundedButton button1 = new RoundedButton("�����ϱ�");
	    background.add(Box.createRigidArea(new Dimension(0, 13)));
		button1.setFont(font);
		
    	RoundedButton button2 = new RoundedButton("���� Ȯ��");
	    background.add(Box.createRigidArea(new Dimension(0, 13)));
    	button2.setFont(font);
    	
    	RoundedButton button3 = new RoundedButton("��ȭ ����");
	    background.add(Box.createRigidArea(new Dimension(0, 13)));
    	button3.setFont(font);
    	
    	RoundedButton button4 = new RoundedButton("���� ����");	
	    background.add(Box.createRigidArea(new Dimension(0, 13)));
    	button4.setFont(font);
	 	
    	button1.setAlignmentX(CENTER_ALIGNMENT);
	 	button2.setAlignmentX(CENTER_ALIGNMENT);
	 	button3.setAlignmentX(CENTER_ALIGNMENT);
	 	button4.setAlignmentX(CENTER_ALIGNMENT);
		// ���� ����: BoxLayout.X_AXIS

		// ���� ����: BoxLayout.Y_AXIS
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
		setResizable(false);				 // ũ�� ���� �Ұ�
		add(background);
		button1.addActionListener(new ActionListener() { 						// ��ȭ ���� ��ư �̺�Ʈ������
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Ticketing().show(); 									// ticketframe�� ������
				Contents.this.dispose();										// mainframe�� dispose��
			}
		});
		button2.addActionListener(new ActionListener() { 						// ���� Ȯ�� ��ư �̺�Ʈ ������
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CheckTicket().show(); 									// checkTicketFrame �� ������
				Contents.this.dispose(); 										// mainframe�� dispose����
			}
		});
	button3.addActionListener(new ActionListener() { 						// ���� Ȯ�� ��ư �̺�Ʈ ������
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ShowMovieContents().show(); 									// checkTicketFrame �� ������
				Contents.this.dispose(); 										// mainframe�� dispose����
			}
		});
	button4.addActionListener(new ActionListener() { 						// ���� Ȯ�� ��ư �̺�Ʈ ������
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Food().show(); 									// checkTicketFrame �� ������
			Contents.this.dispose(); 										// mainframe�� dispose����
		}
	});
//	button4.addActionListener(new ActionListener() { 						// ���� Ȯ�� ��ư �̺�Ʈ ������
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			new CheckTicket().show(); 									// checkTicketFrame �� ������
//			Contents.this.dispose(); 										// mainframe�� dispose����
//		}
//	});
//		button3.addActionListener(new ActionListener() { 						// ��ȭ ���� ��ư �̺�Ʈ������
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				Contents.this.dispose();
//				new MainFrame().show();
//										// mainframe�� dispose��
//			}
//		});
//		button2.addActionListener(new ActionListener() { 						// ���� Ȯ�� ��ư �̺�Ʈ ������
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				Contents.this.dispose(); 										// mainframe�� dispose����
//				new MainFrame().show(); 									// checkTicketFrame �� ������
//			}
//		});
		
}
}
