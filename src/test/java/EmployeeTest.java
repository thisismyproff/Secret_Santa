

import Secret_Santa.model.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testEqualsAndHashCode() {
        Employee e1 = new Employee("Alice", "alice@example.com");
        Employee e2 = new Employee("Alice B", "alice@example.com");
        Employee e3 = new Employee("Bob", "bob@example.com");
        assertEquals(e1, e2);
        assertEquals(e1.hashCode(), e2.hashCode());
        assertNotEquals(e1, e3);
        assertNotEquals(e1.hashCode(), e3.hashCode());
    }

    @Test
    public void testToString() {
        Employee e = new Employee("Alice", "alice@example.com");
        assertEquals("Alice <alice@example.com>", e.toString());
    }
}