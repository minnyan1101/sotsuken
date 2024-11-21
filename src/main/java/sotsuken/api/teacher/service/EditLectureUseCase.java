package sotsuken.api.teacher.service;

import java.time.LocalDate;

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
public class EditLectureUseCase {

    @Autowired
    LectureRepository lectureRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public SubjectLectureResponse handle(Long subjectId, Long lectureId, String lectureName, LocalDate date,
            Long periods) {

        Subject subject =subjectRepository.findById(subjectId)
        .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
        
        if (! subject.containLectureById(lectureId)) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }

        Lecture editLecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        editLecture.changeName(lectureName);
        editLecture.changeStartDate(date);
        editLecture.changePeriods(periods);

        Lecture savedLecture = lectureRepository.save(editLecture);

        return new SubjectLectureResponse(
                savedLecture.getSubject().getId(),
                savedLecture.getId(),
                savedLecture.getName(),
                savedLecture.getStartDate(),
                savedLecture.getPeriods(),
                savedLecture.getJoinCode());
    }
}
