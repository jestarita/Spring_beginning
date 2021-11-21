package com.aplication.number_conversor;

import com.aplication.ws.codegen.NumberToDollars;
import com.aplication.ws.codegen.NumberToDollarsResponse;
import com.aplication.ws.codegen.NumberToWords;
import com.aplication.ws.codegen.NumberToWordsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberConversonrClient extends WebServiceGatewaySupport {

    public String converData(int number){

        NumberToWords ntw = new NumberToWords();
        ntw.setUbiNum(BigInteger.valueOf(number));

        var response = (NumberToWordsResponse) getWebServiceTemplate()
                .marshalSendAndReceive(ntw);
        return response.getNumberToWordsResult();
    }

    public String DollarsData(int number){
        NumberToDollars ntd = new NumberToDollars();
        ntd.setDNum(BigDecimal.valueOf(number));
        var response = (NumberToDollarsResponse) getWebServiceTemplate()
                .marshalSendAndReceive(ntd);
        return response.getNumberToDollarsResult();
    }
}
