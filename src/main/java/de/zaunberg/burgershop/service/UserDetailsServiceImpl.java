package de.zaunberg.burgershop.service;

import de.zaunberg.burgershop.model.Role;
import de.zaunberg.burgershop.model.ShopUser;
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
 * This class will be used by Spring Security for lookup of users
 * and authenticating them.
 * @author ksolodovnik
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private ShopService service;

    /**
     * Creates spring security user instance with populated values
     * @param username - login
     * @return secure user
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ShopUser shopUser = service.findUserByName(username);

        if(shopUser !=null) {
            String password = shopUser.getPassword();
            //populate user roles
            List<GrantedAuthority> authorityCollection = new ArrayList<GrantedAuthority>();
            for (Role role : shopUser.getRoles()) {
                authorityCollection.add(new GrantedAuthorityImpl(role.getRoleName()));
            }
            //create Spring Security User object
            org.springframework.security.core.userdetails.User securityUser = new
                    org.springframework.security.core.userdetails.User(username, password,authorityCollection);
            return securityUser;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}


