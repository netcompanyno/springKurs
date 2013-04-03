package no.mesan.hello0;

import static no.mesan.utils.Strings.isEmpty;

/** Hello world! */
public class HelloApp {

    private static final String GREET= "Hello";

    public static void main(final String[] args) {
        String to= "world";
        String format= "HTML";
        if ( args.length!=0 && !isEmpty(args[0])) {
            format= args[0].toUpperCase();
        }
        if ( args.length>1 && !isEmpty(args[1])) {
            to= args[1];
        }
        String result= "UNKNOWN FORMAT REQUESTED";
        if ( "HTML".equals(format) ) {
            result= new HtmlFormatter().format(GREET, to);
        }
        if ( "XML".equals(format) ) {
            result= new XmlFormatter().format(GREET, to);
        }
        if ( "TEXT".equals(format) ) {
            result= new TextFormatter().format(GREET, to);
        }
        System.out.println(result);
    }

}
