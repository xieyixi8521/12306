package com.xyx.common.ticket.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyx.common.ticket.mapper.TTicketMapper;
import com.xyx.common.ticket.service.TTicketService;
import com.xyx.index12306.model.ticket.entry.TTicket;
import org.springframework.stereotype.Service;

/**
* @author xyx
* @description 针对表【t_ticket(车票表)】的数据库操作Service实现
* @createDate 2024-08-15 16:45:10
*/
@Service
public class TTicketServiceImpl extends ServiceImpl<TTicketMapper, TTicket>
    implements TTicketService {

}




