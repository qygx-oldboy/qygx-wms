package com.ruoyi.basicData.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.basicData.mapper.MdGoodsMapper;
import com.ruoyi.basicData.domain.MdGoods;
import com.ruoyi.basicData.service.IMdGoodsService;

/**
 * 商品信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-07-12
 */
@Service
public class MdGoodsServiceImpl implements IMdGoodsService
{
    @Autowired
    private MdGoodsMapper mdGoodsMapper;

    /**
     * 查询商品信息
     *
     * @param id 商品信息主键
     * @return 商品信息
     */
    @Override
    public MdGoods selectMdGoodsById(Long id)
    {
        return mdGoodsMapper.selectMdGoodsById(id);
    }

    /**
     * 查询商品信息列表
     *
     * @param mdGoods 商品信息
     * @return 商品信息
     */
    @Override
    public List<MdGoods> selectMdGoodsList(MdGoods mdGoods)
    {
        return mdGoodsMapper.selectMdGoodsList(mdGoods);
    }

    /**
     * 新增商品信息
     *
     * @param mdGoods 商品信息
     * @return 结果
     */
    @Override
    public int insertMdGoods(MdGoods mdGoods)
    {
        return mdGoodsMapper.insertMdGoods(mdGoods);
    }

    /**
     * 修改商品信息
     *
     * @param mdGoods 商品信息
     * @return 结果
     */
    @Override
    public int updateMdGoods(MdGoods mdGoods)
    {
        return mdGoodsMapper.updateMdGoods(mdGoods);
    }

    /**
     * 批量删除商品信息
     *
     * @param ids 需要删除的商品信息主键
     * @return 结果
     */
    @Override
    public int deleteMdGoodsByIds(Long[] ids)
    {
        return mdGoodsMapper.deleteMdGoodsByIds(ids);
    }

    /**
     * 删除商品信息信息
     *
     * @param id 商品信息主键
     * @return 结果
     */
    @Override
    public int deleteMdGoodsById(Long id)
    {
        return mdGoodsMapper.deleteMdGoodsById(id);
    }
}
