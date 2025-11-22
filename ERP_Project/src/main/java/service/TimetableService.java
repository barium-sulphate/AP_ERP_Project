package service;

import data.EnrollmentRepository;
import data.SectionRepository;
import domain.Section;

import java.util.*;

public class TimetableService {
    private final EnrollmentRepository enrollmentRepo = new EnrollmentRepository();
    private final SectionRepository sectionRepo = new SectionRepository();
    public List<Section> getTimetable(int studentId) {

        List<Integer> sectionIds = enrollmentRepo.getAllForStudent(studentId);
        List<Section> list = new ArrayList<>();

        for (int sectionId : sectionIds) {
            Section s = sectionRepo.getSectionById(sectionId);
            if (s != null) list.add(s);
        }

        return list;
    }
}
