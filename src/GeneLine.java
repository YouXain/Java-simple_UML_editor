import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class GeneLine extends Line{
	//private ImageIcon img = new ImageIcon("res/association.png");
	GeneLine(int x, int y, Canvas c,Port p1, Port p2){
		super(x, y, c, p1, p2);
		
	}
	
	 @Override public void paintComponent(Graphics g) {
	        //super.paintComponent(g);  // Ask parent to paint background.
	       
	        Graphics2D g2d = (Graphics2D) g;
	        
	        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
	        g2d.drawLine(myp1.getmyX(), myp1.getmyY()+15, myp2.getmyX(), myp2.getmyY());
	        int x[]={myp1.getmyX()+2,myp1.getmyX()-6,myp1.getmyX()+6};
	        int y[]={myp1.getmyY()+7,myp1.getmyY()+15,myp1.getmyY()+15};
	        g.drawPolygon(x, y, 3);
	        //drawArrow(g,myX2,myY2,myX1,myY1);
	    }

	
}