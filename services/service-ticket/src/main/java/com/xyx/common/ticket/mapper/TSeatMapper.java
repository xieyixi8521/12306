package com.xyx.common.ticket.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyx.index12306.model.ticket.entry.TSeat;
import org.apache.ibatis.annotations.Mapper;

/**
* @author xyx
* @description 针对表【t_seat(座位表)】的数据库操作Mapper
* @createDate 2024-08-15 16:45:09
* @Entity generator.domain.TSeat
*/
@Mapper
public interface TSeatMapper extends BaseMapper<TSeat> {

}




