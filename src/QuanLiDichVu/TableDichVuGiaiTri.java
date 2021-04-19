package QuanLiDichVu;

public class TableDichVuGiaiTri extends Object {
	String MA_DV,TENDV,LOAIDV,GIA,KHUNGGIO,TRANGTHAI;
		
	public TableDichVuGiaiTri(String MA_DV, String TENDV, 
			String LOAIDV,String GIA, 
			String KHUNGGIO , String TRANGTHAI) {
		this.MA_DV=MA_DV;
		this.TENDV=TENDV;
		this.LOAIDV=LOAIDV;
		this.GIA=GIA;
		this.KHUNGGIO=KHUNGGIO;
		this.TRANGTHAI=TRANGTHAI;
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

	public String getLOAIDV() {
		return LOAIDV;
	}

	public void setLOAIDV(String lOAIDV) {
		LOAIDV = lOAIDV;
	}

	public String getGIA() {
		return GIA;
	}

	public void setGIA(String gIA) {
		GIA = gIA;
	}

	public String getKHUNGGIO() {
		return KHUNGGIO;
	}

	public void setKHUNGGIO(String kHUNGGIO) {
		KHUNGGIO = kHUNGGIO;
	}

	public String getTRANGTHAI() {
		return TRANGTHAI;
	}

	public void setTRANGTHAI(String tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}
	
}