package de.shop.util.cdi;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Stereotype;

/**
 * @author <a href="mailto:oguzhan.atmaca@web.de">Oguzhan Atmaca</a>
 */
@Alternative
@Stereotype
@Target(TYPE)
@Retention(RUNTIME)
@Documented
public @interface MockService {
}
