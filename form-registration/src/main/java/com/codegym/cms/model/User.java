package com.codegym.cms.model;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Component
@Table(name = "registration")
public class User implements Validator {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName,lastName;
    private int age;
    private String numberPhone;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;
        String numberPhone = user.getNumberPhone();
        String email = user.getEmail();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        int age = user.getAge();

        ValidationUtils.rejectIfEmpty(errors,"firstName","firstName.empty");
        ValidationUtils.rejectIfEmpty(errors,"lastName","lastName.empty");
        ValidationUtils.rejectIfEmpty(errors,"age","age.empty");
        ValidationUtils.rejectIfEmpty(errors,"numberPhone","numberPhone.empty");
        ValidationUtils.rejectIfEmpty(errors,"email","email.empty");
        if(numberPhone.length()<10 ||numberPhone.length()>11){
            errors.rejectValue("numberPhone","numberPhone.length");
        }
        if(!numberPhone.startsWith("0")){
            errors.rejectValue("numberPhone","numberPhone.startsWith");
        }
        if(!numberPhone.matches("(^[0-9]$)")){
            errors.rejectValue("numberPhone","numberPhone.matches");
        }
        if(!email.matches("(^[A-Za-z]{5,}@[a-z]{3,}\\.[a-z]{2,}$)")){
            errors.rejectValue("email","email.matches");
        }
        if(!firstName.matches("(^[A-Za-z]{3,}$)")){
            errors.rejectValue("firstName","firstName.matches");
        }
        if(!lastName.matches("(^[A-Za-z]{3,}$)")){
            errors.rejectValue("lastName","lastName.matches");
        }
        if(age < 18){
            errors.rejectValue("age","age.kid");
        }
    }
}
