package QuanLiDichVu;

import javafx.scene.control.Button;

public class TableDichVuThuGian extends Object {
	String MA_DV,TENDV,LOAIDV,SOLUONGNGUOI,KHUNGGIO,TRANGTHAI,GIA;
		
	public TableDichVuThuGian(String MA_DV, String TENDV, 
			String LOAIDV,String SOLUONGNGUOI, 
			String KHUNGGIO , String TRANGTHAI, String GIA) {
		this.MA_DV=MA_DV;
		this.TENDV=TENDV;
		this.LOAIDV=LOAIDV;
		this.SOLUONGNGUOI=SOLUONGNGUOI;
		this.KHUNGGIO=KHUNGGIO;
		this.TRANGTHAI=TRANGTHAI;
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

	public String getSOLUONGNGUOI() {
		return SOLUONGNGUOI;
	}

	public void setSOLUONGNGUOI(String sOLUONGNGUOI) {
		SOLUONGNGUOI = sOLUONGNGUOI;
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

	public String getGIA() {
		return GIA;
	}

	public void setGIA(String gIA) {
		GIA = gIA;
	}
	
}