package com.example.jsoncassandra.model.dto;

import com.example.jsoncassandra.model.graph.EdgeLabel;
import com.example.jsoncassandra.model.graph.PropertyKey;
import com.example.jsoncassandra.model.graph.VertexIndex;
import com.example.jsoncassandra.model.graph.VertexLabel;
import lombok.Data;

import java.util.*;

@Data
public class TableSchemaRequest {

  private String name;
  private List<PropertyKey> propertyKeys;
  private List<VertexLabel> vertexLabels;
  private List<EdgeLabel> edgeLabels;
  private List<VertexIndex> vertexIndices;


}
