package com.example.jsoncassandra.model.graph;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@UserDefinedType("edge_label_type")
public class EdgeLabel {
  @Column("name")
  private String name;

  @Column("multiplicity")
  private String multiplicity;
}
