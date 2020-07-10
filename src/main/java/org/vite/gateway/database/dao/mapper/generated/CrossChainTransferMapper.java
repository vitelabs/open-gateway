package org.vite.gateway.database.dao.mapper.generated;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.vite.gateway.database.po.generated.CrossChainTransfer;
import org.vite.gateway.database.po.generated.CrossChainTransferCriteria;

@Mapper
public interface CrossChainTransferMapper {
    long countByExample(CrossChainTransferCriteria example);

    int deleteByExample(CrossChainTransferCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(CrossChainTransfer record);

    int insertSelective(CrossChainTransfer record);

    List<CrossChainTransfer> selectByExample(CrossChainTransferCriteria example);

    CrossChainTransfer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CrossChainTransfer record, @Param("example") CrossChainTransferCriteria example);

    int updateByExample(@Param("record") CrossChainTransfer record, @Param("example") CrossChainTransferCriteria example);

    int updateByPrimaryKeySelective(CrossChainTransfer record);

    int updateByPrimaryKey(CrossChainTransfer record);
}