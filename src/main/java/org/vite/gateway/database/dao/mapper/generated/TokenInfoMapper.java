package org.vite.gateway.database.dao.mapper.generated;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.vite.gateway.database.po.generated.TokenInfo;
import org.vite.gateway.database.po.generated.TokenInfoCriteria;

@Mapper
public interface TokenInfoMapper {
    long countByExample(TokenInfoCriteria example);

    int deleteByExample(TokenInfoCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TokenInfo record);

    int insertSelective(TokenInfo record);

    List<TokenInfo> selectByExample(TokenInfoCriteria example);

    TokenInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TokenInfo record, @Param("example") TokenInfoCriteria example);

    int updateByExample(@Param("record") TokenInfo record, @Param("example") TokenInfoCriteria example);

    int updateByPrimaryKeySelective(TokenInfo record);

    int updateByPrimaryKey(TokenInfo record);
}