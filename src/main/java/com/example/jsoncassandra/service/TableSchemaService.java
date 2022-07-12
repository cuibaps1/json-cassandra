package com.example.jsoncassandra.service;

import com.example.jsoncassandra.model.dto.TableSchemaRequest;
import com.example.jsoncassandra.model.dto.TableSchemaResponse;
import com.example.jsoncassandra.model.graph.TableSchema;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TableSchemaService {
  TableSchemaResponse createTableSchema(TableSchemaRequest invitationRequest);

  List<TableSchemaResponse> getTableSchema();
}
