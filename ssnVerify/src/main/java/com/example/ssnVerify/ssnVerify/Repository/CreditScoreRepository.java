package com.example.ssnVerify.ssnVerify.Repository;

import com.example.ssnVerify.ssnVerify.Domain.CrediScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditScoreRepository extends JpaRepository<CrediScore, Long> {

}
