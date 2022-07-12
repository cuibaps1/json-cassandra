package com.example.jsoncassandra.model.graph;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.*;

@Data
@UserDefinedType("vertex_index_type")
public class VertexIndex {

  @Column("name")
  private String name;

  @Column("propertyKeys")
  private List<String> propertyKeys;

  @Column("index_only")
  private String indexOnly;

  @Column("mixed_index")
  private String mixedIndex;

  @Column("composite")
  private String composite;
}
