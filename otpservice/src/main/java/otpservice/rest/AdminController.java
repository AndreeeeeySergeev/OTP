package otpservice.rest;


import otpservice.dto.DeleteUserRequest;
import otpservice.dto.GetUserResponse;
import otpservice.dto.ResponseWithMessage;
import otpservice.dto.SetOtpConfigRequest;
import otpservice.model.entity.OtpConfig;
import otpservice.service.OtpConfigService;
import otpservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final OtpConfigService otpConfigService;
    private final UserService userService;

    @Autowired
    public AdminController(OtpConfigService otpConfigService, UserService userService) {
        this.otpConfigService = otpConfigService;
        this.userService = userService;
    }

    @GetMapping("/get-otp-config")
    public OtpConfig getOtpConfig() {
        return otpConfigService.get();
    }

    @PostMapping("/set-otp-config")
    public OtpConfig setOtpConfig(@RequestBody SetOtpConfigRequest request) {
        return otpConfigService.set(request);
    }

    @GetMapping("/get-users")
    public List<GetUserResponse> getUsers() {
        return userService.getUsersInfo();
    }

    @PostMapping("/delete-user")
    public ResponseEntity<ResponseWithMessage> deleteUser(@RequestBody DeleteUserRequest deleteUserRequest) {
        return  userService.deleteUser(deleteUserRequest);
    }
}
