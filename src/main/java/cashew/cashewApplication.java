package cashew;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Shipeng Xu on 7/1/15.
 */

@ComponentScan
@EnableAutoConfiguration
public class cashewApplication {

    public static void main(String[] args) {
        SpringApplication.run(cashewApplication.class, args);
    }

}
