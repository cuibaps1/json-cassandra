package com.example.jsoncassandra.model.graph;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@UserDefinedType("property_key_type")
public class PropertyKey {

  @Column("name")
  private String name;

  @Column("data_type")
  private String dataType;

  @Column("cardinality")
  private String cardinality;

}
