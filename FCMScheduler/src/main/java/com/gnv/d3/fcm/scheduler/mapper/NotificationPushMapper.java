package com.gnv.d3.fcm.scheduler.mapper;

import com.gnv.d3.fcm.scheduler.bean.NotificationPush;
import com.gnv.d3.fcm.scheduler.bean.NotificationPushExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotificationPushMapper {
    int countByExample(NotificationPushExample example);

    int deleteByExample(NotificationPushExample example);

    int insert(NotificationPush record);

    int insertSelective(NotificationPush record);

    List<NotificationPush> selectByExample(NotificationPushExample example);
    List<NotificationPush> selectByExampleWithRowbounds(NotificationPushExample example);

    int updateByExampleSelective(@Param("record") NotificationPush record, @Param("example") NotificationPushExample example);

    int updateByExample(@Param("record") NotificationPush record, @Param("example") NotificationPushExample example);
}