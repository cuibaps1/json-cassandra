//package com.example.jsoncassandra.repository;
//
//
////import com.datastax.oss.driver.api.core.cql.Statement;
////import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
////import com.datastax.oss.driver.api.querybuilder.delete.Delete;
//import com.datastax.driver.core.Statement;
//import com.datastax.driver.core.querybuilder.QueryBuilder;
//import com.example.jsoncassandra.model.Invitation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.cassandra.core.CassandraOperations;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.util.*;
//
//import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;
//
//@Repository
//public class InvitationRepositoryImpl implements InvitationRepository {
//  private static final String TBL_INVITATION = "invitation";
//
//  private static final String COL_INVITATION_TO = "invitation_to";
//
//  private static final String COL_INVITATION_ID = "invitation_id";
//
//  private static final String COL_INVITATION_DATE = "invitation_date";
//  @Autowired
//  private CassandraOperations cassandraOperations;
//
//  @Override
//  public Invitation createInvitation(Invitation invitation) {
//    return cassandraOperations.insert(invitation);
//  }
//
//  @Override
//  public Invitation updateInvitation(Invitation invitation) {
//    return cassandraOperations.update(invitation);
//  }
//
//  @Override
//  public List<Invitation> getAllInvitationsForSpecificGuest(LocalDate invitationDate, String guestName) {
//    Statement statement = QueryBuilder.select().all()
//        .from(TBL_INVITATION)
//        .where(eq(COL_INVITATION_DATE, invitationDate.toString()))
//        .and(eq(COL_INVITATION_TO, guestName));
//
//    List<Invitation> invitationList = cassandraOperations.select(statement.toString(), Invitation.class);
//    return invitationList;
//  }
//}
//
