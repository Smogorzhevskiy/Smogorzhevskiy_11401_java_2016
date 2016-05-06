package com.smogorzhevskiy.repository;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 19.04.16.
 */
@Repository
public interface PictureRepository extends JpaRepository<Picture, java.lang.Integer> {

    Picture findOneById(java.lang.Integer id);

    List<Picture> findAllByArtist(Artist artist);

    List<Picture> findAllByArtistCredentialLogin(String login);
}
