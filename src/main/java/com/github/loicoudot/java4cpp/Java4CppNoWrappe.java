package com.github.loicoudot.java4cpp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Disable the wrapping of an element. The annotation can be placed on public :
 * <ul>
 * <li>inner-class if {@code Java4Cpp(all = true)}</li>
 * <li>constructor if {@code Java4Cpp(all = true)}</li>
 * <li>method if {@code Java4Cpp(all = true)}</li>
 * <li>static field if {@code Java4Cpp(staticFields = true)}</li>
 * </ul>
 * 
 * @author Loic Oudot
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Java4CppNoWrappe {
}
