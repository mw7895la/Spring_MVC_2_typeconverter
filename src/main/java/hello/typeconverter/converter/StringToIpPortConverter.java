package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.util.StringTokenizer;

@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {


    @Override
    public IpPort convert(String source) {
        log.info("convert source ={}", source);
        // "127.0.0.1:8080"이라는 문자가 들어올 것.  -> IpPort 객체로

        StringTokenizer st = new StringTokenizer(source, ":");


        /*String[] split = source.split(":");//파싱한다.
        String ip = split[0];   //문자 127.0.0.1
        int port = Integer.parseInt(split[1]);      //숫자 8080*/
        String ip = st.nextToken();
        int port = Integer.parseInt(st.nextToken());

        return new IpPort(ip, port);
    }
}
