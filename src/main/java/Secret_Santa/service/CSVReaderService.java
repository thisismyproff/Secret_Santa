package Secret_Santa.service;

import Secret_Santa.model.Employee;

import java.io.*;
import java.util.*;

public class

CSVReaderService {

    public List<Employee> readEmployees(String filepath) throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                employees.add(new Employee(values[0].trim(), values[1].trim()));
            }
        }
        return employees;
    }

    public Map<Employee, Employee> readPreviousAssignments(String filepath) throws IOException {
        Map<Employee, Employee> assignments = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Employee giver = new Employee(values[0].trim(), values[1].trim());
                Employee receiver = new Employee(values[2].trim(), values[3].trim());
                assignments.put(giver, receiver);
            }
        }
        return assignments;
    }
}

