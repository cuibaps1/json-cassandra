package com.example.jsoncassandra.service;

import com.example.jsoncassandra.mapper.InvitationMapper;
import com.example.jsoncassandra.model.Invitation;
import com.example.jsoncassandra.model.InvitationRequest;
import com.example.jsoncassandra.model.InvitationResponse;
import com.example.jsoncassandra.repository.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.example.jsoncassandra.mapper.InvitationMapper.getLocalDateFromString;

@Service
public class InvitationServiceImpl implements InvitationService{

  @Autowired
  private InvitationRepository invitationRepository;

  @Override
  public InvitationResponse createInvitation(InvitationRequest invitationRequest) {

    // map request to domain
    Invitation invitationDomain = InvitationMapper.toDomainFromRequest(invitationRequest);
    invitationDomain.setId(UUID.randomUUID());
    invitationDomain.setInvitationId(UUID.randomUUID());

    Invitation updatedInvitationDomain = invitationRepository.save(invitationDomain);

    // map domain to response
    InvitationResponse invitationResponse = InvitationMapper.toResponseFromDomain(updatedInvitationDomain);
    return invitationResponse;
  }

//  @Override
//  public List<InvitationResponse> getAllInvitationsForSpecificGuest(LocalDate invitationDate, String guestName) {
//    List<Invitation> invitationList = invitationRepository.findAll();
//
//    // map domain to response
//    List<InvitationResponse> invitationResponseList = InvitationMapper.toResponseListFromDomain(invitationList);
//    return invitationResponseList;
//  }


}
