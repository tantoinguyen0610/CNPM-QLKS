package QuanLiKhachHang;

public class PhieuDV {
	String MAPHIEUDV,SOPHONG,TENDV,GIA,TONGTIENDV,SOLUONG;
	public PhieuDV(String MAPHIEUDV,String SOPHONG, String TENDV,String GIA,String SOLUONG, String TONGTIENDV ) {
		this.MAPHIEUDV=MAPHIEUDV;
		this.SOPHONG=SOPHONG;
		this.TENDV=TENDV;
		this.GIA=GIA;
		this.SOLUONG=SOLUONG;
		this.TONGTIENDV=TONGTIENDV;
		
		
	}
	
	public String getSOPHONG() {
		return SOPHONG;
	}

	public void setSOPHONG(String sOPHONG) {
		SOPHONG = sOPHONG;
	}

	public String getGIATIEN() {
		return GIA;
	}

	public void setGIATIEN(String gIA) {
		GIA = gIA;
	}

	public String getMAPHIEUDV() {
		return MAPHIEUDV;
	}
	public void setMAPHIEUDV(String mAPHIEUDV) {
		MAPHIEUDV = mAPHIEUDV;
	}
	public String getTENDV() {
		return TENDV;
	}
	public void setTENDV(String tENDV) {
		TENDV = tENDV;
	}
	public String getTONGTIENDV() {
		return TONGTIENDV;
	}
	public void setTONGTIENDV(String tONGTIENDV) {
		TONGTIENDV = tONGTIENDV;
	}
	public String getSOLUONG() {
		return SOLUONG;
	}
	public void setSOLUONG(String sOLUONG) {
		SOLUONG = sOLUONG;
	}
}
