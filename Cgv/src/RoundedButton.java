import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton { 
	public Graphics2D graphics;
	public static int temp=0;
	
	public RoundedButton() 
	{ 
		super(); 
		decorate();
	}
	
	public RoundedButton(String text) 
	{ 
		super(text);
		decorate();
	}
	
	public RoundedButton(Action action) 
	{ 
		super(action);
		decorate();
	}
	
	public RoundedButton(Icon icon) 
	{ 
		super(icon);
		decorate();
	} 
	public RoundedButton(String text, Icon icon) 
	{ 
		super(text, icon); 
		decorate();
	}
	public void decorate() 
	{ 
		setBorderPainted(false); 
		setOpaque(false);
	}

	public void paintComponent(Graphics g) 
	{ 
		int width = getWidth(); 
		int height = getHeight(); 
		graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (getModel().isArmed()) 
		{
		
			graphics.setColor(getBackground().darker()); 
		} 
		else if (getModel().isRollover()) 
		{ 
			graphics.setColor(getBackground().brighter()); 
		} 
		else 
		{ 
			graphics.setColor(getBackground());
		} 
		
		
		graphics.fillRoundRect(0, 0, width, height, 10, 10);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY); 
		graphics.dispose(); 
		super.paintComponent(g); 
	}

	
}