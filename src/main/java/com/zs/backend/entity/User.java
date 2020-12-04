package com.zs.backend.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Integer id;
    private String name;


}
