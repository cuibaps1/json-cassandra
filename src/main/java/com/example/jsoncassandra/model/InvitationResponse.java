package com.example.jsoncassandra.model;

import lombok.Data;

@Data
public class InvitationResponse {

  private String invitationType;
  private String invitationDate;
  private String invitationMessage;
  private String invitationTo;
  private String invitationFrom;
  private Address address;
  private String invitationId;
}
