import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import javax.sound.sampled.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javazoom.*;






public class ShowMovieContents extends JFrame {

	 JLabel b1 = null;
	 JLabel b2 = null;
	 JLabel b3 = null;
	 JLabel b4 = null;
	 RoundedButton resulvation = null;
	 JLabel label;
	 JPanel background;
	

	 
	 public ShowMovieContents() {
		 
		 ImageIcon icon;
			icon = new ImageIcon("C:\\Users\\USER\\Desktop\\자바실습대체과제\\Cgv\\movie.jpg");
			background = new JPanel() {
	            public void paintComponent(Graphics g) {
	                // Approach 1: Dispaly image at at full size
	                g.drawImage(icon.getImage(), 0, 0,1200,680,null);
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
			
			setSize(1200,700);
			setTitle("Show Movie Contents");
			Font font = new Font("08서울남산체 B",Font.PLAIN,33);
											// cgv 글자를 red로 바꿔줌
		 
		 
	  background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
	  label = new JLabel("Show the Movie contents");
	  label.setFont(font);		
	  label.setForeground(Color.white);
	  label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 65));
	  label.setAlignmentX(CENTER_ALIGNMENT);
	  
	  b1 = new JLabel("1.악마는 프라다를 입는다");
	  b1.setAlignmentX(CENTER_ALIGNMENT);
	  b1.setFont(font);
	  b1.setForeground(Color.black);
	  b1.setBackground(Color.black);
	  
	  b2 = new JLabel("2.노트북");
	  b2.setFont(font);
	  b2.setAlignmentX(CENTER_ALIGNMENT);
	  b2.setForeground(Color.black);
	  b2.setBackground(Color.black);
	  
	  b3 = new JLabel("3.오만과 편견");
	  b3.setFont(font);
	  b3.setAlignmentX(CENTER_ALIGNMENT);
	  b3.setForeground(Color.black);
	  b3.setBackground(Color.black);
	  
	  b4 = new JLabel("4.위대한 개츠비");
	  b4.setFont(font);
	  b4.setAlignmentX(CENTER_ALIGNMENT);
	  b4.setBackground(Color.black);
	  b4.setForeground(Color.black);
	  
	  resulvation = new RoundedButton("영화예약");
	  resulvation.setFont(font);
	  resulvation.setFont(new Font(label.getFont().getName(), Font.PLAIN, 30));
	  resulvation.setAlignmentX(CENTER_ALIGNMENT);
	  
      background.add(Box.createRigidArea(new Dimension(0, 15)));
	  background.add(label);
      background.add(Box.createRigidArea(new Dimension(0, 140)));
	  background.add(b1);
      background.add(Box.createRigidArea(new Dimension(0, 30)));
	  background.add(b2);
      background.add(Box.createRigidArea(new Dimension(0, 30)));
	  background.add(b3);
      background.add(Box.createRigidArea(new Dimension(0, 30)));
	  background.add(b4);
      background.add(Box.createRigidArea(new Dimension(0, 100)));
      background.add(Box.createRigidArea(new Dimension(0, 10)));
	  background.add(resulvation);
	  
	 


	  resulvation.addActionListener(new ActionListener() { 					
			
			@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ShowMovieContents.this.dispose();
				new Ticketing().show();
			}
		});
	  
	  
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setResizable(false);				 // 크기 조절 불가
	  setVisible(false);
	  add(background);
	 

	  this.addWindowListener(new WindowAdapter() {
	   public void windowClosing(WindowEvent e) {
	    System.exit(0);
	   }}); //창을 닫기 위한 윈도우 어답터
	  
	 
}
}
//	 
//class MidiPlayer
//{
//		 File file;
//		 AudioInputStream audioInputStream = null;
//		 SourceDataLine auline = null;
//		 
//	  MidiPlayer()
//	  {
//		  System.out.println("파일을 입력해주세요");
//	  }
//	  
//	  MidiPlayer(String fileName) {
//	   try 
//	   {
//		   file = new File(fileName);
//	   
//	   } catch (Exception e) {
//	    System.out.println(e);
//	    System.out.print("파일입력오류");
//	   }
//	   
//	   try
//	   {
//		   audioInputStream = AudioSystem.getAudioInputStream(file);
//	   }
//	   catch(UnsupportedAudioFileException e1)
//	   {
//		   e1.printStackTrace();
//		    System.out.println(e1);
//		    System.out.print("Un");
//	   }
//	   catch(IOException e1)
//	   {
//		   e1.printStackTrace();
//		    System.out.println(e1);
//		    System.out.print("IOX");
//	   }
//	  AudioFormat format = audioInputStream.getFormat();
//	  DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
//	  
//	  try 
//	  {
//		  auline = (SourceDataLine) AudioSystem.getLine(info);
//		  auline.open(format);
//	  }
//	  catch(LineUnavailableException e2)
//	  {
//		  e2.printStackTrace();
//	  }
//	  catch(Exception e21)
//	  {
//		  e21.printStackTrace();
//	  }
//	
//	  	auline.start();
//	  	int nBytesRead = 0;
//	  	final int EXTERNAL_BUFFER_SIZE = 524288;
//	  	byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
//	  	
//	  	try
//	  	{
//	  		while(nBytesRead != -1)
//	  		{
//	  			nBytesRead = audioInputStream.read(abData,0,abData.length);
//	  			if(nBytesRead>=0)
//	  			{
//	  				auline.write(abData,0,nBytesRead);
//	  			}
//
//	  		}
//	  	}
//	  	catch(IOException e)
//	  	{
//	  		e.printStackTrace();
//	  	
//	  	}
//	  	finally
//	  	{
//	  		auline.drain();
//	  		auline.close();
//	  	}
//	  }
//	 
//
//
//
//
// }
//
//}



