package Check_in;

public class ModelTable extends Object {
		String MA_PT, TENKH,MA_DATPHONG,SOPHONG,NGAYDAT,NGAYNHAN,SONGAYO;

		public ModelTable(String MA_PT, String TENKH, String MA_DATPHONG, String SOPHONG, String NGAYDAT,
				String NGAYNHAN, String SONGAYO) {
			
			this.MA_PT = MA_PT;
			this.TENKH = TENKH;
			this.MA_DATPHONG = MA_DATPHONG;
			this.SOPHONG = SOPHONG;
			this.NGAYDAT = NGAYDAT;
			this.NGAYNHAN = NGAYNHAN;
			this.SONGAYO= SONGAYO;
		}

		public String getMA_PT() {
			return MA_PT;
		}

		public void setMA_PT(String MA_PT) {
			this.MA_PT = MA_PT;
		}

		public String getTENKH() {
			return TENKH;
		}

		public void setTENKH(String TENKH) {
			this.TENKH = TENKH;
		}

		public String getMA_DATPHONG() {
			return MA_DATPHONG;
		}

		public void setMA_DATPHONG(String MA_DATPHONG) {
			this.MA_DATPHONG = MA_DATPHONG;
		}

		public String getSOPHONG() {
			return SOPHONG;
		}

		public void setSOPHONG(String SOPHONG) {
			this.SOPHONG = SOPHONG;
		}

		public String getNGAYDAT() {
			return NGAYDAT;
		}

		public void setNGAYDAT(String NGAYDAT) {
			this.NGAYDAT = NGAYDAT;
		}

		public String getNGAYNHAN() {
			return NGAYNHAN;
		}

		public void setNGAYNHAN(String NGAYNHAN) {
			this.NGAYNHAN = NGAYNHAN;
		}
		
		public String getSONGAYO() {
			return SONGAYO;
		}

		public void setSONGAYO(String SONGAYO) {
			this.SONGAYO = SONGAYO;
		}


		
}
