package com.zj.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zj.entity.TPricetable;
import com.zj.service.TPricetableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TPricetable)表控制层
 *
 * @author makejava
 * @since 2023-03-06 21:52:40
 */
@RestController
@RequestMapping("tPricetable")
public class TPricetableController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TPricetableService tPricetableService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tPricetable 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TPricetable> page, TPricetable tPricetable) {
        return success(this.tPricetableService.page(page, new QueryWrapper<>(tPricetable)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tPricetableService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tPricetable 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TPricetable tPricetable) {
        return success(this.tPricetableService.save(tPricetable));
    }

    /**
     * 修改数据
     *
     * @param tPricetable 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TPricetable tPricetable) {
        return success(this.tPricetableService.updateById(tPricetable));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tPricetableService.removeByIds(idList));
    }
}

