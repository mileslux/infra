package com.infra.common;

import com.infra.common.com.infra.common.rest.TestMethod;
import org.apache.commons.configuration.*;

import org.slf4j.*;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by nop on 2/10/15.
 */
public class Main {
    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        ////
        logger.info("Starting program");

        ////
        readConfiguration();

        ////
        System.out.println("Hello world!");

        //// start servlet
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                TestMethod.class.getCanonicalName());


        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }

    public static void readConfiguration() throws org.apache.commons.configuration.ConfigurationException {
        //// manual control
        //CompositeConfiguration configuration = new CompositeConfiguration();
        //configuration.addConfiguration(new PropertiesConfiguration("application.properties"));
        //
        //// this returns a string from application.properties file
        //String q = configuration.getString("greeting");



        //// automatic
        DefaultConfigurationBuilder defaultConfigurationBuilder = new DefaultConfigurationBuilder("config.xml");
        Configuration configuration = defaultConfigurationBuilder.getConfiguration();

        // this returns a string from application.properties file
        String greetingString = configuration.getString("greeting");

        logger.debug("Greeting string is {}", greetingString);
    }

}
