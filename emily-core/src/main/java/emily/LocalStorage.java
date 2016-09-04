package emily;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * <p>
 * Annotation for marking an <b>interface</b> as a local storage.
 * Emily will generate an implementation for these classes with
 * the prefix "Emily".
 * </p>
 *
 * @author szantogabor
 * @since 1.0
 */

@Target({ElementType.TYPE})
public @interface LocalStorage {
    /**
     * @return Whether the custom objects are cached or not.
     */
    boolean cached() default true;
}