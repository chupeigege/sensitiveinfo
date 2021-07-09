package vip.aquan.sensitiveinfo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.aquan.sensitiveinfo.pojo.User;
import vip.aquan.sensitiveinfo.service.SensitiveInfoService;


/**
 * @desc 接口信息脱敏
 */
@RestController
@RequestMapping("/sensitive")
public class SensitiveInfoController {
    @Autowired
    private SensitiveInfoService sensitiveInfoService;
    @GetMapping("/getData")
    public Object getData() {
        return sensitiveInfoService.getData();
    }
}
