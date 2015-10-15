/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank.funtions;

import bloodbank.GlobalConstants;
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
public class GetDonors {

    ArrayList<Donor> donorList = new ArrayList<Donor>();
    Connection conn = null;

    public ArrayList<Donor> getDonor(String bg) throws ClassNotFoundException {
        String sqlQuery = "select * from donor where bloodgroup like '%" + bg + "%';";
        try {
            Class.forName(GlobalConstants.registerDriver);
            conn = DriverManager.getConnection(GlobalConstants.connection);
            if (GlobalConstants.MODE == 1) {
                conn.setCatalog("test");
            }
            Statement statement = conn.createStatement();

            ResultSet r = statement.executeQuery(sqlQuery);
            ResultSetMetaData m = r.getMetaData();
            int noOfColumns = m.getColumnCount();
            try {
                while (r.next()) {
//                    System.out.println(r.getObject(1).toString());
//                    Donor d = new Donor(r);
//                    d.print();
                      donorList.add(new Donor(r));
                }
            } catch (SQLException e) {
                System.out.println("SqlError while retrieving");
            } catch (NullPointerException n) {
                System.out.println("Null Pointer Error while retrieving");
            }
			// statement.executeUpdate("create table test(id int primary key);");

            // statement.executeUpdate("create table donor(id int primary key, name varchar2(30), email ")
        } catch (SQLException e) {
            System.out.println("Exception SQL");
        }
        return donorList;
    }
}
