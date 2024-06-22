package test.com.emp;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> empList = EmployeeList.getEmployeeList();

		countMaleFemaleEmployee(empList);
		printAllDepartmentsName(empList);
		averageAgeOfMaleAndFemaleEmployee(empList);
		getHighestPaidEmployee(empList);
		getEmployeesAfterJoiningYear(2015, empList);
		countEmployeesPerDepartment(empList);
		avgSalaryPerDepartment(empList);
		youngestEmployeeForDepartment("Product Development", empList);
		mostExpEmployee(empList);
		countMaleAndFemaleEmpInDept("Sales And Marketing", empList);
		avgSalaryOnGender(empList);
		listDownOfAllEmpInEachDept(empList);
		avgAndTotalSalary(empList);
		separateEmpLess(25, empList);
		oldestEmployee(empList);
		sortEmployee(empList);
	}

	private static void sortEmployee(List<Employee> empList) {
		// TODO Auto-generated method stub
		System.out.println("\n sort employees based on Joining date and Id");

		empList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining).thenComparing(Employee::getId))
				.collect(Collectors.toList()).forEach(System.out::println);

	}

	private static void oldestEmployee(List<Employee> empList) {
		// TODO Auto-generated method stub
		System.out.println(
				"\nWho is the oldest employee in the organization? What is his age and which department he belongs to?");

		Employee emp = empList.stream().max(Comparator.comparing(Employee::getAge)).get();
		System.out.println(emp);
	}

	private static void separateEmpLess(int age, List<Employee> empList) {
		// TODO Auto-generated method stub
		System.out.println(
				"\nSeparate the employees who are younger or equal to 25 years from those employees who are older than 25 years.");

		Map<Boolean, List<Employee>> separatedList = empList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() >= age));

		Set<Entry<Boolean, List<Employee>>> entry = separatedList.entrySet();

		for (Entry<Boolean, List<Employee>> empSet : entry) {

			if (empSet.getKey() == true) {
				System.out.println("Employee age less than equal to :::" + age);
			} else {
				System.out.println("Employee age greater than :::" + age);
			}

			for (Employee emp : empSet.getValue()) {

				System.out.println("Employee Name:::" + emp.getName());
			}

			System.out.println("-------------------------");
		}
	}

	private static void avgAndTotalSalary(List<Employee> empList) {
		// TODO Auto-generated method stub
		System.out.println("\nWhat is the average salary and total salary of the whole organization?");

		DoubleSummaryStatistics avgSalary = empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Average salary::" + avgSalary.getAverage());
		System.out.println("Total salary::" + avgSalary.getSum());

	}

	private static void listDownOfAllEmpInEachDept(List<Employee> empList) {
		// TODO Auto-generated method stub
		System.out.println("\nList down the names of all employees in each department?");
		Map<String, List<Employee>> empListPerDept = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		Set<Entry<String, List<Employee>>> entry = empListPerDept.entrySet();

		for (Entry<String, List<Employee>> empSet : entry) {
			System.out.println("Department:::" + empSet.getKey());
			for (Employee emp : empSet.getValue()) {

				System.out.println("Employee Name:::" + emp.getName());
			}
			System.out.println("-------------------------");
		}
	}

	private static void avgSalaryOnGender(List<Employee> empList) {
		// TODO Auto-generated method stub
		System.out.println("\nWhat is the average salary of male and female employees?");
		Map<String, Double> avgSalaryMap = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(avgSalaryMap);
	}

	private static void countMaleAndFemaleEmpInDept(String dept, List<Employee> empList) {
		// TODO Auto-generated method stub
		System.out.println("\nHow many male and female employees are there in the sales and marketing team?");
		Map<String, Long> countMap = empList.stream().filter(e -> e.getDepartment().equals(dept))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(countMap);
	}

	private static void mostExpEmployee(List<Employee> empList) {

		System.out.println("\nWho has the most working experience in the organization?");
		Employee emp = empList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get();

		System.out.println(emp);
	}

	private static void youngestEmployeeForDepartment(String dept, List<Employee> empList) {

		System.out.println("\nGet the details of youngest male employee in the product development department?");

		Employee emp = empList.stream().filter(e -> e.getDepartment().equals(dept) && e.getGender().equals("Male"))
				.min(Comparator.comparingInt(Employee::getAge)).get();
		System.out.println(emp);
	}

	private static void avgSalaryPerDepartment(List<Employee> empList) {
		System.out.println("\nWhat is the average salary of each department?");

		Map<String, Double> avgSalaryPerDept = empList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(avgSalaryPerDept);
	}

	private static void countEmployeesPerDepartment(List<Employee> empList) {
		System.out.println("\nCount the number of employees in each department?");
		Map<String, Long> empCountsPerDept = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		System.out.println(empCountsPerDept);
	}

	private static void getEmployeesAfterJoiningYear(int year, List<Employee> empList) {
		System.out.println("\nGet the names of all employees who have joined after 2015?");

		empList.stream().filter(e -> e.getYearOfJoining() > year).map(Employee::getName).forEach(System.out::println);

	}

	private static void getHighestPaidEmployee(List<Employee> empList) {
		System.out.println("\nGet the details of highest paid employee in the organization?");
		Optional<Employee> employee = empList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

		System.out.println(employee.get().name);
	}

	private static void averageAgeOfMaleAndFemaleEmployee(List<Employee> empList) {
		System.out.println("\nWhat is the average age of male and female employees?");
		Map<String, Double> avgAge = empList.parallelStream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));

		System.out.println(avgAge);

	}

	private static void printAllDepartmentsName(List<Employee> empList) {
		System.out.println("Print the name of all departments in the organization?\n");
		empList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

	}

	// Query 3.1 : How many male and female employees are there in the organization?
	private static void countMaleFemaleEmployee(List<Employee> empList) {
		System.out.println("How many male and female employees are there in the organization?\n");

		Map<String, Long> noOfMaleAndFemaleEmployees = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(noOfMaleAndFemaleEmployees);
	}

}
