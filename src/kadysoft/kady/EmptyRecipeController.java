/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class EmptyRecipeController implements Initializable {

    Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
    
    @FXML
    private JFXButton browse;

    @FXML
    private JFXTextField output,name;

    @FXML
    private JFXButton create;

    @FXML
    void browseaction(ActionEvent event) {

    DirectoryChooser fcho = new DirectoryChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.setTitle("Kady Choose");
    File f = fcho.showDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    output.setText(pathy);
        
    }

    @FXML
    void createaction(ActionEvent event) throws IOException {

        String out=output.getText();
        String namy=name.getText();
        
        String fullpath=out+"\\"+namy+".ks";
        
        String code="<!DOCTYPE html>\n" +
"<html lang=\"ar\">\n" +
"<head>\n" +
"<title>Kadysoft</title>\n" +
"<meta charset=\"UTF-8\">\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"<style>td {\n" +
"height:5px;\n" +
"max-width:100%;\n" +
"white-space:nowrap;\n" +
"}\n" +
"table {\n" +
"height:5px;\n" +
"max-width:100%;\n" +
"height:100%;\n" +
"white-space:nowrap;\n" +
"}\n" +
"tr {\n" +
"height:5px;\n" +
"max-width:100%;\n" +
"white-space:nowrap;\n" +
"}</style></head>\n" +
"<body>\n" +
"<center><center><!-- Creating Recipe From Kadysoft Ltd.--></center></center><meta charset=\"UTF-8\" /><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
"<style>td {height:5px;max-width:100%;white-space:nowrap;}table {height:5px;max-width:100%;height:100%;white-space:nowrap;}tr {height:5px;max-width:100%;white-space:nowrap;}</style>\n" +
"<center><center><!-- Creating Recipe From Kadysoft Ltd.-->\n" +
"<table id=\"exTable\" style=\"height: 648px; width: 956px;\" border=\"1\" cellspacing=\"0\">\n" +
"<tbody>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td class=\"\" style=\"height: 18px; width: 100.047px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 100.203px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 111.172px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 126.266px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\"><strong>/2024</strong></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 70.25px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 99.1719px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 109.016px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 0px;\" align=\"center\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td class=\"\" style=\"height: 18px; width: 100.047px; border-style: dotted;\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 100.203px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 111.172px; border-style: dotted;\" align=\"center\"><b>RECEPI</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 126.266px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 70.25px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 99.1719px; border-style: dotted;\" align=\"center\"><b>DATE:</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\"><strong>/2024</strong></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 109.016px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 0px;\" align=\"center\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td class=\"\" style=\"height: 18px; width: 100.047px; border-style: dotted;\" bgcolor=\"#ffff00\"><strong>Cust :</strong></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 100.203px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 111.172px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 126.266px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 70.25px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 99.1719px; border-style: dotted;\" align=\"center\"><b>Wash Name:</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 109.016px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 0px;\" align=\"center\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td class=\"\" style=\"height: 18px; width: 100.047px; border-style: dotted;\" bgcolor=\"#ffff00\"><strong>PO No :</strong></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 100.203px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 111.172px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 126.266px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 70.25px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 99.1719px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 109.016px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 0px;\" align=\"center\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td class=\"\" style=\"height: 18px; width: 100.047px; border-style: dotted;\" bgcolor=\"#ffff00\"><strong>Po Amount :</strong></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 100.203px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 111.172px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 126.266px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 70.25px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 99.1719px; border-style: dotted;\" align=\"center\"><b>KG :</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 109.016px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 0px;\" align=\"center\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td class=\"\" style=\"height: 18px; width: 100.047px; border-style: dotted;\" bgcolor=\"#ffff00\"><strong>Style Name ;</strong></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 100.203px; border-style: dotted;\" align=\"center\"><b>112352344</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 111.172px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 126.266px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 70.25px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 99.1719px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 109.016px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 0px;\" align=\"center\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td class=\"\" style=\"height: 18px; width: 100.047px; border-style: dotted;\" bgcolor=\"#ffff00\"><strong>Mechine No</strong></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 100.203px; border-style: dotted;\" align=\"center\"><b>Operator</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 111.172px; border-style: dotted;\" align=\"center\"><b>Spining No</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 126.266px; border-style: dotted;\" align=\"center\"><b>Operator</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\"><b>Dryer No</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 70.25px; border-style: dotted;\" align=\"center\"><b>Operator</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 99.1719px; border-style: dotted;\" align=\"center\"><b>PCS :</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 109.016px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 0px;\" align=\"center\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td class=\"\" style=\"height: 18px; width: 100.047px; border-style: dotted;\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 100.203px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 111.172px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 126.266px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 70.25px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 99.1719px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 109.016px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 0px;\" align=\"center\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td class=\"\" style=\"height: 18px; width: 100.047px; border-style: dotted;\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 100.203px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 111.172px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 126.266px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 70.25px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 99.1719px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 109.016px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 0px;\" align=\"center\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td class=\"\" style=\"height: 18px; width: 100.047px; border-style: dotted;\" bgcolor=\"#ffff00\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 100.203px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 111.172px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 126.266px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 70.25px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 99.1719px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 109.016px; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 0px;\" align=\"center\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td class=\"\" style=\"height: 18px; width: 100.047px; border-style: dotted;\" bgcolor=\"#ffff00\"><strong>Action NO</strong></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 100.203px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\"><b>Action NAME</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 111.172px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\"><b>Time(min)</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 126.266px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\"><b>Temp</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\"><b>Liter'S</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 70.25px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\"><b>Amt</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 99.1719px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\"><b>Unit's</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 98.9375px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\"><b>Chemical</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 109.016px; border-style: dotted;\" align=\"center\" bgcolor=\"#ffff00\"><b>Chemical sign</b></td>\n" +
"<td class=\"\" style=\"height: 18px; width: 0px;\" align=\"center\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td style=\"height: 18px; width: 100.047px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 100.203px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 111.172px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 126.266px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 98.9375px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 70.25px; text-align: center; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td class=\"\" style=\"height: 18px; width: 99.1719px; text-align: center; border-style: dotted;\" align=\"center\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 98.9375px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 109.016px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 0px;\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td style=\"height: 18px; width: 100.047px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 100.203px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 111.172px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 126.266px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 98.9375px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 70.25px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 99.1719px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 98.9375px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 109.016px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"height: 18px; width: 0px;\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td style=\"width: 100.047px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 100.203px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 111.172px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 126.266px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 98.9375px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 70.25px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 99.1719px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 98.9375px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 109.016px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 0px;\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td style=\"width: 100.047px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 100.203px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 111.172px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 126.266px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 98.9375px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 70.25px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 99.1719px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 98.9375px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 109.016px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 0px;\">&nbsp;</td>\n" +
"</tr>\n" +
"<tr style=\"height: 18px;\">\n" +
"<td style=\"width: 100.047px; height: 18px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 100.203px; height: 18px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 111.172px; height: 18px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 126.266px; height: 18px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 98.9375px; height: 18px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 70.25px; height: 18px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 99.1719px; height: 18px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 98.9375px; height: 18px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 109.016px; height: 18px; text-align: center; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 0px; height: 18px;\">&nbsp;</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</center></center>\n" +
"</body></html><style>body {  background-image: url(\".bmp\"); background-position: center; height: 170px; background-position-x:550px; background-repeat: no-repeat; background-size: 120px 90px;}</style>\n" +
"\n" +
"\n" +
"</center>\n" +
"</body>\n" +
"</html>";
            
        
        File f1=new File (fullpath);
        f1.createNewFile();
        
        PrintWriter pw=new PrintWriter (new BufferedWriter (new FileWriter (f1)));
        
        pw.println(code);
        
        
        
        
        
        
        
        //Noti
        
        
              Notifications noti = Notifications.create();
              noti.title("Sccessful!");
              noti.text("We have created the recipe successfully.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showInformation();
              
              
              //Close
              
              Stage jk = (Stage)this.output.getScene().getWindow();
              jk.close();
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        conn = db.java_db();
        
        
    }    
    
}
