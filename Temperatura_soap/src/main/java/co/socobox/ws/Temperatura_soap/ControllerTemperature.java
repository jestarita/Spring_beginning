package co.socobox.ws.Temperatura_soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ControllerTemperature {
    @Autowired
    public TemperatureClient temp;


    @GetMapping("ctf")
    public String temperatureChange(@RequestParam String temperature) {
        String resp = temp.convertToFarenheit(temperature);
        return resp;
    }

    @GetMapping("ftc")
    public String temperatureChange2(@RequestParam String temperature) {
        String resp = temp.ConvertToCelcious(temperature);
        return resp;
    }
}
