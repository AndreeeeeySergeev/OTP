package otpservice.rest;


import otpservice.dto.GenerateOtpRequest;
import otpservice.dto.ResponseWithMessage;
import otpservice.dto.ValidateOtpRequest;
import otpservice.dto.ValidateOtpResponse;
import otpservice.service.OtpService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OtpController {
    private final OtpService otpService;

    public OtpController(OtpService otpService) {
        this.otpService = otpService;
    }

    @PostMapping("/otp/generate")
    public ResponseWithMessage generateOtp(@RequestBody GenerateOtpRequest generateOtpRequest) {
        return otpService.generateOtp(generateOtpRequest);
    }

    @PostMapping("/otp/validate")
    public ValidateOtpResponse validateOtp(@RequestBody ValidateOtpRequest request) {
        return otpService.validateOtp(request);
    }
}
