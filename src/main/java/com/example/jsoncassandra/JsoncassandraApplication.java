package com.example.jsoncassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.example.jsoncassandra.configuration.DataStaxAstraProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.nio.file.Path;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class JsoncassandraApplication {

  @Autowired
  CqlSession cqlSession;

  public static void main(String[] args) {
    SpringApplication.run(JsoncassandraApplication.class, args);
  }

  @PostConstruct
  public void start() {
//    System.out.println("creating keyspace");
//    cqlSession.execute("CREATE KEYSPACE main WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };");
    System.out.println("creating address_type table");
    cqlSession.execute("CREATE TYPE IF NOT EXISTS main.address_type (\n" +
        "first_name text,\n" +
        "middle_initial text,\n" +
        "last_name text,\n" +
        "street_name text,\n" +
        "additional_address text,\n" +
        "city text,\n" +
        "state text,\n" +
        "zip text,\n" +
        "country text,\n" +
        "phone text,\n" +
        ");");

    System.out.println("creatuing invitation table ");
    cqlSession.execute("CREATE TABLE IF NOT EXISTS main.invitation (\n" +
        "invitation_date date,\n" +
        "invitation_to text,\n" +
        "invitation_id uuid,\n" +
        "invitation_type text,\n" +
        "invitation_message text,\n" +
        "invitation_from text,\n" +
        "address frozen<main.address_type>,\n" +
        "primary key(invitation_date, invitation_to, invitation_id)\n" +
        ") with comment='Cassandra UDT Table';");
  }



  @Bean
  public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
    Path bundle = astraProperties.getSecureConnectBundle().toPath();
    return cqlSessionBuilder -> cqlSessionBuilder.withCloudSecureConnectBundle(bundle);
  }
}
