package com.example.jsoncassandra.service;

import com.example.jsoncassandra.mapper.TableSchemaMapper;
import com.example.jsoncassandra.model.dto.TableSchemaRequest;
import com.example.jsoncassandra.model.dto.TableSchemaResponse;
import com.example.jsoncassandra.model.graph.TableSchema;
import com.example.jsoncassandra.repository.PropertyKeyRepository;
import com.example.jsoncassandra.repository.TableSchemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TableSchemaServiceImpl implements TableSchemaService{

  @Autowired
  private TableSchemaRepository tableSchemaRepository;

  @Autowired
  private PropertyKeyRepository propertyKeyRepository;

  @Override
  public TableSchemaResponse createTableSchema(TableSchemaRequest invitationRequest) {
    // map request to domain
    TableSchema tableSchema = TableSchemaMapper.toDomainFromRequest(invitationRequest);

    TableSchema updatedInvitationDomain = tableSchemaRepository.save(tableSchema);

    // map domain to response
    return TableSchemaMapper.toResponseFromDomain(updatedInvitationDomain);
  }

  @Override
  public List<TableSchemaResponse> getTableSchema() {
    tableSchemaRepository.findAll().forEach(t -> System.out.println(t.getName()));

    return StreamSupport.stream(tableSchemaRepository.findAll().spliterator(), false)
        .map(TableSchemaMapper::toResponseFromDomain)
        .collect(Collectors.toList());
  }

  @Override
  public void updateTableSchema(String name, TableSchemaRequest tableSchemaRequest) {
    tableSchemaRepository.findById(name).ifPresent(
        tableSchema -> {
          tableSchema.setPropertyKeys(tableSchemaRequest.getPropertyKeys());
          tableSchema.setVertexIndices(tableSchemaRequest.getVertexIndices());
          tableSchema.setVertexLabels(tableSchemaRequest.getVertexLabels());
          tableSchema.setEdgeLabels(tableSchemaRequest.getEdgeLabels());
          tableSchemaRepository.save(tableSchema);
        }
    );
  }
}
