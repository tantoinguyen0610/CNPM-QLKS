package HoaDon;

import javafx.scene.control.Button;

public class TableHoaDonTTP extends Object {
	String MA_HD_TTP,TENKH,SOPHONG,NGAYTHANHTOAN,TIENPHONG,TONGTIENDV,TONGTIEN,TINHTRANG;
	
	public TableHoaDonTTP(String MA_HD_TTP,String TENKH, String SOPHONG,String NGAYTHANHTOAN,String TIENPHONG ,String TONGTIENDV, String TONGTIEN,String TINHTRANG ) {
		this.MA_HD_TTP=MA_HD_TTP;
		this.TENKH=TENKH;
		this.SOPHONG=SOPHONG;
		this.NGAYTHANHTOAN=NGAYTHANHTOAN;
		this.TIENPHONG=TIENPHONG;
		this.TONGTIENDV=TONGTIENDV;
		this.TONGTIEN=TONGTIEN;	
		this.TINHTRANG=TINHTRANG;
	}

	public String getMA_HD_TTP() {
		return MA_HD_TTP;
	}

	public void setMA_HD_TTP(String mA_HD_TTP) {
		MA_HD_TTP = mA_HD_TTP;
	}

	public String getTENKH() {
		return TENKH;
	}

	public void setTENKH(String tENKH) {
		TENKH = tENKH;
	}

	public String getSOPHONG() {
		return SOPHONG;
	}

	public void setSOPHONG(String sOPHONG) {
		SOPHONG = sOPHONG;
	}

	public String getNGAYTHANHTOAN() {
		return NGAYTHANHTOAN;
	}

	public void setNGAYTHANHTOAN(String nGAYTHANHTOAN) {
		NGAYTHANHTOAN = nGAYTHANHTOAN;
	}

	public String getTIENPHONG() {
		return TIENPHONG;
	}

	public void setTIENPHONG(String tIENPHONG) {
		TIENPHONG = tIENPHONG;
	}

	public String getTONGTIENDV() {
		return TONGTIENDV;
	}

	public void setTONGTIENDV(String tONGTIENDV) {
		TONGTIENDV = tONGTIENDV;
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
	

}	
