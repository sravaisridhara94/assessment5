package com.example.ssnVerify.ssnVerify.API;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CreditScoreModel {

    @JsonProperty
    private long ssn;

    @JsonProperty
    private long creditScore;

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public long getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(long creditScore) {
        this.creditScore = creditScore;
    }
}
