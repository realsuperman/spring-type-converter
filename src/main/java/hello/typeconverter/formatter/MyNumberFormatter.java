package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
public class MyNumberFormatter implements Formatter<Number> { // 숫자 계열이 들어올 때 포멧팅 해주겠다

    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text={} locale={}",text,locale);
        // "1,000" -> 1000 변환 하고자 한다
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.parse(text);
    }

    @Override
    public String print(Number object, Locale locale) {
        log.info("object=[],locale={}",object,locale);
        return NumberFormat.getInstance(locale).format(object);
    }
}
