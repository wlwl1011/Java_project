

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
	int member; 														// member�� �ϳ��� �����ϸ鼭 0�̵Ǹ� �¼��� ���� �� ���õȰ��� �ʱ⿡�� ���� ȭ�鿡�� �� �ο���
	/*
	 * TicketingFrame���� ��ȭ������������ �Ķ���ͷ� �Ѱ���, parent�� ticketingFrame�̴�. ���߿� ���ų����� �������Ӵ� ���� ��Ű�������̴�. 
	 */
	public Seat(final String movieName,int people,final int price,final int ticketNum,final String time,final JFrame parent) {
		ImageIcon icon;
		icon = new ImageIcon("C:\\Users\\USER\\Desktop\\�ڹٽǽ���ü����\\Cgv\\background2.jpg");
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


		Font font = new Font("08���ﳲ��ü B",Font.PLAIN,50);
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
					public void mouseClicked(MouseEvent arg0) { 						// ������ �� �Ⱦ��ϱ� ������ click �̺�Ʈ�� ��
						// TODO Auto-generated method stub
						if(seats[k].getBackground()==Color.DARK_GRAY) { 					// MAGETA�� ���� �����ߴ� �¼�
							seats[k].setBackground(Color.WHITE); 						// �ٽ� �����ϸ� �ٽ� ������� ����� �ٲ���
							select[k] = false;											// ���õ� �¼��� false�� �ٲ��ְ� member�� �ϳ�������Ŵ
							member++;
						}
						else if(member>0 && seats[k].getBackground()!=Color.GREEN){ 	// green�� ������ �ٸ������ ������ �¼�, member�� ���� 0�̾ƴϸ�
							seats[k].setBackground(Color.DARK_GRAY);						// ������ �� �����Ƿ� magenta�� ������ �ٲ��ְ� select�� true������
							select[k] = true;						
							member--;													// ���ڸ� ���������Ƿ� member�� ���ҽ�Ŵ
						}
						seats[k].setOpaque(true);										// �ٲ� ���� ����
					}
				});
				seat.add(seats[k]);														// ���Ͱ��� �ʱ�ȭ�� seats ���� �ϳ��� gridlayout���� ������ panel�� add��
			}
		
		try {
			FileReader fr = new FileReader("ticket.txt");								// ticket.txt �� �о�帲
			BufferedReader br = new BufferedReader(fr);
			String str;
			while((str = br.readLine()) != null) { 										// ���ٴ����� �о�帲
				ticket.add(str); 														// ticket arraylist�� add��Ŵ
				StringTokenizer st = new StringTokenizer(str);							// ���� stringtokenize�� �ڸ�����
				String name = st.nextToken("\t ");										// ���⼭ �ʿ��ѰŴ� ��ȭ�̸� ,�ð� ,�¼�������
				String str2 = st.nextToken("\t ");										// �������� �ʿ�����Ƿ� str2�� ���� �־���
				str2 = st.nextToken("\t ");
				String seats = st.nextToken("\t ");
				String tim = st.nextToken("\t ");
				StringTokenizer st2 = new StringTokenizer(seats,",");					// ���� �¼������� ","�� �����Ұ���
				System.out.println(seats);
				if(movieName.equals(name) && time.equals(tim)) {						// ������ ���� �о�帰 ���������� ���� ������ ������ �´����˻��ؼ� ������
					while(st2.hasMoreTokens()) {
						str2 = st2.nextToken();											// ","�� �ڸ� �¼� ��ȣ�� ������ green���� �ٲ���
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
		
		
		prev.addActionListener(new ActionListener() {									// prev ��ư �̺�Ʈ ������
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				parent.setVisible(true);												// �ٽ� Ƽ�� ����ȭ���� �����ְ�
				Seat.this.dispose();												// �¼� ���� ȭ���� dispose
			}
		});
		next.addActionListener(new ActionListener() {									// next ��ư �̺�Ʈ ������
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(member>0) 
					new MsgBox(new JFrame("") ,null,null,"�¼��� ���� �������ּ���",null, false,null); 		// member�� 0���� ũ�ܰ��� �¼��� ���μ��� ���� �ʾҴٴ� ��
				else {
					String msg = movieName+"\t"+ticketNum+"\t"+price;								// �װԾƴϸ� ���������� �Ʒ��� ���� ������
					String seats = "\t";
					String etc = "��    �� : "+time+"   ��     �� : "+price;
					for(int i=0;i<49;i++) {															// �ش��ϴ� �¼��� ���õǸ� true�̱⶧����
						if(select[i])																// true���� �˻��ϰ� ������ seats�� �߰�����
							seats+=(i+1)+",";
					}
					seats = seats.substring(0, seats.length()-1);									// seats�� ������ ���ڰ� ","�̱⶧���� �װ��� �����ֱ�����
					new MsgBox(new JFrame("") ,"��ȭ �̸� : "+movieName,"���� ��ȣ : "+ticketNum, etc,"��     ��   : "+seats, false,Seat.this); // ������ ������ msgbox�� ���
					msg +=seats+"\t"+time;
					ticket.add(msg);																// ����Ʈ�� ���� �߰���
					try {
						FileWriter fw = new FileWriter("ticket.txt"); 								// ���� ���Ÿ� ������ ticket.txt�� ������
						BufferedWriter bw = new BufferedWriter(fw);									// ���� �����Ѱ͸� �߰��ϰ������ �׷��������Ƿ� ticket�� �ִ� ��� ������ �ٽ� �������									
						for(int i = 0 ; i<ticket.size();i++)										// �ݺ����������� ��� ���������� �ٽ� ������� 									
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
		 
		peopleLabel = new JLabel("�ο�       :     "+people+"��");
		priceLabel = new JLabel("����       :     " +price+"��");
		screen.setBounds(40,50,1100,80);
		screen.setHorizontalAlignment(SwingConstants.CENTER);
		
		prev.setBounds(430, 600, 140, 30);	
		// widget�� ������ǥ����
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
		setResizable(false);				 // ũ�� ���� �Ұ�
		add(panel);		
	}

}
