package com.spn.ec.spnticketwebapp;

import java.io.IOException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 * @author SC Daniel Lincango on 15 nov. 2020
 */
@Configuration
public class SpnTicketWebAppConfig {

	/**
	 * Data source connection.
	 * 
	 * @author SC Daniel Lincango on 15 nov. 2020
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	/**
	 * Load session factory.
	 * 
	 * @author SC Daniel Lincango on 15 nov. 2020
	 * @return
	 * @throws IOException
	 */
	@Bean
	public SessionFactory sessionFactory() throws IOException {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.spn.ec.spnticketwebapp.dto");
		sessionFactory.afterPropertiesSet();
		return sessionFactory.getObject();
	}

}
