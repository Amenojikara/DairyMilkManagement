/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dairymilkmainproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author AYAN
 */
public class TransactionController implements Initializable {
    
    @FXML
    public TableView transaction_table;
    public TableColumn table_id,table_date,table_amount,table_description,table_ename,table_type,table_purchase_sale_id;
    public DatePicker date;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showTable();
    }    
    
    public void showTable(){
        try {
            transaction pch;
            Connection con1;
            PreparedStatement insert;
            table_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            table_date.setCellValueFactory(new PropertyValueFactory<>("date"));
            table_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
            table_description.setCellValueFactory(new PropertyValueFactory<>("description"));
            table_ename.setCellValueFactory(new PropertyValueFactory<>("ename"));
            table_type.setCellValueFactory(new PropertyValueFactory<>("type"));
            table_purchase_sale_id.setCellValueFactory(new PropertyValueFactory<>("purchase_sale_id"));
            
            ObservableList<transaction> products=FXCollections.observableArrayList();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1=DriverManager.getConnection("jdbc:mysql://localhost/dairyMilk","root","Ayan@0904");
            insert=con1.prepareStatement("select * from transaction");
            ResultSet rs1=insert.executeQuery();
            
            
            
            while(rs1.next()){
                pch=new transaction(Integer.parseInt(rs1.getString(1)),rs1.getString(2),rs1.getString(3),Double.parseDouble(rs1.getString(4)),rs1.getString(5),rs1.getString(6),rs1.getString(7));
                products.add(pch);
            }
            transaction_table.setItems(products);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    @FXML
    public void searchValue(ActionEvent event) throws SQLException, ClassNotFoundException{
       
       String selectedDate=date.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString();
       
       Connection con1;
       PreparedStatement insert;
       Class.forName("com.mysql.cj.jdbc.Driver");
            con1=DriverManager.getConnection("jdbc:mysql://localhost/dairyMilk","root","Ayan@0904");
            insert=con1.prepareStatement("select * from transaction where date=?");
            
            insert.setString(1,selectedDate);
            ResultSet rs1=insert.executeQuery();
//            System.out.println(rs1);
            
            
            
//            PreparedStatement insert;
            table_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            table_date.setCellValueFactory(new PropertyValueFactory<>("date"));
            table_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
            table_description.setCellValueFactory(new PropertyValueFactory<>("description"));
            table_ename.setCellValueFactory(new PropertyValueFactory<>("ename"));
            table_type.setCellValueFactory(new PropertyValueFactory<>("type"));
            table_purchase_sale_id.setCellValueFactory(new PropertyValueFactory<>("purchase_sale_id"));
            
            
            ObservableList<transaction> products=FXCollections.observableArrayList();
            transaction pch;
       while(rs1.next()){
                pch=new transaction(Integer.parseInt(rs1.getString(1)),rs1.getString(2),rs1.getString(3),Double.parseDouble(rs1.getString(4)),rs1.getString(5),rs1.getString(6),rs1.getString(7));
                products.add(pch);
            }
            transaction_table.setItems(products);
       
            
            
       
    }
    
    
    @FXML
    public void goToStaff(ActionEvent event) throws IOException{
        Parent StaffParent=FXMLLoader.load(getClass().getResource("staff.fxml"));
        Scene sc=new Scene(StaffParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }
    
    @FXML
    public void goToSales(ActionEvent event) throws IOException{
        Parent StaffParent=FXMLLoader.load(getClass().getResource("Sell.fxml"));
        Scene sc=new Scene(StaffParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }
    
    
    public void goToStock(ActionEvent event) throws IOException{
        Parent StaffParent=FXMLLoader.load(getClass().getResource("Stock.fxml"));
        Scene sc=new Scene(StaffParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }
    
    
    public void goToPurchase(ActionEvent event) throws IOException{
        Parent StaffParent=FXMLLoader.load(getClass().getResource("Purchas.fxml"));
        Scene sc=new Scene(StaffParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sc);
        window.show();
    }
    
    
}
