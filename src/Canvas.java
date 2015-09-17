import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLayeredPane;





@SuppressWarnings("serial")
public class Canvas extends JLayeredPane{
	private Canvasadapter myadapter=new Canvasadapter();
	private Mode mode;
	private Canvas myc;
	ArrayList<Shape> shapes=new ArrayList<Shape>();
	Canvas(){
		this.setLayout(null);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setBounds(100,10,880,650);
        this.addMouseListener(myadapter);
        this.addMouseMotionListener(myadapter);
        myc=this;
       
	}

	public void setMode(Mode m){
		mode=m;
	}
	
	public void Addshape(Shape s){
		shapes.add(s);
	}
	
	public ArrayList<Shape> getshapes(){
		return shapes;
	}
	
	
	public void removeShape(Shape s){
		shapes.remove(s);
	}
	
	private class Canvasadapter extends MouseAdapter{
	
    // Override here all the methods you need
	@Override 
	public void mouseClicked(MouseEvent e) {
		mode.Modeclick(e, myc);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		mode.Modepress(e, myc);
    }
	@Override
    public void mouseReleased(MouseEvent e) {
		mode.Moderelease(e, myc);
    }
	@Override
    public void mouseDragged(MouseEvent e) {
		mode.Modedrag(e, myc);
    }
	}
}