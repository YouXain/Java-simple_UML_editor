import java.awt.Graphics;

import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;





@SuppressWarnings("serial")
public class Port extends JPanel{
	private ImageIcon img = new ImageIcon("res/black.png");
	
	
	
	private boolean isconnected=false;
	private ArrayList<Line> mylines=new ArrayList<Line>();
	private int myX;
	private int myY;
	private JLayeredPane canvas;
	Port(int x, int y, Canvas c){
		myX=x;
		myY=y;
		canvas=c;
		draw();
	}
	
	public int getmyX(){
		return myX;
	}
	public int getmyY(){
		return myY;
	}
	
	public void setLocation(int x, int y){
		myX=x;
		myY=y;
		for(Line a: mylines){
			canvas.moveToFront(a);
		}
	}
	
	
	 @Override public void paintComponent(Graphics g) {
	        super.paintComponent(g);  // Ask parent to paint background.
	        g.drawImage( img.getImage(), 0, 0, null);
	        
	    }

	public void remove() {
		// TODO Auto-generated method stub
		if(!isconnected) this.setBounds(1000, 1000, 10, 10);
	}

	public void addLine(Line a) {
		// TODO Auto-generated method stub
		mylines.add(a);
		this.setBounds(myX, myY, 10, 10);
		setSelected();
	}

	

	void setSelected() {
		// TODO Auto-generated method stub
		 isconnected=true;
	}
	

	void draw() {
		// TODO Auto-generated method stub
		canvas.add(this);
		this.setBounds(myX, myY, 10, 10);
	}


}