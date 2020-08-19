package DakPlusPlus.data;

import DakPlusPlus.model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Tineke Haverhals
 * 9/07/20.
 */
public class StaffDAO {

    public List<Staff> getAllStaffs() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Staff");

        return parseStaff(rs);
    }

    public List<Staff> getInfoByFirstName(String FirstName) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement("SELECT * From Staff Where FirstName = ?");
        statement.setString(1, FirstName);

        ResultSet rs = statement.executeQuery();

        return parseStaff(rs);
    }

    public List<Staff> getInfoByLastName(String LastName) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement("SELECT * From Staff Where LastName = ?");
        statement.setString(1, LastName);

        ResultSet rs = statement.executeQuery();

        return parseStaff(rs);

    }

    public List<Staff> getDeleteStaff(int StaffId) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement("DELETE FROM Staff Where Id = ?");
        statement.setInt(1, StaffId);

        int rs = statement.executeUpdate();

        return null;
    }

    public List<Staff> getAddStaff(String FirstName, String LastName, int PhoneNumber, int ICE, int DateOfBirth, int Salary) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement("INSERT INTO Staff VALUES (Null, ? , ?, ?, ? , ? ,? )");
        statement.setString(1, FirstName);
        statement.setString(2, LastName);
        statement.setInt(3, PhoneNumber);
        statement.setInt(4, ICE);
        statement.setInt(5,  DateOfBirth);
        statement.setInt(6, Salary);

        int rs = statement.executeUpdate();

        return null;
    }

    public List<Staff> getChangestaff(String columnName, String value, int staffId) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement("UPDATE Staff SET ? = ? WHERE id = ? ");
        statement.setString(1, columnName);
        statement.setString(2, value);
        statement.setInt(3, staffId);

        int rs = statement.executeUpdate();

        return null;

    }

    public List<Staff> getBirthdayToday() throws SQLException{
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Staff WHERE DateOfBirth =cast(current_timestamp as date);");

        return parseStaff(rs);
    }

    public List<Staff> getBirthdayThisWeek() throws SQLException{
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Staff WHERE DateOfBirth >=cast(current_timestamp AS date) AND DateOfBirth <date_add(cast(current_timestamp AS date),interval 7 day);");

        return parseStaff(rs);
    }

    private static List<Staff> parseStaff(ResultSet rs) throws SQLException {
        List<Staff> result = new ArrayList<>();
        while (rs.next()) {
            Staff staff = new Staff();

            staff.setStaffId(rs.getInt("Id"));
            staff.setFirstName(rs.getString("FirstName"));
            staff.setLastName(rs.getString("LastName"));
            staff.setPhoneNumber(rs.getInt("PhoneNumber"));
            staff.setICE(rs.getInt("ICE"));
            staff.setDateBirth(rs.getDate("DateOfBirth"));
            staff.setSalary(rs.getInt("Salary"));

            result.add(staff);
        }
        return result;
    }
}