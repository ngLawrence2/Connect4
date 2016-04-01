import javax.swing.JOptionPane;

public class Controller {
	private static Grid grid1;
	private ColumnSelector colselector;
	// int myColumn;
	int value;
	
	public Controller(ColumnSelector a, Grid b) {
		colselector = a;
		grid1 = b;
	}

	public String getPlayer() {
		value=colselector.getNumber();
		if (value% 2 == 0) {
			return "B";
		} else {
			return "A";
		}
	}

	public ColumnSelector getColSelector() {
		return colselector;
	}

	public int getColCounter() {
		return colselector.getNumber();
	}

	public int getColumnNumber() {

		return colselector.getColumn();
	}

	public connectButton findLocation(int column) {
		for (int i = grid1.getRows() - 1; i >= 0; i--) {
			if (grid1.getButton(i, column).buttonEmpty()) {				
				return grid1.getButton(i, column);
			}

		}
		value++;
		return null;
	}

	public void setButtonText(String a, connectButton d) {
		d.setText(a);
		d.notEmpty();
	}

	public boolean getColBoolean(ColumnSelector a) {
		return a.getMyBoolean();
	}
	public Grid getGrid() {
		return grid1;
	}

	public static void main(String[] args) {
		int defaultsize=10;
		int connection;
		if(args[0].length()==0 && args[1].length()==0) {
			System.out.println("Default Size set to 10x10 and connection length to 4");
		} else {
			try {
				defaultsize=Integer.parseInt(args[0]);
				connection=Integer.parseInt(args[1]);
			} catch(Exception e) {
			}
		}
		
		Controller a = new Controller(new ColumnSelector(), new Grid(defaultsize, defaultsize));
		while (a.getColCounter() < defaultsize*defaultsize && a.getGrid().getGameStatus()) {
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
			}
			if (a.getColBoolean(a.getColSelector()) && (!(a.findLocation(a.getColumnNumber())==null))) {
				a.setButtonText(a.getPlayer(), a.findLocation(a.getColumnNumber()));
				if(!"".equals(a.getGrid().victory())) {
				JOptionPane.showMessageDialog(null, a.getGrid().victory()+ " won. Exit Program");
			}
			}
			a.getColSelector().setFalse();

		}
	}
}