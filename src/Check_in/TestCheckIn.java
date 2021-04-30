package Check_in;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class TestCheckIn {
	private ModelTable md;
	@Before
	public void setUp() throws Exception {
		md = new ModelTable("1","Phú Lâm Hưng","025974290","0926685361","1","Standard","101","","2020-12-02","2","");
		
	}

	@Test
	public void testInputDung() {
		
		 assertAll("Test này ra KQ đúng!",
			        () -> assertEquals("1", md.getMA_PT()),
			        () -> assertEquals("Phú Lâm Hưng", md.getTENKH()),
			        () -> assertEquals("025974290", md.getCMND()),
			        () -> assertEquals("0926685361", md.getSDT()),
			        () -> assertEquals("1", md.getSONGUOI1PHONG()),
			        () -> assertEquals("Standard", md.getLOAIPHONG()),
			        () -> assertEquals("101", md.getSOPHONG()),
			        () -> assertEquals("", md.getNGAYDAT()),
			        () -> assertEquals("2020-12-02", md.getNGAYNHAN()),
			        () -> assertEquals("2", md.getSONGAYO()),
			        () -> assertEquals("", md.getMA_DATPHONG())
			        
			    );
	}
	
	
	
	@Test
	public void testTenSai() {
		
		try {
			md.setTENKH("Phuus567567");
			//fail("Nếu sai thì sẽ hiện ra Exception");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Ký tự tên không được nhập số!" + e.getMessage());
		}
		catch(Exception e) {
			fail("Lỗi khi bạn nhập số  trong trường tên!");
		}
	}
	
	

}
