package com.example.ssnVerify.ssnVerify.Service;

import com.example.ssnVerify.ssnVerify.Domain.CrediScore;
import com.example.ssnVerify.ssnVerify.Repository.CreditScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditScoreService {

    private CreditScoreRepository repository;

    @Autowired
    public CreditScoreService(CreditScoreRepository repository) {
        this.repository = repository;
    }

    public Optional<CrediScore> getByssn(long ssn){
        return repository.findById(ssn);
    }

}
