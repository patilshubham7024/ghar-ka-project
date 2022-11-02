package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GharKiService {

    public String test(){
        return "Project is up.";
    }

//    @Autowired
//    private CreditService creditService;
//
//    public ResponseEntity<?> dashboard() {
//        try {
//            FilterResponse filterResponse = new FilterResponse();
////          ResponseEntity<?> list = creditService.seeCredit(0,50);
//
//        return new ResponseEntity<>(filterResponse, HttpStatus.OK);
//        } catch (Exception exception){
//            return new ResponseEntity<>("Something went wrong.", HttpStatus.BAD_REQUEST);
//        }
//    }
}
