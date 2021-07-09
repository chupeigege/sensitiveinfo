package vip.aquan.sensitiveinfo.service;

import org.springframework.stereotype.Service;
import vip.aquan.sensitiveinfo.pojo.User;
import vip.aquan.sensitiveinfo.util.sensitive.SensitiveInfoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wcp
 * @create: 2021/7/9 18:27
 */
@Service
public class SensitiveInfoServiceImpl implements SensitiveInfoService{
    @Override
    public List<User> getData() {
        List<User> list = new ArrayList<>();
        list.add(new User().setPhone("13865665611").setName("张大强").setAge(22).setIdCard("666666666666666666"));
        //对单对象日志脱敏打印
        Object listSensitive = SensitiveInfoUtils.noSensitiveObject(list.get(0));
        System.out.println(listSensitive);
        return list;
    }
}
