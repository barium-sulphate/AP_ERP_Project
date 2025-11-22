package service;

import data.CourseRepository;
import domain.Course;
import java.util.*;

public class CourseService {
    private final CourseRepository repo = new CourseRepository();

    public List<Course> getCatalog() {
        return repo.getAllCourses();
    }
}
