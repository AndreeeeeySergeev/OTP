package otpservice.component;

import otpservice.model.entity.OtpState;
import otpservice.model.repo.OtpConfigRepo;
import otpservice.model.repo.OtpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OtpScheduler {
    private final OtpRepo otpRepo;
    private final OtpConfigRepo otpConfigRepo;

    @Autowired
    public OtpScheduler(OtpRepo otpRepo, OtpConfigRepo otpConfigRepo) {
        this.otpRepo = otpRepo;
        this.otpConfigRepo = otpConfigRepo;
    }

    @Scheduled(fixedDelay = 60000)
    public void refreshOtpStates() {
        if (otpConfigRepo.findById(0).isPresent()) {
            var otpConfig = otpConfigRepo.findById(0).get();
        } else return;
        otpRepo.findByState(OtpState.ACTIVE).ifPresent(otpList -> otpList.forEach(otp -> {
            if (!otp.getExpiresAt().isAfter(LocalDateTime.now())) {
                otp.setState(OtpState.EXPIRED);
                otpRepo.save(otp);
            }
        }));
    }
}
