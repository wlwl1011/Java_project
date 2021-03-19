

import java.awt.*;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MsgBox extends Dialog implements ActionListener 	//���̾�α׷� ��ӹ��� �޽��� �ڽ��� ���Ǹ����ʸ� �߰��ϴ� Ŭ����
{
	JLabel label,MovieName,TicketNum,Seats;
	JPanel background;
	boolean id = false;				//id���� �������� ����
	RoundedButton ok,can;					//��ư
	JFrame parent;
	MsgBox(JFrame frame, String movieName,String ticketNum,String msg,String seats, boolean okcan,JFrame parent)
	{
		super(frame, "Message", true);		//Message�� ������ ����
		this.parent = parent;
		ImageIcon icon;
		icon = new ImageIcon("C:\\Users\\USER\\Desktop\\�ڹٽǽ���ü����\\Cgv\\background.jpg");
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(icon.getImage(), 0, 0, 1000,800,null);
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
		Font font = new Font("08���ﳲ��ü B",Font.PLAIN,15);
		
		background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
		
		MovieName = new JLabel(movieName);
		TicketNum = new JLabel(ticketNum);
		Seats = new JLabel(seats);
		
		MovieName.setFont(font);
		TicketNum.setFont(font);
		Seats.setFont(font);
		
		MovieName.setForeground(Color.white);
		TicketNum.setForeground(Color.white);
		Seats.setForeground(Color.white);
		
		MovieName.setBackground(Color.darkGray);
		TicketNum.setBackground(Color.darkGray);
		Seats.setBackground(Color.darkGray);
		
		MovieName.setOpaque(true);	
		TicketNum.setOpaque(true);	
		Seats.setOpaque(true);	
		
		MovieName.setAlignmentX(CENTER_ALIGNMENT);
		TicketNum.setAlignmentX(CENTER_ALIGNMENT);
		Seats.setAlignmentX(CENTER_ALIGNMENT);
		
		background.add(Box.createRigidArea(new Dimension(0, 20)));
		if(movieName!=null) background.add(MovieName);
		background.add(Box.createRigidArea(new Dimension(0, 20)));
		if(ticketNum!=null) background.add(TicketNum);
		background.add(Box.createRigidArea(new Dimension(0, 20)));
		if(seats!=null) background.add(Seats);
		
		label = new JLabel(msg);
		label.setFont(font);
		label.setForeground(Color.white);
		
		label.setAlignmentX(CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0, 30)));
		label.setBackground(Color.darkGray);
		label.setOpaque(true);	
		background.add(label);
		background.add(Box.createRigidArea(new Dimension(0, 20)));
		add(background);
		addOKCancelPanel(okcan);
		createFrame();						//������ ����
		pack();
		setVisible(true);
	}

	void addOKCancelPanel( boolean okcan ) 
	{
		createOKButton( background );				//��ư ����
		if (okcan == true)
			createCancelButton( background );
		add(background);
	}

	void createOKButton(JPanel p) 
	{
		p.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
		p.setAlignmentX(CENTER_ALIGNMENT);
		p.add(ok = new RoundedButton("OK"));		//�ʱ�ȭ�� ������ ����
		p.add(Box.createRigidArea(new Dimension(0, 30)));

		ok.addActionListener(this); 
	}

	void createCancelButton(JPanel p) 
	{
		p.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
		p.setAlignmentX(CENTER_ALIGNMENT);
		
		p.add(can = new RoundedButton("Cancel"));
		p.add(Box.createRigidArea(new Dimension(0, 30)));

		can.addActionListener(this);
	}

	void createFrame() 
	{
		Dimension d = getToolkit().getScreenSize();		//������ ������ ����
		setLocation(d.width/3,d.height/3);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == ok) 					//��ư Ŭ���� ���� �׼� ����
		{
			id = true;
			if(parent!=null) parent.dispose();
			
			new TheEnd().show();
			setVisible(false);
		}
		else if(ae.getSource() == can) 
		{
		
			setVisible(false);
		}
	}
}






