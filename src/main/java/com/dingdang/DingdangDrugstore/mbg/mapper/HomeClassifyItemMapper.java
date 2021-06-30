package com.dingdang.DingdangDrugstore.mbg.mapper;

import com.dingdang.DingdangDrugstore.mbg.model.HomeClassifyItem;
import com.dingdang.DingdangDrugstore.mbg.model.HomeClassifyItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeClassifyItemMapper {
    int countByExample(HomeClassifyItemExample example);

    int deleteByExample(HomeClassifyItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeClassifyItem record);

    int insertSelective(HomeClassifyItem record);

    List<HomeClassifyItem> selectByExample(HomeClassifyItemExample example);

    List<HomeClassifyItem> getHomeClassifyItemByHomeClassifyId(@Param("homeClassifyId") Long homeClassifyId);

    HomeClassifyItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeClassifyItem record, @Param("example") HomeClassifyItemExample example);

    int updateByExample(@Param("record") HomeClassifyItem record, @Param("example") HomeClassifyItemExample example);

    int updateByPrimaryKeySelective(HomeClassifyItem record);

    int updateByPrimaryKey(HomeClassifyItem record);
}