package ph.com.alliance.ServiceChargeApp5.config;

import org.springframework.context.annotation.Configuration;
//import org.javers.core.Javers;
//import org.javers.hibernate.integration.HibernateUnproxyObjectAccessHook;
//import org.javers.repository.sql.ConnectionProvider;
//import org.javers.repository.sql.DialectName;
//import org.javers.repository.sql.JaversSqlRepository;
//import org.javers.repository.sql.SqlRepositoryBuilder;
//import org.javers.spring.jpa.JpaHibernateConnectionProvider;
//import org.javers.spring.jpa.TransactionalJpaJaversBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig {
	
}
