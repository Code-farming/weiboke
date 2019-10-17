package com.lhb.weiboke.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServerResult {
    private int code;
    private String msg;
    private Object data;

    public ServerResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ServerResult() {
    }

    public static ServerResult Success(int code, String msg, Object data) {
        return ServerResult.builder().code(code).msg(msg).data(data).build();
    }

    public static ServerResult Error(int code, String msg, Object data) {
        return ServerResult.builder().code(code).msg(msg).data(null).build();
    }
}
