package QuanLiKhachHang;

import javafx.scene.control.Button;


	public class TableKhachHang extends Object {
		String MAKH,TENKH,NGAYSINH,GIOITINH,DIACHI,QUOCTICH,SDT,CMND;
			
		public TableKhachHang(String MAKH, String TENKH, 
				String NGAYSINH, String GIOITINH, 
				String DIACHI, String QUOCTICH, 
				String SDT,String CMND) {
			this.MAKH=MAKH;
			this.TENKH=TENKH;
			this.NGAYSINH=NGAYSINH;
			this.GIOITINH=GIOITINH;
			this.DIACHI=DIACHI;
			this.QUOCTICH=QUOCTICH;
			this.SDT=SDT;
			this.CMND=CMND;
		}

		public String getMAKH() {
			return MAKH;
		}

		public void setMAKH(String MAKH) {
			MAKH = MAKH;
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

		public void setDIACHI(String DIACHI) {
			DIACHI = DIACHI;
		}

		public String getSDT() {
			return SDT;
		}

		public void setSDT(String SDT) {
			SDT = SDT;
		}

		public String getQUOCTICH() {
			return QUOCTICH;
		}

		public void setQUOCTICH(String QUOCTICH) {
			QUOCTICH = QUOCTICH;
		}

		public String getCMND() {
			return CMND;
		}

		public void setCMND(String CMND) {
			CMND = CMND;
		}

		public String getGIOITINH() {
			return GIOITINH;
		}

		public void setGIOITINH(String GIOITINH) {
			GIOITINH = GIOITINH;
		}

		public String getNGAYSINH() {
			return NGAYSINH;
		}

		public void setNGAYSINH(String nGAYSINH) {
			NGAYSINH = nGAYSINH;
		}


		
		
}
