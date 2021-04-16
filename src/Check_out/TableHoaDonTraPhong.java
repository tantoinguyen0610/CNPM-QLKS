package Check_out;

public class TableHoaDonTraPhong {
	String MAKH, TENKH, SOPHONG, SONGAYO;
	public  TableHoaDonTraPhong(String MAKH, String TENKH, String SOPHONG, String SONGAYO){
		
		this.MAKH=MAKH;
		this.TENKH=TENKH;
		this.SOPHONG=SOPHONG;
		this.SONGAYO=SONGAYO;
		
		
	}
	public String getMAKH() {
		return MAKH;
	}
	public void setMAKH(String MAKH) {
		this.MAKH = MAKH;
	}
	public String getTENKH() {
		return TENKH;
	}
	public void setTENKH(String TENKH) {
		this.TENKH = TENKH;
	}
	public String getSOPHONG() {
		return SOPHONG;
	}
	public void setSOPHONG(String SOPHONG) {
		this.SOPHONG = SOPHONG;
	}
	public String getSONGAYO() {
		return SONGAYO;
	}
	public void setSONGAYO(String SONGAYO) {
		this.SONGAYO = SONGAYO;
	}
}
