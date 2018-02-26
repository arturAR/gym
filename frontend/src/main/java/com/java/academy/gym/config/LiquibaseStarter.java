package com.java.academy.gym.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import liquibase.servicelocator.ServiceLocator;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.liquibase.CommonsLoggingLiquibaseLogger;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

/**
 * Configure Liquibase and run it in @PostConstruct to sure that 'hbm2ddl' finished work
 */
@Configuration
@EnableConfigurationProperties(LiquibaseProperties.class)
public class LiquibaseStarter extends SpringLiquibase {

  private final LiquibaseProperties properties;

  private final ResourceLoader resourceLoader;

  private final DataSource dataSource;

  public LiquibaseStarter(
      LiquibaseProperties properties, ResourceLoader resourceLoader, DataSource dataSource) {
    this.properties = properties;
    this.resourceLoader = resourceLoader;
    this.dataSource = dataSource;
  }

  @PostConstruct
  public void start() throws LiquibaseException {
    if (this.properties.isCheckChangeLogLocation()) {
      Resource resource = this.resourceLoader
          .getResource(this.properties.getChangeLog());
      Assert.state(resource.exists(),
          "Cannot find changelog location: " + resource
              + " (please add changelog or check your Liquibase "
              + "configuration)");
    }
    ServiceLocator serviceLocator = ServiceLocator.getInstance();
    serviceLocator.addPackageToScan(
        CommonsLoggingLiquibaseLogger.class.getPackage().getName());
    this.setChangeLog(this.properties.getChangeLog());
    this.setContexts(this.properties.getContexts());
    this.setDataSource(dataSource);
    this.setDefaultSchema(this.properties.getDefaultSchema());
    this.setShouldRun(true);
    this.setLabels(this.properties.getLabels());
    this.setChangeLogParameters(this.properties.getParameters());
    super.afterPropertiesSet();
  }
}
