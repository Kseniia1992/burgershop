package de.zaunberg.burgershop.validator;

import de.zaunberg.burgershop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Instance of ConstraintValidator
 * @author ksolodovnik
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {

    @Autowired
    private ShopService service;

    @Override
    public void initialize(UniqueUsername uniqueUsername) {
    }

    /**
     * Checks the existence of the user
     * @param s - login
     * @param constraintValidatorContext
     * @return true - user doesn't exist
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       if(service==null)
           return true;
        return service.findUserByName(s)==null;     //true
    }

}