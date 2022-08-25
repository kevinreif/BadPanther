package com.example.application.data.service.clientInfo;

import com.example.application.data.entity.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientInfoRepository extends JpaRepository<ClientInfo, Long> {

    @Query("select c from ClientInfo c " +
            "where lower(c.clientFirstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.clientLastName)  like lower(concat('%', :searchTerm, '%'))")
    List<ClientInfo> search(@Param("searchTerm") String searchTerm);

    @Query("select c from ClientInfo c " +
            "where (lower(c.clientFirstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.clientLastName)  like lower(concat('%', :searchTerm, '%'))) " +
            "and c.userID = :userID")
    List<ClientInfo> searchByUserID(@Param("searchTerm") String searchTerm, @Param("userID") UUID userID);

    @Query("select c from ClientInfo c " +
            "where c.userID = :userID")
    List<ClientInfo> findAllByUserID(@Param("userID") UUID userID);
}
