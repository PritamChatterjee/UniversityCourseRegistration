package universitycourseregistration;
import java.util.*;
public class UniversityRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Registrar registrar = new Registrar();

        int numStudents = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < numStudents; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(",");
            String name = parts[0].trim();
            int pointLevel = Integer.parseInt(parts[1].trim());
            List<String> depts = new ArrayList<>();
            if (parts.length > 2) {
                String deptStr = parts[2].trim();
                depts = Arrays.asList(deptStr.split("\\s+"));
            }
            registrar.addStudent(new Student(name, pointLevel, depts));
        }

        int numCourses = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < numCourses; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0].trim());
            String name = parts[1].trim();
            String dept = parts[2].trim();
            int points = Integer.parseInt(parts[3].trim());
            registrar.addCourse(new Course(id, name, dept, points));
        }

        int numAttempts = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < numAttempts; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(",");
            String studentName = parts[0].trim();
            int courseId = Integer.parseInt(parts[1].trim());
            registrar.registerCourse(studentName, courseId);
        }

        System.out.println("WaitingTicketCount:" + registrar.getWaitingCourseCount());
        System.out.println("CompletedTicketsTotalPoint:" + registrar.getRegisteredCoursesTotalPoints());
        System.out.println("TicketsTotalPointByCategory:");
        for (Map.Entry<String, Integer> entry : registrar.getCoursesTotalPointsByDepartment()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("TicketsTotalPointByEmployee:");
        for (Map.Entry<String, Integer> entry : registrar.getCoursesTotalPointsByStudent()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        sc.close();
    }
}