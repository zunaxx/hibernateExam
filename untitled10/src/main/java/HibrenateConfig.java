import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibrenateConfig {
    public static EntityManagerFactory EntityManagerFactory(){
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER,"org.postgresql.Driver");
        properties.put(Environment.URL,"jdbc:postgresql://localhost:5432/java11");
        properties.put(Environment.USER,"postgres");
        properties.put(Environment.PASS,"wsk11-pk");
        properties.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL,"true");
        properties.put(Environment.HBM2DDL_AUTO,"create");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }

}
