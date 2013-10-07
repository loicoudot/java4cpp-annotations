package com.github.loicoudot.java4cpp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Enable the wrapping of an element. The annotation can be placed on public :
 * <ul>
 * <li>inner-class if {@code Java4Cpp(all = false)}</li>
 * <li>constructor if {@code Java4Cpp(all = false)}</li>
 * <li>method if {@code Java4Cpp(all = false)}</li>
 * <li>static field if {@code Java4Cpp(staticFields = false)}</li>
 * </ul>
 * 
 * @author Loic Oudot
 * @version $Id: $Id
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Java4CppWrappe {
    /**
     * Sets this attribute to change the name of the generated element in the
     * C++ proxy.
     * <p>
     * By default the generated element have the same name as the corresponding
     * Java one. The name is escaped by the mappings configuration of java4cpp.
     * This value need to be a valid C++ name.
     */
    String value() default "";
}
