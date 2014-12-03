package de.zaunberg.burgershop.service;

import de.zaunberg.burgershop.dao.UserDao;
import de.zaunberg.burgershop.model.Role;
import de.zaunberg.burgershop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * This class will be used by Spring Security to pickup users
 * and authenticate them.
 * @author ksolodovnik
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByName(username);

        if(user!=null) {
            String password = user.getPassword();
            //populate user roles
            List<GrantedAuthority> authorityCollection = new ArrayList<GrantedAuthority>();
            for (Role role : user.getRoles()) {
                authorityCollection.add(new GrantedAuthorityImpl(role.getRoleName()));
            }

            //create user Spring Security User object
            org.springframework.security.core.userdetails.User securityUser = new
                    org.springframework.security.core.userdetails.User(username, password,authorityCollection);
            return securityUser;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

