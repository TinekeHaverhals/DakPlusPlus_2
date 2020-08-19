package DakPlusPlus.data;

import DakPlusPlus.model.Project;
import DakPlusPlus.model.WorkDone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Tineke Haverhals
 * 9/07/20.
 */
public class WorkDoneDAO {
    public static List<WorkDone> getAllWorkDone() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM WorkDone");

        return parseWorkDone(rs);

    }

    private static List<WorkDone> parseWorkDone(ResultSet rs) throws SQLException {
        List<WorkDone> result = new ArrayList<>();
        while (rs.next()) {
            WorkDone WorkDone = new WorkDone();

            WorkDone.setEmployeeId(rs.getInt("EmployeeId"));
            WorkDone.setProjectId(rs.getInt("ProjectId"));
            WorkDone.setWorkDate(rs.getDate("WorkDate"));
            WorkDone.setHoursWorked(rs.getInt("HoursWorked"));
            WorkDone.setRemarks(rs.getString("Remarks"));

            result.add(WorkDone);
        }
        return result;
    }

    private static List<WorkDone> parseTop(ResultSet rs) throws SQLException {
        List<WorkDone> result = new ArrayList<>();
        while (rs.next()) {
            WorkDone WorkDone = new WorkDone();

            WorkDone.setEmployeeId(rs.getInt("EmployeeId"));

            result.add(WorkDone);
        }
        return result;
    }

    private static List<WorkDone> parseWorkDoneEmployeeId(ResultSet rs) throws SQLException {
        List<WorkDone> result = new ArrayList<>();
        while (rs.next()) {
            WorkDone WorkDone = new WorkDone();

            WorkDone.setEmployeeId(rs.getInt("EmployeeId"));
            WorkDone.setHoursWorked(rs.getInt("HoursWorked"));

            result.add(WorkDone);
        }
        return result;
    }

    public List<WorkDone> getHoursWorkedById(int ProjectId) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement("SELECT * From WorkDone Where ProjectId = ?");
        statement.setInt(1, ProjectId);

        ResultSet rs = statement.executeQuery();

        return parseWorkDone(rs);
    }

    public List<WorkDone> getDeleteWorkDone(int ProjectId, int EmployeeId) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement("DELETE FROM WorkDone Where ProjectId = ? AND EmployeeId = ?;");
        statement.setInt(1, ProjectId);
        statement.setInt(2, EmployeeId);

        int rs = statement.executeUpdate();

        return null;
    }

    public List<WorkDone> getAddWorkDone(int EmployeeId, int ProjectId, int WorkDate, int HoursWorked, String Remarks) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement("INSERT INTO WorkDone VALUES (? , ?, ?, ? , ?)");
        statement.setInt(1, EmployeeId);
        statement.setInt(2, ProjectId);
        statement.setInt(3, WorkDate);
        statement.setInt(4, HoursWorked);
        statement.setString(5, Remarks);

        int rs = statement.executeUpdate();

        return null;
    }

    public List<WorkDone> getProjectHoursWorked(int employeeId) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT EmployeeId, HoursWorked FROM WorkDone WHERE EmployeeId = ?");
        statement.setInt(1, employeeId);

        ResultSet rs = statement.executeQuery();

        return parseWorkDoneEmployeeId(rs);
    }

    public List<WorkDone> getTop3(int ProjectId) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement("SELECT EmployeeID, COUNT(HoursWorked)AS TotalHoursWorked FROM WorkDone WHERE ProjectId = ? GROUP BY EmployeeID ORDER BY TotalHoursWorked DESC LIMIT 3;");
        statement.setInt(1, ProjectId);

        ResultSet rs = statement.executeQuery();

        return parseTop(rs);
    }
}

