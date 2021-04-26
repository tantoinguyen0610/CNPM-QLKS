package QuanLyPhong;

public class TableQLTB {
	String MA_THIETBI, TEN_THIETBI, NGAY_NHAP,NGAY_XUAT,TINHTRANG,VI_TRI;
	public TableQLTB(String MA_THIETBI,String TEN_THIETBI,String NGAY_NHAP,String NGAY_XUAT,String TINHTRANG,String VI_TRI) {
		this.MA_THIETBI=MA_THIETBI;
		this.TEN_THIETBI=TEN_THIETBI;
		this.NGAY_NHAP=NGAY_NHAP;
		this.NGAY_XUAT=NGAY_XUAT;
		this.TINHTRANG=TINHTRANG;
		this.VI_TRI=VI_TRI;
		
	}
	public String getMA_THIETBI() {
		return MA_THIETBI;
	}
	public void setMA_THIETBI(String mA_THIETBI) {
		MA_THIETBI = mA_THIETBI;
	}
	public String getTEN_THIETBI() {
		return TEN_THIETBI;
	}
	public void setTEN_THIETBI(String tEN_THIETBI) {
		TEN_THIETBI = tEN_THIETBI;
	}
	public String getNGAY_NHAP() {
		return NGAY_NHAP;
	}
	public void setNGAY_NHAP(String nGAY_NHAP) {
		NGAY_NHAP = nGAY_NHAP;
	}
	public String getNGAY_XUAT() {
		return NGAY_XUAT;
	}
	public void setNGAY_XUAT(String nGAY_XUAT) {
		NGAY_XUAT = nGAY_XUAT;
	}
	public String getTINHTRANG() {
		return TINHTRANG;
	}
	public void setTINHTRANG(String tINHTRANG) {
		TINHTRANG = tINHTRANG;
	}
	public String getVI_TRI() {
		return VI_TRI;
	}
	public void setVI_TRI(String vI_TRI) {
		VI_TRI = vI_TRI;
	}
}
