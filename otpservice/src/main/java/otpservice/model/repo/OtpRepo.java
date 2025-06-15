package otpservice.model.repo;

import otpservice.model.entity.Otp;
import otpservice.model.entity.OtpState;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OtpRepo extends CrudRepository<Otp, Long> {
    Optional<List<Otp>> findByUserLogin(String login);
    long deleteByUserLogin(String login);
    Optional<List<Otp>> findByState(OtpState state);
}
