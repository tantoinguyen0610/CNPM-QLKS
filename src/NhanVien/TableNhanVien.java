package NhanVien;

import javafx.scene.control.Button;

public class TableNhanVien extends Object {
	String MANV, TENNV, CHUCVU,CA_LAM,TRANGTHAI,NGAYLAMVIEC,GIOVAO,GIORA,SDT;

	public TableNhanVien(String MANV, String TENNV, 
						String CHUCVU, String CA_LAM, 
						String TRANGTHAI, String NGAYLAMVIEC, 
						String GIOVAO, String GIORA, 
						String SDT) {
		
		this.MANV=MANV;
		this.TENNV=TENNV;
		this.CHUCVU=CHUCVU;
		this.CA_LAM=CA_LAM;
		this.TRANGTHAI=TRANGTHAI;
		this.NGAYLAMVIEC=NGAYLAMVIEC;
		this.GIOVAO=GIOVAO;
		this.GIORA=GIORA;
		this.SDT=SDT;
	}

	public String getMANV() {
		return MANV;
	}

	public void setMANV(String MANV) {
		this.MANV = MANV;
	}

	public String getTENNV() {
		return TENNV;
	}

	public void setTENNV(String TENNV) {
		this.TENNV = TENNV;
	}

	public String getCHUCVU() {
		return CHUCVU;
	}

	public void setCHUCVU(String CHUCVU) {
		this.CHUCVU = CHUCVU;
	}

	public String getCA_LAM() {
		return CA_LAM;
	}

	public void setCA_LAM(String CA_LAM) {
		this.CA_LAM = CA_LAM;
	}

	public String getTRANGTHAI() {
		return TRANGTHAI;
	}

	public void setTRANGTHAI(String TRANGTHAI) {
		this.TRANGTHAI = TRANGTHAI;
	}

	public String getNGAYLAMVIEC() {
		return NGAYLAMVIEC;
	}

	public void setNGAYLAMVIEC(String NGAYLAMVIEC) {
		this.NGAYLAMVIEC = NGAYLAMVIEC;
	}

	public String getGIOVAO() {
		return GIOVAO;
	}

	public void setGIOVAO(String GIOVAO) {
		this.GIOVAO = GIOVAO;
	}

	public String getGIORA() {
		return GIORA;
	}

	public void setGIORA(String GIORA) {
		this.GIORA = GIORA;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String SDT) {
		this.SDT = SDT;
	}
	
	
}
