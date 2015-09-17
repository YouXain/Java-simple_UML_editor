import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;



@SuppressWarnings("serial")
public class Group extends Shape{
	private Set<Shape> groupObjects = new HashSet<Shape>();
	private boolean Selected= false;
	private Shape mygroup;
	Group(int x, int y ,Canvas c, Set<Shape> s){
		super(x,y,c);
		groupObjects = s;
		for(Shape k: groupObjects){
			k.markGroup(this);
		}
	}

	public boolean iscontained(Shape s){
		if(groupObjects.contains(s)){
			return true;
		}
		return false;
	}
	
	
	@Override
	void setSelected() {
		// TODO Auto-generated method stub
		Selected=true;
		for(Shape s: groupObjects){
			s.setSelected();
		}
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	Boolean isSelected() {
		// TODO Auto-generated method stub
		 return Selected;
		
	}

	@Override
	void setmyname(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void setnotSelected() {
		// TODO Auto-generated method stub
		Selected=false;
		for(Shape s: groupObjects){
			s.setnotSelected();
		}
	}

	@Override
	Boolean isClicked(int x, int y) {
		// TODO Auto-generated method stub
		for(Shape s: groupObjects){
			if(s.isClicked(x, y)) return true;
		}
		return false;
	}

	@Override
	void myDrag(int x, int y) {
		// TODO Auto-generated method stub
		Set<Shape> dragObjects = new HashSet<Shape>();
		for(Shape a: groupObjects){
			if(a.getObjects()!=null){
				dragObjects.addAll(a.getObjects());
			}
			else
				dragObjects.add(a);
		}
		for(Shape s: dragObjects){
			if(s.isClicked(x, y)){
				for(Shape s1: dragObjects){
					if(s1.equals(s)) continue;
					//if(s1.getObjects()==null)
					s1.myDrag(s1.getmyX()-s.getmyX()+x, s1.getmyY()-s.getmyY()+y);
				}
				s.myDrag(x, y);
				break;
			}
		  }
	}

	@Override
	Boolean isChosen(Point p, MouseEvent e) {
		// TODO Auto-generated method stub
		for(Shape s: groupObjects){
			if(s.isChosen(p, e)){
				//System.err.print(""+p.x+p.y);
				return true;
			}
		}
		return false;
	}

	@Override
	int getZorder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	Port getPort(MouseEvent e) {
		// TODO Auto-generated method stub
		for(Shape s: groupObjects){
			if(s.isClicked(e.getX(), e.getY())) return s.getPort(e);
		}
		return null;
	}

	@Override
	Shape getGroup() {
		// TODO Auto-generated method stub
		if(mygroup==null) return this;
		return mygroup.getGroup();
	}
	
	@Override
	Set<Shape> getObjects() {
		// TODO Auto-generated method stub
		Set<Shape> temp = new HashSet<Shape>();
		for(Shape s: groupObjects){
			if(s.getObjects()==null){
				temp.add(s);
			}
			else{
				temp.addAll(s.getObjects());
			}
		}
		return  temp;
	}
	
	void markGroup(Shape s){
		mygroup=s;
	}
	
	@Override
	void removeGroup() {
		// TODO Auto-generated method stub
		
		for(Shape k: groupObjects){
			k.markGroup(null);
			k.setnotSelected();
		}
		groupObjects.removeAll(groupObjects);
		canvas.removeShape(this);
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
}