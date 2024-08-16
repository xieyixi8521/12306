package com.xyx.index12306.model.ticket.vo;

import lombok.Data;

@Data
public class StationQueryRespVO {
    /**
     * 名称
     */
    private String name;

    /**
     * 地区编码
     */
    private String code;

    /**
     * 拼音
     */
    private String spell;

    /**
     * 城市名称
     */
    private String regionName;
}
