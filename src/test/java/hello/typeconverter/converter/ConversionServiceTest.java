package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionServiceTest {
    @Test
    void conversionService(){

        //DefaultConversionService 통해서 컨버터들을 등록해놓고  데이터만 넣고 반환값을 확인만 하면 된다. 이렇게 만들어놓고 다른곳에서 주입받아서 쓰기만 하면 된다.

        //DefaultConversionService는 인터페이스 ConversionService를 구현한 구현체
        DefaultConversionService conversionService = new DefaultConversionService();

        //우리가 만들것들을 컨버터로 등록
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        //사용
        Integer result = conversionService.convert("10", Integer.class);//문자 10을 숫자로 변환 해달라.
        System.out.println("result = " + result);

        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        IpPort res = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(res).isEqualTo(new IpPort("127.0.0.1", 8080));

        String ipPortString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");
    }
}
