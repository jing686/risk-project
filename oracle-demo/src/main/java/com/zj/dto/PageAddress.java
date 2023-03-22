package com.zj.dto;

import com.zj.entity.TAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: zj
 * @Date: 2023/3/8 21:37
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class PageAddress extends TAddress {
    private Integer start;
    private Integer size;
}
