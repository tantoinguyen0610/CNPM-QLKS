package HoaDon;

public class TableHoaDonSuaThietBi extends Object {
	String MA_HD,TENTB,SOLUONG,NGAYBD,CHIPHI,TONGTIEN,TINHTRANG,DUYETTHANHTOAN;
	
	public TableHoaDonSuaThietBi(String MA_HD,String TENTB, String SOLUONG,String NGAYBD,String CHIPHI ,String TONGTIEN, String TINHTRANG,String DUYETTHANHTOAN ) {
		this.MA_HD=MA_HD;
		this.TENTB=TENTB;
		this.SOLUONG=SOLUONG;
		this.NGAYBD=NGAYBD;
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

	public String getTENTB() {
		return TENTB;
	}

	public void setTENTB(String tENTB) {
		TENTB = tENTB;
	}

	public String getSOLUONG() {
		return SOLUONG;
	}

	public void setSOLUONG(String sOLUONG) {
		SOLUONG = sOLUONG;
	}

	public String getNGAYBD() {
		return NGAYBD;
	}

	public void setNGAYBD(String nGAYBD) {
		NGAYBD = nGAYBD;
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