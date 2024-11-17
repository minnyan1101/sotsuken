package sotsuken.api.teacher.controller;

    import java.time.LocalDate;
    import java.util.List;

    public class SubjectsResponse {
    
        public String subjectname;//授業名
        public LocalDate startDate;//開始日
        public LocalDate finishDate;//終了日
        public Long teacherId;//先生ID
        public List<Long> studentIds;//学生ID
    
        public SubjectsResponse(
        
            String subjectname, 
            LocalDate startDate, 
            LocalDate finishDate,
            Long teacherId,
            List<Long> studentIds)
        {
    
            this.subjectname = subjectname;
            this.startDate = startDate;
            this.finishDate = finishDate;
            this.teacherId = teacherId;
            this.studentIds = studentIds;
        }
    
    }
    

