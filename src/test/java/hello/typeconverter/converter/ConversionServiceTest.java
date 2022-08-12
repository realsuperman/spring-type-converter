package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.assertThat;


public class ConversionServiceTest {
    @Test
    void conversionService(){
        //디폴트 컨버터 선언한다
        DefaultConversionService conversionService = new DefaultConversionService();
        // 아래와 같이 컨버터 등록한다
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConveter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        //컨버터 서비스의 convert를 호출해서 컨버터 기능을 사용한다
        assertThat(conversionService.convert("10",Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10,String.class)).isEqualTo("10");
        IpPort result = conversionService.convert("127.0.0.1:8080",IpPort.class);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1",8080));
        String ipPortString = conversionService.convert(new IpPort("127.0.0.1",8080),String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");
    }
}
