package co.socobox.ws.Temperatura_soap;

import co.socobox.ws.codegen.CelsiusToFahrenheit;
import co.socobox.ws.codegen.CelsiusToFahrenheitResponse;
import co.socobox.ws.codegen.FahrenheitToCelsius;
import co.socobox.ws.codegen.FahrenheitToCelsiusResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

public class TemperatureClient extends WebServiceGatewaySupport {

    public String convertToFarenheit(String temperature) {
        CelsiusToFahrenheit Celsius = new CelsiusToFahrenheit();
        Celsius.setCelsius(temperature);
        var response = (CelsiusToFahrenheitResponse) getWebServiceTemplate()
                .marshalSendAndReceive(Celsius, message -> ((SoapMessage) message).setSoapAction("https://www.w3schools.com/xml/CelsiusToFahrenheit"));
        return "Te Convertion Returns " + response.getCelsiusToFahrenheitResult();
    }

    public String ConvertToCelcious(String temperature) {
        FahrenheitToCelsius ftc = new FahrenheitToCelsius();
        ftc.setFahrenheit(temperature);
        var response = (FahrenheitToCelsiusResponse) getWebServiceTemplate()
                .marshalSendAndReceive(ftc, message -> ((SoapMessage) message).setSoapAction("https://www.w3schools.com/xml/FahrenheitToCelsius"));
        return "Te Convertion Returns " + response.getFahrenheitToCelsiusResult();

    }

}
