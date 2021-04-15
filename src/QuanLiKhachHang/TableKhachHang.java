package QuanLiKhachHang;

import javafx.scene.control.Button;


	public class TableKhachHang extends Object {
		String MAKH,TENKH,DIACHI,SDT,QUOCTICH,CMND,GIOITINH,NGAYSINH,NGAYCHECK_IN,SONGAYO;
			
		public TableKhachHang(String MAKH, String TENKH, 
				String DIACHI, String SDT, 
				String QUOCTICH, String CMND, 
				String GIOITINH,String NGAYSINH,String NGAYCHECK_IN,String SONGAYO) {
			this.MAKH=MAKH;
			this.TENKH=TENKH;
			this.DIACHI=DIACHI;
			this.SDT=SDT;
			this.QUOCTICH=QUOCTICH;
			this.CMND=CMND;
			this.GIOITINH=GIOITINH;
			this.NGAYSINH=NGAYSINH;
			this.NGAYCHECK_IN=NGAYCHECK_IN;
			this.SONGAYO=SONGAYO;
		}

		public String getMAKH() {
			return MAKH;
		}

		public void setMAKH(String mAKH) {
			MAKH = mAKH;
		}

		public String getTENKH() {
			return TENKH;
		}

		public void setTENKH(String tENKH) {
			TENKH = tENKH;
		}

		public String getDIACHI() {
			return DIACHI;
		}

		public void setDIACHI(String dIACHI) {
			DIACHI = dIACHI;
		}

		public String getSDT() {
			return SDT;
		}

		public void setSDT(String sDT) {
			SDT = sDT;
		}

		public String getQUOCTICH() {
			return QUOCTICH;
		}

		public void setQUOCTICH(String qUOCTICH) {
			QUOCTICH = qUOCTICH;
		}

		public String getCMND() {
			return CMND;
		}

		public void setCMND(String cMND) {
			CMND = cMND;
		}

		public String getGIOITINH() {
			return GIOITINH;
		}

		public void setGIOITINH(String gIOITINH) {
			GIOITINH = gIOITINH;
		}

		public String getNGAYSINH() {
			return NGAYSINH;
		}

		public void setNGAYSINH(String nGAYSINH) {
			NGAYSINH = nGAYSINH;
		}

		public String getNGAYCHECK_IN() {
			return NGAYCHECK_IN;
		}

		public void setNGAYCHECK_IN(String nGAYCHECK_IN) {
			NGAYCHECK_IN = nGAYCHECK_IN;
		}

		public String getSONGAYO() {
			return SONGAYO;
		}

		public void setSONGAYO(String sONGAYO) {
			SONGAYO = sONGAYO;
		}
		
		
}
