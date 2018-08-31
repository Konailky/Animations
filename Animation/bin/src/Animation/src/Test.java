import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;


final public class Test {

		JFrame frame;
		DrawPanel drawPanel;
		
		private int facex = 100; // face x starting point	//  oval? or rounded rectangle?
		private int facey = 100; // face y starting point
		
		private int leftEyex = 150; // left eye  // rounded rectangles? or x's? 
		private int leftEyey = 170;
		private int rightEyex = 310; // right eye
		private int rightEyey = 170;
		
		private int tear1x = 170; // left tear x starting point		// ovals?
		private int tear2x = 330; // right tear x starting point
		private int tearx = 0;
		private int teary = 190;
		
		private int mouth1 = 200; // first point of the mouth	// ovals? or half circle?
		private int mouth2 = 315; // second point of the mouth
		

		
		
		
		private int count = 0; // counter for each tear and tear droppings
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new Test().go();
			
		}
		
		public void go() {
			frame = new JFrame("Play");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			drawPanel = new DrawPanel();
			
			frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
			
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setSize(500, 500);
			frame.setLocation(375, 55);
			move();
			
		}
		
		class DrawPanel extends JPanel{
		
			public void paintComponent1(Graphics f) {				
				f.fill3DRect(100, 100, 10, 100, true);
			}
			
			
			public void paintComponent(Graphics g) {
				//Recreating the Rainbow :)
				List<Color> colors = new ArrayList<Color>(); 
				for(int r = 0; r < 100; r++) {
					colors.add(new Color(r*255/100, 255, 0));}
				for( int gre = 100; gre > 0; gre--) {
					colors.add(new Color(255, gre*255/100, 0));}
				for(int b = 0; b < 100; b++) {
					colors.add(new Color(255, 0, b*255/100));}
				for( int r = 100; r > 0; r--) {
					colors.add(new Color(r*255/100, 0, 255));}
				for( int gre = 0; gre < 100; gre++) {
					colors.add(new Color(0, gre*255/100, 255));}
				for( int b = 100; b > 0; b--) {
					colors.add(new Color(0, 255, b*255/100));
					colors.add(new Color(0, 255, 0));}
				
				//white border
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, this.getHeight(), this.getWidth() );
				// black border
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, this.getHeight(), this.getWidth() );
				// inside color
				if(count % 3 == 0) {
					int ran = (int) (Math.random()*255) + 1;
					g.setColor(colors.get(ran));
					g.fillRect(0, 0, this.getHeight(), this.getWidth());}
				
				//Face 
				g.setColor(new Color(210,180,140) );
				g.fillRoundRect(facex, facey, 300, 300, 100, 100);
									
				//Eye shapes
				g.setColor(Color.WHITE);
				g.fillRoundRect(rightEyex, rightEyey, 50, 50, 30, 30);
				g.fillRoundRect(leftEyex, leftEyey, 50, 50, 30, 30);
					
				//Pupils outline
				g.setColor(Color.BLACK);
				g.drawArc(rightEyex, rightEyey, 50, 50, 60, 340);
				g.drawArc(leftEyex, leftEyey, 50, 50, 60, 340);
				
				//Mouth
				if (count % 3 == 0) {
				g.setColor(Color.WHITE);
				g.fillArc(mouth1,  mouth2, 100, 50, 0, 180);
								
				}
				else {
					g.setColor(Color.WHITE);
					g.fillArc(mouth1,  mouth2,  100,  50, 180, 180);
				}
				//Hair
				if (count % 3 == 0) {
					int ran = (int)(Math.random()*255) + 1;
							g.setColor(new Color(ran));
							for(int range = 150; range < 350; range++) {
									g.drawLine(range, 100,  range ,  50);
									g.drawLine(range, 100, range , 50);
				}
				
				}
				// Counter and tears
			
				if (checkCount()) {
				tearx = tear1x;	
				//Left Pupil 
				g.setColor(Color.BLUE);
				g.fillArc(leftEyex, leftEyey, 50, 50, 60, 340);

				}
				else {
					tearx = tear2x;
					//Right Pupils 
					g.setColor(Color.BLUE);
					g.fillArc(rightEyex, rightEyey, 50, 50, 60, 340);
		
				}
				g.setColor(Color.BLUE);
				g.fillOval(tearx, teary, 20, 50);
			}
			
							
			
		}
		
		
		public void move() {
			
			while(true) {
				moveLoc();
				try {
					Thread.sleep(10);	
				} catch (Exception exc ) {}
				frame.repaint();
				
			}
		}
			
		
		
		public boolean checkCount(){
			if (count % 2 == 0) {
				return true; 				
			}
		else{
			return false;
		}
				
		}
		
		public void moveLoc() {
			
				teary += 4;
				if (teary >= 500 ) {
					teary = 190;
					count ++;
				}
					
		}
		
		
	
}
