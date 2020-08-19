package DakPlusPlus.services;

import DakPlusPlus.data.NonUniqueResultException;
import DakPlusPlus.data.ProjectDAO;
import DakPlusPlus.data.StaffDAO;
import DakPlusPlus.data.WorkDoneDAO;
import DakPlusPlus.model.Project;
import DakPlusPlus.model.Staff;
import DakPlusPlus.model.WorkDone;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Tineke Haverhals
 * 9/07/20.
 */
public class DakService {
    private StaffDAO staffDAO = new StaffDAO();
    private ProjectDAO projectDAO = new ProjectDAO();
    private WorkDoneDAO workDoneDAO = new WorkDoneDAO();


    public List<Staff> getAllStaffs() throws SQLException {
        return staffDAO.getAllStaffs();
    }

    public List<Staff> getInfoByFirstName(String FirstName) throws SQLException {
        return staffDAO.getInfoByFirstName(FirstName);
    }

    public List<Staff> getInfoByLastName(String LastName) throws SQLException {
        return staffDAO.getInfoByLastName(LastName);
    }

    public List<Project> getAllProjects() throws SQLException {
        return projectDAO.getAllProjects();
    }

    public static Optional<Project> getProjectById(int id) throws SQLException, NonUniqueResultException {
        Optional<Project> optionalProject = ProjectDAO.getProjectById(id);

        if (!optionalProject.isPresent()) return optionalProject;
        else {
            Project project = optionalProject.get();

            return optionalProject;
        }
    }

    public List<Project> getProjectPriceById(int projectId) throws SQLException {
        return projectDAO.getProjectPriceById(projectId);
    }

    public List<Staff> getAddStaff(String FirstName, String LastName, int PhoneNumber, int ICE, int DateOfBirth, int Salary) throws Exception {
        return staffDAO.getAddStaff(FirstName, LastName, PhoneNumber, ICE, DateOfBirth, Salary);
    }

    public List<Project> getAddProject(int BeginDate, String description, int price, int EndDate) throws SQLException {
        return ProjectDAO.getAddProject(BeginDate, description, price, EndDate);
    }

    public List<Staff> getDeleteStaff(int StaffId) throws SQLException {
        return staffDAO.getDeleteStaff(StaffId);
    }

    public List<Project> getDeleteProject(int ProjectId) throws SQLException {
        return projectDAO.getDeleteProject(ProjectId);
    }

    public List<WorkDone> getHoursWorkedById(int EmployeeId) throws SQLException {
        return workDoneDAO.getHoursWorkedById(EmployeeId);
    }

    public List<WorkDone> getDeleteWorkDone(int ProjectId, int EmployeeId) throws SQLException {
        return workDoneDAO.getDeleteWorkDone(ProjectId, EmployeeId);
    }

    public List<WorkDone> getAddWorkDone(int EmployeeId, int ProjectId, int WorkDate, int HoursWorked, String Remarks) throws SQLException {
        return workDoneDAO.getAddWorkDone(EmployeeId, ProjectId, WorkDate, HoursWorked, Remarks);
    }

    public List<Staff> getChangestaff(String columnName, String value, int staffId) throws SQLException {
        return staffDAO.getChangestaff(columnName, value, staffId);
    }

    public List<Staff> getBirthdayToday() throws SQLException {
        return staffDAO.getBirthdayToday();
    }

    public List<Staff> getBirthdayThisWeek() throws SQLException {
        return staffDAO.getBirthdayThisWeek();
    }

    public List<Project> getAllProjectsToday() throws SQLException {
        return projectDAO.getAllProjectsToday();
    }

    public List<Project> getAllProjectsProgress() throws SQLException{
        return projectDAO.getAllProjectsProgress();
    }

    public List<WorkDone> getProjectHoursWorked(int projectId) throws SQLException {
        return workDoneDAO.getProjectHoursWorked(projectId);
    }

    public List<WorkDone> getTop3(int projectId) throws SQLException {
        return workDoneDAO.getTop3(projectId);
    }
}