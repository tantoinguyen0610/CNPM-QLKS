package LogIn;

public class Taikhoan extends Object {
	private Integer MATK;
	private Integer MANV;
	private String USERNAME;
	private String PWS;

	public Taikhoan() {
		super();
	}

	public Taikhoan(Integer MATK, Integer MANV, String USERNAME, String PWS) {
		this.MANV = MANV;
		this.MATK = MATK;
		this.USERNAME = USERNAME;
		this.PWS = PWS;
	}

	public Integer getMATK() {
		return MATK;
	}

	public void setMATK(Integer mATK) {
		MATK = mATK;
	}

	public Integer getMANV() {
		return MANV;
	}

	public void setMANV(Integer mANV) {
		MANV = mANV;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getPWS() {
		return PWS;
	}

	public void setPWS(String pWS) {
		PWS = pWS;
	}
}
