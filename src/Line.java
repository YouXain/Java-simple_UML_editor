

import java.awt.Point;




import java.awt.event.MouseEvent;
import java.util.Set;

@SuppressWarnings("serial")
public abstract class Line extends Shape{
	
	
	protected Port myp1;
	protected Port myp2;
	Line(int x, int y, Canvas c, Port p1, Port p2){
		super(x,y,c);
		myp1=p1;
		myp2=p2;
		
		draw();
		//contain.setComponentZOrder(myL, 0);
	}
	@Override
	void setSelected() {
		// TODO Auto-generated method stub
	}
	
	@Override
	void draw() {
		// TODO Auto-generated method stub
		canvas.add(this,new Integer(50));
		this.setBounds(0, 0, 880, 650);
		this.setOpaque(false);
	}

	@Override
	Boolean isSelected() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void setmyname(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void setnotSelected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	Boolean isClicked(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void myDrag(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	Boolean isChosen(Point p, MouseEvent e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	int getZorder() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	Port getPort(MouseEvent e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	Shape getGroup() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	Set<Shape> getObjects() {
		// TODO Auto-generated method stub
		return  null;
	}
	@Override
	void markGroup(Shape s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	int getmyX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int getmyY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	void removeGroup() {
		// TODO Auto-generated method stub
		
	}
}