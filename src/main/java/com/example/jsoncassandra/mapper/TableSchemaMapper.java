package com.example.jsoncassandra.mapper;

import com.example.jsoncassandra.model.dto.TableSchemaRequest;
import com.example.jsoncassandra.model.dto.TableSchemaResponse;
import com.example.jsoncassandra.model.graph.TableSchema;

public class TableSchemaMapper {
    public static TableSchema toDomainFromRequest(TableSchemaRequest tableSchemaRequest) {
    if (null != tableSchemaRequest) {
      TableSchema tableSchema = new TableSchema();
      tableSchema.setName(tableSchemaRequest.getName());
      tableSchema.setPropertyKeys(tableSchemaRequest.getPropertyKeys());
      tableSchema.setVertexLabels(tableSchemaRequest.getVertexLabels());
      tableSchema.setEdgeLabels(tableSchemaRequest.getEdgeLabels());
      tableSchema.setVertexIndices(tableSchemaRequest.getVertexIndices());
      return tableSchema;
    }
    return null;
  }

  public static TableSchemaResponse toResponseFromDomain(TableSchema tableSchema) {
    if (null != tableSchema) {
      TableSchemaResponse tableSchemaResponse = new TableSchemaResponse();
      tableSchemaResponse.setName(tableSchema.getName());
      tableSchemaResponse.setPropertyKeys(tableSchema.getPropertyKeys());
      tableSchemaResponse.setVertexLabels(tableSchema.getVertexLabels());
      tableSchemaResponse.setEdgeLabels(tableSchema.getEdgeLabels());
      tableSchemaResponse.setVertexIndices(tableSchema.getVertexIndices());
      return tableSchemaResponse;
    }
    return null;
  }

//  public static List<InvitationResponse> toResponseListFromDomain(List<Invitation> invitationList) {
//    List<InvitationResponse> invitationResponseList = null;
//    if (!CollectionUtils.isEmpty(invitationList)) {
//      invitationResponseList = new ArrayList<>();
//      for (Invitation invitation: invitationList) {
//        InvitationResponse invitationResponse = toResponseFromDomain(invitation);
//        invitationResponseList.add(invitationResponse);
//      }
//    }
//    return invitationResponseList;
//  }
}
