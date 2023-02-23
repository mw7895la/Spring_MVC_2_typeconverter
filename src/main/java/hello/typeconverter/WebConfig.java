package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override           //등록하자 !
    public void addFormatters(FormatterRegistry registry) {
        //addFormatters - 컨버터의 조금더 확장된 기능이라 보면됨

        //우선 순위 때문에 2개 주석처리 했다.  잘 보면, 문자를 숫자로, 숫자를 문자로 바꾸는 컨버터들을 주석처리 했다.  우리가 추가해준 MyNumberFormatter도  문자를 숫자로  객체(Long,Integer ... )를 숫자로 바꿔준다.
        // 컨버터가 우선순위가 높다. 그래서 주석처리한 것.
        //registry.addConverter(new StringToIntegerConverter());
        //registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        //추가
        registry.addFormatter(new MyNumberFormatter());

    }
}
