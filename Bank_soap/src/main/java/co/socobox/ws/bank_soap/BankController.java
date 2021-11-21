package co.socobox.ws.bank_soap;

import co.socobox.ws.codegen.DetailsType;
import co.socobox.ws.codegen.GetBankResponseType;
import co.socobox.ws.codegen.GetBankType;
import co.socobox.ws.codegen.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/")
public class BankController {

    @Autowired
    BankClient bankClient;

    @GetMapping("bank")
    public DetailsType SearchBank(@RequestParam String bank) {
        ObjectFactory objectFactory = new ObjectFactory();
        GetBankType type = new GetBankType();
        type.setBlz(bank);

        GetBankResponseType response = bankClient.BankRequest(objectFactory.createGetBank(type));
        return response.getDetails();
    }
}
