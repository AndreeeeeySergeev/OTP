package otpservice.model.repo;

import otpservice.model.entity.OtpConfig;
import org.springframework.data.repository.CrudRepository;

public interface OtpConfigRepo extends CrudRepository<OtpConfig, Integer> {
}
