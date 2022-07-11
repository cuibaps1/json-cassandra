package com.example.jsoncassandra.controller;

import com.example.jsoncassandra.model.InvitationRequest;
import com.example.jsoncassandra.model.InvitationResponse;
import com.example.jsoncassandra.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.time.LocalDate;

import static com.example.jsoncassandra.mapper.InvitationMapper.getLocalDateFromString;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/invitation")
public class InvitationController {

    @Autowired
    InvitationService invitationService;

    @PostMapping
    public ResponseEntity createInvitation(@RequestBody InvitationRequest invitationRequest) {

      InvitationResponse invitationResponse = invitationService.createInvitation(invitationRequest);

      if (null != invitationResponse) {
        return new ResponseEntity(invitationResponse, OK);
      } else {
        return new ResponseEntity("Issue while writing invitationRequest message", BAD_REQUEST);
      }
    }



//    @GetMapping("/{invitationGuestName}")
//    public ResponseEntity getInvitationForTheGuest(@RequestParam String invitationDate, @PathVariable String invitationGuestName) {
//      LocalDate invitationLocalDate = getLocalDateFromString(invitationDate);
//      List<InvitationResponse> invitationResponseList = invitationService.getAllInvitationsForSpecificGuest(invitationLocalDate, invitationGuestName);
//
//      if (!CollectionUtils.isEmpty(invitationResponseList)) {
//        return new ResponseEntity(invitationResponseList, OK);
//      } else {
//        return new ResponseEntity("No invitation exists", OK);
//      }
//    }


}
