package com.zj.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zj
 * @Date: 2023/2/18 10:45
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private String user;
    private String url;
    private Long timeStamp;
}
