package co.socobox.ws.bank_soap;

import co.socobox.ws.codegen.GetBankResponseType;
import co.socobox.ws.codegen.GetBankType;
import co.socobox.ws.codegen.ObjectFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class BankClient extends WebServiceGatewaySupport {

    public GetBankResponseType  BankRequest(Object request)  {

        JAXBElement res = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(request);
        return (GetBankResponseType) res.getValue();

    }
}
