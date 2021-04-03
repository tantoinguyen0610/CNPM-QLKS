//package LogIn;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.util.List;
//import java.util.ResourceBundle;
//
//import javax.swing.JOptionPane;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.query.Query;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import javafx.stage.Window;
//import qlbhh.qlbhh.Taikhoannv;
//
//public class LoginController {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private BorderPane BP1;
//
//    @FXML
//    private AnchorPane anchorPane1;
//
//    @FXML
//    private ImageView pic1;
//
//    @FXML
//    private Text QLKS_Label;
//
//    @FXML
//    private AnchorPane AnchorPane2;
//
//    @FXML
//    private ImageView pic2;
//
//    @FXML
//    private Label username_Label;
//
//    @FXML
//    private Label psw_Label;
//
//    @FXML
//    private TextField username_textField;
//
//    @FXML
//    private PasswordField password_textField;
//
//    @FXML
//    private Button Button_LogIn;
//
//    @FXML
//    private Label Notification;
//    
//    @FXML
//    void login(ActionEvent event) throws IOException {
//	 Window owner = Button_LogIn.getScene().getWindow();
//
//      System.out.println(username_textField.getText());
//      System.out.println(password_textField.getText());
//
//       if (username_textField.getText().isEmpty()) {
//    	   Notification.setText("Enter username");
//           return;
//       }
//       else if (password_textField.getText().isEmpty()) {
//    	   Notification.setText("Enter Password");
//           return ;
//           }
//       }
//
//    @FXML
//    void Login_ActionListener(ActionEvent event) throws IOException {
//    	
//       	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
//    			.configure("hibernate.cfg.xml")
//    			.build();
//    	Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
//    	SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
//    	Session session = sessionFactory.openSession();
//    	String username = username_textField.getText();
//    	String password =password_textField.getText();
//		String hql = "FROM Taikhoan A WHERE A.USERNAME = :USERNAME and A.PSW = :PSW";
//		String hql1 = "SELECT username, password FROM Taikhoan and username ='quanly' and A.password = :password";
//		String hql2 = "SELECT username, password FROM Taikhoan and username ='ketoan' and A.password = :password";
//		String hql3 = "SELECT username, password FROM Taikhoan and username ='nhanvien' and A.password = :password";
//        Query query = session.createQuery(hql);
//        query.setParameter("username", username);
//        query.setParameter("password", password);
//        Query query1 = session.createQuery(hql1);
//        query1.setParameter("username", username);
//        query1.setParameter("password", password);
//        Query query2 = session.createQuery(hql2);
//        query2.setParameter("username", username);
//        query2.setParameter("password", password);
//        Query query3 = session.createQuery(hql2);
//        query3.setParameter("username", username);
//        query.setParameter("password", password);
//        List<Object[]> tk1 = query1.list();
//        List<Object[]> tk2 = query2.list();
//        List<Object[]> tk3 = query3.list();
//        List<Taikhoan> checktaikhoan = query.list(); 
//        for(Taikhoan checktk1 : checktaikhoan) {
//        	//KIEM TRA XEM DANG NHAP DUOC HAY KHONG
//        	if(checktk1.getUSERNAME().contains(Taikhoan.getusername()) && checktk1.getpassword().contains(Taikhoan.getpassword())) {
//        		for(Object[] singleRowValues : tk1 ) {
//        			String tentaikhoan = (String)singleRowValues[0];
//                	String matkhau = (String)singleRowValues[1];
//                	String cvString = (String)singleRowValues[2];
//                //	System.out.println(tentaikhoan);
//                //	System.out.println(matkhau);
//                //	System.out.println(cvString);
//                	if(tentaikhoan.contains(checktk1.getUSERNAME())&& matkhau.contains(checktk1.getpassword()) && cvString.contains("QL")) {
//                	   Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
//                   	   FXMLLoader loader = new FXMLLoader();
//                   	   loader.setLocation(getClass().getResource("danhsachnhanvien.fxml"));
//                   	   Parent sampleparent =loader.load();
//                   	   Scene scene = new Scene(sampleparent);
//                   	   stage.setScene(scene);
//                	}
//    }
//    
//    
//   
//}
//}}