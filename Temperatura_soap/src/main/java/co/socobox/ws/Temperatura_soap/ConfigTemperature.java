package co.socobox.ws.Temperatura_soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConfigTemperature {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("co.socobox.ws.codegen");
        return marshaller;
    }


    @Bean
    public TemperatureClient temperatureClient(Jaxb2Marshaller marshaller) {
        TemperatureClient client = new TemperatureClient();
        client.setDefaultUri("https://www.w3schools.com/xml/tempconvert.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;

    }
}
