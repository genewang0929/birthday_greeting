package genewang.controller;

import genewang.entity.Message;
import genewang.service.GreetingService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v2", produces = MediaType.APPLICATION_JSON_VALUE)
public class GreetingController {
    public GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/{month}/{day}")
    public ResponseEntity<Object> getGreeting(@PathVariable("month") String month,
                                              @PathVariable("day") String day) {
        Map<String, Object> map = new HashMap<>();
        List<Message> messageList = greetingService.getGreetingByGender(month, day);
        map.put("message", messageList);
        return ResponseEntity.ok(map);
    }
}
