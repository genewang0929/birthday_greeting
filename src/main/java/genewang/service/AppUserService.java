package genewang.service;

import genewang.entity.AppUser;
import genewang.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    public final UserRepository userRepository;
    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initialize(AppUser appUser) {
        AppUser user = new AppUser();
        user.setFirstName(appUser.getFirstName());
        user.setLastName(appUser.getLastName());
        user.setGender(appUser.getGender());
        user.setDateOfBirth(appUser.getDateOfBirth());
        user.setEmail(appUser.getEmail());
        userRepository.insert(user);
    }
}
