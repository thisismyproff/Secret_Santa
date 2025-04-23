package Secret_Santa.util;


import Secret_Santa.model.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CSVWriterUtil {

    public void writeAssignments(String filepath, Map<Employee, Employee> assignments) throws IOException {
        try (FileWriter writer = new FileWriter(filepath)) {
            writer.append("Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID\n");
            for (Map.Entry<Employee, Employee> entry : assignments.entrySet()) {
                Employee giver = entry.getKey();
                Employee receiver = entry.getValue();
                writer.append(giver.getName()).append(",")
                        .append(giver.getEmail()).append(",")
                        .append(receiver.getName()).append(",")
                        .append(receiver.getEmail()).append("\n");
            }
        }
    }
}