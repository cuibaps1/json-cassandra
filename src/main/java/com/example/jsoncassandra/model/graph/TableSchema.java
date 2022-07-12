package com.example.jsoncassandra.model.graph;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.*;

@Data
@Table("table_schema")
public class TableSchema {

  @PrimaryKey
  @Column("name")
  private String name;

  @Column("propertyKeys")
  private List<PropertyKey> propertyKeys;

  @Column("vertexLabels")
  private List<VertexLabel> vertexLabels;

  @Column("edgeLabels")
  private List<EdgeLabel> edgeLabels;

  @Column("vertexIndices")
  private List<VertexIndex> vertexIndices;
}
