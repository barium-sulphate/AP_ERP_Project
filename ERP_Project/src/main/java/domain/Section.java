package domain;

import java.time.LocalTime;

public class Section {
    private int sectionId;
    private int courseId;
    private int instructorId;
    private String day;
    private LocalTime start;
    private LocalTime end;
    private String room;
    private int capacity;
    private String semester;
    private int year;

    public Section(int sectionId, int courseId, int instructorId,
                   String day, LocalTime start, LocalTime end,
                   String room, int capacity, String semester, int year) {

        this.sectionId = sectionId;
        this.courseId = courseId;
        this.instructorId = instructorId;
        this.day = day;
        this.start = start;
        this.end = end;
        this.room = room;
        this.capacity = capacity;
        this.semester = semester;
        this.year = year;
    }

    public int getSectionId() { return sectionId; }
    public int getCourseId() { return courseId; }
    public String getDay() { return day; }
    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }
    public String getRoom() { return room; }
}
