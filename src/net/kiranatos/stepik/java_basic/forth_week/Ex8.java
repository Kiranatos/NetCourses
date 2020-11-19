package net.kiranatos.stepik.java_basic.forth_week;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * В этой задаче вам нужно реализовать метод, 
 * настраивающий параметры логирования. Конфигурирование 
 * в коде позволяет выполнить более тонкую и хитрую настройку, 
 * чем при помощи properties-файла.

Требуется выставить такие настройки, чтобы:

- Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
- Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
- Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", 
    независимо от серьезности сообщения печатались в консоль в формате XML (*) 
    и не передавались вышестоящим обработчикам на уровнях "org.stepic", "org" и "".

Не упомянутые здесь настройки изменяться не должны.

(*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл.
Но проверяющая система не разрешает создавать файлы на диске, поэтому придется так.

Подсказки:

    Level есть не только у Logger, но и у Handler.
    Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.
 */

public class Ex8 {
    
    private static void configureLogging() {
        Logger logA = Logger.getLogger("org.stepic.java.logging.ClassA");
        logA.setLevel(Level.ALL);
        Logger logB = Logger.getLogger("org.stepic.java.logging.ClassB");
        logB.setLevel(Level.WARNING);
        
        Logger logZ = Logger.getLogger("org.stepic.java");
        logZ.setLevel(Level.ALL);
        
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setFormatter(new XMLFormatter());
        
        logZ.addHandler(ch);
        logZ.setUseParentHandlers(false);
}
    
}

/*
 -создаёте третий логгер Logger LOGGER3 = Logger.getLogger(" org.stepic.java ");
-устанавливаете ему уровень ALL
-создаёте ConsoleHandler
-устанавливаете и ему уровень ALL
-прикрепляете к нему XMLFormatter
-прикрепляете хэндлер к третьему логгеру

-от третьего логгера вызываете метод setUseParentHandlers(false)

Вуаля!

А делать его родителем не надо, т.к. он чисто по иерархии является родителем первого и второго логгера.
*/