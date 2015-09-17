import java.awt.*;

import javax.swing.*;



@SuppressWarnings("serial")
public class Usecase extends Myobject{
	
	Usecase(int x, int y,  Canvas c){
		super(x, y, c);
		this.setLayout(null);
		myW=120;
		myH=80;
		img = new ImageIcon("res/usecase.png");
		draw();

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