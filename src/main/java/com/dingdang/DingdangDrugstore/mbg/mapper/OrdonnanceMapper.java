package com.dingdang.DingdangDrugstore.mbg.mapper;

import com.dingdang.DingdangDrugstore.mbg.model.Ordonnance;
import com.dingdang.DingdangDrugstore.mbg.model.OrdonnanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdonnanceMapper {
    int countByExample(OrdonnanceExample example);

    int deleteByExample(OrdonnanceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Ordonnance record);

    int insertSelective(Ordonnance record);

    List<Ordonnance> selectByExample(OrdonnanceExample example);

    List<Ordonnance> getAllOrdonnance();

    Ordonnance selectByPrimaryKey(Long id);

    Ordonnance selectByUserIdAndProductId(@Param("userId")Long userId, @Param("productId") Long productId);

    int updateByExampleSelective(@Param("record") Ordonnance record, @Param("example") OrdonnanceExample example);

    int updateByExample(@Param("record") Ordonnance record, @Param("example") OrdonnanceExample example);

    int updateByPrimaryKeySelective(Ordonnance record);

    int updateByPrimaryKey(Ordonnance record);
}