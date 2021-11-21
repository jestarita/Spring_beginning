package co.socobox.ws.proof_2_soap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ControllerProof {


    @Autowired
    HelloClient helloClient;

    @GetMapping("greetings")
    public String sayHello(@RequestParam String name) {
        return helloClient.sayHello(name);
    }

}
