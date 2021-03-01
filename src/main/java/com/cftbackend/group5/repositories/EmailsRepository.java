package com.cftbackend.group5.repositories;

import com.cftbackend.group5.models.Emails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailsRepository extends JpaRepository<Emails, Long> {}
