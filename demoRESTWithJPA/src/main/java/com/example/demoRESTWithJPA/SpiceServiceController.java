package com.example.demoRESTWithJPA;

import com.example.demoRESTWithJPA.domain.Spice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SpiceServiceController {

    private static Map<Integer, Spice> spiceRepo = new HashMap<>();

    static {
        Spice chiliPowder = new Spice();
        chiliPowder.setName("Chili powder");
        chiliPowder.setSpecialName("Meat curry");
        chiliPowder.setSpiceId(1);

        spiceRepo.put(chiliPowder.getSpiceId(), chiliPowder);

        Spice curryPowder = new Spice();
        curryPowder.setName("Curry Powder");

        spiceRepo.put(curryPowder.getSpiceId(), curryPowder);

    }
    @RequestMapping(value="/spices", method= RequestMethod.POST)
    public ResponseEntity<Object>createSpice(@RequestBody Spice spice){
        spiceRepo.put(spice.getSpiceId(), spice);

        return new ResponseEntity<>("Spice is created successfully", HttpStatus.CREATED);

    }

    @RequestMapping(value="/spices")
    public ResponseEntity<Object> getSpice(){
        return new ResponseEntity<>(spiceRepo.values(), HttpStatus.OK);

    }


}
