package com.smogorzhevskiy.utility.transformers;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.entities.enums.Role;
import com.smogorzhevskiy.forms.ArtistCreationForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by User on 05.05.16.
 */
public class ArtistFromRegForm {
        static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        public static Artist artistTransform(ArtistCreationForm form, Credential credential){
            if(form==null)
                return null;
            Artist artist=new Artist();
            artist.setName(form.getName());
            artist.setCredential(credential);
            artist.setSurname(form.getSurname());
            return artist;
        }

        public static Credential transformCredential(ArtistCreationForm form){
            if(form==null)
                return null;
            Credential credential = new Credential();
            credential.setLogin(form.getLogin());
            credential.setPassword(encoder.encode(form.getPassword()));
            credential.setRole(Role.ROLE_ARTIST);
            return credential;
        }

}
