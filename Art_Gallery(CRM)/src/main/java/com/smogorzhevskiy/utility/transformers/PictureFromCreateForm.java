package com.smogorzhevskiy.utility.transformers;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Picture;
import com.smogorzhevskiy.forms.PictureCreationForm;
import com.smogorzhevskiy.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by User on 06.05.16.
 */
@Component
public class PictureFromCreateForm {
    @Autowired
    ArtistRepository artistRepository;
    public Picture pictureTransform(PictureCreationForm form, Artist artist) {

        if(form == null)
            return null;
        Picture picture = new Picture();
        picture.setName(form.getName());
        picture.setArtist_id(artistRepository.getOneByName(form.getArtist()).getId());
        return picture;
    }

}
