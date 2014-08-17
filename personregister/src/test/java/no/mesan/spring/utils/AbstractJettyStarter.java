package no.mesan.spring.utils;

import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.util.StopWatch;

/**
 * Starter jetty med gitte parametre. Implementeres av de prosjektene som trenger denne.
 *
 * @author tmo
 */
public abstract class AbstractJettyStarter {
    private final int port;
    private final String warPath;
    private final String contextPath;

    private Server server;
    private String descriptor;

    protected AbstractJettyStarter(final int port, final String warPath, final String contextPath) {
        this.port = port;
        this.warPath = warPath;
        this.contextPath = contextPath;
    }

    protected AbstractJettyStarter(final int port, final String warPath, final String contextPath, final String descriptor) {
        this.port = port;
        this.warPath = warPath;
        this.contextPath = contextPath;
        this.descriptor = descriptor;
    }

    protected void start() throws Exception {
        setupProperties();

        server = new Server(port);
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final WebAppContext context = new WebAppContext();
        context.setServer(server);
        context.getInitParams().put("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");
        context.getInitParams().put("org.eclipse.jetty.servlet.Default.aliases", "true");
        context.getInitParams().put("useFileMappedBuffer", "false");
        context.setContextPath(contextPath);
        context.setWar(warPath);
        if (descriptor != null) {
            context.setDescriptor(warPath + descriptor);
        }

        server.setHandler(context);
        server.start();

        stopWatch.stop();
        System.out.println("Server startet etter " + stopWatch.getTotalTimeSeconds() + " sekunder!");

        server.join();
    }

    /**
     * Sett opp nødvendige systemproperties i subklasser. Eksempel:<br/>
     * <code>
     *     System.setProperty("my.property", "myPropertyValue");
     * </code>
     */
    protected abstract void setupProperties();
}
