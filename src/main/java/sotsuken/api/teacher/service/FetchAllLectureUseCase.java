package sotsuken.api.teacher.service;

import java.util.ArrayList;
import java.util.List;

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
public class FetchAllLectureUseCase {

    @Autowired
    LectureRepository lectureRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public List<SubjectLectureResponse> handle(String user_id,Long subjectId){
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        List<Lecture> lectures = lectureRepository.findBySubject(subject);
        
        List<SubjectLectureResponse> res = new ArrayList<>();
        for (Lecture lecture: lectures) {
            res.add(new SubjectLectureResponse(subjectId,lecture.getId(),lecture.getName(),lecture.getStartDate(),lecture.getPeriods(),lecture.getJoinCode()));
        }
        return res;
    }
}