package com.zj.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zj.entity.TOwnertype;
import com.zj.service.TOwnertypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TOwnertype)表控制层
 *
 * @author makejava
 * @since 2023-03-06 21:52:39
 */
@RestController
@RequestMapping("tOwnertype")
public class TOwnertypeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TOwnertypeService tOwnertypeService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tOwnertype 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TOwnertype> page, TOwnertype tOwnertype) {
        return success(this.tOwnertypeService.page(page, new QueryWrapper<>(tOwnertype)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tOwnertypeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tOwnertype 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TOwnertype tOwnertype) {
        return success(this.tOwnertypeService.save(tOwnertype));
    }

    /**
     * 修改数据
     *
     * @param tOwnertype 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TOwnertype tOwnertype) {
        return success(this.tOwnertypeService.updateById(tOwnertype));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tOwnertypeService.removeByIds(idList));
    }
}

