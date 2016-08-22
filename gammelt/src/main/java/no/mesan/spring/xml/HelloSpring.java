package no.mesan.spring.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static no.mesan.utils.ClassUtils.pathToClass;
import static no.mesan.utils.Strings.isEmpty;

/** Hello world! */
public class HelloSpring {

    private static final String SPRING_CONFIG=
        pathToClass(HelloSpring.class) + "Hello.spring.xml";

    public static void main(final String[] args) {
        String to= System.getProperty("user.name");
        if ( args.length!=0 && !isEmpty(args[0])) {
            to= args[0];
        }
        final Greeter greeter=
            new ClassPathXmlApplicationContext(SPRING_CONFIG)
                          .getBean(Greeter.class);
        final String greet= greeter.greet(to);
        System.out.println(greet);
    }
}
