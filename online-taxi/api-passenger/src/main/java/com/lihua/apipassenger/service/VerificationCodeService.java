package com.lihua.apipassenger.service;

import com.lihua.apipassenger.remote.ServiceVerificationcodeClient;
import com.lihua.internalcommon.dto.ResponseResult;
import com.lihua.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeService {

    @Autowired
    private ServiceVerificationcodeClient serviceVerificationcodeClient;

    private String verificationCodePrefix = "passenger-verification-code-";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public ResponseResult generatorCode(String passengerPhone){
        // 调用验证码服务，获取验证码
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();
        // 存入redis
        // key value 过期时间
        String key = verificationCodePrefix + passengerPhone;
        stringRedisTemplate.opsForValue().set(key, numberCode+"", 2, TimeUnit.MINUTES);
        // 通过短信服务商，将对应的验证码发送到手机上

        // 返回值
        return ResponseResult.success("");
    }
}
