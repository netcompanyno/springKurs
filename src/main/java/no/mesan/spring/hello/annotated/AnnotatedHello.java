package no.mesan.spring.hello.annotated;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static no.mesan.utils.Strings.isEmpty;
import static no.mesan.utils.ClassUtils.pathToClass;

/** Hello world! */
public class AnnotatedHello {

    private static final String SPRING_CONFIG=
        pathToClass(AnnotatedHello.class) + "AnnotatedHello.spring.xml";

    public static void main(final String[] args) {
        String to= "world";
        if ( args.length!=0 && !isEmpty(args[0])) {
            to= args[0];
        }
        final Greeter greeter=
            (Greeter) new ClassPathXmlApplicationContext(SPRING_CONFIG)
                          .getBean("greeter");
        final String greet= greeter.greet(to);
        System.out.println(greet);
    }
}
