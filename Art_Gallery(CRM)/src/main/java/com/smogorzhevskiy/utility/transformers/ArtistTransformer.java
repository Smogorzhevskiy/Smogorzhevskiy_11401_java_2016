package com.smogorzhevskiy.utility.transformers;

import com.google.common.base.Function;
import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.enums.Role;
import com.smogorzhevskiy.forms.ArtistCreationForm;
import com.smogorzhevskiy.repository.ArtistRepository;
import com.smogorzhevskiy.repository.DirectionRepository;
import com.smogorzhevskiy.repository.CredentialRepository;
import com.smogorzhevskiy.repository.AdminRepository;
import com.smogorzhevskiy.utility.RoleFormCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ArtistTransformer  implements Function<ArtistCreationForm, Artist> {
    @Autowired
    RoleFormCreator roleFormCreator;
    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    DirectionRepository directionRepository;
    @Autowired
    AdminRepository adminRepository;


    @Override
    public Artist apply(ArtistCreationForm form) {
        Artist artist = new Artist();
        artist.setCredential(roleFormCreator.createRoleForUser(
                form.getLogin(),
                form.getEmail(),
                form.getPassword(),
                Role.ROLE_ARTIST
        ));
        artist.setName(form.getName());
        artist.setSurname(form.getSurname());
//        artist.setGallery (artistRepository.findByName(form.getName()).getGallery());
//        artist.setGallery (adminRepository.findOneByRoleEntity(UtilSecurity.getCurrentLoggedUser()).getGallery());
        artist.setDirection(directionRepository.findByName(form.getDirection()));
        return  artist;
    }
}
