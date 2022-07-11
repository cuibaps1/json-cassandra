package com.example.jsoncassandra.service;

import com.example.jsoncassandra.model.InvitationRequest;
import com.example.jsoncassandra.model.InvitationResponse;

import java.util.*;
import java.time.LocalDate;

public interface InvitationService {

  InvitationResponse createInvitation(InvitationRequest invitationRequest);

//  List<InvitationResponse> getAllInvitationsForSpecificGuest(LocalDate invitationLocalDate, String invitationGuestName);
}
