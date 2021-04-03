package LogIn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="TAIKHOAN")
public class Taikhoan {
	@Id
	private Integer MATK;
	private Integer MANV;
	private static String USERNAME;
	private String PSW;

	public Taikhoan() {
		super();
	}

	public Taikhoan(Integer MATK, Integer MANV, String USERNAME, String PWS) {
		this.MANV = MANV;
		this.MATK = MATK;
		this.USERNAME = USERNAME;
		this.PSW = PSW;
	}

	public Integer getMATK() {
		return MATK;
	}

	public void setMATK(Integer MATK) {
		this.MATK = MATK;
	}

	public Integer getMANV() {
		return MANV;
	}

	public void setMANV(Integer MANV) {
		this.MANV = MANV;
	}

	public static String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String USERNAME) {
		this.USERNAME = USERNAME;
	}

	public String getPWS() {
		return PSW;
	}

	public void setPWS(String PSW) {
		this.PSW = PSW;
	}
}
