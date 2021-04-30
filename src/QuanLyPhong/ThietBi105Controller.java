package QuanLyPhong;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Check_in.ModelTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ThietBi105Controller implements Initializable {

    @FXML
    private AnchorPane Ap;

    @FXML
    private CheckBox cb5;

    @FXML
    private CheckBox cb1;

    @FXML
    private CheckBox cb2;

    @FXML
    private CheckBox cb8;

    @FXML
    private CheckBox cb6;

    @FXML
    private CheckBox cb3;

    @FXML
    private CheckBox cb4;

    @FXML
    private CheckBox cb7;

    @FXML
    private Button btCapnhat;

    @FXML
    private Button btLuu;

    @FXML
    private Button btHuy;
    
    @FXML
    private Label lbThietbiphong;
    ObservableList<String> checkboxlist = FXCollections.observableArrayList();
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	LayDataVeCheckBox();
		
	}
    
  public void  LayDataVeCheckBox() {
	  try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			Statement s= conn.createStatement();
			ResultSet rs = s.executeQuery("select THIETBI from phong where MA_PHONG = '5' ");
			rs.next();
			//ResultSet rs = conn.createStatement().executeQuery("select THIETBI from phong where MA_PHONG = '1' ");
				rs.getString("THIETBI");
				if(rs.getString("THIETBI")!=null) {
				cb1.setSelected(false);
				cb2.setSelected(false);
				cb3.setSelected(false);
				cb4.setSelected(false);
				cb5.setSelected(false);
				cb6.setSelected(false);
				cb7.setSelected(false);
				cb8.setSelected(false);	
				String checkBoxString = rs.getString("THIETBI").replace("[", "").replace("]", "");
				List<String> listtb = Arrays.asList(checkBoxString.split("\\s*,\\s*"));
				for(String thietbi : listtb) {
					switch(thietbi) {
					case "Giường ngủ" : cb1.setSelected(true);
						break;
					case "Bàn đầu giường" : cb2.setSelected(true);
						break;
					case "Ti vi" : cb3.setSelected(true);
						break;
					case "Tủ lạnh " : cb4.setSelected(true);
						break;
					case "Tủ để quần áo" : cb5.setSelected(true);
						break;
					case "Đèn phòng" : cb6.setSelected(true);
						break;
					case "Bàn và ghế làm việc" : cb7.setSelected(true);
						break;
					case "Điều hòa nhiệt độ" : cb8.setSelected(true);
						break;
					default				 : cb1.setSelected(false);
										   cb2.setSelected(false);
										   cb3.setSelected(false);
										   cb4.setSelected(false);
										   cb5.setSelected(false);
										   cb6.setSelected(false);
										   cb7.setSelected(false);
										   cb8.setSelected(false);
					}
				}}
				else {
					cb1.setSelected(false);
					cb2.setSelected(false);
					cb3.setSelected(false);
					cb4.setSelected(false);
					cb5.setSelected(false);
					cb6.setSelected(false);
					cb7.setSelected(false);
					cb8.setSelected(false);
				}
				
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
  }

    @FXML
    void cb1_ActionListener(ActionEvent event) {
    	checkboxlist.add(cb1.getText());
    }

    @FXML
    void cb2_ActionListener(ActionEvent event) {
    	checkboxlist.add(cb2.getText());
    }

    @FXML
    void cb3_ActionListener(ActionEvent event) {
    	checkboxlist.add(cb3.getText());
    }

    @FXML
    void cb4_ActionListener(ActionEvent event) {
    	checkboxlist.add(cb4.getText());
    }

    @FXML
    void cb5_ActionListener(ActionEvent event) {
    	checkboxlist.add(cb5.getText());
    }

    @FXML
    void cb6_ActionListener(ActionEvent event) {
    	checkboxlist.add(cb6.getText());
    }

    @FXML
    void cb7_ActionListener(ActionEvent event) {
    	checkboxlist.add(cb7.getText());
    }

    @FXML
    void cb8_ActionListener(ActionEvent event) {
    	checkboxlist.add(cb8.getText());
    }
    
    @FXML
    void Luu_ActionListener(ActionEvent event) {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "UPDATE phong SET THIETBI = ? WHERE TEN_PHONG= 105";
			PreparedStatement pst = conn.prepareStatement(query);
			 if (checkboxlist.isEmpty()) {
				 pst.setString(1, null); 
		           
		        } else {
		        	 pst.setString(1, checkboxlist.toString());
		        }
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
		}
	catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi:" +e);
		}
    }
    
    @FXML
    void Huy_ActionListener(ActionEvent event) {
    int response=	JOptionPane.showConfirmDialog(null, "Bạn muốn lưu r xoá", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    	if(response == JOptionPane.YES_OPTION) {
    		try {
    			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
    			Connection conn = DriverManager.getConnection(DB_URL,"root","");
    			String query = "UPDATE phong SET THIETBI = ? WHERE TEN_PHONG= 105";
    			PreparedStatement pst = conn.prepareStatement(query);
    			pst.setString(1, checkboxlist.toString());
    			pst.executeUpdate();
    			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
    		}
    	catch(Exception e) {
    			JOptionPane.showMessageDialog(null, "Lỗi:" +e);
    		}
    	}
    	else if(response == JOptionPane.NO_OPTION){
    		
    	}
    }

	

    
}
