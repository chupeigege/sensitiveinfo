package vip.aquan.sensitiveinfo.util.sensitive;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/** 
 * @ClassName:SensitiveInfo 
 * @Function: TODO ADD FUNCTION
 * @Reason:   TODO ADD REASON
 * @Date:     2018年11月5日 下午2:52:37 
 * @author   huoliang 
 * @version   
 * @since    JDK 1.8
 * @see       
 */
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveInfoSerialize.class)
public @interface SensitiveInfo {
    
    public SensitiveType value();

}
