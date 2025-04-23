package Secret_Santa.service;
import Secret_Santa.model.Employee;

import java.util.*;

public class SecretSantaService {

    public Map<Employee, Employee> assignSecretSanta(
            List<Employee> employees,
            Map<Employee, Employee> lastYearAssignments) {

        Map<Employee, Employee> currentAssignments = new HashMap<>();
        List<Employee> availableChildren = new ArrayList<>(employees);
        Collections.shuffle(availableChildren);

        for (Employee giver : employees) {
            Employee assigned = findValidChild(giver, availableChildren, lastYearAssignments);
            if (assigned == null) {
                throw new RuntimeException("Valid assignment not possible. Please retry.");
            }
            currentAssignments.put(giver, assigned);
            availableChildren.remove(assigned);
        }

        return currentAssignments;
    }

    private Employee findValidChild(Employee giver, List<Employee> candidates,
                                    Map<Employee, Employee> lastYearAssignments) {
        for (Employee candidate : candidates) {
            if (!candidate.equals(giver) &&
                    (lastYearAssignments.get(giver) == null || !lastYearAssignments.get(giver).equals(candidate))) {
                return candidate;
            }
        }
        return null; // No valid candidate
    }
}
