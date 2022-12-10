package genewang.controller;

import genewang.entity.AppUser;
import genewang.service.AppUserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppUserController {
    public AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("")
    public ResponseEntity<Object> insertData(@RequestBody AppUser appUser) {
        appUserService.initialize(appUser);
        return ResponseEntity.ok().build();
    }
}
