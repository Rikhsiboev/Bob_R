package com.Bob_R.streampractice.practice;

import com.Bob_R.streampractice.model.*;
import com.Bob_R.streampractice.service.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class Practice {

    public static CountryService countryService;
    public static DepartmentService departmentService;
    public static EmployeeService employeeService;
    public static JobHistoryService jobHistoryService;
    public static JobService jobService;
    public static LocationService locationService;
    public static RegionService regionService;

    public Practice(CountryService countryService, DepartmentService departmentService,
                    EmployeeService employeeService, JobHistoryService jobHistoryService,
                    JobService jobService, LocationService locationService,
                    RegionService regionService) {

        Practice.countryService = countryService;
        Practice.departmentService = departmentService;
        Practice.employeeService = employeeService;
        Practice.jobHistoryService = jobHistoryService;
        Practice.jobService = jobService;
        Practice.locationService = locationService;
        Practice.regionService = regionService;

    }

    // You can use the services above for all the CRUD (create, read, update, delete) operations.
    // Above services have all the required methods.
    // Also, you can check all the methods in the ServiceImpl classes inside the service.impl package, they all have explanations.

    // Display all the employees
    public static List<Employee> getAllEmployees() {
        return employeeService.readAll();
    }

    // Display all the countries
    public static List<Country> getAllCountries() {
        //TODO Implement the method
        return countryService.readAll();
    }

    // Display all the departments
    public static List<Department> getAllDepartments() {
        //TODO Implement the method
        return departmentService.readAll();
    }

    // Display all the jobs
    public static List<Job> getAllJobs() {
        //TODO Implement the method
        return jobService.readAll();
    }

    // Display all the locations
    public static List<Location> getAllLocations() {
        //TODO Implement the method
        return locationService.readAll();
    }

    // Display all the regions
    public static List<Region> getAllRegions() {
        //TODO Implement the method
        return regionService.readAll();
    }

    // Display all the job histories
    public static List<JobHistory> getAllJobHistories() {
        //TODO Implement the method
        return jobHistoryService.readAll();
    }

    // Display all the employees' first names
    public static List<String> getAllEmployeesFirstName() {
        //TODO Implement the method
        // map return String  All intermediate operation use String  => because of that we have to collect
        //  Collectors.toList
        //Map
        //accept Function of interface accept object, return object
        //R apply(T t);  sending employee object and return iterate
        // we can use lambda

        return getAllEmployees().stream()
                //.map(Employee::getFirstName)
                .map(Employee::getFirstName)
                .collect(Collectors.toList());

//    return employeeService.readAll().stream().    we can use this way too

/*
        List<Employee> employeeList = getAllEmployees();
        List<String> nameList = new ArrayList<>();
        for (Employee employee : employeeList) {
            nameList.add(employee.getFirstName());
        }
        return nameList;
*/
    }

    // Display all the countries' names
    public static List<String> getAllCountryNames() {
        //TODO Implement the method
        return getAllCountries().stream()
                //   .map(Country::getCountryName)
                .map(Country::getCountryName)
                .collect(Collectors.toList());
/*
  we are adding getAllCountries() => to new list
         we are adding <String> => to new list
        List<Country> countryList=getAllCountries();
        List<String> stringList = new ArrayList<>();

        /// now from country list as basket we are iterating to Country originally

        for (Country countryEach : countryList) {
            // and adding stingList.add(=> countryEach.getCountryName())=> we can call getter here name
            stringList.add(countryEach.getCountryName());
        }
        return stringList;
    }
 */
    }

    // Display all the departments' manager`s first names
    public static List<String> getAllDepartmentManagerFirstNames() {
        //TODO Implement the method
        return getAllDepartments().stream()
                .map(department -> department.getManager().getFirstName())
                .collect(Collectors.toList());
//        return getAllDepartments().stream()
//                .map()
//                .collect(Collectors.toList());
        /*
              List<Department> departmentList = getAllDepartments();
        List<String> stringList = new ArrayList<>();
        for (Department departmentEach : departmentList) {
            /// department link with manager  private Employee manager;
            stringList.add(departmentEach.getManager().getFirstName());
        }
    return stringList;
         */
    }

    // Display all the departments where manager name of the department is 'Steven'
    public static List<Department> getAllDepartmentsWhichManagerFirstNameIsSteven() {
        //TODO Implement the method


        return getAllDepartments().stream()
                // we are filter for steven as boolean for filter also intermediate operation because of that is String
                .filter(department -> department.getManager().getFirstName().equals("Steven"))
                .collect(Collectors.toList());
                /*
                 List<Department> departmentList = getAllDepartments();
                List<Department> resultList = new ArrayList<>();
                for (Department department : departmentList) {
                    Employee manager = department.getManager();
                    if (manager.getFirstName().equals("Steven")) {
                        resultList.add(department);
                    }
                }
                return resultList;
            }
                 */
    }

    // Display all the departments where postal code of the location of the department is '98199'
    public static List<Department> getAllDepartmentsWhereLocationPostalCodeIs98199() {
        //TODO Implement the method
        return getAllDepartments().stream()
                .filter(department -> department.getLocation().getPostalCode().equals("98199")) // operation string
                .collect(Collectors.toList());

        /*
        List<Department> departmentList = getAllDepartments();
                List<Department> resultList = new ArrayList<>();
                for (Department department : departmentList) {
                    Location location = department.getLocation();
                    if (location.getPostalCode().equals("98199")) {
                        resultList.add(department);
                    }
                }
                return resultList;
            }
         */
    }

    // Display the region of the IT department
    public static Region getRegionOfITDepartment() throws Exception {
        //TODO Implement the method
        /////// we cam use Optional method /////////////////////////////
        return getAllDepartments().stream()
                .filter(department -> department.getDepartmentName().equals("IT"))  // boolean
                .findFirst().get().getLocation().getCountry().getRegion();   // Optional Class instance
        // string work when we run index number change or order

        /*
          List<Department> departmentList = getAllDepartments();
                for (Department department : departmentList) {
                    if (department.getDepartmentName().equals("IT")) {
                        return department.getLocation().getCountry().getRegion();
                    }
                }
                throw new Exception("IT department not found");
            }
         */
    }

    // Display all the departments where the region of department is 'Europe'
    public static List<Department> getAllDepartmentsWhereRegionOfCountryIsEurope() {
        //TODO Implement the method
        return getAllDepartments().stream()
                .filter(department -> department.getLocation().getCountry().getRegion().getRegionName().equals("Europe"))
                .collect(Collectors.toList());

        /*
         List<Department> departmentList = getAllDepartments();
                List<Department> resultList = new ArrayList<>();
                for (Department department : departmentList) {
                    if (department.getLocation().getCountry().getCountryName().equals("Europe")) {
                        resultList.add(department);
                    }
                }
                return resultList;
            }
         */
    }

    // Display if there is any employee with salary less than 1000. If there is none, the method should return true
    public static boolean checkIfThereIsNoSalaryLessThan1000() {
        /////////////////////////Match Any Match /////////////////////////////////////////////
        /// any match return faster
        // no match = all math
        /*
        return getAllEmployees().stream()
                .allMatch(employee -> employee.getSalary()>1000);// all match return Boolean no string true or folse*/
        /*
        return getAllEmployees().stream()
                .noneMatch(employee -> employee.getSalary()<1000);  //terminal
        */
        return !getAllEmployees().stream()   // we are using ! why because becoming result as false
                .anyMatch(employee -> employee.getSalary() < 1000);  //terminal

        /*
        List<Employee> employeeList = getAllEmployees();
                for (Employee employee : employeeList) {
                    if (employee.getSalary() < 1000) {
                        return false;
                    }
                }
                return true;
            }
         */
    }

    // Check if the salaries of all the employees in IT department are greater than 2000 (departmentName: IT)
    public static boolean checkIfThereIsAnySalaryGreaterThan2000InITDepartment() {
        //TODO Implement the method


//        return getAllEmployees().stream()
//                .filter(employee -> employee.getDepartment().getDepartmentName().equals("IT"))
//                .noneMatch(employee -> employee.getSalary()<2000);


        return getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().getDepartmentName().equals("IT"))
                .map(Employee::getSalary)
                .allMatch(salary -> salary > 2000);

            /*
            if any matches < 2000 true        return if condition correct nor not  if it will work one time what I accept not happen
                    !anyMatch

             */

        /*
         List<Employee> employeeList = getAllEmployees();
                for (Employee employee : employeeList) {
                    if (employee.getDepartment().equals("IT") && employee.getSalary() > 2000) {
                        return true;
                    }
                }
                return false;
            }
         */
    }

    // Display all the employees whose salary is less than 5000
    public static List<Employee> getAllEmployeesWithLessSalaryThan5000() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary() < 5000)
                .collect(Collectors.toList());
        /*
             List<Employee> allEmployees = getAllEmployees();
                List<Employee> employeesWithLessSalaryThan5000 = new ArrayList<>();
                for (Employee employee : allEmployees) {
                    if (employee.getSalary() < 5000) {
                        employeesWithLessSalaryThan5000.add(employee);
                    }
                }
                return employeesWithLessSalaryThan5000;
            }
         */
    }

    // Display all the employees whose salary is between 6000 and 7000
    public static List<Employee> getAllEmployeesSalaryBetween() {
        //TODO Implement the method
//        return getAllEmployees().stream()
//                .filter(employee -> employee.getSalary() > 6000 && employee.getSalary() < 7000)
//                .collect(Collectors.toList());
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > 6000)
                .filter(employee -> employee.getSalary() < 7000)
                .collect(Collectors.toList());

        /*
         List<Employee> employees = getAllEmployees();
                List<Employee> result = new ArrayList<>();
                for (Employee employee : employees) {
                    if (employee.getSalary() >= 6000 && employee.getSalary() <= 7000) {
                        result.add(employee);
                    }
                }
                return result;
            }
         */
    }

    // Display the salary of the employee Grant Douglas (lastName: Grant, firstName: Douglas)
    public static Long getGrantDouglasSalary() {
        //TODO Implement the method
        Optional<Employee> optionalEmployeew = getAllEmployees().stream()
                .filter(employee -> employee.getFirstName().equals("Douglas"))
                .filter(employee -> employee.getLastName().equals("Grant"))
                // not in list don`t have this person we will get null
                //  .collect(Collectors.toList()).get(0).getSalary();/// we are getting 1 person information as index get(0)
                .findFirst();

        if (optionalEmployeew.isPresent()) {
            return optionalEmployeew.get().getSalary();
        }
        return null;

//        return getAllEmployees().stream()
//                .filter(employee -> employee.getFirstName().equals("Douglas"))
//                .filter(employee -> employee.getLastName().equals("Grant"))
//                // not in list don`t have this person we will get null
//                //  .collect(Collectors.toList()).get(0).getSalary();/// we are getting 1 person information as index get(0)
//                .findFirst().get().getSalary();

        /*
             List<Employee> employees = getAllEmployees();
                for (Employee employee : employees) {
                    if (employee.getFirstName().equals("Douglas") && employee.getLastName().equals("Grant")) {
                        return employee.getSalary();
                    }
                }
                throw new Exception("Grant Douglas not found");
            }
         */
    }

    // Display the maximum salary an employee gets
    public static Long getMaxSalary() {
        // return getAllEmployees().stream();
        //sorted method use comparator =>
//                .sorted(Comparator.comparing(Employee::getSalary).reversed())  // by sort from small to big after that we reversing
//                .findFirst().get().getSalary();  // and we are selecting first method
//        return  getAllEmployees().stream()
//                // max terminate operation
//                .max(Comparator.comparing(Employee::getSalary))
//                .get().getSalary();// we are selecting

//        return  getAllEmployees().stream()
//                // max terminate operation
//                .sorted(Comparator.comparing(Employee::getSalary).reversed())
//                .limit(1).collect(Collectors.toList()).get(0).getSalary(); // becouse of limit string we are using .collect(Collectors.toList()).get(0).getSalary()
//

//        return getAllEmployees().stream()
//                .map(Employee::getSalary)
//                .reduce((salary1, salary2) -> salary1 > salary2 ? salary1 : salary2)  /// reduce return optional because of that we are using get
//                .get()

//        return getAllEmployees().stream()
//                .map(Employee::getSalary)
//                .reduce(Long ::max)  /// class xcome from long max
//                .get()

//        return getAllEmployees().stream()
//                .map(Employee::getSalary)
//                .collect(Collectors.maxBy(Comparator.comparing(Long::longValue)))
//                .get();

//        return getAllEmployees().stream()
//                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)))
//                .get().getSalary();
        return getAllEmployees().stream()
                .map(Employee::getSalary)
                .mapToLong(i -> i)
                .max().getAsLong();

        /*
         List<Employee> employeeList = getAllEmployees();
                Long maxSalary = Long.MIN_VALUE;
                for (Employee employee : employeeList) {
                    if (employee.getSalary() > maxSalary) {
                        maxSalary = employee.getSalary();
                    }
                }
                return maxSalary;
            }
         */
    }

    // Display the employee(s) who gets the maximum salary
    public static List<Employee> getMaxSalaryEmployee() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary().equals(getMaxSalary()))
                .collect(Collectors.toList());
        /*  List<Employee> employeeList = getAllEmployees();
                Long maxSalary = Long.MIN_VALUE;
                Long secondMaxSalary = Long.MIN_VALUE;
                for (Employee employee : employeeList) {
                    if (employee.getSalary() > maxSalary) {
                        secondMaxSalary = maxSalary;
                        maxSalary = employee.getSalary();
                    } else if (employee.getSalary() > secondMaxSalary) {
                        secondMaxSalary = employee.getSalary();
                    }
                }
                if (secondMaxSalary == Long.MIN_VALUE) {
                    throw new Exception("No second maximum salary found");
                }
                return secondMaxSalary;
            }

         */
    }

    // Display the max salary employee's job
    public static Job getMaxSalaryEmployeeJob() throws Exception {
        //TODO Implement the method
        return getMaxSalaryEmployee().get(0).getJob();  // first employee from list
                /*
                 List<Employee> employees = getAllEmployees();
                List<Employee> maxSalaryEmployees = new ArrayList<>();
                int maxSalary = Integer.MIN_VALUE;
                for (Employee employee : employees) {
                    if (employee.getSalary() > maxSalary) {
                        maxSalary = Math.toIntExact(employee.getSalary());
                        maxSalaryEmployees.clear();
                        maxSalaryEmployees.add(employee);
                    } else if (employee.getSalary() == maxSalary) {
                        maxSalaryEmployees.add(employee);
                    }
                }
                if (maxSalaryEmployees.isEmpty()) {
                    throw new Exception("No employees found");
                }
                return (Job) maxSalaryEmployees;
                 */
    }

    // Display the max salary in Americas Region
    public static Long getMaxSalaryInAmericasRegion() throws Exception {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().getLocation().getCountry().getRegion().getRegionName().equals("Americas"))
                .max(Comparator.comparing(Employee::getSalary))
                .get().getSalary();
        /*
          List<Employee> employees = getAllEmployees();
                Long maxSalary = Long.MIN_VALUE;
                for (Employee employee : employees) {
                    if (employee.getDepartment().getLocation().getCountry().getRegion().equals("Americas") && employee.getSalary() > maxSalary) {
                        maxSalary = employee.getSalary();
                    }
                }
                if (maxSalary == Long.MIN_VALUE) {
                    throw new Exception("No employees found in Americas region");
                }
                return maxSalary;
            }
         */
    }

    // Display the second maximum salary an employee gets
    public static Long getSecondMaxSalary() {
        //TODO Implement the method
        ///compareTo return (x < y) ? -1 : ((x == y) ? 0 : 1);
//        return getAllEmployees().stream()
//                .filter(employee -> employee.getSalary().compareTo(getMaxSalary()) < 0)  //.compareTo(getMaxSalary())  bring us
//                                                                                        // -1 so we can bring boolean
//                .sorted(Comparator.comparing(Employee::getSalary).reversed())
//                .findFirst().get().getSalary();


        return getAllEmployees().stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getSalary)
                .distinct()
                .skip(1)
                .findFirst().get();

        /*+
        List<Employee> employeeList = getAllEmployees();
                Long maxSalary = Long.MIN_VALUE;
                Long secondMaxSalary = Long.MIN_VALUE;
                for (Employee employee : employeeList) {
                    if (employee.getSalary() > maxSalary) {
                        secondMaxSalary = maxSalary;
                        maxSalary = employee.getSalary();
                    } else if (employee.getSalary() > secondMaxSalary) {
                        secondMaxSalary = employee.getSalary();
                    }
                }
                if (secondMaxSalary == Long.MIN_VALUE) {
                    throw new Exception("No second maximum salary found");
                }
                return secondMaxSalary;
            }
         */
    }

    // Display the employee(s) who gets the second maximum salary
    public static List<Employee> getSecondMaxSalaryEmployee() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary().equals(getSecondMaxSalary()))
                .collect(Collectors.toList());
                /*
                    List<Employee> employees = getAllEmployees();
                Long maxSalary = Long.MIN_VALUE;
                Long secondMaxSalary = Long.MIN_VALUE;
                List<Employee> maxSalaryEmployees = new ArrayList<>();
                List<Employee> secondMaxSalaryEmployees = new ArrayList<>();

                for (Employee employee : employees) {
                    Long salary = employee.getSalary();
                    if (salary > maxSalary) {
                        secondMaxSalary = maxSalary;
                        maxSalary = salary;
                        secondMaxSalaryEmployees = maxSalaryEmployees;
                        maxSalaryEmployees = new ArrayList<>();
                        maxSalaryEmployees.add(employee);
                    } else if (salary == maxSalary) {
                        maxSalaryEmployees.add(employee);
                    } else if (salary > secondMaxSalary) {
                        secondMaxSalary = salary;
                        secondMaxSalaryEmployees = new ArrayList<>();
                        secondMaxSalaryEmployees.add(employee);
                    } else if (salary == secondMaxSalary) {
                        secondMaxSalaryEmployees.add(employee);
                    }
                }
                    return secondMaxSalaryEmployees;
            }

                 */
    }

    // Display the minimum salary an employee gets
    public static Long getMinSalary() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .findFirst().get().getSalary();

        /*
            List<Employee> employeeList = getAllEmployees();
                Long minSalary = Long.MAX_VALUE;
                for (Employee employee : employeeList) {
                    if (employee.getSalary() < minSalary) {
                        minSalary = employee.getSalary();
                    }
                }
                if (minSalary == Long.MAX_VALUE) {
                    throw new Exception("No employees found");
                }
                return minSalary;
            }
         */
    }

    // Display the employee(s) who gets the minimum salary
    public static List<Employee> getMinSalaryEmployee() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary().equals(getMinSalary()))
                .collect(Collectors.toList());
        /*
        List<Employee> employees = getAllEmployees();
                List<Employee> minSalaryEmployees = new ArrayList<>();
                int minSalary = Integer.MAX_VALUE;
                for (Employee employee : employees) {
                    if (employee.getSalary() < minSalary) {
                        minSalary = Math.toIntExact(employee.getSalary());
                        minSalaryEmployees.clear();
                        minSalaryEmployees.add(employee);
                    } else if (employee.getSalary() == minSalary) {
                        minSalaryEmployees.add(employee);
                    }
                }
                return minSalaryEmployees;
            }
         */
    }

    // Display the second minimum salary an employee gets
    public static Long getSecondMinSalary() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .map(Employee::getSalary)
                .distinct()
                .skip(1)
                .findFirst().get();
    }

    // Display the employee(s) who gets the second minimum salary
    public static List<Employee> getSecondMinSalaryEmployee() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary().equals(getSecondMinSalary()))
                .collect(Collectors.toList());
    }

    // Display the average salary of the employees
    public static Double getAverageSalary() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
    }

    // Display all the employees who are making more than average salary
    public static List<Employee> getAllEmployeesAboveAverage() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > getAverageSalary())
                .collect(Collectors.toList());
    }

    // Display all the employees who are making less than average salary
    public static List<Employee> getAllEmployeesBelowAverage() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary() < getAverageSalary())
                .collect(Collectors.toList());
    }

    // Display all the employees separated based on their department id number
    public static Map<Long, List<Employee>> getAllEmployeesForEachDepartment() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment().getId()));
    }

    // Display the total number of the departments
    public static Long getTotalDepartmentsNumber() {
        //TODO Implement the method
        return (long) getAllDepartments().size();
        //return departmentService.readAll().stream().count();
        // return  getAllDepartments().stream().count();
    }

    // Display the employee whose first name is 'Alyssa' and manager's first name is 'Eleni' and department name is 'Sales'
    public static Employee getEmployeeWhoseFirstNameIsAlyssaAndManagersFirstNameIsEleniAndDepartmentNameIsSales() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getFirstName().equals("Alyssa"))
                .filter(employee -> employee.getManager().getFirstName().equals("Eleni"))
                .filter(employee -> employee.getDepartment().getDepartmentName().equals("Sales"))
                .findFirst().get();
    }

    // Display all the job histories in ascending order by start date
    public static List<JobHistory> getAllJobHistoriesInAscendingOrder() {
        //TODO Implement the method
        return getAllJobHistories().stream()
                .sorted(Comparator.comparing(JobHistory::getStartDate))
                .collect(Collectors.toList());
    }

    // Display all the job histories in descending order by start date
    public static List<JobHistory> getAllJobHistoriesInDescendingOrder() {
        //TODO Implement the method
        return getAllJobHistories().stream()
                .sorted(Comparator.comparing(JobHistory::getStartDate).reversed())
                .collect(Collectors.toList());
    }

    // Display all the job histories where the start date is after 01.01.2005
    public static List<JobHistory> getAllJobHistoriesStartDateAfterFirstDayOfJanuary2005() {
        //TODO Implement the method
        return getAllJobHistories().stream()
                .filter(jobHistory -> jobHistory.getStartDate().isAfter(LocalDate.of(2005, 01, 01)))
                .collect(Collectors.toList());
    }

    // Display all the job histories where the end date is 31.12.2007 and the job title of job is 'Programmer'
    public static List<JobHistory> getAllJobHistoriesEndDateIsLastDayOfDecember2007AndJobTitleIsProgrammer() {
        //TODO Implement the method
        return getAllJobHistories().stream()
                .filter(jobHistory -> jobHistory.getEndDate().equals(LocalDate.of(2007, 12, 31)))
                .filter(jobHistory -> jobHistory.getJob().getJobTitle().equals("Programmer"))
                .collect(Collectors.toList());
    }

    // Display the employee whose job history start date is 01.01.2007 and job history end date is 31.12.2007 and department's name is 'Shipping'
    public static Employee getEmployeeOfJobHistoryWhoseStartDateIsFirstDayOfJanuary2007AndEndDateIsLastDayOfDecember2007AndDepartmentNameIsShipping() {
        //TODO Implement the method
//        return getAllJobHistories().stream()
//                .filter(jobHistory -> jobHistory.getStartDate().equals(LocalDate.of(2007,1,1)))
//                .filter(jobHistory -> jobHistory.getEndDate().equals(LocalDate.of(2007,12,31)))
//                .filter(jobHistory -> jobHistory.getDepartment().getDepartmentName().equals("Shipping"))
//                .map(JobHistory::getEmployee)
//                .findFirst().get();
        return getAllJobHistories().stream()
                .filter(jobHistory -> jobHistory.getStartDate().equals(LocalDate.of(2007, 1, 1)))
                .filter(jobHistory -> jobHistory.getEndDate().equals(LocalDate.of(2007, 12, 31)))
                .filter(jobHistory -> jobHistory.getDepartment().getDepartmentName().equals("Shipping"))
                .findFirst().get().getEmployee();

    }

    // Display all the employees whose first name starts with 'A'
    public static List<Employee> getAllEmployeesFirstNameStartsWithA() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
    }

    // Display all the employees whose job id contains 'IT'
    public static List<Employee> getAllEmployeesJobIdContainsIT() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getJob().getId().contains("IT"))
                .collect(Collectors.toList());
    }

    // Display the number of employees whose job title is programmer and department name is 'IT'
    public static Long getNumberOfEmployeesWhoseJobTitleIsProgrammerAndDepartmentNameIsIT() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getJob().getJobTitle().equals("Programmer"))
                .filter(employee -> employee.getDepartment().getDepartmentName().equals("IT"))
                .count();  // autoboxing implicitly
    }

    // Display all the employees whose department id is 50, 80, or 100
    public static List<Employee> getAllEmployeesDepartmentIdIs50or80or100() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().getId().equals(50L)
                        || employee.getDepartment().getId().equals(80L)
                        || employee.getDepartment().getId().equals(100L))
                .collect(Collectors.toList());
    }

    // Display the initials of all the employees
    // Note: You can assume that there is no middle name
    public static List<String> getAllEmployeesInitials() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .map(employee -> {
                            String firstNameInitial = employee.getFirstName().substring(0, 1);
                            String lastNameInitial = employee.getLastName().substring(0, 1);
                            return firstNameInitial + lastNameInitial;
                        }
                ).collect(Collectors.toList());
    }

    // Display the full names of all the employees
    public static List<String> getAllEmployeesFullNames() {
        //TODO Implement the method
//        return getAllEmployees().stream()
//                .map(employee -> {
//                            String firstName = employee.getFirstName();
//                            String lastName = employee.getLastName();
//                            return firstName +" "+ lastName;
//                        }
//                ).collect(Collectors.toList());

        return getAllEmployees().stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .collect(Collectors.toList());
    }

    // Display the length of the longest full name(s)
    public static Integer getLongestNameLength() {
        //TODO Implement the method
        return getAllEmployeesFullNames().stream()
                .max(Comparator.comparing(String::length))
                .get().length();
    }

    // Display the employee(s) with the longest full name(s)
    public static List<Employee> getLongestNamedEmployee() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getFirstName().length() + employee.getLastName().length() + 1 == getLongestNameLength())
                .collect(Collectors.toList());
    }

    // Display all the employees whose department id is 90, 60, 100, 120, or 130
    public static List<Employee> getAllEmployeesDepartmentIdIs90or60or100or120or130() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().getId().equals(90L)
                        || employee.getDepartment().getId().equals(60L)
                        || employee.getDepartment().getId().equals(100L)
                        || employee.getDepartment().getId().equals(120L)
                        || employee.getDepartment().getId().equals(130L)
                )
                .collect(Collectors.toList());
    }

    // Display all the employees whose department id is NOT 90, 60, 100, 120, or 130
    public static List<Employee> getAllEmployeesDepartmentIdIsNot90or60or100or120or130() {
        //TODO Implement the method
        return getAllEmployees().stream()
                .filter(employee -> !getAllEmployeesDepartmentIdIs90or60or100or120or130().contains(employee))
                .collect(Collectors.toList());

        /*
  return employeeService.readAll().stream()
                .filter(p -> p.getDepartment().getId() != 60)
                .filter(p -> p.getDepartment().getId() != 90)
                .filter(p -> p.getDepartment().getId() != 100)
                .filter(p -> p.getDepartment().getId() != 120)
                .filter(p -> p.getDepartment().getId() != 130)
                .collect(Collectors.toList());
         */
    }

}
