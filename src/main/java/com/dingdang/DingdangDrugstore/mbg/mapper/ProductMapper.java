package com.dingdang.DingdangDrugstore.mbg.mapper;

import com.dingdang.DingdangDrugstore.mbg.model.Product;
import com.dingdang.DingdangDrugstore.mbg.model.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExampleWithBLOBs(ProductExample example);

    List<Product> selectByExample(ProductExample example);

    List<Product> selectByCondition(@Param("type") Integer type,
                                    @Param("brandId") Long brandId,
                                    @Param("productCategoryId") Long productCategoryId,
                                    @Param("name") String name);

    List<Product> selectByQuery(@Param("query") String query);

    Product selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExampleWithBLOBs(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
}