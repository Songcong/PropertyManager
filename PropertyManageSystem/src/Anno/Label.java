/**
 * 
 */
package Anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author admin
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Label {
	String value() default "";
}
