package sotsuken.api.teacher.controller;

    import java.time.LocalDate;
    import java.util.List;

    public class SubjectsResponse {
    
        public String subjectname;
        public LocalDate startDate;
        public LocalDate finishDate;
        public Long teacherId;
        public List<Long> studentIds;
    
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
    

