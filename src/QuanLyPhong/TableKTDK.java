package QuanLyPhong;

public class TableKTDK {
	String MA_KTDK, TEN_PHONG, NGAY_KT, GIO_BD, GIO_KT, TRANGTHAISAUKT, GHI_CHU;
	public TableKTDK(String MA_KTDK, String TEN_PHONG, String NGAY_KT, String GIO_BD, String GIO_KT, String TRANGTHAISAUKT, String GHI_CHU) {
		this.MA_KTDK=MA_KTDK;
		this.TEN_PHONG=TEN_PHONG;
		this.NGAY_KT=NGAY_KT;
		this.GIO_BD=GIO_BD;
		this.GIO_KT=GIO_KT;
		this.TRANGTHAISAUKT=TRANGTHAISAUKT;
		this.GHI_CHU=GHI_CHU;
		
	}
	public String getMA_KTDK() {
		return MA_KTDK;
	}
	public void setMA_KTDK(String mA_KTDK) {
		MA_KTDK = mA_KTDK;
	}
	public String getTEN_PHONG() {
		return TEN_PHONG;
	}
	public void setTEN_PHONG(String tEN_PHONG) {
		TEN_PHONG = tEN_PHONG;
	}
	public String getNGAY_KT() {
		return NGAY_KT;
	}
	public void setNGAY_KT(String nGAY_KT) {
		NGAY_KT = nGAY_KT;
	}
	public String getGIO_BD() {
		return GIO_BD;
	}
	public void setGIO_BD(String gIO_BD) {
		GIO_BD = gIO_BD;
	}
	public String getGIO_KT() {
		return GIO_KT;
	}
	public void setGIO_KT(String gIO_KT) {
		GIO_KT = gIO_KT;
	}
	public String getTRANGTHAISAUKT() {
		return TRANGTHAISAUKT;
	}
	public void setTRANGTHAISAUKT(String tRANGTHAISAUKT) {
		TRANGTHAISAUKT = tRANGTHAISAUKT;
	}
	public String getGHI_CHU() {
		return GHI_CHU;
	}
	public void setGHICHU(String gHI_CHU) {
		GHI_CHU = gHI_CHU;
	}
}
