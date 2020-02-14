package com.example.ssnVerify.ssnVerify.API;

import com.example.ssnVerify.ssnVerify.Domain.CrediScore;
import com.example.ssnVerify.ssnVerify.Helper.CreditScoreHelper;
import com.example.ssnVerify.ssnVerify.Service.CreditScoreService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("ssn")
public class Controller {

    private CreditScoreService scoreService;

    public Controller(CreditScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/verify/{ssn}")
    public ResponseEntity<String> getEligibilityStatus(@PathVariable String ssn){
        Base64 base64 = new Base64();
        long ssn1 = Long.parseLong(new String(base64.decode(ssn.getBytes())));
        Optional<CrediScore> score = scoreService.getByssn(ssn1);
        if(!score.isPresent()){
            throw new IllegalArgumentException();
        }
        return ResponseEntity.ok().body(CreditScoreHelper.calculate(score.get()));
    }
}
