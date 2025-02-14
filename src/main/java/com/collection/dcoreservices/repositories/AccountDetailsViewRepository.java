package com.collection.dcoreservices.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.collection.dcoreservices.entities.AccountDetailsViewEntity;


import java.util.Optional;

@Repository
public interface AccountDetailsViewRepository extends JpaRepository<AccountDetailsViewEntity, String> {

    // Method to fetch account details by loan account number
    AccountDetailsViewEntity findByAgrseq(String agrseq);
}
