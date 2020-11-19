package net.kiranatos.epam.summer20.p1.ex4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD, ElementType.METHOD })
 
// Симулирует тег  (tag) <LI> в HTML.
public @interface AnnHtmlLI {
 
    public String background();
 
    public String color() default "red";
     
}