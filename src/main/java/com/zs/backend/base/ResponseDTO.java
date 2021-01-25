package com.zs.backend.base;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Optional;

@Data
public class ResponseDTO<T> implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(ResponseDTO.class);
    private static final long serialVersionUID = -2104615952790251447L;
    private Boolean success;
    private T entity;
    private Message message;

    public Boolean isSuccess() {
        return this.success;
    }


    public ResponseDTO(Boolean status) {
        this.success = status;
    }

    public ResponseDTO(Boolean status, Message message, T entity) {
        this.success = status;
        this.message = message;
        this.entity = entity;
    }

    public static ResponseDTO<?> success() {
        return new ResponseDTO();
    }


    public static <T> ResponseDTO<T> success(T entity, Message message) {
        return new ResponseDTO(true, message, entity);
    }

    public static ResponseDTO<?> unsuccess() {
        return new ResponseDTO(false);
    }

    public static <T> ResponseDTO<T> unsuccess(Message message, T entity) {
        return new ResponseDTO(false, message, entity);
    }

    public static <T> Optional<T> getEntityWithNull(ResponseDTO<T> dto) {
        if (dto.isSuccess()) {
            return Optional.ofNullable(dto.getEntity());
        } else if (dto.getMessage() != null) {
            log.error("service error message : {}", JSON.toJSONString(dto.getMessage()));
            throw BaseException.createBusinessCode("222", "222");
        } else {
            throw BaseException.createBusinessCode("222");
        }
    }

    public static <T> T getResEntity(ResponseDTO<T> dto) {
        return getResEntity(dto, (String)null, "查询对象不存在");
    }

    public static <T> T getResEntity(ResponseDTO<T> dto, String businessCode) {
        return getResEntity(dto, businessCode, "查询对象不存在");
    }

    public static <T> T getResEntity(ResponseDTO<T> dto, String businessCode, String message) {
        Optional<T> optional = Optional.empty();
        if (dto.isSuccess()) {
            optional = Optional.ofNullable(dto.getEntity());
        } else if (dto.getMessage() != null) {
            log.error("service error message : {}", JSON.toJSONString(dto.getMessage()));
            throw BaseException.createBusinessCode("111", "222");
        }

        if (optional.isEmpty()) {
            throw BaseException.createBusinessCode(businessCode, message);
        } else {
            return optional.get();
        }
    }

    public static <T> ResponseDTO.ResponseDTOBuilder<T> builder() {
        return new ResponseDTO.ResponseDTOBuilder();
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public T getEntity() {
        return this.entity;
    }

    public Message getMessage() {
        return this.message;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public void setMessage(Message message) {
        this.message = message;
    }




    protected boolean canEqual(Object other) {
        return other instanceof ResponseDTO;
    }




    public ResponseDTO() {
    }

    public ResponseDTO(Boolean success, T entity, Message message) {
        this.success = success;
        this.entity = entity;
        this.message = message;
    }

    public static class ResponseDTOBuilder<T> {
        private Boolean success;
        private T entity;
        private Message message;

        ResponseDTOBuilder() {
        }

        public ResponseDTO.ResponseDTOBuilder<T> success(Boolean success) {
            this.success = success;
            return this;
        }

        public ResponseDTO.ResponseDTOBuilder<T> entity(T entity) {
            this.entity = entity;
            return this;
        }

        public ResponseDTO.ResponseDTOBuilder<T> message(Message message) {
            this.message = message;
            return this;
        }

        public ResponseDTO<T> build() {
            return new ResponseDTO(this.success, this.entity, this.message);
        }



    }
}
