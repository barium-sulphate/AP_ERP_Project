package service;

import data.SectionRepository;
import domain.Section;
import java.util.List;

public class SectionService {
    private final SectionRepository repo = new SectionRepository();

    public List<Section> getSections(int courseId) {
        return repo.getSectionsForCourse(courseId);
    }

    public List<Section> getAllSections() {
        return repo.getAllSections();
    }

}
