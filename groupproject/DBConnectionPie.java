/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
//Made By Dylan Cunha Mota
 */
package groupproject;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author dylanmota
 */
public class DBConnectionPie {
     private static Connection con;
     public Statement st;

    
    public void connect(){
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:Pie.db");
            st = con.createStatement();
            System.out.println("Connection is successful");
            
            Statement statment = con.createStatement();
            ResultSet resultSet = statment.executeQuery("select * from data");
            DefaultPieDataset dataset = new DefaultPieDataset();
            
            while (resultSet.next()) {
                dataset.setValue(
                       resultSet.getString("Type Of Role"),
                       Double.parseDouble(resultSet.getString("Total")));
                       
            }
            
            JFreeChart chart = ChartFactory.createPieChart(
                        "Total Of Type of Roles",
                        dataset,
                        true,
                        true,
                        false);
            
            int width = 560;
            int height = 370;
            
            File pieChart = new File ("PieChart.jpeg");
            ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
                        
     
           
        }catch (Exception e){
            System.out.println("Connection failed");
            System.out.println(e.getClass().getName() + "i" + e.getMessage() );
            System.exit(0);
        }
      }
    
    public static void main(String[] args) {
        DBConnectionPie obj = new DBConnectionPie();
        obj.connect();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new RoleType().setVisible(true);
            }
    });
        
    }
        
    }
    

