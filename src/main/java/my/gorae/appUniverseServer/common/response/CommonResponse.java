package my.gorae.appUniverseServer.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CommonResponse<T> {

    private Integer code;
    private String message;
    private T result;

}

