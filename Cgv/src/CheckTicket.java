

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckTicket extends JFrame
{
	ArrayList<String> ticket; 											// text파일에서 예매된 정보를 가져와서 arraylist에 넣어줌

	JLabel label,numLabel;
	RoundedButton next,prev;
	JTextField numText;
	public CheckTicket(){
		ImageIcon icon;
		icon = new ImageIcon("C:\\Users\\USER\\Desktop\\자바실습대체과제\\Cgv\\background2.jpg");
		JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(icon.getImage(), 0, 0, 1200, 700, null);
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


		Font font = new Font("08서울남산체 B", Font.PLAIN, 33);
		setSize(1200,700);
		setTitle("CheckTicket");
//		//Container con = getContentPane();
//		RoundedButton button1 = new RoundedButton("예약하기");
//		button1.setFont(font);
//    	RoundedButton button2 = new RoundedButton("예약 확인");
//    	button2.setFont(font);
//    	RoundedButton button3 = new RoundedButton("영화 정보");
//    	button3.setFont(font);
//    	RoundedButton button4 = new RoundedButton("음식 예약");	
//    	button4.setFont(font);
//	 	
//    	button1.setAlignmentX(CENTER_ALIGNMENT);
//	 	button2.setAlignmentX(CENTER_ALIGNMENT);
//	 	button3.setAlignmentX(CENTER_ALIGNMENT);
//	 	button4.setAlignmentX(CENTER_ALIGNMENT);
//		// 수평 정렬: BoxLayout.X_AXIS
//
//		// 수직 정렬: BoxLayout.Y_AXIS
//        background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
//       
//        
//        
//        background.add(Box.createRigidArea(new Dimension(0, 120)));
//        background.add(button1);     
//        background.add(Box.createRigidArea(new Dimension(0, 20)));
//        background.add(button2);
//        background.add(Box.createRigidArea(new Dimension(0, 20)));
//        background.add(button3);
//        background.add(Box.createRigidArea(new Dimension(0, 20)));
//        background.add(button4);    
//        background.add(Box.createRigidArea(new Dimension(0, 20)));
		label = new JLabel("Check the Reservation");
		label.setFont(font);
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 65));
		label.setForeground(Color.white);
		next = new RoundedButton("NEXT");
		prev = new RoundedButton("PREV");
		
		numLabel = new JLabel("  예약 번호  ");
		numLabel.setFont(font);
		numLabel.setForeground(Color.white);
		numText = new JTextField(10);
		numText.setMaximumSize (new Dimension(280,33));
		ticket = new ArrayList<String>(); 								// arraylist 초기화

		try {
			FileReader fr = new FileReader("ticket.txt");				// ticket.txt 파일에서 예매 정보를 가져옴
			BufferedReader br = new BufferedReader(fr);
			String str;
			
			
			
			while((str = br.readLine()) != null) { 						// 한줄단위로읽어서 arraylist에 넣어줌
				ticket.add(str);
			}
			br.close();
			fr.close();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		prev.addActionListener(new ActionListener() { 					// home 버튼 이벤트 리스너
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CheckTicket.this.dispose(); 						// 현재 frame을 dispose 해줌
				new Contents().show(); 								// mainframe을 show 해줌
			}
		});
		
		background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
		
		
		next.addActionListener(new ActionListener() { 					// 예매 정보 확인 버튼 이벤트 리스너
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//CheckTicket.this.dispose(); 
				for(int i=0;i<ticket.size();i++) {						// text에서 읽어온 예매된정보 에서 
					
					StringTokenizer st = new StringTokenizer(ticket.get(i).toString());
					String name = st.nextToken("\t ");
					String num = st.nextToken("\t ");
					if(num.equals(numText.getText().toString())) {
						String price = st.nextToken("\t ");
						String seats = st.nextToken("\t ");
						String time = st.nextToken("\t");
						String etc = "시    간 : "+time+"   가     격 : "+price;
						new MsgBox(new JFrame("") ,"영화 이름 : "+name,"예약 번호 : "+num, etc,"좌     석   : "+seats, false,null);
					}
				}
			}
		});
		
		next.setAlignmentX(CENTER_ALIGNMENT);
		prev.setAlignmentX(CENTER_ALIGNMENT);
		label.setAlignmentX(CENTER_ALIGNMENT);
		numLabel.setAlignmentX(CENTER_ALIGNMENT);
		numText.setAlignmentX(CENTER_ALIGNMENT);
		
		background.add(Box.createRigidArea(new Dimension(0, 40)));
		background.add(label);
		background.add(Box.createRigidArea(new Dimension(0, 100)));
		background.add(numLabel);
		background.add(Box.createRigidArea(new Dimension(0, 90)));
		background.add(numText);
		background.add(Box.createRigidArea(new Dimension(0, 100)));
		next.setFont(new Font(next.getFont().getName(), Font.PLAIN, 25));
		background.add(next);
		prev.setFont(new Font(prev.getFont().getName(), Font.PLAIN, 25));
		background.add(Box.createRigidArea(new Dimension(0, 20)));
		background.add(prev);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);				 // 크기 조절 불가
		add(background);
		
		
	}
}
