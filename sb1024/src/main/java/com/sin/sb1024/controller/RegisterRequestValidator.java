package com.sin.sb1024.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sin.sb1024.spring.RegisterRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



public class RegisterRequestValidator implements Validator {

    private static final String emailRegExp =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;

    public RegisterRequestValidator() {
        pattern = Pattern.compile(emailRegExp);
        System.out.println("RegisterRequestValidator#now():" +this);
    }


    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("RegisterRequestValidator#now():" +this);
        RegisterRequest regReq = (RegisterRequest) target;
        if(regReq.getEmail()== null || regReq.getEmail().trim().isEmpty()) {
            errors.reject("email","required");
        }else {
            Matcher matcher = pattern.matcher(regReq.getEmail());
            if(!matcher.matches()) {
                errors.reject("email","bad");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","required");
        ValidationUtils.rejectIfEmpty(errors, "password", "required");
        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
        if(!regReq.getPassword().isEmpty()) {
            if(!regReq.isPasswordEqualToConfirmPassword()) {
                errors.reject("cofirmPassword","nomatch");
            }
        }
        // TODO Auto-generated method stub

    }

}

