package com.zj.vo;

import lombok.Data;

/**
 * @Author: zj
 * @Date: 2023/6/2 21:31
 * @Version: 1.0
 */
@Data
public class RequestParam {

    private String ip;
    private String port;
    private String serviceName;
    private String pid;
    private String username;
    private String password;
    private String sqlPath;

}
