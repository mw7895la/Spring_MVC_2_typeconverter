package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
public class MyNumberFormatter implements Formatter<Number> {       //import org.springframework.format.Formatter;
    /**
     *      "문자"를 "숫자"로 변환해주는 parse()
     */
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text ={}, locale={}", text, locale);
        // "1,000" -> 1000  이런거 수동으로 바꿔주는거 쉽지않다.
        NumberFormat format = NumberFormat.getInstance(locale);       //java.text
        Number parse = format.parse(text);
        return parse;
    }

    /**
     *      "객체"를 "문자"로 변환해주는 print()
     */

    @Override
    public String print(Number object, Locale locale) {
        log.info("object ={}, locale={}", object, locale);
        NumberFormat instance = NumberFormat.getInstance(locale);
        String format = instance.format(object);
        return format;
    }
}
