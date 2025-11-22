package service;

import data.EnrollmentRepository;
import data.SectionRepository;
import domain.Section;

import java.util.List;

public class EnrollmentService {

    private final EnrollmentRepository enrollRepo = new EnrollmentRepository();
    private final SectionRepository sectionRepo = new SectionRepository();

    public boolean register(int studentId, int sectionId) {

        if (enrollRepo.isAlreadyEnrolled(studentId, sectionId))
            return false;

        enrollRepo.enroll(studentId, sectionId);
        return true;
    }

    public void drop(int student, int section) {
        enrollRepo.drop(student, section);
    }

    public void saveSelections(int studentId, List<Integer> selected) {

        List<Integer> current = enrollRepo.getAllForStudent(studentId);

        // DROP old selections
        for (int section : current) {
            if (!selected.contains(section)) {
                enrollRepo.drop(studentId, section);
            }
        }

        // ADD new selections
        for (int section : selected) {
            if (!current.contains(section)) {
                enrollRepo.enroll(studentId, section);
            }
        }
        System.out.println("Saving for student: " + studentId);
        System.out.println("Selected sections: " + selected);
    }

    public List<Integer> getAllForStudent(int studentId) {
        return enrollRepo.getAllForStudent(studentId);
    }

}
