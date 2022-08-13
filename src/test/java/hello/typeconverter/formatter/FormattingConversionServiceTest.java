package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.assertThat;

class FormattingConversionServiceTest {
    @Test
    void formattingConversionService(){
        DefaultFormattingConversionService service = new DefaultFormattingConversionService();

        service.addConverter(new StringToIpPortConverter());
        service.addConverter(new IpPortToStringConverter());

        // 포멧터도 컨버터의 일종이므로 컨버터 등록하는 것처럼 하면 됨
        service.addFormatter(new MyNumberFormatter());

        IpPort ipPort = service.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1",8080));
        String result = service.convert(1000,String.class);
        assertThat(result).isEqualTo("1,000");
        Long t = service.convert("1,000",Long.class);
        assertThat(t).isEqualTo(1000L);
    }
}
