package src.vo;

public class BoardingPass {

	private int rowNum;
	private int colNum;
	private int seatNum;
	
	public BoardingPass(int rowNum, int colNum) {
		this.rowNum = rowNum;
		this.colNum = colNum;
		this.seatNum = (rowNum * 8) + colNum;
	}
	
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getColNum() {
		return colNum;
	}
	public void setColNum(int colNum) {
		this.colNum = colNum;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colNum;
		result = prime * result + rowNum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardingPass other = (BoardingPass) obj;
		if (colNum != other.colNum)
			return false;
		if (rowNum != other.rowNum)
			return false;
		return true;
	}
	
}
