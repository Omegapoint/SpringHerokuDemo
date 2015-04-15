package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
public class Controller {

    private final AlternativeRepository alternativeRepository;

    @Autowired
    public Controller(AlternativeRepository alternativeRepository) {
        this.alternativeRepository = alternativeRepository;
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/result")
    public Iterable<Alternative> getResult() {
        return alternativeRepository.findAll();
    }

    @RequestMapping("/vote")
    public String placeVote(@RequestParam(value = "alternative", required = true) final String alternativeString) {
        if (alternativeString.trim().equals("")) {
            return "Ogiltigt alternativ";
        }
        Alternative alternative = alternativeRepository.findByAlternative(alternativeString);
        if (alternative == null) {
            alternative = new Alternative(alternativeString);
        }
        alternative.increaseCount();
        alternativeRepository.save(alternative);
        return String.format("Your vote has been placed on %s", alternativeString);
    }
}
