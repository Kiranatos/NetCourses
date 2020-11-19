package net.kiranatos.epam.summer20.p1.ex4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
@Retention(RetentionPolicy.RUNTIME)
 
// Данная аннотация (Annotation) говорит:
// AnnHtmlUL используется только для Class, interface, annotation, enum.
@Target(value = { ElementType.TYPE })
 
// AnnHtmlUL: Симулирует тег (tag) <UL> в HTML.
public @interface AnnHtmlUL {
 
    public String border() default "border:1px solid blue;";
     
}