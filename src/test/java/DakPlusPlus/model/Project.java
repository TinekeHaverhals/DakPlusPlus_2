package DakPlusPlus.model;

import java.util.Date;

/**
 * Tineke Haverhals
 * 9/07/20.
 */
public class Project {
    private int ProjectId;
    private Date BeginDate;
    private String Description;
    private float Price;
    private Date EndDate;

    @Override
    public String toString() {
        return "Project{" +
                " ProjectId=" + ProjectId +
                ", BeginDate=" + BeginDate +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", EndDate=" + EndDate +
                '}';
    }

    public int getProjectId() {
        return ProjectId;
    }

    public Project setProjectId(int ProjectId) {
        this.ProjectId = ProjectId;
        return this;
    }

    public Date getBeginDate() {
        return BeginDate;
    }

    public Project setBeginDate(Date beginDate) {
        this.BeginDate = beginDate;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public Project setDescription(String description) {
        this.Description = description;
        return this;
    }

    public float getPrice() {
        return Price;
    }

    public Project setPrice(float price) {
        this.Price = price;
        return this;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public Project setEndDate(Date endDate) {
        this.EndDate = endDate;
        return this;
    }


    public String getSingleLine() {
        return "Project{" +
                "Projectid=" + ProjectId +
                ", BeginDate='" + BeginDate + '\'' +
                ", Description=" + Description + '\'' +
                ", Price=" + Price +
                ", Enddate=" + EndDate +
                '}';
    }
}