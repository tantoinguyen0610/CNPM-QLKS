package HoaDon;

public class TableHoaDonTTP {
	String TENKH,SOPHONG,GIAPHONG,SONGAYO,TINHTRANG,NGAYTHANHTOAN,TONGTIENDV,THANHTOAN;
	
	public TableHoaDonTTP(String TENKH, String SOPHONG,String GIAPHONG, String SONGAYO,String TINHTRANG, String NGAYTHANHTOAN, String TONGTIENDV, String THANHTOAN ) {
		this.TENKH=TENKH;
		this.SOPHONG=SOPHONG;
		this.GIAPHONG=GIAPHONG;
		this.SONGAYO = SONGAYO;
		this.TINHTRANG=TINHTRANG;
		this.NGAYTHANHTOAN=NGAYTHANHTOAN;
		this.TONGTIENDV=TONGTIENDV;
		this.THANHTOAN=THANHTOAN;
		
		
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

	public String getGIAPHONG() {
		return GIAPHONG;
	}

	public void setGIAPHONG(String GIAPHONG) {
		this.GIAPHONG = GIAPHONG;
	}

	public String getSONGAYO() {
		return SONGAYO;
	}

	public void setSONGAYO(String SONGAYO) {
		this.SONGAYO = SONGAYO;
	}

	public String getTINHTRANG() {
		return TINHTRANG;
	}

	public void setTINHTRANG(String TINHTRANG) {
		this.TINHTRANG = TINHTRANG;
	}

	public String getNGAYTHANHTOAN() {
		return NGAYTHANHTOAN;
	}

	public void setNGAYTHANHTOAN(String NGAYTHANHTOAN) {
		this.NGAYTHANHTOAN = NGAYTHANHTOAN;
	}

	public String getTONGTIENDV() {
		return TONGTIENDV;
	}

	public void setTONGTIENDV(String TONGTIENDV) {
		this.TONGTIENDV = TONGTIENDV;
	}

	public String getTHANHTOAN() {
		return THANHTOAN;
	}

	public void setTHANHTOAN(String THANHTOAN) {
		this.THANHTOAN = THANHTOAN;
	}
	
}
