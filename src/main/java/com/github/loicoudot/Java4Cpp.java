package com.github.loicoudot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to controls C++ proxies generation.
 * <p>
 * A {@code class}, {@code interface} or {@code enum} annotated with
 * {@code Java4Cpp} will be added to the java4cpp list of classes to be
 * processed. Controls the mappings between the java type and the proxy with the
 * annotation attributes.
 * 
 * @author Loic Oudot
 * @version $Id: $Id
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Java4Cpp {
    /**
     * The name of the C++ class proxy for the current type.
     * <p>
     * By default, the C++ class proxy have the same name as the current type.
     * <p>
     * You have to provide a valid C++ class name (no C/C++ reserved words).
     */
    String name() default "";

    /**
     * Enable the generation of the C++ proxy of the superclass and derive the
     * C++ proxy from this class.
     * <p>
     * By default, {@code superclass} is {@code false} and the superclass of the
     * current type will not be added to the java4cpp list of classes.
     * <p>
     * Sets {@code superclass} to {@code true}, will had the superclass type to
     * the java4cpp list of classes.
     * <p>
     * If {@code superclass} is set on type with no superclass (java.lang.Object
     * for exemple), the annotation has no effects.
     * <p>
     * Due to the mecanism of dependency management of java4cpp, even if
     * {@code superclass} is {@code false}, if a method requiere this type as a
     * parameter or as a return type, then the corresponding C++ proxy of the
     * superclass will be generated, BUT the C++ proxy will not be the
     * superclass of this C++ proxy.
     */
    boolean superclass() default false;

    /**
     * Enable the generation of the C++ proxies for the interfaces classes
     * implemented by the current type.
     * <p>
     * By default, {@code interfaces} is {@code false} and only the interfaces
     * classes that appears in {@code wrappeInterfaces} will be added to the
     * java4cpp list of classes.
     * <p>
     * Sets {@code interfaces} to {@code true} will add all the interfaces
     * classes implemented by the current type except those which appears in
     * {@code noWrappeInterfaces}.
     * <p>
     * If the current type has no interfaces, the annotation has no effects.
     */
    boolean interfaces() default false;

    /**
     * Enable the generation of the C++ proxies for the listed interfaces
     * classes implemented by the current type.
     * <p>
     * If {@code interfaces} is {@code false} then the interfaces classes that
     * appears in this list will be added to the java4cpp list of classes.
     * <p>
     * If {@code interfaces} is {@code true}, {@code wrappeInterfaces} will be
     * ignored.
     * <p>
     * It's not an error if a listed class does not appear in the implemented
     * interfaces of the current type.
     */
    Class<?>[] wrappeInterfaces() default {};

    /**
     * Disable the generation of the C++ proxies for the listed interfaces
     * classes implemented by the current type.
     * <p>
     * If {@code interfaces} is {@code true} then the interfaces classes that
     * appears in this list will not be added to the java4cpp list of classes.
     * <p>
     * If {@code interfaces} is {@code false}, {@code noWrappeInterfaces} will
     * be ignored.
     * <p>
     * It's not an error if a listed class does not appear in the interfaces of
     * the current type.
     */
    Class<?>[] noWrappeInterfaces() default {};

    /**
     * Enable the generation of the public methods and public inner-classes of
     * the class.
     * <p>
     * By default, {@code all} is {@code true} and all the public methods and
     * public inner-classes declared in the class will be added to the C++
     * proxy. If the annotation {@code Java4CppNoWrappe} is present for a method
     * or an inner-class, this later will not be added to the C++ proxy class.
     * <p>
     * If {@code all} is {@code false}, then nothing will be added to the C++
     * proxy class unless the annotation {@code Java4CppWrappe} will be present
     * for a public method or a public inner-class.
     * <p>
     * Note that for the case of an inner-class (static or not), it is possible
     * to use the {@code Java4Cpp} annotation instead of {@code Java4CppWrappe}
     * to gain a finner control of the corresponding generated C++ proxy
     * (superclass, interfaces etc.).
     * <p>
     * It is not an error to annotate a method or an inner-class with
     * {@code Java4CppWrappe} if {@code all} is {@code true}, or with
     * {@code Java4CppNoWrappe} if {@code all} is {@code false}.
     * <p>
     * Due to the mecanism of dependency management of java4cpp, even if an
     * inner-class is annotated with {@code Java4CppNoWrappe}, if an exported
     * method has this inner-class as a parameters or as a return type, then the
     * inner-class will be wrapped.
     */
    boolean all() default true;

    /**
     * Enable the generation of the public static fields of the class.
     * <p>
     * By default, {@code staticFields} is {@code false}, and no public static
     * fields will be added to the C++ proxy class unless the annotation
     * {@code Java4CppWrappe} is present for a particular public static field.
     * <p>
     * If {@code staticFields} is {@code true} then all the public static fields
     * declared in the class will be added to the C++ proxy. If the annotation
     * {@code Java4CppNoWrappe} is present for a public static field, this later
     * will not be added to the C++ proxy class.
     * <p>
     * It is not an error to annotate a static field with {@code Java4CppWrappe}
     * if {@code staticFields} is {@code true}, or with {@code Java4CppNoWrappe}
     * if {@code staticFields} is {@code false}.
     */
    boolean staticFields() default false;
}
