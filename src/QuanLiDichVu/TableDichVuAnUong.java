package QuanLiDichVu;

import javafx.scene.control.Button;

public class TableDichVuAnUong extends Object {
	String MA_DV,TENDV,LOAIDV,SOLUONG,GIA,TINHTRANG;
		
	public TableDichVuAnUong(String MA_DV, String TENDV, 
			String LOAIDV, String SOLUONG, 
			String GIA, String TINHTRANG) {
		this.MA_DV=MA_DV;
		this.TENDV=TENDV;
		this.LOAIDV=LOAIDV;
		this.SOLUONG=SOLUONG;
		this.GIA=GIA;
		this.TINHTRANG=TINHTRANG;
	}

	public String getMA_DV() {
		return MA_DV;
	}

	public void setMADV(String MA_DV) {
		MA_DV = MA_DV;
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

	public String getSOLUONG() {
		return SOLUONG;
	}

	public void setSOLUONG(String sOLUONG) {
		SOLUONG = sOLUONG;
	}

	public String getGIA() {
		return GIA;
	}

	public void setGIA(String gIA) {
		GIA = gIA;
	}

	public String getTINHTRANG() {
		return TINHTRANG;
	}

	public void setTINHTRANG(String tINHTRANG) {
		TINHTRANG = tINHTRANG;
	}
	
}	