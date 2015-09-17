import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;



@SuppressWarnings("serial")
public class AssoLine extends Line{
	//private ImageIcon img = new ImageIcon("res/association.png");
	
	AssoLine(int x, int y, Canvas c,Port p1, Port p2){
		super(x, y, c, p1, p2);
		
	}
	 @Override public void paintComponent(Graphics g) {
	        //super.paintComponent(g);  // Ask parent to paint background.
	       
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
	        g2d.drawLine(myp1.getmyX(), myp1.getmyY(), myp2.getmyX(), myp2.getmyY());
	       
	    }
	 
	 
}