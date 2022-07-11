package com.example.jsoncassandra.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Table("invitation")
@EqualsAndHashCode(doNotUseGetters = true, of = {"invitationId"})
public class Invitation {

  @PrimaryKey
  private UUID id;

  @Column("invitation_date")
  private LocalDate invitationDate;

  @Column("invitation_to")
  private String invitationTo;

  @Column("invitation_id")
  private UUID invitationId;

  @Column("invitation_type")
  private String invitationType;

  @Column("invitation_message")
  private String invitationMessage;

  @Column("invitation_from")
  private String invitationFrom;

  @Frozen
  private Address address;

}

