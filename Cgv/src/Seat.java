

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Seat extends JFrame {
	JPanel panel,seat;
	JLabel screen,seats[],peopleLabel,priceLabel;
	RoundedButton prev,next;
	boolean[] select;
	ArrayList<String> ticket;
	int member; 														// member는 하나씩 감소하면서 0이되면 좌석이 전부 다 선택된것임 초기에는 그전 화면에서 고른 인원수
	/*
	 * TicketingFrame에서 영화예매정보들을 파라미터로 넘겨줌, parent는 ticketingFrame이다. 나중에 예매끝나면 두프레임다 종료 시키기위함이다. 
	 */
	public Seat(final String movieName,int people,final int price,final int ticketNum,final String time,final JFrame parent) {
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
		setSize(1200,700);
		setTitle("Choice seats");
		member = people;
		panel = new JPanel(null);
		
		screen = new JLabel("SCREEN");
		screen.setBackground(Color.DARK_GRAY);
		screen.setFont(font);
		screen.setFont(new Font(screen.getFont().getName(), Font.PLAIN, 65));
		screen.setForeground(Color.white);
		screen.setOpaque(true);												
		
		prev = new RoundedButton("PREV");
		next = new RoundedButton("NEXT");
		ticket = new ArrayList<String>();									
		
		seat = new JPanel(new GridLayout(7, 7));	 						
		seats = new JLabel[50];												
		select = new boolean[50];											
		

		seat.setBackground(Color.white);
		seat.setOpaque(true);
		
		for(int i=0;i<7;i++) 												
			for(int j=0;j<7;j++) {
				final int k =i*7+j;											
				seats[k] = new JLabel(Integer.toString(k+1)); 				
				seats[k].setHorizontalAlignment(JLabel.CENTER);				
				seats[k].addMouseListener(new MouseListener() {				
					
					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent arg0) { 						// 위에는 다 안쓰니깐 버리고 click 이벤트만 씀
						// TODO Auto-generated method stub
						if(seats[k].getBackground()==Color.DARK_GRAY) { 					// MAGETA는 지금 선택했던 좌석
							seats[k].setBackground(Color.WHITE); 						// 다시 선택하면 다시 흰색으로 배경을 바꿔줌
							select[k] = false;											// 선택된 좌석을 false로 바꿔주고 member를 하나증가시킴
							member++;
						}
						else if(member>0 && seats[k].getBackground()!=Color.GREEN){ 	// green는 이전에 다른사람이 예매한 좌석, member가 아직 0이아니면
							seats[k].setBackground(Color.DARK_GRAY);						// 선택할 수 있으므로 magenta로 색깔을 바꿔주고 select를 true로해줌
							select[k] = true;						
							member--;													// 한자리 선택했으므로 member는 감소시킴
						}
						seats[k].setOpaque(true);										// 바뀐 배경색 적용
					}
				});
				seat.add(seats[k]);														// 위와같이 초기화한 seats 라벨을 하나씩 gridlayout으로 세팅한 panel에 add함
			}
		
		try {
			FileReader fr = new FileReader("ticket.txt");								// ticket.txt 를 읽어드림
			BufferedReader br = new BufferedReader(fr);
			String str;
			while((str = br.readLine()) != null) { 										// 한줄단위로 읽어드림
				ticket.add(str); 														// ticket arraylist에 add시킴
				StringTokenizer st = new StringTokenizer(str);							// 이제 stringtokenize로 자를것임
				String name = st.nextToken("\t ");										// 여기서 필요한거는 영화이름 ,시간 ,좌석정보임
				String str2 = st.nextToken("\t ");										// 나머지는 필요없으므로 str2에 대충 넣어줌
				str2 = st.nextToken("\t ");
				String seats = st.nextToken("\t ");
				String tim = st.nextToken("\t ");
				StringTokenizer st2 = new StringTokenizer(seats,",");					// 이제 좌석정보를 ","로 구분할것임
				System.out.println(seats);
				if(movieName.equals(name) && time.equals(tim)) {						// 이전에 지금 읽어드린 예매정보가 내가 예매할 정보랑 맞는지검사해서 맞으면
					while(st2.hasMoreTokens()) {
						str2 = st2.nextToken();											// ","로 자른 좌석 번호의 배경색을 green으로 바꿔줌
						int k = Integer.parseInt(str2);
						this.seats[k].setBackground(Color.GREEN);
						this.seats[k].setOpaque(true);
					}
				}
			}
			br.close();
			fr.close();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		prev.addActionListener(new ActionListener() {									// prev 버튼 이벤트 리스너
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				parent.setVisible(true);												// 다시 티켓 선택화면을 보여주고
				Seat.this.dispose();												// 좌석 선택 화면은 dispose
			}
		});
		next.addActionListener(new ActionListener() {									// next 버튼 이벤트 리스너
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(member>0) 
					new MsgBox(new JFrame("") ,null,null,"좌석을 전부 선택해주세요",null, false,null); 		// member가 0보다 크단것은 좌석을 전부선택 하지 않았다는 뜻
				else {
					String msg = movieName+"\t"+ticketNum+"\t"+price;								// 그게아니면 예매정보를 아래와 같이 가공함
					String seats = "\t";
					String etc = "시    간 : "+time+"   가     격 : "+price;
					for(int i=0;i<49;i++) {															// 해당하는 좌석이 선택되면 true이기때문에
						if(select[i])																// true인지 검사하고 맞으면 seats에 추가해줌
							seats+=(i+1)+",";
					}
					seats = seats.substring(0, seats.length()-1);									// seats의 마지막 문자가 ","이기때문에 그것을 없애주기위함
					new MsgBox(new JFrame("") ,"영화 이름 : "+movieName,"예약 번호 : "+ticketNum, etc,"좌     석   : "+seats, false,Seat.this); // 가공한 정보를 msgbox로 띄움
					msg +=seats+"\t"+time;
					ticket.add(msg);																// 리스트에 역시 추가함
					try {
						FileWriter fw = new FileWriter("ticket.txt"); 								// 이제 예매를 했으니 ticket.txt에 쓸것임
						BufferedWriter bw = new BufferedWriter(fw);									// 지금 예매한것만 추가하고싶으나 그럴수없으므로 ticket에 있는 모든 정보를 다시 출력해줌									
						for(int i = 0 ; i<ticket.size();i++)										// 반복문을돌려서 모든 예매정보를 다시 출력해줌 									
							bw.write(ticket.get(i)+"\n");
						bw.close();
						fw.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		 
		peopleLabel = new JLabel("인원       :     "+people+"명");
		priceLabel = new JLabel("가격       :     " +price+"원");
		screen.setBounds(40,50,1100,80);
		screen.setHorizontalAlignment(SwingConstants.CENTER);
		
		prev.setBounds(430, 600, 140, 30);	
		// widget들 절대좌표지정
		next.setBounds(630, 600, 140, 30);
		seat.setBounds(40,130,1100,400);
		peopleLabel.setBounds(80,280,140,30);
		priceLabel.setBounds(280,280,140,30);
		
		panel.add(seat);
		panel.add(screen);
		panel.add(prev);
		panel.add(next);
		panel.add(peopleLabel);
		panel.add(priceLabel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);				 // 크기 조절 불가
		add(panel);		
	}

}
