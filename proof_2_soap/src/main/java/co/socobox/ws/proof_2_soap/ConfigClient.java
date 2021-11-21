package co.socobox.ws.proof_2_soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConfigClient {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this ContextPath(i.e. package) must match the value of <generatePackage> specified in pom.xml

        marshaller.setContextPath("co.socobox.ws.codegen");
        return marshaller;
    }


    @Bean
    public HelloClient helloClient(Jaxb2Marshaller marshaller) {
        HelloClient client = new HelloClient();
        client.setDefaultUri("https://www.learnwebservices.com/services/hello");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;

    }

}
