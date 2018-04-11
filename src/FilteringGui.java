import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.awt.Graphics;

public class FilteringGui extends JFrame
{
	public JButton lpButton, embButton, gaussButton, originalButton, lineDetection, verticalLineDetection, degrees45Detection;
	public JLabel display;
	public ImageIcon icon;
	//Image image;
	//public int screenWidth;
	//public int screenHeight;
	
	
	public FilteringGui()
	{
		setLayout(new FlowLayout());
		
		originalButton = new JButton("Original");
		add(originalButton);
		lpButton=new JButton("Laplace Filter");
		add(lpButton);
		embButton=new JButton("Emboss Filter");
		add(embButton);
		gaussButton=new JButton("Gauss Filter");
		add(gaussButton);
		lineDetection=new JButton("Horizontal Line Detection");
		add(lineDetection);
		verticalLineDetection=new JButton("Vertical Line Detection");
		add(verticalLineDetection);
		degrees45Detection = new JButton("45° Line Detection");
		add(degrees45Detection);
		display = new JLabel("");
		add(display);
		

		icon=new ImageIcon("asd.jpg");
		display.setIcon(icon);
		
		lpButton.addActionListener(new laplaceListener());
		embButton.addActionListener(new embListener());
		gaussButton.addActionListener(new gaussListener());
		originalButton.addActionListener(new originalListener());
		lineDetection.addActionListener(new lineDetListener());
		verticalLineDetection.addActionListener(new verticalDetection());
		degrees45Detection.addActionListener(new degreesListener());
		setSize(1000,700);
		setVisible(true);
		
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paint(g);
		icon.paintIcon(this,g,0,0);
	}
	public class originalListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			icon = new ImageIcon("asd.jpg");
			display.setIcon(icon);
			display.repaint();
		}
	}
	public class laplaceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try {
				Convolution.convertFunction("asd.jpg", "outLaplace.jpg", Filters.laplaceFilter2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			icon = new ImageIcon("outLaplace.jpg");
			display.setIcon(icon);
			display.repaint();
			File img = new File("outLaplace.jpg");
			img.delete();
			
		}
	}
	public class lineDetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try {
				Convolution.convertFunction("asd.jpg", "outLineDet.jpg", Filters.horizontalLineDetection);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			icon = new ImageIcon("outLineDet.jpg");
			display.setIcon(icon);
			display.repaint();
			File img = new File("outLineDet.jpg");
			img.delete();
			
		}
	}
	public class embListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try {
				Convolution.convertFunction("asd.jpg", "outEmb.jpg", Filters.embossFilter);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			icon = new ImageIcon("outEmb.jpg");
			display.setIcon(icon);
			display.repaint();
			File img = new File("outEmb.jpg");
			img.delete();
		}
	}
	public class gaussListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try {
				Convolution.convertFunction("asd.jpg", "outGauss.jpg", Filters.gaussianFilter);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			icon = new ImageIcon("outGauss.jpg");
			display.setIcon(icon);
			display.repaint();
			File img = new File("outGauss.jpg");
			img.delete();
			
		}
	}
	public class degreesListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try {
				Convolution.convertFunction("asd.jpg", "outDegrees.jpg", Filters.degreesFilter);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			icon = new ImageIcon("outDegrees.jpg");
			display.setIcon(icon);
			display.repaint();
			File img = new File("outDegrees.jpg");
			img.delete();
			
		}
	}
	public class verticalDetection implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try {
				Convolution.convertFunction("asd.jpg", "outVertical.jpg", Filters.verticalFilter);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			icon = new ImageIcon("outVertical.jpg");
			display.setIcon(icon);
			display.repaint();
			File img = new File("outVertical.jpg");
			img.delete();
			
		}
	}
	public static void main(String[] args)
	{
		FilteringGui ic=new FilteringGui();
		ic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
//	public void resizeGUI()
//	{
//		if (screenWidth>=1280)
//		setSize(1024,768);
		
//		else if(screenWidth>=1024)
//		setSize(800,600);
		
//		else if(screenWidth>=800)
//		setSize(640,480);
		
//		setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
//	}
	
	
}
