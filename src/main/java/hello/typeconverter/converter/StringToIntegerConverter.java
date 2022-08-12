package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

// 제네릭의 앞은 input에 대한 설정이고 뒤는 output에 대한 설정이다
@Slf4j
public class StringToIntegerConverter implements Converter<String,Integer> {
    @Override
    public Integer convert(String source) { // 문자를 숫자로 바꾸는 컨버터임
        log.info("convert source={}",source);
        Integer integer = Integer.valueOf(source);
        return integer;
    }
}
