package com.smogorzhevskiy.crm.utility.transformers;

import com.google.common.base.Function;
import com.smogorzhevskiy.crm.entities.Artist;
import com.smogorzhevskiy.crm.entities.enums.Role;
import com.smogorzhevskiy.crm.forms.ArtistCreationForm;
import com.smogorzhevskiy.crm.repositories.ArtistRepository;
import com.smogorzhevskiy.crm.repositories.DirectionRepository;
import com.smogorzhevskiy.crm.repositories.CredentialRepository;
import com.smogorzhevskiy.crm.repositories.AdminRepository;
import com.smogorzhevskiy.crm.utility.RoleFormCreator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;

/**
 * Created by User on 28.04.16.
 */
public class ArtistTransformer implements Function<ArtistCreationForm, Artist> {
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

    @Nullable
    @Override
    public Artist apply(@Nullable ArtistCreationForm form) {
        Artist artist = new Artist();
        artist.setRole(roleFormCreator.createRoleForUser(
                form.getLogin(),
                form.getEmail(),
                form.getPassword(),
                Role.ROLE_ARTIST
        ));
        artist.setName(form.getName());
        artist.setSurname(form.getSurname());
//        artist.setGallery (systemAdminEntityRepository.findOneByRoleEntity(UtilSecurity.getCurrentLoggedUser()).getGallery());
        artist.setDirection(directionRepository.findByName(form.getDirection()));
        return  artist;
    }
}
