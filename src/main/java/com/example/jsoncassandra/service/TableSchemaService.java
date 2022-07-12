package com.example.jsoncassandra.service;

import com.example.jsoncassandra.model.dto.TableSchemaRequest;
import com.example.jsoncassandra.model.dto.TableSchemaResponse;
import com.example.jsoncassandra.model.graph.TableSchema;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TableSchemaService {
  TableSchemaResponse createTableSchema(TableSchemaRequest tableSchemaRequest);

  List<TableSchemaResponse> getTableSchema();

  void updateTableSchema(String name, TableSchemaRequest tableSchemaRequest);
}
