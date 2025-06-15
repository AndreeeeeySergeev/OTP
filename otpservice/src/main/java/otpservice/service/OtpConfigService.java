package otpservice.service;

import otpservice.dto.SetOtpConfigRequest;
import otpservice.model.entity.OtpConfig;
import otpservice.model.repo.OtpConfigRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OtpConfigService {
    @Autowired
    OtpConfigRepo repo;

    public OtpConfig get() {
        return repo.findById(0).orElse(null);
    }

    public OtpConfig set(SetOtpConfigRequest request) {
        var otpConfig = repo.findById(0).orElseThrow();
        otpConfig.setLength(request.getLength());
        otpConfig.setLifetime(request.getLifetime());
        repo.save(otpConfig);
        return otpConfig;
    }
}
