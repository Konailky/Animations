import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;


final public class Test {

		JFrame frame;
		DrawPanel drawPanel;
		
		private int facex = 100; // face x starting point	//  oval? or rounded rectangle?
		private int facey = 100; // face y starting point
		
		private int leftEyex = 200; // left eye  // rounded rectangles? or x's? 
		private int leftEyey = 150;
		private int rightEyex = 400; // right eye
		private int rightEyey = 150;
		
		private int tear1x = 205; // left tear x starting point		// ovals?
		private int tear1y = 205; // left tear y starting point
		private int tear2x = 405; // right tear x starting point
		private int tear2y = 405; // right tear y starting point
		private int tear = 0;     // actual position of the tear relating to the counter
		
		private int mouth1 = 100; // first point of the mouth	// ovals? or half circle?
		private int mouth2 = 150; // second point of the mouth
		
		
		
		boolean down = true;
		
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
				//white border
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, this.getHeight(), this.getWidth() );
				// black border
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, this.getHeight(), this.getWidth() );
				// inside color
				g.setColor(Color.GRAY);
				g.fillRect(0, 0, this.getHeight(), this.getWidth());
				
				//Face 
				g.setColor(new Color(210,180,140) );
				g.fillRoundRect(facex, facey, 300, 300, 50, 50);
				
				//Eye shapes
				g.setColor(Color.WHITE);
				g.fillRoundRect(rightEyex, rightEyey, 50, 50, 30, 30);
				g.fillRoundRect(leftEyex, leftEyey, 50, 50, 30, 30);
				//Pupils
				g.setColor(Color.RED);
				g.drawLine(rightEyex, rightEyey, rightEyex + 50, rightEyey + 50);
				g.drawLine(leftEyex, leftEyey, leftEyex + 50, leftEyey + 50);
				//Pupils outline
				//g.setColor(Color.BLACK);
				//g.drawArc(rightEyex, rightEyey, 50, 50, 60, 340);
				//g.drawArc(leftEyex, leftEyey, 50, 50, 60, 340);
				
				//Mouth
				
				
				//Hair
				g.setColor(Color.BLACK);  	//Draw some lines as hair 
				
				
				
				
				
				
				// Counter and tears
				g.setColor(Color.BLUE);
				if (count % 2 == 0) {
					g.
				}
			
			}
			
			
			
			
			
			
		}
		
		
		public void move() {
			
			while(true) {
				checkBounds();
				moveLoc();
				try {
					Thread.sleep(10);	
				} catch (Exception exc ) {}
				frame.repaint();
				
			}
			
		}
		
		public void checkBounds(){
			if (count % 2 == 0) {
				int ran = (int) Math.random() ;  
				
			}
				
		}
		
		public void moveLoc() {
			if(down) {
				tear += 1;
			}
			
		}
		
	
}
