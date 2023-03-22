package com.zj.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zj.entity.TArea;
import com.zj.service.TAreaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TArea)表控制层
 *
 * @author makejava
 * @since 2023-03-06 21:52:39
 */
@RestController
@RequestMapping("tArea")
public class TAreaController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TAreaService tAreaService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tArea 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TArea> page, TArea tArea) {
        return success(this.tAreaService.page(page, new QueryWrapper<>(tArea)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tAreaService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tArea 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TArea tArea) {
        return success(this.tAreaService.save(tArea));
    }

    /**
     * 修改数据
     *
     * @param tArea 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TArea tArea) {
        return success(this.tAreaService.updateById(tArea));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tAreaService.removeByIds(idList));
    }
}

