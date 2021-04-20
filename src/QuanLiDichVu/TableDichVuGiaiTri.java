package QuanLiDichVu;

import javafx.scene.control.Button;

public class TableDichVuGiaiTri extends Object {
	String MA_DV,TENDV,LOAIDV,KHUNGGIO,TINHTRANG,GIA;
		
	public TableDichVuGiaiTri(String MA_DV, String TENDV, 
			String LOAIDV, String KHUNGGIO , 
			String TINHTRANG,String GIA) {
		this.MA_DV=MA_DV;
		this.TENDV=TENDV;
		this.LOAIDV=LOAIDV;
		this.KHUNGGIO=KHUNGGIO;
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

	public String getLOAIDV() {
		return LOAIDV;
	}

	public void setLOAIDV(String lOAIDV) {
		LOAIDV = lOAIDV;
	}

	public String getKHUNGGIO() {
		return KHUNGGIO;
	}

	public void setKHUNGGIO(String kHUNGGIO) {
		KHUNGGIO = kHUNGGIO;
	}

	public String getTINHTRANG() {
		return TINHTRANG;
	}

	public void setTRANGTHAI(String tINHTRANG) {
		TINHTRANG = tINHTRANG;
	}
	
	public String getGIA() {
		return GIA;
	}

	public void setGIA(String gIA) {
		GIA = gIA;
	}
}