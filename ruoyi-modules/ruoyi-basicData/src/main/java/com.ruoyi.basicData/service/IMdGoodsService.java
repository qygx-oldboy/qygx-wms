package com.ruoyi.basicData.service;

import java.util.List;
import com.ruoyi.basicData.domain.MdGoods;

/**
 * 商品信息Service接口
 *
 * @author ruoyi
 * @date 2022-07-12
 */
public interface IMdGoodsService
{
    /**
     * 查询商品信息
     *
     * @param id 商品信息主键
     * @return 商品信息
     */
    public MdGoods selectMdGoodsById(Long id);

    /**
     * 查询商品信息列表
     *
     * @param mdGoods 商品信息
     * @return 商品信息集合
     */
    public List<MdGoods> selectMdGoodsList(MdGoods mdGoods);

    /**
     * 新增商品信息
     *
     * @param mdGoods 商品信息
     * @return 结果
     */
    public int insertMdGoods(MdGoods mdGoods);

    /**
     * 修改商品信息
     *
     * @param mdGoods 商品信息
     * @return 结果
     */
    public int updateMdGoods(MdGoods mdGoods);

    /**
     * 批量删除商品信息
     *
     * @param ids 需要删除的商品信息主键集合
     * @return 结果
     */
    public int deleteMdGoodsByIds(Long[] ids);

    /**
     * 删除商品信息信息
     *
     * @param id 商品信息主键
     * @return 结果
     */
    public int deleteMdGoodsById(Long id);
}
