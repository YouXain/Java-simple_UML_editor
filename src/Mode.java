import java.awt.event.MouseEvent;
import java.util.ArrayList;



import java.awt.Point;
class Mode{
	private Modetype mytype;

	ArrayList<Myobject> myobjects;
	public Mode(){
		
	}
	public Mode getMode(){
		return this;
	}
	public void setMode(int arg){
		if(arg==1) mytype=new selectMode();
		if(arg==2) mytype=new associMode();
		if(arg==3) mytype=new generalMode();
		if(arg==4) mytype=new composiMode();
		if(arg==5) mytype=new classMode();
		if(arg==6) mytype=new usecaseMode();
	}
	public void Modeclick(MouseEvent e, Canvas c){
		//myobjects =canvas.getMyobject();
		if(mytype!=null) mytype.mouseClicked(e,c);
	}
	public void Modepress(MouseEvent e, Canvas c){
		//myobjects =canvas.getMyobject();
		if(mytype!=null) mytype.mousePressed(e,c);
	}
	public void Moderelease(MouseEvent e, Canvas c){
		//myobjects =canvas.getMyobject();
		if(mytype!=null) mytype.mouseReleased(e,c);
	}
	public void Modedrag(MouseEvent e, Canvas c){
		//myobjects =canvas.getMyobject();
		if(mytype!=null) mytype.mouseDragged(e,c);
	}
}


abstract class Modetype {
	Modetype(){}
	abstract public void mouseClicked(MouseEvent e, Canvas c);
	abstract public void mousePressed(MouseEvent e, Canvas c);
	abstract public void mouseReleased(MouseEvent e, Canvas c);
	abstract public void mouseDragged(MouseEvent e, Canvas c);
}

class classMode extends Modetype{

	public void mouseClicked(MouseEvent e,Canvas c) {
		// TODO Auto-generated method stub
		
		c.Addshape(new Class(e.getX(),e.getY(),c));
	}

	@Override
	public void mousePressed(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		
	}

}

class usecaseMode extends Modetype{

	public void mouseClicked(MouseEvent e,Canvas c) {
		// TODO Auto-generated method stub
		
		c.Addshape(new Usecase(e.getX(),e.getY(),c));
	}

	@Override
	public void mousePressed(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		
	}

}

class selectMode extends Modetype{
	int pressX=0;
	int pressY=0;
	Shape temp;
	public void mouseClicked(MouseEvent e,Canvas c) {
		// TODO Auto-generated method stub
		temp=null;
		for(Shape s : c.getshapes()){
			s.setnotSelected();	
			if(s.isClicked(e.getX(), e.getY()) && temp==null)
			{
				temp=s;
				continue;
			}
			else if(s.isClicked(e.getX(), e.getY()) && temp!=null){
				if(s.getZorder()<temp.getZorder())temp=s;
			}
		}
		if(temp!=null){
			temp.getGroup().setSelected();
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		temp=null;
		for(Shape s : c.getshapes()){
			s.setnotSelected();	
			if(s.isClicked(e.getX(), e.getY()) && temp==null)
			{
				temp=s;
				
				continue;
			}
			else if(s.isClicked(e.getX(), e.getY()) && temp!=null){
				if(s.getZorder()<temp.getZorder())temp=s;
			}
			
		}
		if(temp!=null){
			temp.getGroup().setSelected();
		}
		if(temp==null){
			pressX=e.getX();
			pressY=e.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		if(pressX>0 && pressY>0){
			for(Shape s : c.getshapes()){
				if(s.isChosen(new Point(pressX, pressY), e))
					s.getGroup().setSelected();	
			}
		}
		pressX=0;
		pressY=0;
	}

	@Override
	public void mouseDragged(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		for(Shape s : c.getshapes()){
			if(s.isSelected()){
				s.getGroup().myDrag(e.getX(), e.getY());
				
			}
		}
	}

}
class associMode extends Modetype{
	Shape temp=null;
	MouseEvent tempe=null;
	public void mouseClicked(MouseEvent e,Canvas c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		for(Shape s : c.getshapes()){
			if(s.isClicked(e.getX(), e.getY()))
			{
				temp=s;
				tempe=e;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		if(temp!=null){
			for(Shape s : c.getshapes()){
				if(s.equals(temp)) continue;
				if(s.isClicked(e.getX(), e.getY()))
				{
					Line l=new AssoLine(e.getX(), e.getY(), c, temp.getPort(tempe), s.getPort(e));
					temp.getPort(tempe).addLine(l);
					s.getPort(e).addLine(l);
				}
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		
	}
}
class generalMode extends Modetype{
	Shape temp=null;
	MouseEvent tempe=null;
	public void mouseClicked(MouseEvent e,Canvas c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		for(Shape s : c.getshapes()){
			if(s.isClicked(e.getX(), e.getY()))
			{
				temp=s;
				tempe=e;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		if(temp!=null){
			for(Shape s : c.getshapes()){
				if(s.equals(temp)) continue;
				if(s.isClicked(e.getX(), e.getY()))
				{
					Line l=new GeneLine(e.getX(), e.getY(), c, temp.getPort(tempe), s.getPort(e));
					temp.getPort(tempe).addLine(l);
					s.getPort(e).addLine(l);
				}
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		
	}
}
class composiMode extends Modetype{
	Shape temp=null;
	MouseEvent tempe=null;
	public void mouseClicked(MouseEvent e,Canvas c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		for(Shape s : c.getshapes()){
			if(s.isClicked(e.getX(), e.getY()))
			{
				temp=s;
				tempe=e;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		if(temp!=null){
			for(Shape s : c.getshapes()){
				if(s.equals(temp)) continue;
				if(s.isClicked(e.getX(), e.getY()))
				{
					Line l=new CompLine(e.getX(), e.getY(), c, temp.getPort(tempe), s.getPort(e));
					temp.getPort(tempe).addLine(l);
					s.getPort(e).addLine(l);
				}
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e, Canvas c) {
		// TODO Auto-generated method stub
		
	}
}