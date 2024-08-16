package com.xyx.common.ticket.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyx.index12306.model.ticket.entry.TTicket;
import org.apache.ibatis.annotations.Mapper;

/**
* @author xyx
* @description 针对表【t_ticket(车票表)】的数据库操作Mapper
* @createDate 2024-08-15 16:45:10
* @Entity generator.domain.TTicket
*/
@Mapper
public interface TTicketMapper extends BaseMapper<TTicket> {

}




