import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public abstract class Myobject extends Shape{
	protected int myX;
	protected int myY;
	protected int myH;
	protected int myW;
	protected ImageIcon img;
	protected Canvas canvas;
	protected Port[] myPort = new Port[4];
	protected JLabel myname = new JLabel("untitled");
	protected Myobject myo;
	protected Shape mygroup=null;
	protected Boolean Selected = false;
	Myobject(int x, int y, Canvas c){
		super(x, y, c);
		this.setLayout(null);
		this.myX=x;
		this.myY=y;
		canvas=c;
		myo=this;
		
		
	}
	@Override
	void draw() {
		// TODO Auto-generated method stub
		canvas.add(myo);
		myo.setOpaque(false);
		myo.setBounds(myX, myY, myW, myH);
		canvas.moveToFront(myo);
		myo.add(myname);
		myname.setBounds(myW/2-20, -12+myH/10, 50, 50);
		myname.setOpaque(false);
		setPorts();
		removePorts();
	}
	
	public void setmyname(String name){
		myname.setText(name);
	}
	
	public void setPorts(){
		myPort[0]=new Port(myX+myW/2-5,myY-5,canvas);
		myPort[1]=new Port(myX-5,myY+myH/2-5,canvas);
		myPort[2]=new Port(myX+myW/2-5,myY+myH-5,canvas);
		myPort[3]=new Port(myX+myW-5,myY+myH/2-5,canvas);
		for(int i=0; i<=3 ; i++){
			canvas.moveToFront(myPort[i]);
		}
	}
	
	public void removePorts(){
		 for(int i=0;i<=3;i++)
			 myPort[i].remove();
	}
	public Boolean isClicked(int x, int y){
		if(x<myX+10) return false;
		if(x>myX+myW+10) return false;
		if(y<myY+10) return false;
		if(y>myY+myH+10) return false;
		return true;
	}
	public Boolean isChosen(Point p, MouseEvent e){
		if(Math.min(p.x, e.getX())>myX) return false;
		if(Math.min(p.y, e.getY())>myY) return false;
		if(Math.max(p.x, e.getX())<myX+myW) return false;
		if(Math.max(p.y, e.getY())<myY+myH) return false;
		return true;
	}
	public void setSelected(){
		Selected=true;
		canvas.moveToFront(myo);
		updatePorts();
		
	 }
	
	public int getZorder(){
		return canvas.getComponentZOrder(myo);
	}
	public void setnotSelected(){
		removePorts();
		Selected=false;
	 }
	
	public Boolean isSelected(){
		 return Selected;
		
	 }
	
	public void myDrag(int x, int y){
		canvas.moveToFront(myo);
		myX=x-55;
		myY=y-45;
		myo.setBounds(myX, myY, myW, myH);
		updatePorts();
	 }
	
	
	public void updatePorts(){
		myPort[0].setBounds(myX+myW/2-5,myY-5, 10, 10);
		myPort[0].setLocation(myX+myW/2-5,myY-5);
		myPort[1].setBounds(myX-5,myY+myH/2-5, 10, 10);
		myPort[1].setLocation(myX-5,myY+myH/2-5);
		myPort[2].setBounds(myX+myW/2-5,myY+myH-5, 10, 10);
		myPort[2].setLocation(myX+myW/2-5,myY+myH-5);
		myPort[3].setBounds(myX+myW-5,myY+myH/2-5, 10, 10);
		myPort[3].setLocation(myX+myW-5,myY+myH/2-5);
		for(int i=0; i<=3 ; i++){
			canvas.moveToFront(myPort[i]);
		}
	}
	public Port getPort(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()<myX+myW/2 && e.getY()<myY+myH/2) return myPort[0];
		if(e.getX()<myX+myW/2 && e.getY()>myY+myH/2) return myPort[1];
		if(e.getX()>myX+myW/2 && e.getY()>myY+myH/2) return myPort[2];
		if(e.getX()>myX+myW/2 && e.getY()<myY+myH/2) return myPort[3];
		return null;
	}
	
	@Override
	Shape getGroup() {
		// TODO Auto-generated method stub
		if(mygroup==null) return myo;
		return mygroup.getGroup();
	}
	
	@Override
	Set<Shape> getObjects() {
		// TODO Auto-generated method stub
		return  null;
	}
	
	void markGroup(Shape s){
		mygroup=s;
	}
	@Override
	int getmyX() {
		// TODO Auto-generated method stub
		return myX;
	}

	@Override
	int getmyY() {
		// TODO Auto-generated method stub
		return myY;
	}
	@Override
	void removeGroup() {
		// TODO Auto-generated method stub
		
	}
}