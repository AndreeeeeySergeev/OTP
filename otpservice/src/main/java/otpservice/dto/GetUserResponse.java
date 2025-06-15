package otpservice.dto;

import otpservice.model.entity.Otp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class GetUserResponse {
    public String login;
    public String role;
    public List<Otp> otps;
}
