package HoaDon;

import javafx.scene.control.Button;

public class TableHoaDonNangCapPhong extends Object {
	String MA_HD,SOPHONG,NGAYBD,NGAYKT,CHIPHI,TONGTIEN,TINHTRANG,DUYETTHANHTOAN;
	
	public TableHoaDonNangCapPhong(String MA_HD,String SOPHONG, String NGAYBD,String NGAYKT,String CHIPHI ,String TONGTIEN, String TINHTRANG,String DUYETTHANHTOAN ) {
		this.MA_HD=MA_HD;
		this.SOPHONG=SOPHONG;
		this.NGAYBD=NGAYBD;
		this.NGAYKT=NGAYKT;
		this.CHIPHI=CHIPHI;
		this.TONGTIEN=TONGTIEN;	
		this.TINHTRANG=TINHTRANG;
		this.DUYETTHANHTOAN=DUYETTHANHTOAN;
	}

	public String getMA_HD() {
		return MA_HD;
	}

	public void setMA_HD(String mA_HD) {
		MA_HD = mA_HD;
	}

	public String getSOPHONG() {
		return SOPHONG;
	}

	public void setSOPHONG(String sOPHONG) {
		SOPHONG = sOPHONG;
	}

	public String getNGAYBD() {
		return NGAYBD;
	}

	public void setNGAYBD(String nGAYBD) {
		NGAYBD = nGAYBD;
	}

	public String getNGAYKT() {
		return NGAYKT;
	}

	public void setNGAYKT(String nGAYKT) {
		NGAYKT = nGAYKT;
	}

	public String getCHIPHI() {
		return CHIPHI;
	}

	public void setCHIPHI(String cHIPHI) {
		CHIPHI = cHIPHI;
	}

	public String getTONGTIEN() {
		return TONGTIEN;
	}

	public void setTONGTIEN(String tONGTIEN) {
		TONGTIEN = tONGTIEN;
	}

	public String getTINHTRANG() {
		return TINHTRANG;
	}

	public void setTINHTRANG(String tINHTRANG) {
		TINHTRANG = tINHTRANG;
	}

	public String getDUYETTHANHTOAN() {
		return DUYETTHANHTOAN;
	}

	public void setDUYETTHANHTOAN(String dUYETTHANHTOAN) {
		DUYETTHANHTOAN = dUYETTHANHTOAN;
	}
	
}
