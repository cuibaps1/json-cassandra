package com.example.jsoncassandra.repository;

import com.example.jsoncassandra.model.graph.TableSchema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableSchemaRepository extends CrudRepository<TableSchema, String> {
}