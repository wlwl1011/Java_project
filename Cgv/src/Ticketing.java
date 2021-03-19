

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Ticketing extends JFrame implements ItemListener, ActionListener{
	Choice movieName;              //영화목록  
	Choice selectTime; 			//시간
	Choice adultTicket;	//성인
	Choice childTicket;	//학생

	
	JLabel label,name,time,adult,child;
	RoundedButton next,prev;
	int ticketNum,select;
	public Ticketing()
	{
		setTitle("Ticketing");
		ImageIcon icon;
		icon = new ImageIcon("C:\\Users\\USER\\Desktop\\자바실습대체과제\\Cgv\\background2.jpg");
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


		Font font = new Font("08서울남산체 B",Font.PLAIN,50);
		setSize( 1200,700);
		setTitle("영화 예매");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label = new JLabel("Reservation");
		label.setFont(font);
		name = new JLabel("영화 제목 : ");
		time = new JLabel("영화 시간 : ");
		adult = new JLabel("어   른 : ");
		child = new JLabel("청소년 : ");
		
		ticketNum = (int) (Math.random()*99999);						// 예매 번호를 random으로 선택함
		next = new RoundedButton("NEXT");
		prev = new RoundedButton("PREV");
		
		next.addActionListener(this);									// next 이벤트 리스너
		
		prev.addActionListener(new ActionListener() { 					// home 버튼 이벤트 리스너 이전 frame의 home 이벤트 리스너와 같음
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Ticketing.this.dispose();
				new Contents().show();
//				this.addWindowListener(new WindowAdapter() {
//					public void windowClosing(WindowEvent e) {
//						System.exit(0);
//					}});
			}
		});
		
		movieName=new Choice();                // 초이스 객체를 생성한다.
		selectTime=new Choice(); 
		
		selectTime.setFont(font);
		selectTime.add("09:00~11:20(조조할인)");       // 영화에 따라 다른 시간표를 추가한다.
		selectTime.add("11:30~13:50");
		selectTime.add("14:00~16:20");
		selectTime.add("16:30~18:50");
		selectTime.add("19:00~17:20");
		selectTime.add("17:30~19:50");
		selectTime.add("22:00~24:20(심야할인)");
		
		adultTicket=new Choice();			// 여른표 구매수를 입력받기 위한 텍스트필드
		childTicket=new Choice();			// 청소년표 구매수를 입력받기 위한 텍스트필드
		adultTicket.setFont(font);
		childTicket.setFont(font);
		
		movieName.setFont(font);
		movieName.add("노트북");     
		movieName.add("악마는 프라다를 입는다");
		movieName.add("위대한 개츠비");
		movieName.add("오만과 편견");
	
		movieName.addItemListener(this);
	
		for(int i=0; i < 11; i++) {                 //인원수 최대 10명
			adultTicket.add(String.valueOf(i));
			childTicket.add(String.valueOf(i));
		}
       
		movieName.setFont(new Font(movieName.getFont().getName(), Font.PLAIN, 25));
		movieName.setMaximumSize (new Dimension(250,33));
		selectTime.setFont(new Font(selectTime.getFont().getName(), Font.PLAIN, 25));
		selectTime.setMaximumSize (new Dimension(250,33));
		adultTicket.setFont(new Font(adultTicket.getFont().getName(), Font.PLAIN, 25));
		adultTicket.setMaximumSize (new Dimension(250,33));
		childTicket.setFont(new Font(childTicket.getFont().getName(), Font.PLAIN, 25));
		prev.setFont(new Font(childTicket.getFont().getName(), Font.PLAIN, 25));
		next.setFont(new Font(childTicket.getFont().getName(), Font.PLAIN, 25));
		childTicket.setMaximumSize (new Dimension(250,33));
		
		background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
		
		label.setAlignmentX(CENTER_ALIGNMENT);
        
		//background.add(Box.createRigidArea(new Dimension(0, 10)));
        label.setForeground(Color.white);

		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 65));
		background.add(Box.createRigidArea(new Dimension(0, 20)));
        
        
    	name.setAlignmentX(CENTER_ALIGNMENT);

    	name.setFont(font);
    	name.setFont(new Font(movieName.getFont().getName(), Font.PLAIN, 33));
    	
	 	time.setAlignmentX(CENTER_ALIGNMENT);
    	time.setFont(font);
    	time.setFont(new Font(movieName.getFont().getName(), Font.PLAIN, 33));
    	
		adult.setAlignmentX(CENTER_ALIGNMENT);
    	adult.setFont(font);
    	adult.setFont(new Font(movieName.getFont().getName(), Font.PLAIN, 33));
    	
		child.setAlignmentX(CENTER_ALIGNMENT);
        child.setFont(font);
    	child.setFont(new Font(movieName.getFont().getName(), Font.PLAIN, 33));
    	
        next.setAlignmentX(CENTER_ALIGNMENT);
        prev.setAlignmentX(CENTER_ALIGNMENT);
		// 수직 정렬: BoxLayout.Y_AXIS
        
        name.setForeground(Color.white);
		time.setForeground(Color.white);
		adult.setForeground(Color.white);
		child.setForeground(Color.white);

		background.add(Box.createRigidArea(new Dimension(0, 30)));
		background.add(label);
		background.add(Box.createRigidArea(new Dimension(0, 30)));
		background.add(name);
		background.add(Box.createRigidArea(new Dimension(0, 10)));
		background.add(movieName);
		background.add(Box.createRigidArea(new Dimension(0, 18)));
		background.add(time);
		background.add(Box.createRigidArea(new Dimension(0, 10)));
		background.add(selectTime);
		background.add(Box.createRigidArea(new Dimension(0, 18)));
		background.add(adult);
		background.add(Box.createRigidArea(new Dimension(0, 10)));
		background.add(adultTicket);
		background.add(Box.createRigidArea(new Dimension(0, 18)));
		background.add(child);
		background.add(Box.createRigidArea(new Dimension(0, 10)));
		background.add(childTicket);
		background.add(Box.createRigidArea(new Dimension(0, 30)));
		background.add(next);
		background.add(Box.createRigidArea(new Dimension(0, 10)));
		background.add(prev);
		background.add(Box.createRigidArea(new Dimension(0, 10)));
		setResizable(false);				 // 크기 조절 불가
		add(background);
		
	}
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int index = movieName.getSelectedIndex();		//ch1의 선택번호를 index에 입력
		System.out.println(index);
		selectTime.removeAll();
		if(index == 0)							//index가 0일 경우
		{					
			selectTime.add("09:00~11:20(조조할인)");//영화에따라다른시간표를추가한다.
			selectTime.add("11:30~13:50");
			selectTime.add("14:00~16:20");
			selectTime.add("16:30~18:50");
			selectTime.add("19:00~17:20");
			selectTime.add("17:30~19:50");
			selectTime.add("22:00~24:20(심야할인)");
		}
		else if(index==1)
		{					
			selectTime.add("09:10~12:10(조조할인)");//영화에따라다른시간표를추가한다.
			selectTime.add("12:20~15:20");
			selectTime.add("15:30~18:30");
			selectTime.add("18:40~21:40");
			selectTime.add("--:--~--:--");
			selectTime.add("--:--~--:--");
			selectTime.add("21:50~24:50(심야할인)");
		}
		else if(index==2)
		{					
			selectTime.add("09:00~10:50(조조할인)");//영화에따라다른시간표를추가한다.
			selectTime.add("11:00~12:50");
			selectTime.add("13:00~14:50");
			selectTime.add("15:00~16:50");
			selectTime.add("17:00~18:50");
			selectTime.add("19:00~20:50");
			selectTime.add("--:--~--:--(심야영화없음)");
		}
		else if(index==3)
		{					
			selectTime.add("--:--~--:--(조조할인없음)");
			selectTime.add("11:00~13:50");//영화에따라다른시간표를추가한다.
			selectTime.add("14:00~16:50");
			selectTime.add("17:00~19:50");
			selectTime.add("20:00~22:50");
			selectTime.add("--:--~--:--");
			selectTime.add("23:00~25:50(심야할인)");
		}
		else if(index==4)
		{					
			selectTime.add("10:00~12:20(조조할인)");//영화에따라다른시간표를추가한다.
			selectTime.add("12:30~14:50");
			selectTime.add("15:00~17:20");
			selectTime.add("19:00~17:20");
			selectTime.add("17:30~19:50");
			selectTime.add("--:--~--:--");
			selectTime.add("22:00~24:20(심야할인)");
		}
		else if(index==5)
		{					
			selectTime.add("--:--~--:--(조조할인없음)");
			selectTime.add("11:00~13:50");//영화에따라다른시간표를추가한다.
			selectTime.add("14:00~16:50");
			selectTime.add("17:00~19:50");
			selectTime.add("20:00~22:50");
			selectTime.add("--:--~--:--");
			selectTime.add("--:--~--:--(심야영화없음)");
		}
		select = index;
	}
	public void actionPerformed(ActionEvent e){

		// 버튼에 적힌 문자열을 읽어온다.

			int l_nmovie_time = selectTime.getSelectedIndex();		//각 아이템에서 index 를 얻어옴
			String l_strmovie_time = selectTime.getSelectedItem();
			int l_nadult_ticket = adultTicket.getSelectedIndex();
			int l_nstudent_ticket = childTicket.getSelectedIndex();


			String all ="";
			int l_nadult_price = 9000;					//각표에 대한 가격 설정
			int l_nstudent_price = 8000;
			int l_totalPrice = 0;

			if((l_nadult_ticket == 0 && l_nstudent_ticket == 0) 
				|| l_strmovie_time.equals("--:--~--:-- (조조 할인 없음)") 
				|| l_strmovie_time.equals("--:--~--:-- (심야 영화 없음)")
				|| l_strmovie_time.equals("--:--~--:--")
				||l_strmovie_time.equals(null))
			{
				new MsgBox(new JFrame("") ,null,null ,"다시 한번 확인해주세요.",null, false,null);
			}
			else
			{
				if(l_nmovie_time == 0 && !l_strmovie_time.equals("--:--~--:-- (조조 할인 없음)"))
				{
					l_nadult_price -= 2000;
					l_nstudent_price -= 2000;
				}
				else if(l_nmovie_time == 6 && !l_strmovie_time.equals("--:--~--:-- (심야 영화 없음)"))
				{
					l_nadult_price -= 1000;
					l_nstudent_price -= 1000;
				}
				if(l_nadult_ticket != 0)
				{
					l_totalPrice += l_nadult_ticket*l_nadult_price; 
				}
				if(l_nstudent_ticket != 0)
				{
					l_totalPrice += l_nstudent_ticket*l_nstudent_price;
				}
				
				all += String.valueOf(l_totalPrice)+"   ";
				
				
				//MsgBox message = new MsgBox(new Frame("") , l_strmovie_time+"   " + all, true);
				//Ticketing.this.setVisible(false); // 현재 티켓고르는 화면은 visivle false로 해줌 dispose 안한것은 seatframe에서 prev버튼 처리를 쉽게하기위함임 dispose해주면 사용자가 입력한 모든 정보가 날라가기 때문
				/*
				 * 지금 선택한 영화의 모든 정보를 seatFrame에 넘겨줌 seatFrame에선 모든 좌석을 선택하면 영화 예매가 완료됨
				 */
				Seat seat = new Seat(movieName.getItem(select),l_nadult_ticket+l_nstudent_ticket,l_totalPrice,ticketNum,l_strmovie_time,Ticketing.this);
				seat.show();
				// 좌석 선택 화면 show해줌
				Ticketing.this.dispose();
				Ticketing.this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}}); 
			}
	  }
	
}
