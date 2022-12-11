package genewang.service;

import genewang.entity.AppUser;
import genewang.entity.Message;
import genewang.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GreetingService {
    public final UserRepository userRepository;
    public GreetingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Message> getGreeting(String month, String day) {
        String birthday = month + "/" + day;


        List<AppUser> userList = userRepository.findAll()
                .stream()
                .filter(appUser -> appUser.getDateOfBirth().substring(5, appUser.getDateOfBirth().length()).equals(birthday))
                .toList();

        List<Message> messages = new ArrayList<>();
        for (AppUser appUser : userList) {
            Message message = new Message(
                    "Subject: Happy birthday!",
                    "Happy birthday, dear " + appUser.getFirstName() + "!"
            );
            messages.add(message);
        }

        return messages;
    }
}
