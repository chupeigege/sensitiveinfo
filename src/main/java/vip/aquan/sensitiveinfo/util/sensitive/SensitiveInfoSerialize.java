package vip.aquan.sensitiveinfo.util.sensitive;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

import java.io.IOException;
import java.util.Objects;

public class SensitiveInfoSerialize extends JsonSerializer<String> implements ContextualSerializer {

    private SensitiveType type;
    
    public SensitiveInfoSerialize() {
    }
   
    public SensitiveInfoSerialize(final SensitiveType type) {
      this.type = type;
    }
    
    @Override
    public JsonSerializer<?> createContextual(final SerializerProvider serializerProvider, final BeanProperty beanProperty)
            throws JsonMappingException {
        if (beanProperty != null) { // 为空直接跳过
            if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) { // 非 String 类直接跳过
              SensitiveInfo sensitiveInfo = beanProperty.getAnnotation(SensitiveInfo.class);
              if (sensitiveInfo == null) {
                sensitiveInfo = beanProperty.getContextAnnotation(SensitiveInfo.class);
              }
              if (sensitiveInfo != null) { // 如果能得到注解，就将注解的 value 传入 SensitiveInfoSerialize
       
                return new SensitiveInfoSerialize(sensitiveInfo.value());
              }
            }
            return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
          }
          return serializerProvider.findNullValueSerializer(beanProperty);
    }

    @Override
    public void serialize(final String s, final JsonGenerator jsonGenerator, final SerializerProvider serializers) throws IOException {
        switch (this.type) {
        case CHINESE_NAME: {
          jsonGenerator.writeString(SensitiveInfoUtils.chineseName(s));
          break;
        }
        case ID_CARD: {
          jsonGenerator.writeString(SensitiveInfoUtils.idCardNum(s));
          break;
        }
        case MOBILE_PHONE: {
          jsonGenerator.writeString(SensitiveInfoUtils.mobilePhone(s));
          break;
        }
        case BANK_CARD: {
          jsonGenerator.writeString(SensitiveInfoUtils.bankCard(s));
          break;
        }
      }
    }

}
