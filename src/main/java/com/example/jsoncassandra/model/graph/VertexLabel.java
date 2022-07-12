package com.example.jsoncassandra.model.graph;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@UserDefinedType("vertex_label_type")
public class VertexLabel {

  @Column("name")
  private String name;
}
