package com.zj.dto;

import com.zj.entity.TAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zj
 * @Date: 2023/3/8 22:34
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {
    private Integer start;
    private Integer size;
    private Integer count;
    private Integer totalPage;
    private List<TAddress> AddressList;
}
