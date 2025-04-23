import Secret_Santa.model.Employee;
import Secret_Santa.service.SecretSantaService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class SecretSantaServiceTest {
    private final SecretSantaService service = new SecretSantaService();

    @Test
    public void testAssignSecretSantaNoPrevious() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "alice@example.com"),
                new Employee("Bob", "bob@example.com"),
                new Employee("Carol", "carol@example.com")
        );
        Map<Employee, Employee> assignments = service.assignSecretSanta(employees, Collections.emptyMap());
        assertEquals(employees.size(), assignments.size());
        for (Employee giver : employees) {
            Employee receiver = assignments.get(giver);
            assertNotNull(receiver);
            assertNotEquals(giver, receiver);
            assertTrue(employees.contains(receiver));
        }
        Set<Employee> receivers = new HashSet<>(assignments.values());
        assertEquals(employees.size(), receivers.size());
    }

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