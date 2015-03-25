package cashew;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

/**
 * Created by Shipeng Xu on 7/1/15.
 */

@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
public class cashewApplication {

    public static void main(String[] args) {
        String profile = "local";
        if(args.length>=1) {
            for(String arg: args) {
                if (arg.contains("-Dspring.profiles.active=")) {
                    profile = arg.substring(arg.lastIndexOf("=") + 1);
                }
            }
        }
        System.out.println("Using profile: " + profile);
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, profile);
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, profile);

        SpringApplication.run(cashewApplication.class, args);
    }
}
