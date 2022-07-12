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

    System.out.println("creating UDT property_keys_type");
    cqlSession.execute("CREATE TYPE IF NOT EXISTS cassandra_udt.property_key_type (\n" +
        "name text,\n" +
        "data_type text,\n" +
        "cardinality text\n" +
        ");");

    System.out.println("creating UDT vertex_label_type");
    cqlSession.execute("CREATE TYPE IF NOT EXISTS cassandra_udt.vertex_label_type (\n" +
        "name text\n" +
        ");");

    System.out.println("creating UDT edge_label_type");
    cqlSession.execute("CREATE TYPE IF NOT EXISTS cassandra_udt.edge_label_type (\n" +
        "name text,\n" +
        "multiplicity text\n" +
        ");");

    System.out.println("creating UDT vertex_index_type");
    cqlSession.execute("CREATE TYPE IF NOT EXISTS cassandra_udt.vertex_index_type (\n" +
        "name text,\n" +
        "propertyKeys list<text>,\n" +
        "index_only text,\n" +
        "mixed_index text,\n" +
        "composite text\n" +
        ");");

    System.out.println("creating schema table ");
    cqlSession.execute("CREATE TABLE IF NOT EXISTS cassandra_udt.table_schema (\n" +
        "name text,\n" +
        "propertyKeys list<frozen<cassandra_udt.property_key_type>>,\n" +
        "vertexLabels list<frozen<cassandra_udt.vertex_label_type>>,\n" +
        "edgeLabels list<frozen<cassandra_udt.edge_label_type>>,\n" +
        "vertexIndices list<frozen<cassandra_udt.vertex_index_type>>,\n" +
        "primary key(name)\n" +
        ");");
  }

  @Bean
  public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
    Path bundle = astraProperties.getSecureConnectBundle().toPath();
    return cqlSessionBuilder -> cqlSessionBuilder.withCloudSecureConnectBundle(bundle);
  }
}
