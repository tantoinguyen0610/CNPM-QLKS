package QuanLiDichVu;

public class TableDichVuPhucVu extends Object {
	String MA_DV,TENDV,SOLUONG,LOAIDV,TINHTRANG,GIA;
		
	public TableDichVuPhucVu(String MA_DV, String TENDV, 
			String SOLUONG,String LOAIDV, 
			 String TINHTRANG, String GIA) {
		this.MA_DV=MA_DV;
		this.TENDV=TENDV;
		this.SOLUONG=SOLUONG;
		this.LOAIDV=LOAIDV;
		this.TINHTRANG=TINHTRANG;
		this.GIA=GIA;
	}

	public String getMA_DV() {
		return MA_DV;
	}

	public void setMA_DV(String mA_DV) {
		MA_DV = mA_DV;
	}

	public String getTENDV() {
		return TENDV;
	}

	public void setTENDV(String tENDV) {
		TENDV = tENDV;
	}

	public String getSOLUONG() {
		return SOLUONG;
	}

	public void setSOLUONG(String sOLUONG) {
		SOLUONG = sOLUONG;
	}

	public String getLOAIDV() {
		return LOAIDV;
	}

	public void setLOAIDV(String lOAIDV) {
		LOAIDV = lOAIDV;
	}

	public String getTINHTRANG() {
		return TINHTRANG;
	}

	public void setTINHTRANG(String tINHTRANG) {
		TINHTRANG = tINHTRANG;
	}

	public String getGIA() {
		return GIA;
	}

	public void setGIA(String gIA) {
		GIA = gIA;
	}
	
}