package DakPlusPlus;

import DakPlusPlus.data.NonUniqueResultException;
import DakPlusPlus.model.Project;
import DakPlusPlus.model.Staff;
import DakPlusPlus.model.WorkDone;
import DakPlusPlus.services.DakService;
import java.sql.SQLException;
import java.util.*;

/**
 * Tineke Haverhals
 * 9/07/20.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int mainChoice;
        int subChoice = -1;

        do {
            showMenu();
            mainChoice = requestIntInput(0, 4);

            if (mainChoice != 0) {
                showSubMenu(mainChoice);
                subChoice = requestIntInput(0, 8);

                handleUserChoice(mainChoice, subChoice);
            }
        } while (mainChoice != 0 && subChoice != 0);
    }

    private static void handleUserChoice(int mainChoice, int subChoice) throws Exception {
        if (mainChoice == 1) {
            DakService dakService = new DakService();

            if (subChoice == 1) {
                List<Staff> staffs = null;
                try {
                    staffs = dakService.getAllStaffs();
                    staffs.forEach(b -> System.out.println(b.getSingleLine()));
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

            if (subChoice == 2) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("enter the column name you want to change ");
                String columnName = scanner.next();
                System.out.println("enter the Value ");
                String value = scanner.next();
                System.out.println("enter a staffId ");
                int staffId = scanner.nextInt();

                scanner.nextLine();
                try {
                    List<Staff> staff = dakService.getChangestaff(columnName, value, staffId);
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

            if (subChoice == 3) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a firstName");
                String FirstName = scanner.next();
                System.out.println("Enter a lastName");
                String LastName = scanner.next();
                System.out.println("Enter a PhoneNumber");
                int PhoneNumber = scanner.nextInt();
                System.out.println("Enter a Ice");
                int ICE = scanner.nextInt();
                System.out.println("Enter a dateofbirth YYYY-MM-DD");
                int DateOfBirth = scanner.nextInt();
                System.out.println("Enter a salary");
                int Salary = scanner.nextInt();

                scanner.nextLine();
                try {
                    List<Staff> staff = dakService.getAddStaff(FirstName,  LastName, PhoneNumber,  ICE,  DateOfBirth,  Salary);
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

            if (subChoice == 4) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter an Id");
                int StaffId = scanner.nextInt();
                scanner.nextLine();
                try {
                    List<Staff> staff = dakService.getDeleteStaff(StaffId);
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

            if (subChoice == 5) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a firstName");
                String FirstName = scanner.next();
                scanner.nextLine();
                try {
                    List<Staff> staff = dakService.getInfoByFirstName(FirstName);
                    staff.forEach(b -> System.out.println(b.getSingleLine()));
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

            if (subChoice == 6) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a lastName");
                String LastName = scanner.next();
                scanner.nextLine();
                try {
                    List<Staff> staff = dakService.getInfoByLastName(LastName);
                    staff.forEach(b -> System.out.println(b.getSingleLine()));
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

            if (subChoice == 7) {
                List<Staff> staffs = null;
                try {
                    staffs = dakService.getBirthdayToday();
                    staffs.forEach(b -> System.out.println(b.getSingleLine()));
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

            if (subChoice == 8) {
                List<Staff> staffs = null;
                try {
                    staffs = dakService.getBirthdayThisWeek();
                    staffs.forEach(b -> System.out.println(b.getSingleLine()));
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

        }
        if (mainChoice == 2) {
            DakService dakService = new DakService();

            if (subChoice == 1) {
                List<Project> projects = null;
                try {
                    projects = dakService.getAllProjects();
                    projects.forEach(b -> System.out.println(b.getSingleLine()));
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

            if (subChoice == 2) {
                System.out.println("Please enter id of Project: ");
                int id = requestIntInput(1, Integer.MAX_VALUE);

                Optional<Project> optionalProject = null;
                try {
                    optionalProject = DakService.getProjectById(id);
                } catch (SQLException ignored) {
                    System.out.println("Problems with database");
                } catch (NonUniqueResultException e) {
                    System.out.println(e.getMessage());
                }
                if (optionalProject.isPresent()) {
                    System.out.println(optionalProject.get().toString());
                } else {
                    System.out.println("Project with id: " + id + " was not found in database.");
                }
            }

            if (subChoice == 3) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a Begindate");
                int BeginDate = scanner.nextInt();
                System.out.println("Enter a Description");
                String Description = scanner.next();
                System.out.println("Enter a price");
                int Price = scanner.nextInt();
                System.out.println("Enter a Enddate");
                int EndDate = scanner.nextInt();

                scanner.nextLine();
                try {
                    List<Project> project = dakService.getAddProject(BeginDate,  Description, Price,  EndDate );
                } catch (SQLException ignored) {
                    //System.out.println("Problems with database");
                    ignored.printStackTrace();
                }
            }

            if (subChoice == 4) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter an ProjectId");
                int ProjectId = scanner.nextInt();
                scanner.nextLine();
                try {
                    List<Project> project = dakService.getDeleteProject(ProjectId);
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

            if (subChoice == 5) {
                List<Project> project = null;
                try {
                    project = dakService.getAllProjectsProgress();
                    project.forEach(b -> System.out.println(b.getSingleLine()));
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }


            if (subChoice == 6) {
                List<Project> project = null;
                try {
                    project = dakService.getAllProjectsToday();
                    project.forEach(b -> System.out.println(b.getSingleLine()));
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }
        }

        if (mainChoice == 3) {
            DakService dakService = new DakService();

            if (subChoice == 1) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a projectId");
                int EmployeeId = scanner.nextInt();
                scanner.nextLine();
                try {
                    List<WorkDone> workDone = dakService.getHoursWorkedById(EmployeeId);
                    workDone.forEach(b -> System.out.println(b.getSingleLine()));
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

            if (subChoice == 2){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter an EmployeeId");
                int EmployeeId = scanner.nextInt();
                System.out.println("Enter a ProjectId ");
                int ProjectId = scanner.nextInt();
                System.out.println("Enter a WorkDate");
                int WorkDate = scanner.nextInt();
                System.out.println("Enter a HoursWorked");
                int HoursWorked = scanner.nextInt();
                System.out.println("Enter a Remarks");
                String Remarks = scanner.next();

                scanner.nextLine();
                try {
                    List<WorkDone> workdone = dakService.getAddWorkDone(EmployeeId, ProjectId, WorkDate,  HoursWorked, Remarks );
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

            if (subChoice == 3) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter an ProjectId");
                int ProjectId = scanner.nextInt();
                System.out.println("Enter an EmployeeId");
                int EmployeeId = scanner.nextInt();
                scanner.nextLine();
                try {
                    List<WorkDone> workdone = dakService.getDeleteWorkDone(ProjectId, EmployeeId);
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }
        }

        if (mainChoice == 4) {
            DakService dakService = new DakService();

            if (subChoice == 1) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a projectId");
                int projectId = scanner.nextInt();
                scanner.nextLine();
                try {
                    List<Project> project = dakService.getProjectPriceById(projectId);
                    project.forEach(b -> System.out.println(b.getSingleLine()));
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }
            if (subChoice == 2) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter an projectId");
                int EmployeeId = scanner.nextInt();
                scanner.nextLine();
                try {
                    List<WorkDone> project = dakService.getProjectHoursWorked(EmployeeId);
                    project.forEach(b -> System.out.println(b.getSingleLine()));
                } catch (SQLException throwables) {
                    System.out.println("Problems with database");
                }
            }

            if (subChoice == 3){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a projectId");
                int projectId = scanner.nextInt();
                scanner.nextLine();
                try {
                    List<WorkDone> workdone = dakService.getTop3(projectId);
                    workdone.forEach(b -> System.out.println(b.getSingleLine()));
                } catch (SQLException ignored) {
                    //System.out.println("Problems with database");
                    ignored.printStackTrace();
                }
            }
        }
    }

    private static void showMenu() {
        System.out.println("0. Exit");
        System.out.println("1. Staff");
        System.out.println("2. Projects");
        System.out.println("3. WorkDone");
        System.out.println("4. profitability");
    }

    private static void showSubMenu(int choice) {
        if (choice == 1) {
            System.out.println("0. Exit");
            System.out.println("1. Show all Staff");
            System.out.println("2. change a staff");
            System.out.println("3. Create a new staff");
            System.out.println("4. Delete a staff By Id");
            System.out.println("5. Information by FirstName");
            System.out.println("6. information by lastName");
            System.out.println("7. Birthday today!");
            System.out.println("8. birthday this week");
        }
        else if (choice == 2) {
            System.out.println("0. Exit");
            System.out.println("1. Show all projects");
            System.out.println("2. Show project By Id");
            System.out.println("3. create a new project");
            System.out.println("4. delete a project by ID");
            System.out.println("5. projects in progress");
            System.out.println("6. projects today");
        }

        if (choice == 3) {
            System.out.println("0. Exit");
            System.out.println("1. Show workdone by projectId");
            System.out.println("2. create a new workdone");
            System.out.println("3. delete a workdone");
        }
        else if (choice == 4) {
            System.out.println("1. price of project");
            System.out.println("2. hoursworked by employee");
            System.out.println("3. top 3 Employee");
        }
    }

    private static int requestIntInput(int lower, int upper) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        do {
            try {
                System.out.print("Make a choice: ");
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                input = -1;
            }
            scanner.nextLine();
            if (input < lower || input > upper) System.out.println("please enter a valid value");
        } while (input < lower || input > upper);

        return input;
    }

    private static void printResult(List<String> result) {
        result.forEach(System.out::println);
    }

}
