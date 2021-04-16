package Check_out;

public class TableHoaDon {
	String MA_HDTTP,MAKH,TENKH,MAPHONG,GIATIEN,NGAYNHAN,NGAYTHANHTOAN,TINHTRANG,TONGTIEN;
	
	public TableHoaDon(String MA_HDTTP, String MAKH, String TENKH, String MAPHONG, String GIATIEN, String NGAYNHAN, String NGAYTHANHTOAN, String TINHTRANG,String TONGTIEN) {
		this.MA_HDTTP=MA_HDTTP;
		this.MAKH=MAKH;
		this.TENKH=TENKH;
		this.MAPHONG=MAPHONG;
		this.GIATIEN=GIATIEN;
		this.NGAYNHAN=NGAYNHAN;
		this.NGAYTHANHTOAN=NGAYTHANHTOAN;
		this.TINHTRANG=TINHTRANG;
		this.TONGTIEN=TONGTIEN;
		
	}

	public String getTONGTIEN() {
		return TONGTIEN;
	}

	public void setTONGTIEN(String TONGTIEN) {
		this.TONGTIEN = TONGTIEN;
	}

	public String getMA_HDTTP() {
		return MA_HDTTP;
	}

	public void setMA_HDTTP(String MA_HDTTP) {
		this.MA_HDTTP = MA_HDTTP;
	}

	public String getMAKH() {
		return MAKH;
	}

	public void setMAKH(String MAKH) {
		this.MAKH = MAKH;
	}

	public String getTENKH() {
		return TENKH;
	}

	public void setTENKH(String TENKH) {
		this.TENKH = TENKH;
	}

	public String getMAPHONG() {
		return MAPHONG;
	}

	public void setMAPHONG(String MAPHONG) {
		this.MAPHONG = MAPHONG;
	}

	public String getGIATIEN() {
		return GIATIEN;
	}

	public void setGIATIEN(String GIATIEN) {
		this.GIATIEN = GIATIEN;
	}

	public String getNGAYNHAN() {
		return NGAYNHAN;
	}

	public void setNGAYNHAN(String NGAYNHAN) {
		this.NGAYNHAN = NGAYNHAN;
	}

	public String getNGAYTHANHTOAN() {
		return NGAYTHANHTOAN;
	}

	public void setNGAYTHANHTOAN(String NGAYTHANHTOAN) {
		this.NGAYTHANHTOAN = NGAYTHANHTOAN;
	}

	public String getTINHTRANG() {
		return TINHTRANG;
	}

	public void setTINHTRANG(String TINHTRANG) {
		this.TINHTRANG = TINHTRANG;
	}
}
