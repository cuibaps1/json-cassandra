package com.example.jsoncassandra.repository;

import com.example.jsoncassandra.model.graph.PropertyKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyKeyRepository extends CassandraRepository<PropertyKey, String> {
}
