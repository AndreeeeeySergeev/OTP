package otpservice.service.senders;

import otpservice.model.entity.ChannelType;

public interface OtpSender {
    void sendOtp(String destination, int code);
    ChannelType getChannelType();
}
