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

    public List<Message> getGreetingByGender(String month, String day) {
        String birthday = month + "/" + day;


        List<AppUser> userList = userRepository.findAll()
                .stream()
                .filter(appUser -> appUser.getDateOfBirth().substring(5, appUser.getDateOfBirth().length()).equals(birthday))
                .toList();

        List<Message> messages = new ArrayList<>();
        for (AppUser appUser : userList) {
            Message message = new Message();
            message.setTitle("Subject: Happy birthday!");
            if (appUser.getGender().equals("Male")) {
                message.setContent(
                        "Happy birthday, dear " +
                        appUser.getFirstName() + "! " +
                        "We offer special discount 20% off for the following items: " +
                        "White Wine, iPhone X"
                );
            } else {
                message.setContent(
                        "Happy birthday, dear " +
                        appUser.getFirstName() + "! " +
                        "We offer special discount 50% off for the following items: " +
                        "Cosmetic, LV Handbags"
                );
            }
            messages.add(message);
        }

        return messages;
    }
}
