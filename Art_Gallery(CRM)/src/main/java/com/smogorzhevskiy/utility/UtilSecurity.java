package com.smogorzhevskiy.utility;

import com.smogorzhevskiy.entities.Credential;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by User on 29.04.16.
 */
public class UtilSecurity {
    public static Credential getCurrentLoggedUser(){
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         Credential user = (Credential) authentication.getPrincipal();
        return user;
    }

}
