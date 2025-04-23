import Secret_Santa.model.Employee;
import Secret_Santa.service.CSVReaderService;
import org.junit.jupiter.api.Test;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class CSVReaderServiceTest {
    private final CSVReaderService service = new CSVReaderService();

    @Test
    public void testReadEmployees() throws IOException {
        Path tempFile = Files.createTempFile("employees", ".csv");
        List<String> lines = Arrays.asList("Name,Email", "Alice, alice@example.com", "Bob,bob@example.com");
        Files.write(tempFile, lines);
        List<Employee> employees = service.readEmployees(tempFile.toString());
        assertEquals(2, employees.size());
        assertEquals("Alice", employees.get(0).getName());
        assertEquals("alice@example.com", employees.get(0).getEmail());
        assertEquals("Bob", employees.get(1).getName());
        assertEquals("bob@example.com", employees.get(1).getEmail());
    }

    @Test
    public void testReadPreviousAssignments() throws IOException {
        Path tempFile = Files.createTempFile("assignments", ".csv");
        List<String> lines = Arrays.asList(
                "GiverName,GiverEmail,ReceiverName,ReceiverEmail",
                "Alice, alice@example.com, Bob,bob@example.com",
                "Bob,bob@example.com,Alice, alice@example.com"
        );
        Files.write(tempFile, lines);
        Map<Employee, Employee> assignments = service.readPreviousAssignments(tempFile.toString());
        assertEquals(2, assignments.size());
        Employee alice = new Employee("Alice", "alice@example.com");
        Employee bob = new Employee("Bob", "bob@example.com");
        assertEquals(bob, assignments.get(alice));
        assertEquals(alice, assignments.get(bob));
    }
}
