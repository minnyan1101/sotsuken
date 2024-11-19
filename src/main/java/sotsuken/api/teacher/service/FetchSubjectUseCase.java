package sotsuken.api.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import sotsuken.api.model.Subject;
import sotsuken.api.repository.SubjectRepository;
import sotsuken.api.teacher.controller.SubjectResponse;

@Service
public class FetchSubjectUseCase {

    @Autowired
    SubjectRepository subjectRepository;

    public SubjectResponse handle(String userId, Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        return new SubjectResponse(subject.getId(), subject.getName(), subject.getStartDate(), subject.getFinishDate(),
                subject.getTeacherId(), subject.getJoinedStudentIds());
    }
}
