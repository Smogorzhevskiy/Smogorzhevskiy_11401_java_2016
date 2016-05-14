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
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SavePicture {
    public static String savePhoto(MultipartFile photo, String type) {

        final String SAVE_DIR_USER = "users";

        final String SAVE_DIR_CLASS = "classes";

        String filename = null;

        final String SAVE_DIR;
        if ("class".equals(type)) {
            SAVE_DIR = SAVE_DIR_CLASS;
        } else if ("user".equals(type)) {
            SAVE_DIR = SAVE_DIR_USER;
        } else {
            return null;
        }

        if (!photo.isEmpty()) {
            try {
                byte[] bytes = photo.getBytes();
                filename = photo.getOriginalFilename();
                String rootPath = "//Users/User/Desktop/Work/Programming/Smogorzhevskiy_11401_java_2016/Tasks2k_4s_2016/Art_Gallery(CRM)/target/art_gallery-1.0-SNAPSHOT/resources/images";
                File dir = new File(rootPath + File.separator + SAVE_DIR);
                System.out.println("Root path1 - target: " + rootPath);

                String rootPath2 = "/Users/User/Desktop/Work/Programming/Smogorzhevskiy_11401_java_2016/Tasks2k_4s_2016/Art_Gallery(CRM)/src/main/webapp/resources/images";
                File dir2 = new File(rootPath2 + File.separator + SAVE_DIR);

                System.out.println("Root path2: " + rootPath2);

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + filename);
                File uploadedFile2 = new File(dir2.getAbsolutePath() + File.separator + filename);

                System.out.println("uploadedFile" + uploadedFile.toPath());
                System.out.println("uploadedFile2" + uploadedFile2.toPath());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                stream.flush();
                stream.close();
                BufferedOutputStream stream2 = new BufferedOutputStream(new FileOutputStream(uploadedFile2));
                stream2.write(bytes);
                stream2.flush();
                stream2.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return filename;
    }
}
