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
			Font font = new Font("08서울남산체 B", Font.PLAIN, 33);
			setTitle("Food Reservation");
			JLabel label;
			label = new JLabel("Food   Reservation");
			label.setFont(font);
			label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 65));
			label.setForeground(Color.white);
			label.setAlignmentX(CENTER_ALIGNMENT);
			ImageIcon ico;
			ico = new ImageIcon("C:\\Users\\USER\\Desktop\\자바실습대체과제\\Cgv\\background2.jpg");
			
			//음식을 정력할 panel
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
	                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	                super.paintComponent(g);
	            }
	        };
			Font font1 = new Font("08서울남산체 B",Font.PLAIN,17);
			Font font2 = new Font("08서울남산체 B",Font.PLAIN,15);
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			setBackground(Color.black);
			
			//JPanel panel = new JPanel();
			//panel.setBackground(new Color(255,255,215));
			//panel.setLayout(null);
			panel.setSize(1200, 700);
			panel.setFont(font1);
			
			String menu[] = { "팝콘", "핫도그", "햄버거", "찡오랑", "회오리", "콜  라" };
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
	        // 버튼 설정 부분
	        for (int i = 0; i < menu.length; i++) {
	 
	            // 햄버거 버튼
	            bt[i] = new JButton();
	               if (i < 4) {
	                bt[i].setBounds(25 + i * 150, 70, 100, 100);
	            } else {
	                bt[i].setBounds(25 + (i - 4) * 150, 360, 100, 100);
	            }
	            //ImageIcon temp;
	    		//temp = new ImageIcon("C:\\Users\\USER\\Desktop\\자바실습대체과제\\Cgv\\main.jpg");
	    		
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
//	                    setOpaque(false); //그림을 표시하게 설정,투명하게 조절
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
	            // 숫자 txt 버튼
	            suja[i] = new TextField("0");
	            suja[i].setBackground(Color.white);
	            suja[i].setEditable(false);
	            suja[i].setMaximumSize (new Dimension(30,30));
	            // "-" 버튼
	            minus[i] = new RoundedButton("-");
	            minus[i].setMaximumSize (new Dimension(20,20));
	            minus[i].setEnabled(false);
	 
	            // "+" 버튼
	            plus[i] = new RoundedButton("+");
	            plus[i].setMaximumSize (new Dimension(20,20));
	            plus[i].setEnabled(false);
	 
	            // 가격
	            l[i] = new Label(price[i] + "원");
	            l[i].setMaximumSize (new Dimension(190,20));
	 
	            // 확인 버튼
	            ok[i] = new RoundedButton("확인");
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
	 
	        // 중앙
	        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
	        ta.setText("   상품명        단가        수량        합계\n\n");
	        ta.setBackground(Color.white);
	        ta.setEditable(false);
	        ta.setFont(font2);
	 
	 
	        Panel pSouth = new Panel();
	        pSouth.setFont(font1);
	        pSouth.setBackground(new Color(255, 255, 215));
	        
	        RoundedButton bt1 = new RoundedButton("주문");
	        RoundedButton bt2 = new RoundedButton("초기화");
	        RoundedButton bt3 = new RoundedButton("닫기");
	        RoundedButton bt4 = new RoundedButton("PREV");
	        pSouth.add(bt1);
	        pSouth.add(bt2);
	        pSouth.add(bt3);
	        pSouth.add(bt4);
	        // 주문버튼
	        bt1.addActionListener(new ActionListener() {
	 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JOptionPane.showMessageDialog(null, ta.getText() + " 주문되었습니다. \n이용해주셔서 감사합니다.");
	                for (int i = 0; i < menu.length; i++) {
	                    bt[i].setEnabled(true);
	                    minus[i].setEnabled(false);
	                    plus[i].setEnabled(false);
	                    suja[i].setText("0");
	                    ta.setText("   상품명        단가        수량        합계\n\n");
	 
	                }
	            }
	        });
	 
	        // 초기화 버튼
	        bt2.addActionListener(new ActionListener() {
	 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                for (int i = 0; i < menu.length; i++) {
	                    bt[i].setEnabled(true);
	                    minus[i].setEnabled(false);
	                    plus[i].setEnabled(false);
	                    suja[i].setText("0");
	                    ta.setText("   상품명        단가        수량        합계\n\n");
	 
	                }
	            }
	        });
	 
	 
	        //bt3 닫기버튼
	        
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
	 
	 
	        // 컴포넌트
	        add(panel, BorderLayout.CENTER);
	        //add(ta, BorderLayout.NORTH);
	        add(pSouth, BorderLayout.SOUTH);
	        setVisible(true);
	 
	        // 이벤트단
	        for (int i = 0; i < menu.length; i++) {
	            int j = i;
	 
	            // 햄버그 버튼 이벤트
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
	 
	            // "-" 버튼 이벤트
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
	            
	            // "+" 버튼 이벤트
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
	            
	            //확인 버튼 이벤트
	            ok[i].addActionListener(new ActionListener() {
	 
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    show = bt[j].getActionCommand();
	                    ta.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count
	                            + "원" + "\n");
	                    ok[j].setEnabled(false);
	                }
	            });
	 
	        }
	 
	        // 끄기
	        addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                System.exit(0);
	            }
	        });

	    }
	 // 메인
	   



		
	    }






