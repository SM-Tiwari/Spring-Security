package com.gnv.d3.fcm.scheduler.mapper;

import com.gnv.d3.fcm.scheduler.bean.Secretkey;
import com.gnv.d3.fcm.scheduler.bean.SecretkeyExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SecretkeyMapper {
    int countByExample(SecretkeyExample example);

    int deleteByExample(SecretkeyExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(Secretkey record);

    int insertSelective(Secretkey record);

    List<Secretkey> selectByExampleWithRowbounds(SecretkeyExample example, RowBounds rowBounds);

    List<Secretkey> selectByExample(SecretkeyExample example);

    Secretkey selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") Secretkey record, @Param("example") SecretkeyExample example);

    int updateByExample(@Param("record") Secretkey record, @Param("example") SecretkeyExample example);
    int updateByExample2(@Param("example") SecretkeyExample example);

    int updateByPrimaryKeySelective(Secretkey record);

    int updateByPrimaryKey(Secretkey record);
}