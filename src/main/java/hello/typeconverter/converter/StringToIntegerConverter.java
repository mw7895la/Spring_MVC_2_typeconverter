package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIntegerConverter implements Converter<String, Integer> {
    //첫번째 파라미터를 두번째 파라미터 타입으로 바꾼다.

    @Override       //컨버터 1
    public Integer convert(String source) {
        log.info("convert source={}", source);
        return Integer.valueOf(source);
    }


}
