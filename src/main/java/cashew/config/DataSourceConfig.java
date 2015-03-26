package cashew.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Shipeng Xu on 25/3/15.
 */
@Configuration
@PropertySource("classpath:datasource_local.properties")
public class DataSourceConfig {
    @Value("${url}")
    private String localUrl;
    @Value("${username}")
    private String localUsername;
    @Value("${password}")
    private String localPassword;
    @Value("${driverClassName}")
    private String driverClassName;

    @Bean
    @Profile("local")
    public DataSource localDataSource() throws URISyntaxException {
        System.out.println("localDataSource()");
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(localUrl);
        basicDataSource.setUsername(localUsername);
        basicDataSource.setPassword(localPassword);
        return basicDataSource;
    }

    @Bean
    @Profile("dev")
    public DataSource devDataSource() throws URISyntaxException {
        System.out.println("devDataSource()");
        URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
        System.out.println(dbUri);
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    @Bean
    @Profile("live")
    public DataSource liveDataSource() throws URISyntaxException {
        System.out.println("liveDataSource()");
        URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }
}
