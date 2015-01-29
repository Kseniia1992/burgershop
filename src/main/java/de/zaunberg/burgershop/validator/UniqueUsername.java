package de.zaunberg.burgershop.validator;

/**
 * Annotation class for user validation
 * @author ksolodovnik
 */

/** where annotation will be putted */
@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/** unique username is validated by UniqueUsernameValidator  */
@javax.validation.Constraint(validatedBy = {UniqueUsernameValidator.class})
public @interface UniqueUsername {

    java.lang.String message();

    java.lang.Class<?>[] groups() default {};

    java.lang.Class<? extends javax.validation.Payload>[] payload() default {};
}