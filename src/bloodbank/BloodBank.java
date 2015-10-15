/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank;

/**
 *
 * @author moonblade
 */
import bloodbank.models.Donor;
import bloodbank.funtions.GetDonors;
import bloodbank.views.MainScreen;
import java.awt.Dimension;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BloodBank {

    private static String bloodGroup = "a+";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
    }

    private static void mainScreen(){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        JButton b = new JButton("Search");
        b.setSize(40,40);
        mainPanel.add(b);

        f.add(mainPanel);
        f.setSize(500, 500);
        f.setVisible(true);
        GetDonors getDonors = new GetDonors();
        try
        {
            ArrayList<Donor> donorList = getDonors.getDonor(bloodGroup);
        }catch(ClassNotFoundException e){
            
        }
    }

}
