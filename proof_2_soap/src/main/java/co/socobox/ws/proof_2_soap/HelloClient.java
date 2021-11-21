package co.socobox.ws.proof_2_soap;

import javax.xml.bind.JAXBElement;


import co.socobox.ws.codegen.HelloRequest;
import co.socobox.ws.codegen.SayHello;
import co.socobox.ws.codegen.SayHelloResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


public class HelloClient extends WebServiceGatewaySupport {

    public String sayHello(String name) {

        SayHello request = new SayHello();
        HelloRequest hr = new HelloRequest();
        hr.setName(name);
        request.setHelloRequest(hr);

        var response = (JAXBElement<SayHelloResponse>) getWebServiceTemplate()
                .marshalSendAndReceive(request);

        return response.getValue().getHelloResponse().getMessage();
    }
}
