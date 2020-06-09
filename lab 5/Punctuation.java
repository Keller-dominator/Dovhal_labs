package ua.kpi.io93.dovhal.lab5;

/
public class Punctuation {

	private char symbol;

	private int position;

	public Punctuation(char a, int p) {
		setSymbol(a);
		setPosition(p);
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}
}
