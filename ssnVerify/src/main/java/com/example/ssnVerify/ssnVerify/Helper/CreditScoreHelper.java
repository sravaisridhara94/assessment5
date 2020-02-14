package com.example.ssnVerify.ssnVerify.Helper;

import com.example.ssnVerify.ssnVerify.Domain.CrediScore;
import org.apache.commons.codec.binary.Base64;

public class CreditScoreHelper {

    public static String calculate(CrediScore score){
        if(Integer.parseInt(score.getCreditScore())>700)
        {
            return "Yes";
        }
        return "False";
    }
}
