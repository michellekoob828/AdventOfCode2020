package src.vo;

public class Directions {

	private int right;
	private int down;
	
	public Directions(int right, int down) {
		this.right = right;
		this.down = down;
	}
	
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	
}
