package com.smogorzhevskiy.utility.validators;


import com.smogorzhevskiy.forms.ArtistCreationForm;
import com.smogorzhevskiy.repository.ArtistRepository;
import com.smogorzhevskiy.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@Qualifier("artistFormValidator")
public class ArtistFormValidator implements Validator {
    public boolean supports(Class<?> Class) {
        return ArtistCreationForm.class.equals(Class);
    }

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    ArtistRepository artistRepository;

    public void validate(Object o, Errors errors) {
        ArtistCreationForm form = (ArtistCreationForm) o;
        if (credentialRepository.findOneByLogin(form.getLogin()) != null) {
            errors.rejectValue("login", "", "login is used already");
        }
        if (credentialRepository.findOneByEmail(form.getEmail()) != null) {
            errors.rejectValue("email", "", "email is used already");
        }
        if (!form.getPassword().equals(form.getRepassword())) {
            errors.rejectValue("repassword", "", "passwords doesn't match");
        }
    }
}
