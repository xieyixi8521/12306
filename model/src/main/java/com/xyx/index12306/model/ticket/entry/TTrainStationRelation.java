package com.xyx.index12306.model.ticket.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 列车站点关系表
 * @TableName t_train_station_relation
 */
@TableName(value ="t_train_station_relation")
@Data
public class TTrainStationRelation implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 车次ID
     */
    private Long trainId;

    /**
     * 出发站点
     */
    private String departure;

    /**
     * 到达站点
     */
    private String arrival;

    /**
     * 起始城市名称
     */
    private String startRegion;

    /**
     * 终点城市名称
     */
    private String endRegion;

    /**
     * 始发标识
     */
    private Integer departureFlag;

    /**
     * 终点标识
     */
    private Integer arrivalFlag;

    /**
     * 出发时间
     */
    private Date departureTime;

    /**
     * 到达时间
     */
    private Date arrivalTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除标识
     */
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TTrainStationRelation other = (TTrainStationRelation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTrainId() == null ? other.getTrainId() == null : this.getTrainId().equals(other.getTrainId()))
            && (this.getDeparture() == null ? other.getDeparture() == null : this.getDeparture().equals(other.getDeparture()))
            && (this.getArrival() == null ? other.getArrival() == null : this.getArrival().equals(other.getArrival()))
            && (this.getStartRegion() == null ? other.getStartRegion() == null : this.getStartRegion().equals(other.getStartRegion()))
            && (this.getEndRegion() == null ? other.getEndRegion() == null : this.getEndRegion().equals(other.getEndRegion()))
            && (this.getDepartureFlag() == null ? other.getDepartureFlag() == null : this.getDepartureFlag().equals(other.getDepartureFlag()))
            && (this.getArrivalFlag() == null ? other.getArrivalFlag() == null : this.getArrivalFlag().equals(other.getArrivalFlag()))
            && (this.getDepartureTime() == null ? other.getDepartureTime() == null : this.getDepartureTime().equals(other.getDepartureTime()))
            && (this.getArrivalTime() == null ? other.getArrivalTime() == null : this.getArrivalTime().equals(other.getArrivalTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTrainId() == null) ? 0 : getTrainId().hashCode());
        result = prime * result + ((getDeparture() == null) ? 0 : getDeparture().hashCode());
        result = prime * result + ((getArrival() == null) ? 0 : getArrival().hashCode());
        result = prime * result + ((getStartRegion() == null) ? 0 : getStartRegion().hashCode());
        result = prime * result + ((getEndRegion() == null) ? 0 : getEndRegion().hashCode());
        result = prime * result + ((getDepartureFlag() == null) ? 0 : getDepartureFlag().hashCode());
        result = prime * result + ((getArrivalFlag() == null) ? 0 : getArrivalFlag().hashCode());
        result = prime * result + ((getDepartureTime() == null) ? 0 : getDepartureTime().hashCode());
        result = prime * result + ((getArrivalTime() == null) ? 0 : getArrivalTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", trainId=").append(trainId);
        sb.append(", departure=").append(departure);
        sb.append(", arrival=").append(arrival);
        sb.append(", startRegion=").append(startRegion);
        sb.append(", endRegion=").append(endRegion);
        sb.append(", departureFlag=").append(departureFlag);
        sb.append(", arrivalFlag=").append(arrivalFlag);
        sb.append(", departureTime=").append(departureTime);
        sb.append(", arrivalTime=").append(arrivalTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}