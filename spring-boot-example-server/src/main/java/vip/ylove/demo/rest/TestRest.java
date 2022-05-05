package vip.ylove.demo.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.ylove.annotation.StAuth;
import vip.ylove.annotation.StEncrypt;
import vip.ylove.config.StConfig;
import vip.ylove.demo.common.BaseResult;
import vip.ylove.sdk.common.StAuthInfo;
import vip.ylove.sdk.util.StClientUtil;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestRest {

    @Autowired
    private StConfig stConfig;

    /**
     * 不使用加密
     * @param form
     * @return
     */
    @PostMapping("/noEncrypt")
    public BaseResult noEncrypt(@RequestBody Object form){
        return BaseResult.success_(form);
    }

    /**
     * 加密的请求
     *  StAuthInfo auth 获取到具体的授权向信息，进行相应的权限验证，也可以使用StAuthUtil,auth获取
     * @param form
     * @return
     */
    @StEncrypt
    @PostMapping("/encrypt")
    public BaseResult encrypt(@RequestBody Object form,@StAuth StAuthInfo auth){
        log.info("服务器收到请求参数:{},请求授权信息auth:{}",form,auth);
        return BaseResult.success_(form);
    }

    /**
     * 生成公私钥，在控制台看
     * @param form
     * @return
     */
    @PostMapping("/createRSABase64Key")
    public Object createRSABase64Key(@RequestBody Object form){
        StClientUtil.createRSABase64Key();
        return BaseResult.success_();
    }


}
