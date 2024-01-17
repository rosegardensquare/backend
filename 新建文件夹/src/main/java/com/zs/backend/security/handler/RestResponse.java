package com.zs.backend.security.handler;

import com.baomidou.mybatisplus.extension.api.IErrorCode;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import java.util.Map;
import java.util.Optional;

@JsonDeserialize(using = JsonDeserializer.class)
@JsonSerialize(using = JsonSerializer.class)
public interface RestResponse<T> extends IErrorCode {
    Optional<Map<String, Object>> getFields();
    Optional<T> getData();
}
