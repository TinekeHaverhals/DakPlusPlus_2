package DakPlusPlus.model;

import java.util.Date;

/**
 * Tineke Haverhals
 * 9/07/20.
 */
public class WorkDone {

    private int EmployeeId;
    private int ProjectId;
    private Date WorkDate;
    private int HoursWorked;
    private String Remarks;
    private Project project;
    private Staff staff;

    @Override
    public String toString() {
        return "WorkDone{" +
                "EmployeeId=" + EmployeeId +
                ", ProjectId=" + ProjectId +
                ", WorkDate=" + WorkDate +
                ", HoursWorked=" + HoursWorked +
                ", Remarks='" + Remarks +
                '}';
    }

    public String getSingleLine() {
        return "WorkDone{" +
                "EmployeeId=" + EmployeeId +
                ", ProjectId=" + ProjectId +
                ", WorkDate=" + WorkDate +
                ", HoursWorked=" + HoursWorked +
                ", Remarks='" + Remarks +
                '}';
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public WorkDone setEmployeeId(int employeeId) {
        this.EmployeeId = employeeId;
        return this;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public WorkDone setProjectId(int projectId) {
        this.ProjectId = projectId;
        return this;
    }

    public Date getWorkDate() {
        return WorkDate;
    }

    public WorkDone setWorkDate(Date workDate) {
        this.WorkDate = workDate;
        return this;
    }

    public int getHoursWorked() {
        return HoursWorked;
    }

    public WorkDone setHoursWorked(int hoursWorked) {
        this.HoursWorked = hoursWorked;
        return this;
    }

    public String getRemarks() {
        return Remarks;
    }

    public WorkDone setRemarks(String remarks) {
        this.Remarks = remarks;
        return this;
    }

    public Project getProject() {
        return project;
    }

    public WorkDone setProject(Project project) {
        this.project = project;
        return this;
    }

    public Staff getStaff() {
        return staff;
    }

    public WorkDone setStaff(Staff staff) {
        this.staff = staff;
        return this;
    }
}
