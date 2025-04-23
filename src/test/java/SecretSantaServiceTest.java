import Secret_Santa.model.Employee;
import Secret_Santa.service.SecretSantaService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class SecretSantaServiceTest {
    private final SecretSantaService service = new SecretSantaService();


    @Test
    public void testAssignSecretSantaWithPrevious() {
        Employee alice = new Employee("Alice", "alice@example.com");
        Employee bob = new Employee("Bob", "bob@example.com");
        List<Employee> employees = Arrays.asList(alice, bob);
        Map<Employee, Employee> lastYear = new HashMap<>();
        lastYear.put(alice, bob);
        lastYear.put(bob, alice);
        assertThrows(RuntimeException.class, () -> {
            service.assignSecretSanta(employees, lastYear);
        });
    }
}