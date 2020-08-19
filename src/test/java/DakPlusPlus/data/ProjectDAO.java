package DakPlusPlus.data;

import DakPlusPlus.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Tineke Haverhals
 * 9/07/20.
 */
public class ProjectDAO {

    public List<Project> getAllProjects() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Project");

        return parseProject(rs);
    }

    private static List<Project> parseProject(ResultSet rs) throws SQLException {
        List<Project> result = new ArrayList<>();
        while (rs.next()) {
            Project project = new Project();

            project.setProjectId(rs.getInt("Id"));
            project.setBeginDate(rs.getDate("BeginDate"));
            project.setDescription(rs.getString("Description"));
            project.setPrice(rs.getInt("Price"));
            project.setEndDate(rs.getDate("EndDate"));

            result.add(project);
        }
        return result;
    }

    private static List<Project> parseProjectPrice(ResultSet rsP) throws SQLException {
        List<Project> resultPrice = new ArrayList<>();
        while (rsP.next()) {
            Project project = new Project();

            project.setProjectId(rsP.getInt("Id"));
            project.setPrice(rsP.getInt("Price"));

            resultPrice.add(project);
        }
        return resultPrice;
    }

    public static Optional<Project> getProjectById(int EmployeeId) throws SQLException, NonUniqueResultException {
        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM Project WHERE Id = ?");
        statement.setInt(1, EmployeeId);

        ResultSet rs = statement.executeQuery();
        List<Project> projects = parseProject(rs);

        if (projects.size() == 0) return Optional.empty();
        if (projects.size() == 1) return Optional.of(projects.get(0));

        throw new NonUniqueResultException("Found multiple results for id: " + EmployeeId);
    }

    public  List<Project> getProjectPriceById(int ProjectId) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT Id, Price FROM Project WHERE Id = ?");
        statement.setInt(1, ProjectId);

        ResultSet rs = statement.executeQuery();

        return parseProjectPrice(rs);
    }

    public List<Project> getDeleteProject(int ProjectId) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement("DELETE FROM Project Where Id = ?");
        statement.setInt(1, ProjectId);

        int rs = statement.executeUpdate();

        return null;
    }

    public static List<Project> getAddProject(int BeginDate, String Description, int Price, int EndDate) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement("INSERT INTO Project VALUES (Null, ? , ?, ?, ? )");
        statement.setInt(1, BeginDate);
        statement.setString(2, Description);
        statement.setInt(3, Price);
        statement.setInt(4, EndDate);

        int rs = statement.executeUpdate();

        return null;

    }

    public List<Project> getAllProjectsToday() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Project WHERE BeginDate = CURRENT_DATE;");

        return parseProject(rs);
    }

    public List<Project> getAllProjectsProgress() throws SQLException{
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Project WHERE CURRENT_DATE BETWEEN BeginDate AND EndDate;");

        return parseProject(rs);
    }
}
