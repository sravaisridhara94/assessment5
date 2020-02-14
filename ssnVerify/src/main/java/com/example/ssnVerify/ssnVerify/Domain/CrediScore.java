package com.example.ssnVerify.ssnVerify.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creditScore")
public class CrediScore {

    @Id
    @Column(name = "ssn")
    private long ssn;

    @Column(name = "creditScore")
    private String creditScore;

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }
}
