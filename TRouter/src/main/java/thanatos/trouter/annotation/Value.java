package thanatos.trouter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import thanatos.trouter.control.Type;

/**
 * Created on 2017/2/21.
 * 作者：by thanatos
 * 作用：
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Value {
    String name() default "android://*";
    Type type() default Type.Activity;
}
