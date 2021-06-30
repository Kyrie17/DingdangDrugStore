package com.dingdang.DingdangDrugstore.mbg.mapper;

import com.dingdang.DingdangDrugstore.mbg.model.HomeClassify;
import com.dingdang.DingdangDrugstore.mbg.model.HomeClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomeClassifyMapper {
    int countByExample(HomeClassifyExample example);

    int deleteByExample(HomeClassifyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HomeClassify record);

    int insertSelective(HomeClassify record);

    List<HomeClassify> selectByExample(HomeClassifyExample example);

    List<HomeClassify> selectAll();

    HomeClassify selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HomeClassify record, @Param("example") HomeClassifyExample example);

    int updateByExample(@Param("record") HomeClassify record, @Param("example") HomeClassifyExample example);

    int updateByPrimaryKeySelective(HomeClassify record);

    int updateByPrimaryKey(HomeClassify record);
}