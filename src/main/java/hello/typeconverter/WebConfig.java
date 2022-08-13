package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConveter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer { // 스프링 MVC에 등록할 때 사용하는 인터페이스

    @Override
    public void addFormatters(FormatterRegistry registry) { // 추가 컨버터 등록 ( 스프링이 등록한 컨버터보다 우선순위 높다)
        //registry.addConverter(new StringToIntegerConverter());
        //registry.addConverter(new IntegerToStringConveter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        registry.addFormatter(new MyNumberFormatter());
        // 참고로 컨버터가 포멧터보다 우선순위가 높다
    }
}
