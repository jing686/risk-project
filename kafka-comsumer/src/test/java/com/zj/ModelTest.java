package com.zj;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zj.common.EventModel;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: zj
 * @Date: 2023/2/17 23:27
 * @Version: 1.0
 */
public class ModelTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void jsonTest() throws JsonProcessingException {
        EventModel eventModel = new EventModel();
        eventModel.setEventId(1);
        eventModel.setMessage("这是一条测试消息");
        eventModel.setPrice(new BigDecimal(10));
        eventModel.setStartTime(new Date(System.currentTimeMillis()));
        eventModel.setEndTime(new Date(System.currentTimeMillis()));
        String result = mapper.writeValueAsString(eventModel);
        System.out.println(result);

    }
}
