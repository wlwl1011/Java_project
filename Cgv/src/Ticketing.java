

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
	Choice movieName;              //��ȭ���  
	Choice selectTime; 			//�ð�
	Choice adultTicket;	//����
	Choice childTicket;	//�л�

	
	JLabel label,name,time,adult,child;
	RoundedButton next,prev;
	int ticketNum,select;
	public Ticketing()
	{
		setTitle("Ticketing");
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
		setSize( 1200,700);
		setTitle("��ȭ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label = new JLabel("Reservation");
		label.setFont(font);
		name = new JLabel("��ȭ ���� : ");
		time = new JLabel("��ȭ �ð� : ");
		adult = new JLabel("��   �� : ");
		child = new JLabel("û�ҳ� : ");
		
		ticketNum = (int) (Math.random()*99999);						// ���� ��ȣ�� random���� ������
		next = new RoundedButton("NEXT");
		prev = new RoundedButton("PREV");
		
		next.addActionListener(this);									// next �̺�Ʈ ������
		
		prev.addActionListener(new ActionListener() { 					// home ��ư �̺�Ʈ ������ ���� frame�� home �̺�Ʈ �����ʿ� ����
			
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
		
		movieName=new Choice();                // ���̽� ��ü�� �����Ѵ�.
		selectTime=new Choice(); 
		
		selectTime.setFont(font);
		selectTime.add("09:00~11:20(��������)");       // ��ȭ�� ���� �ٸ� �ð�ǥ�� �߰��Ѵ�.
		selectTime.add("11:30~13:50");
		selectTime.add("14:00~16:20");
		selectTime.add("16:30~18:50");
		selectTime.add("19:00~17:20");
		selectTime.add("17:30~19:50");
		selectTime.add("22:00~24:20(�ɾ�����)");
		
		adultTicket=new Choice();			// ����ǥ ���ż��� �Է¹ޱ� ���� �ؽ�Ʈ�ʵ�
		childTicket=new Choice();			// û�ҳ�ǥ ���ż��� �Է¹ޱ� ���� �ؽ�Ʈ�ʵ�
		adultTicket.setFont(font);
		childTicket.setFont(font);
		
		movieName.setFont(font);
		movieName.add("��Ʈ��");     
		movieName.add("�Ǹ��� ����ٸ� �Դ´�");
		movieName.add("������ ������");
		movieName.add("������ ���");
	
		movieName.addItemListener(this);
	
		for(int i=0; i < 11; i++) {                 //�ο��� �ִ� 10��
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
		// ���� ����: BoxLayout.Y_AXIS
        
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
		setResizable(false);				 // ũ�� ���� �Ұ�
		add(background);
		
	}
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int index = movieName.getSelectedIndex();		//ch1�� ���ù�ȣ�� index�� �Է�
		System.out.println(index);
		selectTime.removeAll();
		if(index == 0)							//index�� 0�� ���
		{					
			selectTime.add("09:00~11:20(��������)");//��ȭ������ٸ��ð�ǥ���߰��Ѵ�.
			selectTime.add("11:30~13:50");
			selectTime.add("14:00~16:20");
			selectTime.add("16:30~18:50");
			selectTime.add("19:00~17:20");
			selectTime.add("17:30~19:50");
			selectTime.add("22:00~24:20(�ɾ�����)");
		}
		else if(index==1)
		{					
			selectTime.add("09:10~12:10(��������)");//��ȭ������ٸ��ð�ǥ���߰��Ѵ�.
			selectTime.add("12:20~15:20");
			selectTime.add("15:30~18:30");
			selectTime.add("18:40~21:40");
			selectTime.add("--:--~--:--");
			selectTime.add("--:--~--:--");
			selectTime.add("21:50~24:50(�ɾ�����)");
		}
		else if(index==2)
		{					
			selectTime.add("09:00~10:50(��������)");//��ȭ������ٸ��ð�ǥ���߰��Ѵ�.
			selectTime.add("11:00~12:50");
			selectTime.add("13:00~14:50");
			selectTime.add("15:00~16:50");
			selectTime.add("17:00~18:50");
			selectTime.add("19:00~20:50");
			selectTime.add("--:--~--:--(�ɾ߿�ȭ����)");
		}
		else if(index==3)
		{					
			selectTime.add("--:--~--:--(�������ξ���)");
			selectTime.add("11:00~13:50");//��ȭ������ٸ��ð�ǥ���߰��Ѵ�.
			selectTime.add("14:00~16:50");
			selectTime.add("17:00~19:50");
			selectTime.add("20:00~22:50");
			selectTime.add("--:--~--:--");
			selectTime.add("23:00~25:50(�ɾ�����)");
		}
		else if(index==4)
		{					
			selectTime.add("10:00~12:20(��������)");//��ȭ������ٸ��ð�ǥ���߰��Ѵ�.
			selectTime.add("12:30~14:50");
			selectTime.add("15:00~17:20");
			selectTime.add("19:00~17:20");
			selectTime.add("17:30~19:50");
			selectTime.add("--:--~--:--");
			selectTime.add("22:00~24:20(�ɾ�����)");
		}
		else if(index==5)
		{					
			selectTime.add("--:--~--:--(�������ξ���)");
			selectTime.add("11:00~13:50");//��ȭ������ٸ��ð�ǥ���߰��Ѵ�.
			selectTime.add("14:00~16:50");
			selectTime.add("17:00~19:50");
			selectTime.add("20:00~22:50");
			selectTime.add("--:--~--:--");
			selectTime.add("--:--~--:--(�ɾ߿�ȭ����)");
		}
		select = index;
	}
	public void actionPerformed(ActionEvent e){

		// ��ư�� ���� ���ڿ��� �о�´�.

			int l_nmovie_time = selectTime.getSelectedIndex();		//�� �����ۿ��� index �� ����
			String l_strmovie_time = selectTime.getSelectedItem();
			int l_nadult_ticket = adultTicket.getSelectedIndex();
			int l_nstudent_ticket = childTicket.getSelectedIndex();


			String all ="";
			int l_nadult_price = 9000;					//��ǥ�� ���� ���� ����
			int l_nstudent_price = 8000;
			int l_totalPrice = 0;

			if((l_nadult_ticket == 0 && l_nstudent_ticket == 0) 
				|| l_strmovie_time.equals("--:--~--:-- (���� ���� ����)") 
				|| l_strmovie_time.equals("--:--~--:-- (�ɾ� ��ȭ ����)")
				|| l_strmovie_time.equals("--:--~--:--")
				||l_strmovie_time.equals(null))
			{
				new MsgBox(new JFrame("") ,null,null ,"�ٽ� �ѹ� Ȯ�����ּ���.",null, false,null);
			}
			else
			{
				if(l_nmovie_time == 0 && !l_strmovie_time.equals("--:--~--:-- (���� ���� ����)"))
				{
					l_nadult_price -= 2000;
					l_nstudent_price -= 2000;
				}
				else if(l_nmovie_time == 6 && !l_strmovie_time.equals("--:--~--:-- (�ɾ� ��ȭ ����)"))
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
				//Ticketing.this.setVisible(false); // ���� Ƽ�ϰ��� ȭ���� visivle false�� ���� dispose ���Ѱ��� seatframe���� prev��ư ó���� �����ϱ������� dispose���ָ� ����ڰ� �Է��� ��� ������ ���󰡱� ����
				/*
				 * ���� ������ ��ȭ�� ��� ������ seatFrame�� �Ѱ��� seatFrame���� ��� �¼��� �����ϸ� ��ȭ ���Ű� �Ϸ��
				 */
				Seat seat = new Seat(movieName.getItem(select),l_nadult_ticket+l_nstudent_ticket,l_totalPrice,ticketNum,l_strmovie_time,Ticketing.this);
				seat.show();
				// �¼� ���� ȭ�� show����
				Ticketing.this.dispose();
				Ticketing.this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}}); 
			}
	  }
	
}
