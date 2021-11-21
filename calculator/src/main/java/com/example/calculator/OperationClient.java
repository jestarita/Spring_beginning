package com.example.calculator;

import com.ws.codegen.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

public class OperationClient extends WebServiceGatewaySupport {

    public int addingMetod(int number1, int number2){
        Add ad = new Add();
        ad.setIntA(number1);
        ad.setIntB(number2);
        var response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(ad, message -> ((SoapMessage) message).setSoapAction("http://tempuri.org/Add"));
        return response.getAddResult();
    }

    public int substractMetod(int number1, int number2){
        Subtract sb = new Subtract();
        sb.setIntA(number1);
        sb.setIntB(number2);
        var response = (SubtractResponse) getWebServiceTemplate()
                .marshalSendAndReceive(sb, message -> ((SoapMessage) message).setSoapAction("http://tempuri.org/Subtract"));
        return response.getSubtractResult();
    }

    public int multiplyMetod(int number1, int number2){
        Multiply m = new Multiply();
        m.setIntA(number1);
        m.setIntB(number2);
        var response = (MultiplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(m, message -> ((SoapMessage) message).setSoapAction("http://tempuri.org/Multiply"));
        return response.getMultiplyResult();
    }

    public int DivideMethod(int number1, int number2){
        Divide m = new Divide();
        m.setIntA(number1);
        m.setIntB(number2);
        var response = (DivideResponse) getWebServiceTemplate()
                .marshalSendAndReceive(m, message -> ((SoapMessage) message).setSoapAction("http://tempuri.org/Divide"));
        return response.getDivideResult();
    }


}
