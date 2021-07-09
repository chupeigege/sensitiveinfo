package vip.aquan.sensitiveinfo.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import vip.aquan.sensitiveinfo.util.sensitive.SensitiveInfo;
import vip.aquan.sensitiveinfo.util.sensitive.SensitiveInfoType;
import vip.aquan.sensitiveinfo.util.sensitive.SensitiveType;

import java.io.Serializable;

/**
 * @description:
 * @author: wcp
 * @create: 2021/7/9 17:39
 */
@Data
@Accessors(chain = true)
public class User {
    //姓名
    @SensitiveInfo(value = SensitiveType.CHINESE_NAME)
    @SensitiveInfoType(value = SensitiveType.CHINESE_NAME)
    private String name;
    //手机号
    @SensitiveInfo(value = SensitiveType.MOBILE_PHONE)
    @SensitiveInfoType(value = SensitiveType.MOBILE_PHONE)
    private String phone;
    //身份证号
    @SensitiveInfo(value = SensitiveType.ID_CARD)
    @SensitiveInfoType(value = SensitiveType.ID_CARD)
    private String idCard;
    //年龄
    int age;

}
