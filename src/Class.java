import java.awt.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Class extends Myobject{

	Class(int x, int y,  Canvas c){
		super(x, y, c);
		this.setLayout(null);
		myW=100;
		myH=100;
		img = new ImageIcon("res/class.png");
		draw();
		//setup();
	}

	
	 @Override public void paintComponent(Graphics g) {
	        //super.paintComponent(g);  // Ask parent to paint background.
	        g.drawImage( img.getImage(), 0, 0, null);
	        
	    }


	@Override
	void draw() {
		// TODO Auto-generated method stub
		super.draw();
	}
	

	


	
}

