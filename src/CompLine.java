import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;



@SuppressWarnings("serial")
public class CompLine extends Line{
	//private ImageIcon img = new ImageIcon("res/association.png");
	
	CompLine(int x, int y, Canvas c,Port p1, Port p2){
		super(x, y, c, p1, p2);
		
	}
	 @Override public void paintComponent(Graphics g) {
	        //super.paintComponent(g);  // Ask parent to paint background.
	       
	        Graphics2D g2d = (Graphics2D) g;
	        
	        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
	        g2d.drawLine(myp1.getmyX()-16, myp1.getmyY(), myp2.getmyX(), myp2.getmyY());
	        int x[]={myp1.getmyX(),myp1.getmyX()-8,myp1.getmyX()-16,myp1.getmyX()-8};
	        int y[]={myp1.getmyY(),myp1.getmyY()-8,myp1.getmyY(),myp1.getmyY()+8};
	        g.drawPolygon(x, y, 4);
	        
	    }
	
	
}