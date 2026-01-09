package universitycourseregistration;
import java.util.*;

class Student {
    private String fullName;
    private int pointLevel;
    private List<String> approvedDepartments;

    public Student(String fullName, int pointLevel, List<String> approvedDepartments) {
        this.fullName = fullName;
        this.pointLevel = pointLevel;
        this.approvedDepartments = approvedDepartments;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPointLevel() {
        return pointLevel;
    }

    public List<String> getApprovedDepartments() {
        return approvedDepartments;
    }
}