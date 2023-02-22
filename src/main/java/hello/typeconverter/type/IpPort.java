package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;


//"127.0.0.1:8080" 라고 문자가 들어오면  IpPort라는 객체로 컨버터를 이용해서 바꿔보자
@Getter
@EqualsAndHashCode
public class IpPort {
    private String ip;
    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IpPort ipPort = (IpPort) o;
        return port == ipPort.port && Objects.equals(ip, ipPort.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }*/
}
