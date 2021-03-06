import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

final public class Animate {

    JFrame frame;
    DrawPanel drawPanel;

    private int oneX = 200; // Starting X coordinate
    private int oneY = 200; // Starting Y coordinate

    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;
    
	

    public static void main(String[] args) {
        new Animate().go();
    }

    private void go() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(500, 600);
        frame.setLocation(375, 55);
        moveDot();
    }

    class DrawPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3030379568821478211L;
		
		public void paintComponent1(Graphics f) {
			f.fill3DRect(oneX +100, oneY-50, 10,100,true);
		}
		
		public void paintComponent(Graphics g) {
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
					
					
					
					
					
			
        	//White Border
            g.setColor(colors.get(230));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            //Black Border
            g.setColor(colors.get(1));
            g.fillRect(3, 3, this.getWidth()-6, this.getHeight()-6);
            //Inside Color
            g.setColor(colors.get(255));
            g.fillRect(6, 6, this.getWidth()-12, this.getHeight()-12);
            
            //Dot
            g.setColor(new Color (255,255,255));
            //g.drawLine(200, 200, 0, 50 );
           
            //g.drawRoundRect(200, 200, 200, 100, 50, 50);
           // g.fillArc(oneX, oneY, 300, 300 , 50, 300); // This is the dot
            //g.fillRect(oneX + 2, oneY - 2, 80, 10);
            //g.fillRect(oneX - 2, oneY + 2, 10, 2);
            
        	//Face 
			g.setColor(new Color(210,180,140) );
			g.fillRoundRect(120, 100, 300, 300, 50, 50);
			
			//Eye shapes
			g.setColor(Color.WHITE);
			g.fillRoundRect(200, 200, 50, 50, 30, 30);
			g.fillRoundRect(300, 200, 50, 50, 30, 30);
			//Pupils
			g.setColor(colors.get(25));
			g.fillArc(200, 200, 50, 50, 60, 340);
			g.fillArc(300, 200, 50, 50, 60, 304);				
			//Pupils outline
			g.setColor(Color.BLACK);
			g.drawArc(200, 200, 50, 50, 60, 340);
			g.drawArc(300, 200, 50, 50, 60, 340);
			
			//Mouth
			g.setColor(Color.WHITE);
			g.fillArc(200,  300, 100, 50, 0, 180);

        }
    }

    private void moveDot() {
        while(true){
            checkBounds();
            moveLoc();
            try{
                Thread.sleep(10);
            } catch (Exception exc){}
            frame.repaint();
        }
    }
    private void moveLoc(){
    	if(up){
            oneY-=5;
        }
        if(down){
            oneY+=5;
        }
        if(left){
            oneX-=5;
        }
        if(right){
            oneX+=5;
        }	
    }
    private void checkBounds(){
    	if(oneX >= 200){
            right = false;
            left = true;
        }
        if(oneX <= 7){
            right = true;
            left = false;
        }
        if(oneY >= 270){
            up = true;
            down = false;
        }
        if(oneY <= 7){
            up = false;
            down = true;
        }	
    }
}