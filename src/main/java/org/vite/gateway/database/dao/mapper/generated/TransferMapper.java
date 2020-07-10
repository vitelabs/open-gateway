package org.vite.gateway.database.dao.mapper.generated;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.vite.gateway.database.po.generated.Transfer;
import org.vite.gateway.database.po.generated.TransferCriteria;

@Mapper
public interface TransferMapper {
    long countByExample(TransferCriteria example);

    int deleteByExample(TransferCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Transfer record);

    int insertSelective(Transfer record);

    List<Transfer> selectByExample(TransferCriteria example);

    Transfer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Transfer record, @Param("example") TransferCriteria example);

    int updateByExample(@Param("record") Transfer record, @Param("example") TransferCriteria example);

    int updateByPrimaryKeySelective(Transfer record);

    int updateByPrimaryKey(Transfer record);
}