package emily;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Annotation for telling Emily to use this name as a SharedPreferences key
 * instead of the default one. <b>Please note that when using this annotation,
 * you need to annotate both the getter and the setter with the same name.</b>
 * <p>
 *
 * @author szantogabor
 * @since 1.0
 */

@Target({ElementType.METHOD})
public @interface Named {
    String value();
}