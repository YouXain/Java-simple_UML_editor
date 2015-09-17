import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Set;

import javax.swing.JPanel;




@SuppressWarnings("serial")
abstract class Shape extends JPanel{
	protected int myX;
	protected int myY;
	protected Canvas canvas;
	//private ImageIcon img = new ImageIcon("res/class.png");
	Shape(int x, int y, Canvas c){
		myX=x;
		myY=y;
		canvas=c;
	}
	abstract void draw();
	abstract Boolean isSelected();
	abstract int getmyX();
	abstract int getmyY();
	abstract void setmyname(String s);
	abstract void setnotSelected();
	abstract Boolean isClicked(int x, int y);
	abstract void myDrag(int x, int y);
	abstract Boolean isChosen(Point p, MouseEvent e);
	abstract int getZorder();
	abstract Shape getGroup();
	abstract Set<Shape> getObjects();
	abstract void markGroup(Shape s);
	abstract void setSelected();
	abstract Port getPort(MouseEvent e);
	abstract void removeGroup();
}