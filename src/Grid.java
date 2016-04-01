import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Grid extends JFrame {
	connectButton[][] buttonArr;
	private int row;
	private int col;
	private boolean gameStatus=true;

	public Grid(int rows, int cols) {
		row = rows;
		col = cols;
		buttonArr = new connectButton[cols][rows];
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(cols, row));

		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				connectButton button = new connectButton("");
				button.setLocx(y);
				button.setLocy(x);
				pane.add(button);
				buttonArr[y][x] = button;
			}
		}
		setVisible(true);
		setSize(500, 500);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public boolean getGameStatus() {
		return gameStatus;
	}
	public int getRows() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public String victory() {
		String result = checkCol() + checkRow() + checkDia() + checkDia2();
		return result;
	}
	public String checkCol(){
		try{
			for (int y = 0; y < row; y++) {
				for (int x = 0; x < col; x++) {
					String temp = buttonArr[y][x].getText();
					if (!temp.equals("") && temp.equals(buttonArr[y][x + 1].getText())
							&& temp.equals(buttonArr[y][x + 2].getText())
							&& temp.equals(buttonArr[y][x + 3].getText())) {
						gameStatus=false;
						return temp;
					}
				}
			}
		}catch(Exception e){
		}
		return "";
	}
	public String checkRow(){
		try{
			for (int y = 0; y < row; y++) {
				for (int x = 0; x < col; x++) {
					String temp = buttonArr[y][x].getText();
					if (!temp.equals("") && temp.equals(buttonArr[y + 1][x].getText())
							&& temp.equals(buttonArr[y + 2][x].getText())
							&& temp.equals(buttonArr[y + 3][x].getText())) {
							gameStatus=false;
						return temp;
					}
				}
			}
		}catch(Exception e){
		}
		return "";
	}
	public String checkDia(){
		try{
			for (int y = 0; y < row; y++) {
				for (int x = 0; x < col; x++) {
					String temp = buttonArr[y][x].getText();
					if (!temp.equals("") && temp.equals(buttonArr[y + 1][x + 1].getText())
							&& temp.equals(buttonArr[y + 2][x + 2].getText())
							&& temp.equals(buttonArr[y + 3][x + 3].getText())) {
						gameStatus=false;
						return temp;
					}
				}
			}
		}catch(Exception e){
		}
		return "";
	}
	public String checkDia2(){
		try{
			for (int y = 0; y < row; y++) {
				for (int x = 0; x < col; x++) {
					String temp = buttonArr[y][x].getText();
					 if (!temp.equals("") && temp.equals(buttonArr[y + 1][x - 1].getText())
								&& temp.equals(buttonArr[y + 2][x - 2].getText())
								&& temp.equals(buttonArr[y + 3][x - 3].getText())) {
						 gameStatus=false;
							return temp;
					 }
				}
			}
		}catch(Exception e){
		}
		return "";
	}
	public connectButton getButton(int y, int x) {
		return buttonArr[y][x];
	}

}