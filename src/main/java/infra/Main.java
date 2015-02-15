package infra;

import org.apache.commons.configuration.*;

import org.slf4j.*;

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
