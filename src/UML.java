import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class UML extends JFrame{
	private Canvas mycanvas= new Canvas();
	private JMenuBar jmb;
    private JMenu file = new JMenu("File"),edit = new JMenu("Edit");;
    private JMenuItem [] file_item = new JMenuItem[3];//選單1
    private JMenuItem [] edit_item = new JMenuItem[3];//選單2
    private JButton[] btns = new JButton[6];
    private Mode mode= new Mode();
	UML(){
		
		init();
		initMenu();
		initButton();
		
	}

	private void initMenu() {
		// TODO Auto-generated method stub
		jmb = new JMenuBar();
        this.setJMenuBar(jmb); //加入工具列
        //遊戲的選擇項目
        jmb.add(file);
        file_item[0] = new JMenuItem("1");
        file_item[1] = new JMenuItem("2");
        file.add(file_item[0]);
        file.add(file_item[1]);
        //關於的選擇項目
        jmb.add(edit);
        edit_item[0] = new JMenuItem("change object name");
        edit_item[1] = new JMenuItem("group");
        edit_item[2] = new JMenuItem("ungroup");
        edit_item[0].addActionListener(changename);
        edit_item[1].addActionListener(groupclick);
        edit_item[2].addActionListener(ungroupclick);
        edit.add(edit_item[0]);
        edit.add(edit_item[1]);
        edit.add(edit_item[2]);

	}

	private void init() {
		// TODO Auto-generated method stub
		this.setLayout(null);
		this.add(mycanvas);
		this.setSize(1000,700);
        this.setLocation(50,10); 
        this.setResizable(false);//視窗放大按鈕無效 
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mycanvas.setMode(mode);
	}
	
	private void initButton() {
		// TODO Auto-generated method stub
    	int totaly=5;
        for(int i=0;i<=5;i++)
        {
           
            	
                btns[i]=new JButton();
                Icon imgicon = new ImageIcon("res/"+String.valueOf(i+1)+".png");
                btns[i].setIcon(imgicon);
                btns[i].addActionListener(myclick);
                this.add(btns[i]);
                btns[i].setBounds(10, totaly, 50, 50);
                totaly=totaly+65;

        }
	}
	ActionListener myclick = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			for(int i=0;i<=5;i++){
				btns[i].setBackground(Color.white);
				if(btns[i].equals(e.getSource())){
					mode.setMode(i+1);
					btns[i].setBackground(Color.black);
					}
				}
			for(Shape s : mycanvas.getshapes()){
				s.setnotSelected();	
			}
			}

		};
    	
		ActionListener changename = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(Shape s : mycanvas.getshapes()){
					if(s.isSelected()){
						String name = JOptionPane.showInputDialog(null,"Enter Name","change object name",1);
						if(name!=null) s.setmyname(name);
					}
				}
				
			}

		};
		
		ActionListener groupclick = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Set<Shape> tempObjects = new HashSet<Shape>();
				for(Shape s : mycanvas.getshapes()){
					if(s.getGroup().isSelected()) tempObjects.add(s.getGroup());
				}
				if(!tempObjects.isEmpty()){
					Group g = new Group(0, 0, mycanvas, tempObjects);
					mycanvas.Addshape(g);
					
				}
			}

		};
		
		ActionListener ungroupclick = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(Shape g: mycanvas.getshapes()){
					if(g.getGroup().isSelected()){
						g.getGroup().removeGroup();
						break;
					}
				}
				
			}

		};
	public static void main(String[] args) { 
		new UML();
		
	}
}

