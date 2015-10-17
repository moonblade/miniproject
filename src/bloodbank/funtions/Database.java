/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank.funtions;

import bloodbank.GlobalVariables;
import bloodbank.models.Donor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author moonblade
 */
public class Database {

    ArrayList<Donor> donorList = new ArrayList<Donor>();
    Connection conn = null;

    public boolean login(String username, String password) throws ClassNotFoundException {
        String loginQuery = "select * from donor where email = '" + username + "' and password = '" + password + "';";
        try {
            Class.forName(GlobalVariables.registerDriver);
            conn = DriverManager.getConnection(GlobalVariables.connection);
            if (GlobalVariables.MODE == 1) {
                conn.setCatalog("test");
            }
            Statement statement = conn.createStatement();

            ResultSet r = statement.executeQuery(loginQuery);
            ResultSetMetaData m = r.getMetaData();
            int id = 0;
            while (r.next()) {
                id = Integer.parseInt(r.getString("id"));
                GlobalVariables.me = new Donor(r);
            }
            if (id > 0) {
                System.out.println("Login Successful");
                return true;
            } else {
                System.out.println("Login Unsuccessful");
                GlobalVariables.me = new Donor();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("SqlError while retrieving");
        } catch (NullPointerException n) {
            System.out.println("Null Pointer Error while retrieving");
        }
        return false;
    }

    public ArrayList<Donor> getDonor(String bg) throws ClassNotFoundException {
        String sqlQuery = "select * from donor where bloodgroup like '%" + bg + "%';";
        try {
            Class.forName(GlobalVariables.registerDriver);
            conn = DriverManager.getConnection(GlobalVariables.connection);
            Statement statement = conn.createStatement();

            ResultSet r = statement.executeQuery(sqlQuery);
            ResultSetMetaData m = r.getMetaData();
            int noOfColumns = m.getColumnCount();
            try {
                while (r.next()) {
                    donorList.add(new Donor(r));
                }
            } catch (SQLException e) {
                System.out.println("SqlError while retrieving");
            } catch (NullPointerException n) {
                System.out.println("Null Pointer Error while retrieving");
            }
	} catch (SQLException e) {
            System.out.println("Exception SQL");
        }
        return donorList;
    }

    public boolean addDonor(Donor donor) throws ClassNotFoundException {
        String sqlQuery = "insert into donor(name,email,password,bloodgroup,mobile) values('" + donor.name + "','" + donor.email + "','" + donor.password + "','" + donor.bloodgroup + "','" + donor.mobile + "')";
        try {
            Class.forName(GlobalVariables.registerDriver);
            conn = DriverManager.getConnection(GlobalVariables.connection);
            Statement statement = conn.createStatement();

            int m = statement.executeUpdate(sqlQuery);
            if (m > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("SqlError while retrieving");
        } catch (NullPointerException n) {
            System.out.println("Null Pointer Error while retrieving");
        }
	return false;
    }

    public boolean editDonor(Donor donor) throws ClassNotFoundException {
        String sqlQuery = "update donor set name='"+donor.name + "', email = '" + donor.email + "', password='" + donor.password + "',bloodgroup='" + donor.bloodgroup + "',mobile='" + donor.mobile + "' where id="+donor.id;
        try {
            Class.forName(GlobalVariables.registerDriver);
            conn = DriverManager.getConnection(GlobalVariables.connection);
            Statement statement = conn.createStatement();

            int m = statement.executeUpdate(sqlQuery);
            if (m > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("SqlError while retrieving");
        } catch (NullPointerException n) {
            System.out.println("Null Pointer Error while retrieving");
        }
	return false;
    }
}
