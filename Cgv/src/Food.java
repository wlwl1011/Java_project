import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;



public class Food extends JFrame{
	 int count = 0;
	    String show = "";
	
	    public Food()
	    {
	    	setSize(1200, 700);
			Font font = new Font("08���ﳲ��ü B", Font.PLAIN, 33);
			setTitle("Food Reservation");
			JLabel label;
			label = new JLabel("Food   Reservation");
			label.setFont(font);
			label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 65));
			label.setForeground(Color.white);
			label.setAlignmentX(CENTER_ALIGNMENT);
			ImageIcon ico;
			ico = new ImageIcon("C:\\Users\\USER\\Desktop\\�ڹٽǽ���ü����\\Cgv\\background2.jpg");
			
			//������ ������ panel
			JPanel seat = new JPanel(new GridLayout(2, 3));
			
			seat.setBackground(Color.white);
			seat.setOpaque(true);
			seat.setBounds(40,130,1200,500);
			
			JPanel panel = new JPanel() 
			{
	            public void paintComponent(Graphics g) {
	                // Approach 1: Dispaly image at at full size
	                g.drawImage(ico.getImage(), 0, 0, 1200, 700,null);
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
			Font font1 = new Font("08���ﳲ��ü B",Font.PLAIN,17);
			Font font2 = new Font("08���ﳲ��ü B",Font.PLAIN,15);
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			setBackground(Color.black);
			
			//JPanel panel = new JPanel();
			//panel.setBackground(new Color(255,255,215));
			//panel.setLayout(null);
			panel.setSize(1200, 700);
			panel.setFont(font1);
			
			String menu[] = { "����", "�ֵ���", "�ܹ���", "������", "ȸ����", "��  ��" };
	        int price[] = { 5000, 5500, 6000, 6500, 7000, 7500, 3000, 2000 };
	        JButton bt[] = new JButton[menu.length];
	        TextField suja[] = new TextField[menu.length];
	        RoundedButton minus[] = new RoundedButton[menu.length];
	        RoundedButton plus[] = new RoundedButton[menu.length];
	        RoundedButton ok[] = new RoundedButton[menu.length];
	        Label l[] = new Label[menu.length];
	        ImageIcon icon[] = new ImageIcon[menu.length];
	        panel.add(label);
            panel.add(Box.createRigidArea(new Dimension(0, 100)));
	        panel.add(seat);
	        // ��ư ���� �κ�
	        for (int i = 0; i < menu.length; i++) {
	 
	            // �ܹ��� ��ư
	            bt[i] = new JButton();
	               if (i < 4) {
	                bt[i].setBounds(25 + i * 150, 70, 100, 100);
	            } else {
	                bt[i].setBounds(25 + (i - 4) * 150, 360, 100, 100);
	            }
	            //ImageIcon temp;
	    		//temp = new ImageIcon("C:\\Users\\USER\\Desktop\\�ڹٽǽ���ü����\\Cgv\\main.jpg");
	    		
//	    		JPanel background = new JPanel() {
//	                public void paintComponent(Graphics g) {
//	                    // Approach 1: Dispaly image at at full size
//	                    g.drawImage(temp.getImage(), 0, 0, 500,375,null);
//	                    // Approach 2: Scale image to size of component
//	                    // Dimension d = getSize();
//	                    // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
//	                    // Approach 3: Fix the image position in the scroll pane
//	                    // Point p = scrollPane.getViewport().getViewPosition();
//	                    // g.drawImage(icon.getImage(), p.x, p.y, null);
//	                    setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
//	                    super.paintComponent(g);
//	                }
//	            };
//	            
	            ImageIcon tmp_icon = new ImageIcon(i + ".jpg");
	            Image org_icon = tmp_icon.getImage();
	            Image changedImg = org_icon.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	            
	            icon[i] = new ImageIcon(changedImg);

	           // g.drawImage(temp.getImage(), 0, 0, 500,375,null);
	            bt[i].setIcon(icon[i]);
	            bt[i].setMaximumSize (new Dimension(100,100));
	            // ���� txt ��ư
	            suja[i] = new TextField("0");
	            suja[i].setBackground(Color.white);
	            suja[i].setEditable(false);
	            suja[i].setMaximumSize (new Dimension(30,30));
	            // "-" ��ư
	            minus[i] = new RoundedButton("-");
	            minus[i].setMaximumSize (new Dimension(20,20));
	            minus[i].setEnabled(false);
	 
	            // "+" ��ư
	            plus[i] = new RoundedButton("+");
	            plus[i].setMaximumSize (new Dimension(20,20));
	            plus[i].setEnabled(false);
	 
	            // ����
	            l[i] = new Label(price[i] + "��");
	            l[i].setMaximumSize (new Dimension(190,20));
	 
	            // Ȯ�� ��ư
	            ok[i] = new RoundedButton("Ȯ��");
	            ok[i].setMaximumSize (new Dimension(20,20));
	            ok[i].setEnabled(false);
	            
	            panel.add(Box.createRigidArea(new Dimension(0, 40)));

	           	
	            
	            seat.add(bt[i]);
	            seat.add(suja[i]);
	            seat.add(minus[i]);
	            seat.add(plus[i]);
	            seat.add(l[i]);
	            seat.add(ok[i]);
	        }
	 
	        // �߾�
	        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
	        ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");
	        ta.setBackground(Color.white);
	        ta.setEditable(false);
	        ta.setFont(font2);
	 
	 
	        Panel pSouth = new Panel();
	        pSouth.setFont(font1);
	        pSouth.setBackground(new Color(255, 255, 215));
	        
	        RoundedButton bt1 = new RoundedButton("�ֹ�");
	        RoundedButton bt2 = new RoundedButton("�ʱ�ȭ");
	        RoundedButton bt3 = new RoundedButton("�ݱ�");
	        RoundedButton bt4 = new RoundedButton("PREV");
	        pSouth.add(bt1);
	        pSouth.add(bt2);
	        pSouth.add(bt3);
	        pSouth.add(bt4);
	        // �ֹ���ư
	        bt1.addActionListener(new ActionListener() {
	 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JOptionPane.showMessageDialog(null, ta.getText() + " �ֹ��Ǿ����ϴ�. \n�̿����ּż� �����մϴ�.");
	                for (int i = 0; i < menu.length; i++) {
	                    bt[i].setEnabled(true);
	                    minus[i].setEnabled(false);
	                    plus[i].setEnabled(false);
	                    suja[i].setText("0");
	                    ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");
	 
	                }
	            }
	        });
	 
	        // �ʱ�ȭ ��ư
	        bt2.addActionListener(new ActionListener() {
	 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                for (int i = 0; i < menu.length; i++) {
	                    bt[i].setEnabled(true);
	                    minus[i].setEnabled(false);
	                    plus[i].setEnabled(false);
	                    suja[i].setText("0");
	                    ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");
	 
	                }
	            }
	        });
	 
	 
	        //bt3 �ݱ��ư
	        
	        bt3.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);
	            }
	        });
	        
	        bt4.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Food.this.dispose();
					new Contents().show();
				}
	        });
	 
	 
	        // ������Ʈ
	        add(panel, BorderLayout.CENTER);
	        //add(ta, BorderLayout.NORTH);
	        add(pSouth, BorderLayout.SOUTH);
	        setVisible(true);
	 
	        // �̺�Ʈ��
	        for (int i = 0; i < menu.length; i++) {
	            int j = i;
	 
	            // �ܹ��� ��ư �̺�Ʈ
	            bt[i].addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    minus[j].setEnabled(true);
	                    plus[j].setEnabled(true);
	                    bt[j].setEnabled(false);
	                    ok[j].setEnabled(true);
	 
	                    count = 0;
	                }
	            });
	 
	            // "-" ��ư �̺�Ʈ
	            minus[i].addActionListener(new ActionListener() {
	 
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    if (count > 0) {
	                        count = count - 1;
	                        suja[j].setText(count + "");
	                        ok[j].setEnabled(true);
	                    } else {
	                        minus[j].setEnabled(false);
	                    }
	                }
	            });
	            
	            // "+" ��ư �̺�Ʈ
	            plus[i].addActionListener(new ActionListener() {
	 
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    count = count + 1;
	                    suja[j].setText(count + "");
	                    ok[j].setEnabled(true);
	                    if (count > 0) {
	                        minus[j].setEnabled(true);
	                    }
	                }
	            });
	            
	            //Ȯ�� ��ư �̺�Ʈ
	            ok[i].addActionListener(new ActionListener() {
	 
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    show = bt[j].getActionCommand();
	                    ta.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count
	                            + "��" + "\n");
	                    ok[j].setEnabled(false);
	                }
	            });
	 
	        }
	 
	        // ����
	        addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                System.exit(0);
	            }
	        });

	    }
	 // ����
	   



		
	    }






