import java.awt.*;
import java.awt.event.*;

class myFrame extends Frame{

     
     String msg="";
	 int x,y;
	 
	 myFrame()
	 {
	 addMouseListener(new myMouseAdapter(this)); 
	   msg="";
	   x=0;
	   y=0;
	 }
	 
	 public void paint(Graphics g)
	 {
	 g.drawString(msg,x,y);
	 }
}

     class myMouseAdapter extends MouseAdapter
	 {
	    myFrame o1;  //myFrame class reference variable
		myMouseAdapter(myFrame o2)
		{
		o1=o2;   //myFrame class object is assigned to myFrame class reference variable
		}
		
		public void mouseClicked(MouseEvent me){
		     o1.msg="Mouse Clicked..";
		     o1.x=100;
	             o1.y=100;
		     o1.repaint();
		}
		
		public void mouseEntered(MouseEvent me){
		     o1.msg="Mouse Entered..";
			 o1.x=200;
			 o1.y=200;
		     o1.repaint();
		}
		
		public void mouseExited(MouseEvent me){
		     o1.msg="Mouse Exited..";
			 o1.x=300;
			 o1.y=300;
		     o1.repaint();
		}
	 }
	 
class AnonymousWindowAdapter{
        public static void main(String args[])
		{
		   myFrame f=new myFrame();
		   f.setSize(500,500);
		   f.setVisible(true);
		   f.setTitle("Paint() Demo with Adapter Classes");
           f.addWindowListener(new WindowAdapter()
		   {
			   public void windowClosing(WindowEvent we)
			   {
				   System.exit(0);
			   }
           });
		}
}
