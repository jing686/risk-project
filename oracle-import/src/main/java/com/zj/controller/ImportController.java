package com.zj.controller;

import com.zj.utils.OracleImportUtils;
import com.zj.vo.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * @Author: zj
 * @Date: 2023/6/2 21:29
 * @Version: 1.0
 */
@RestController
public class ImportController {

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String importSql(@RequestBody RequestParam param) throws SQLException, ClassNotFoundException {
        long start = System.currentTimeMillis();
        OracleImportUtils.importSqlForOracle(param);
        long end = System.currentTimeMillis();

        return "导入成功！！共耗时：" + (end - start) / (1000 * 60) + " min " + (end - start) % (1000 * 60) / 1000 + " s";
    }
}
