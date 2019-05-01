package gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display {
	
	private DisplayPanel dispPanel;
	
	public Display() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setTitle("GeneticImage");
		dispPanel = new DisplayPanel(null);
		frame.add(dispPanel, BorderLayout.CENTER);
	}
	
	public void displayImage(BufferedImage image) {
		dispPanel.displayImage(image);
		dispPanel.repaint();
	}
	
	private class DisplayPanel extends JPanel{
		private static final long serialVersionUID = 1L;
		private BufferedImage image;
		
		public DisplayPanel(BufferedImage image) {
			this.image = image;
		}
		
		public void displayImage(BufferedImage image) {
			this.image = image;
		}
		
		@Override
		public void paint(Graphics g) {
			if(image != null) {
				g.drawImage(image, 0, 0, null);
			}
		}
	}
}
