package com.smogorzhevskiy.utility.validators;

import com.smogorzhevskiy.forms.AdminRegistrationForm;
import com.smogorzhevskiy.repository.AdminRepository;
import com.smogorzhevskiy.repository.CredentialRepository;
import com.smogorzhevskiy.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@Qualifier("adminRegFormValidator")
public class AdminRegFormValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return AdminRegistrationForm.class.equals(aClass);
    }

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    GalleryRepository galleryRepository;

    public void validate(Object o, Errors errors) {
        AdminRegistrationForm form = (AdminRegistrationForm) o;
        if (credentialRepository.findOneByLogin(form.getLogin()) != null) {
            errors.rejectValue("login", "", "used already");
        }
        if (!form.getPassword().equals(form.getRepassword())) {
            errors.rejectValue("repassword", "", "passwords doesn't match");
        }
    }
}