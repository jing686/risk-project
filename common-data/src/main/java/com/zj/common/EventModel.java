package com.zj.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: zj
 * @Date: 2023/2/17 23:26
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventModel {
    private Integer eventId;
    private String message;
    private BigDecimal price;
    private Date startTime;
    private Date endTime;
}
