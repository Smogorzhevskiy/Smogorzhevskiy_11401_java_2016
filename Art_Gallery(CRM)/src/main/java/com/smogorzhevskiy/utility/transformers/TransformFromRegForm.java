package com.smogorzhevskiy.utility.transformers;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.entities.enums.Role;
import com.smogorzhevskiy.forms.ArtistCreationForm;
import com.smogorzhevskiy.forms.ViewerRegistrationForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by User on 05.05.16.
 */
public class TransformFromRegForm {
        static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

       public static Credential transformArtistFormCredential(ArtistCreationForm form){
            if(form==null)
                return null;
            Credential credential = new Credential();
            credential.setLogin(form.getLogin());
            credential.setPassword(encoder.encode(form.getPassword()));
            credential.setRole(Role.ROLE_ARTIST);
            credential.setEmail(form.getEmail());
            return credential;
        }
    public static Credential transformViewerFormCredential(ViewerRegistrationForm form){
        if(form==null)
            return null;
        Credential credential = new Credential();
        credential.setLogin(form.getLogin());
        credential.setPassword(encoder.encode(form.getPassword()));
        credential.setRole(Role.ROLE_VIEWER);
        credential.setEmail(form.getEmail());
        return credential;
    }

}
