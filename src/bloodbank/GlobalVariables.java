/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank;

import bloodbank.models.Donor;

/**
 *
 * @author moonblade
 */
public class GlobalVariables {
    public static int MODE = 1;
    public static String connection="jdbc:mysql://localhost:3306/test?user=root&password=root";
//    public static String connection="jdbc:mysql://localhost:3306/test?user=root&password=root";
    public static String registerDriver="com.mysql.jdbc.Driver";
//    public static String registerDriver="com.mysql.jdbc.Driver";
    public static String col[] = {"Id","Name","email","bloodgroup","mobile"};   
    public static String requestCol[] = {"Name","Mobile"};   
    public static String historyCol[] = {"Name","Date"};   
    
    public static Donor me = new Donor();
    public static int request=0;
    public static int defaultStatus=0;
    public static String nameAccept;
    public static String dateString;
}
