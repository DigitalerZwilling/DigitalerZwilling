/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatenbankSchnittestelle.Qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

/**
 *
 * @author chrklaas
 */
@Qualifier
@Target({TYPE,METHOD,FIELD,PARAMETER})
@Retention(RUNTIME)
public @interface DB_Info {
    @Nonbinding
    String db_name() default "";
    @Nonbinding        
    String db_user() default "";
    @Nonbinding
    String db_pw() default "";
}
