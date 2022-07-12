package com.example.jsoncassandra.service;

import com.example.jsoncassandra.model.dto.TableSchemaRequest;
import com.example.jsoncassandra.model.dto.TableSchemaResponse;

public interface TableSchemaService {
  TableSchemaResponse createTableSchema(TableSchemaRequest invitationRequest);
}
