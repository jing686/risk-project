package com.zj.controller;


import com.zj.dao.TAddressDao;
import com.zj.dto.PageAddress;
import com.zj.dto.PageResult;
import com.zj.utils.TestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (TAddress)表控制层
 *
 * @author makejava
 * @since 2023-03-06 21:52:39
 */
@RestController
@RequestMapping("/tAddress")
public class TAddressController {
    @Autowired
    private TAddressDao addressDao;

    @PostMapping("/queryByPage")
    public PageResult queryByPage(@RequestBody PageAddress pageAddress) {
        String filedUrl = TestUtils.getFiledUrl();
        System.out.println("filedUrl -->" + filedUrl);

        PageResult pageResults = addressDao.queryPageInfo(pageAddress);
        return pageResults;
    }
}

