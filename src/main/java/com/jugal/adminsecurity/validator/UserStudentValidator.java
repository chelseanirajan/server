package com.jugal.adminsecurity.validator;

import com.jugal.adminsecurity.user.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class UserStudentValidator {

    public boolean supports(Class<?> paramClass) {
        return Student.class.equals(paramClass);
    }
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.student.name");
    }
}
