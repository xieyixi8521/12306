package com.xyx.common.ticket.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyx.common.ticket.mapper.TSeatMapper;
import com.xyx.common.ticket.service.TSeatService;
import com.xyx.index12306.model.ticket.entry.TSeat;
import org.springframework.stereotype.Service;

/**
* @author xyx
* @description 针对表【t_seat(座位表)】的数据库操作Service实现
* @createDate 2024-08-15 16:45:09
*/
@Service
public class TSeatServiceImpl extends ServiceImpl<TSeatMapper, TSeat>
    implements TSeatService {

}




