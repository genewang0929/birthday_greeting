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

    public List<Message> getGreetingByAge(String year, String month, String day) {
        String birthday = month + "/" + day;

        int birthYear = Integer.parseInt(year) - 49;


        List<AppUser> userList = userRepository.findAll()
                .stream()
                .filter(appUser -> appUser.getDateOfBirth().substring(5, appUser.getDateOfBirth().length()).equals(birthday))
                .filter(appUser -> Integer.parseInt(appUser.getDateOfBirth().substring(0, 4)) < birthYear)
                .toList();

        List<Message> messages = new ArrayList<>();
        for (AppUser appUser : userList) {
            Message message = new Message(
                    "Subject: Happy birthday!",
                    "Happy birthday, dear `" + appUser.getFirstName() + "`!" + " https://hr.jhu.edu/wp-content/uploads/elder-care-GettyImages-912073272.jpg"
            );
            messages.add(message);
        }

        return messages;
    }
}
