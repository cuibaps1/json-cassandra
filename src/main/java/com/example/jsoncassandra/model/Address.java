package com.example.jsoncassandra.model;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@UserDefinedType("address_type")
public class Address {

  @Column("first_name")
  private String firstName;

  @Column("middle_initial")
  private String middleInitial;

  @Column("last_name")
  private String lastName;

  @Column("street_name")
  private String streetName;

  @Column("additional_address")
  private String additional_address;

  @Column("city")
  private String city;

  @Column("state")
  private String state;

  @Column("zip")
  private String zip;

  @Column("country")
  private String country;

  @Column("phone")
  private String phone;
}

