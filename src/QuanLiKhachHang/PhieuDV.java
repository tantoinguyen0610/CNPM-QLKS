package QuanLiKhachHang;

public class PhieuDV {
	String MAPHIEUDV,TENDV,GIA,TONGTIENDV,SOLUONG;
	public PhieuDV(String MAPHIEUDV, String TENDV,String GIA,String SOLUONG, String TONGTIENDV ) {
		this.MAPHIEUDV=MAPHIEUDV;
		this.TENDV=TENDV;
		this.GIA=GIA;
		this.SOLUONG=SOLUONG;
		this.TONGTIENDV=TONGTIENDV;
		
		
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
