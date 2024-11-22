package sotsuken.api.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import jakarta.transaction.Transactional;
import sotsuken.api.model.Account;
import sotsuken.api.model.AccountType;
import sotsuken.api.model.Student;
import sotsuken.api.model.StudentClass;
import sotsuken.api.repository.AccountRepository;
import sotsuken.api.repository.StudentClassRepository;
import sotsuken.api.repository.StudentRepository;
import sotsuken.api.student.controller.StudentAccountResponse;

@Service
public class RegisterStudentAccountUseCase {

    @Autowired
    StudentClassRepository studentClassRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public StudentAccountResponse handle(String newStudentId, String newStudentName, String password, Long classId) {
        StudentClass studentClass = studentClassRepository.findById(classId).orElseThrow(() -> new ErrorResponseException(HttpStatus.BAD_REQUEST));

        if (studentRepository.existsById(newStudentId)) {
            throw new ErrorResponseException(HttpStatus.CONFLICT);
        }
        
        if (accountRepository.existsById(newStudentId)) {
            throw new ErrorResponseException(HttpStatus.CONFLICT);
        }

        String passwordHash = passwordEncoder.encode(password);
        Account newAccount = new Account(newStudentId, passwordHash, AccountType.STUDENT);
        Student newStudent = new Student(newStudentId, newStudentName, studentClass);

        accountRepository.saveAndFlush(newAccount);
        studentRepository.saveAndFlush(newStudent);

        return new StudentAccountResponse(newStudentId);
    }
}
