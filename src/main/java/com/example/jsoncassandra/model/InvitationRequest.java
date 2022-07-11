package com.example.jsoncassandra.model;

import lombok.Data;

@Data
public class InvitationRequest {

  private String invitationType;
  private String invitationDate;
  private String invitationMessage;
  private String invitationTo;
  private String invitationFrom;
  private Address address;

}
