package Secret_Santa;

import Secret_Santa.model.Employee;
import Secret_Santa.service.CSVReaderService;
import Secret_Santa.service.SecretSantaService;
import Secret_Santa.util.CSVWriterUtil;

import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String employeeFile = "resources/employees.csv";
        String lastYearFile = "resources/last_year_assignments.csv";
        String outputFile = "resources/current_assignments.csv";

        CSVReaderService readerService = new CSVReaderService();
        SecretSantaService santaService = new SecretSantaService();
        CSVWriterUtil writerUtil = new CSVWriterUtil();

        try {
            List<Employee> employees = readerService.readEmployees(employeeFile);
            Map<Employee, Employee> lastAssignments = readerService.readPreviousAssignments(lastYearFile);

            Map<Employee, Employee> currentAssignments = santaService.assignSecretSanta(employees, lastAssignments);

            writerUtil.writeAssignments(outputFile, currentAssignments);

            System.out.println("Secret Santa assignment completed successfully!");
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}