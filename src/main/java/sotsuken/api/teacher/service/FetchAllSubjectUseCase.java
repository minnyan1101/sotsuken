package sotsuken.api.teacher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sotsuken.api.model.Subject;
import sotsuken.api.repository.SubjectRepository;
import sotsuken.api.teacher.controller.SubjectResponse;

@Service
public class FetchAllSubjectUseCase {

    @Autowired
    SubjectRepository subjectRepository;

    public List<SubjectResponse> handle(String user_id) {
        List<Subject> subjects = subjectRepository.findAll();

        List<SubjectResponse> res = new ArrayList<>();
        for (Subject subject: subjects) {
            res.add(new SubjectResponse(subject.getId(), subject.getName(), subject.getStartDate(), subject.getFinishDate(), subject.getTeacherId(), subject.getJoinedStudentIds()));
        }
        return res;
    }
}