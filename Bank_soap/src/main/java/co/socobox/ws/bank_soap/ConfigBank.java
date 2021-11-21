package co.socobox.ws.bank_soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConfigBank {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("co.socobox.ws.codegen");
        return marshaller;
    }


    @Bean
    public BankClient bankClient(Jaxb2Marshaller marshaller) {
        BankClient client = new BankClient();
        client.setDefaultUri("http://www.thomas-bayer.com/axis2/services/BLZService");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;

    }

}
