package com.example.jsoncassandra.service;

import com.example.jsoncassandra.mapper.TableSchemaMapper;
import com.example.jsoncassandra.model.dto.TableSchemaRequest;
import com.example.jsoncassandra.model.dto.TableSchemaResponse;
import com.example.jsoncassandra.model.graph.TableSchema;
import com.example.jsoncassandra.repository.TableSchemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableSchemaServiceImpl implements TableSchemaService{

  @Autowired
  private TableSchemaRepository tableSchemaRepository;

  @Override
  public TableSchemaResponse createTableSchema(TableSchemaRequest invitationRequest) {
    // map request to domain
    TableSchema tableSchema = TableSchemaMapper.toDomainFromRequest(invitationRequest);

    TableSchema updatedInvitationDomain = tableSchemaRepository.save(tableSchema);

    // map domain to response
    return TableSchemaMapper.toResponseFromDomain(updatedInvitationDomain);
  }
}
