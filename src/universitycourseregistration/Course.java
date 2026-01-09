package universitycourseregistration;
class Course {
    private int id;
    private String name;
    private String department;
    private int requiredPoints;
    private String registeredStudent = "";
    private boolean isRegistered = false;

    public Course(int id, String name, String department, int requiredPoints) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.requiredPoints = requiredPoints;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public int getRequiredPoints() {
        return requiredPoints;
    }

    public String getRegisteredStudent() {
        return registeredStudent;
    }

    public void setRegisteredStudent(String registeredStudent) {
        this.registeredStudent = registeredStudent;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }
}