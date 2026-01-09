package universitycourseregistration;
import java.util.*;

class Registrar {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    private static final String[] DEPARTMENTS_ORDER = {
        "ComputerScience", "Physics", "Chemistry", "Mathematics", "Biology"
    };

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void registerCourse(String studentName, int courseId) {
        Student student = null;
        for (Student s : students) {
            if (s.getFullName().equals(studentName)) {
                student = s;
                break;
            }
        }
        if (student == null) return;

        Course course = null;
        for (Course c : courses) {
            if (c.getId() == courseId) {
                course = c;
                break;
            }
        }
        if (course == null || course.isRegistered()) return;

        if (student.getApprovedDepartments().contains(course.getDepartment()) &&
            student.getPointLevel() >= course.getRequiredPoints()) {
            course.setRegistered(true);
            course.setRegisteredStudent(studentName);
        }
    }

    public int getWaitingCourseCount() {
        int count = 0;
        for (Course c : courses) {
            if (!c.isRegistered()) count++;
        }
        return count;
    }

    public int getRegisteredCoursesTotalPoints() {
        int sum = 0;
        for (Course c : courses) {
            if (c.isRegistered()) sum += c.getRequiredPoints();
        }
        return sum;
    }

    public List<Map.Entry<String, Integer>> getCoursesTotalPointsByDepartment() {
        Map<String, Integer> map = new HashMap<>();
        for (String dept : DEPARTMENTS_ORDER) {
            map.put(dept, 0);
        }
        for (Course c : courses) {
            String dept = c.getDepartment();
            map.put(dept, map.getOrDefault(dept, 0) + c.getRequiredPoints());
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (String dept : DEPARTMENTS_ORDER) {
            list.add(new AbstractMap.SimpleEntry<>(dept, map.get(dept)));
        }
        return list;
    }

    public List<Map.Entry<String, Integer>> getCoursesTotalPointsByStudent() {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Student s : students) {
            map.put(s.getFullName(), 0);
        }
        for (Course c : courses) {
            if (c.isRegistered()) {
                String student = c.getRegisteredStudent();
                map.put(student, map.getOrDefault(student, 0) + c.getRequiredPoints());
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (Student s : students) {
            list.add(new AbstractMap.SimpleEntry<>(s.getFullName(), map.get(s.getFullName())));
        }
        return list;
    }
}