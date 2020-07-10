package org.vite.gateway.database.dao.mapper.generated;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.vite.gateway.database.po.generated.DepositAddress;
import org.vite.gateway.database.po.generated.DepositAddressCriteria;

@Mapper
public interface DepositAddressMapper {
    long countByExample(DepositAddressCriteria example);

    int deleteByExample(DepositAddressCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(DepositAddress record);

    int insertSelective(DepositAddress record);

    List<DepositAddress> selectByExample(DepositAddressCriteria example);

    DepositAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DepositAddress record, @Param("example") DepositAddressCriteria example);

    int updateByExample(@Param("record") DepositAddress record, @Param("example") DepositAddressCriteria example);

    int updateByPrimaryKeySelective(DepositAddress record);

    int updateByPrimaryKey(DepositAddress record);
}