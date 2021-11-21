package com.aplication.number_conversor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class NumberConverConfig {

    @Bean
    public Jaxb2Marshaller marshaller()  {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.aplication.ws.codegen");
        return marshaller;
    }
    @Bean
    public NumberConversonrClient soapConnector(Jaxb2Marshaller marshaller) {
        NumberConversonrClient client = new NumberConversonrClient();
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver/numberconversion.wso");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
