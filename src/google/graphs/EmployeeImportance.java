package google.graphs;

import java.util.*;
import java.io.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
    public Employee(int id, int importance, List<Integer> subordinates) {
    	this.id = id;
    	this.importance = importance;
    	this.subordinates = subordinates;
    }
}

public class EmployeeImportance {
	static int sum;
	public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> m = new HashMap<>();
        for(Employee e: employees) {
            m.put(e.id, e);
        }
        sum = 0;
        dfs(m, id);
        return sum;
    }

    public static void dfs(Map<Integer, Employee> m, int employeeId) {
        Employee currentEmployee = m.get(employeeId);
        sum += currentEmployee.importance;
        for(int i=0; i<currentEmployee.subordinates.size(); i++) {
            dfs(m, currentEmployee.subordinates.get(i));
        }
    }

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, 5, Arrays.asList(2,3)));
		employees.add(new Employee(2, 3, Collections.emptyList()));
		employees.add(new Employee(3, 3, Collections.emptyList()));
		System.out.println(getImportance(employees, 1));
	}
}