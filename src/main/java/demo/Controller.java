package demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    private final Map<String, Integer> voteCount;

    public Controller() {
        this.voteCount = new HashMap<>();
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/result")
    public Map<String, Integer> getResult() {
        return voteCount;
    }

    @RequestMapping("/vote")
    public String placeVote(@RequestParam final String alternative) {
        if (alternative == null || alternative.trim().equals("")) {
            return "Ogiltigt alternativ";
        }
        Integer count = voteCount.get(alternative);
        voteCount.put(alternative, count == null ? 1 : count + 1);
        return String.format("Your vote has been placed on %s", alternative);
    }


}
