package com.example.jsoncassandra.repository;

import com.example.jsoncassandra.model.Invitation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvitationRepository extends CrudRepository<Invitation, UUID> {

}

