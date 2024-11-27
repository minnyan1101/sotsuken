package sotsuken.api.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import sotsuken.api.model.Lecture;
import sotsuken.api.model.Subject;
import sotsuken.api.repository.LectureRepository;
import sotsuken.api.repository.SubjectRepository;
import sotsuken.api.teacher.controller.SubjectLectureResponse;

@Service
public class FetchLectureUseCase {
    
    @Autowired
    LectureRepository lectureRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public SubjectLectureResponse handle(String userId, Long subjectId,Long lectureId) {
        Subject subject = subjectRepository.findById(subjectId)
            .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        if (! subject.containLectureById(lectureId)) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }

        Lecture lecture = lectureRepository.findById(lectureId)
            .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        return new SubjectLectureResponse(subject.getId(), lecture.getId(), lecture.getName(), lecture.getStartDate(), lecture.getPeriods(), lecture.getJoinCode());
    }
}
