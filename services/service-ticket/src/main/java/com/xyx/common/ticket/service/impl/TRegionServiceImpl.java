package com.xyx.common.ticket.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyx.common.ticket.mapper.TRegionMapper;
import com.xyx.common.ticket.service.TRegionService;
import com.xyx.index12306.model.ticket.entry.TRegion;
import org.springframework.stereotype.Service;

/**
* @author xyx
* @description 针对表【t_region(地区表)】的数据库操作Service实现
* @createDate 2024-08-15 16:45:09
*/
@Service
public class TRegionServiceImpl extends ServiceImpl<TRegionMapper, TRegion>
    implements TRegionService {

}




