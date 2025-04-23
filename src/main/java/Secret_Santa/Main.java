package Secret_Santa;

import Secret_Santa.model.Employee;
import Secret_Santa.service.CSVReaderService;
import Secret_Santa.service.SecretSantaService;
import Secret_Santa.util.CSVWriterUtil;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        String employeeFile = "resources/Employee-List.csv";
        String lastYearFile = "resources/Secret-Santa-Game-Result-2023.csv";
        String outputFile = "resources/Current_Assignments.csv";

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