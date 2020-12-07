package com.zs.backend.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class JSONArrayWrapper implements Serializable {
    private JSONArray data;

    public JSONArrayWrapper() {
    }

    public JSONArrayWrapper(Collection<?> collection) {
        this.setData(collection);
    }

    public JSONArrayWrapper(String jsonArray) {
        this.setData(jsonArray);
    }

    public JSONArray getData() {
        return this.data;
    }

    public void setData(Collection<?> collection) {
        if (CollectionUtils.isNotEmpty(collection)) {
            this.data = JSONArray.parseArray(JSON.toJSONString(collection));
        }

    }

    public void setData(String jsonArray) {
        if (StringUtils.isNotEmpty(jsonArray) && jsonArray.startsWith("[")) {
            this.data = JSONArray.parseArray(jsonArray);
        }

    }

    public <T> List<T> getData(Class<T> targetClass) {
        return this.data == null ? null : JSONObject.parseArray(this.data.toJSONString(), targetClass);
    }
}

