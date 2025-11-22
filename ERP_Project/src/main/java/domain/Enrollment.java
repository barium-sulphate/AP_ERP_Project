package domain;

public class Enrollment {
    private int studentId;
    private int sectionId;
    private String status;

    public Enrollment(int studentId, int sectionId, String status) {
        this.studentId = studentId;
        this.sectionId = sectionId;
        this.status = status;
    }

    public int getStudentId() { return studentId; }
    public int getSectionId() { return sectionId; }
    public String getStatus() { return status; }
}
