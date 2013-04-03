package no.mesan.hello0;


/** Hello world! */
public class HelloApp {

    private static final String GREET= "Hello";

    public static void main(final String[] args) {
        final String to= "world";
        // FIXME -- vil kunne konfigurere denne!
        final String result= new HtmlFormatter().format(GREET, to);
        System.out.println(result);
    }

}
