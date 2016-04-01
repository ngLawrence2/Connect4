import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ColumnSelector extends JFrame{
	JButton button=new JButton("Select Column");
	JPanel panel= new JPanel(); 
	volatile int myCol;
	volatile int counter=0;
	JTextField colNum = new JTextField(2);
	volatile boolean myBoolean;
	public ColumnSelector() {
		super("pick a column");
		setSize(100,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					myBoolean=true;
					if(colNum.getText().length()==0) {
						myBoolean=false;
					}
					myCol=Integer.parseInt(colNum.getText());
					colNum.setText("");
					counter++;
				} catch (Exception ed) {
					JOptionPane.showMessageDialog(null, "Enter Integer only");
				}
			}
		});
		setResizable(false);
		panel.add(colNum);
		panel.add(button);
		add(panel);
	}
	public int getNumber() {
		return counter;
	}
	public int getColumn() {
		//System.out.println(myCol+" my column");
		return myCol;
	}
	public void setFalse() {
		myBoolean=false;
	}
	public boolean getMyBoolean() {
		return myBoolean;
	}
	
}