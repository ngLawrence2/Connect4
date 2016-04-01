
import javax.swing.JButton;

public class connectButton extends JButton{
	volatile boolean pressed=true; 
	 int locx,locy; 
	public connectButton(String label){
		this.setText(label);
	}
	public void setLocx(int a) {
		locx=a;
	}
	public void setLocy(int a)  {
		locy=a;
	}
	public int getLocx() {
		return locx;
	}
	public void notEmpty() {
		pressed=false;
	}
	public boolean buttonEmpty() {
		return pressed;
	}
	public String toString() {
		return locx + ", " + locy;
	}
}
