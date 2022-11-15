package com.lihua.serviceverificationcode.controller;

import com.lihua.internalcommon.dto.ResponseResult;
import com.lihua.internalcommon.response.NumberCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable("size") int size){
        System.out.println(size);
        // 生成验证码
        double mathRandom = (Math.random() * 9 + 1) * (Math.pow(10, size - 1));
        int resultInt = (int)mathRandom;
        NumberCodeResponse numberCodeResponse = new NumberCodeResponse();
        numberCodeResponse.setNumberCode(resultInt);
        return ResponseResult.success(numberCodeResponse);
    }
}
