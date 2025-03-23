package my.gorae.appUniverseServer.common.response;

public class CommonResponseUtil {

    public static <T> CommonResponse<T> success(T result) {
        return new CommonResponse<T>(0, "success", result);
    }

    public static <T> CommonResponse<T> error(Integer code, String message) {
        return new CommonResponse<>(code, message, null);
    }
}
