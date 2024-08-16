package com.xyx.index12306.model.ticket.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 列车表
 * @TableName t_train
 */
@TableName(value ="t_train")
@Data
public class TTrain implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 列车车次
     */
    private String trainNumber;

    /**
     * 列车类型 0：高铁 1：动车 2：普通车
     */
    private Integer trainType;

    /**
     * 列车标签 0：复兴号 1：智能动车组 2：静音车厢 3：支持选铺
     */
    private String trainTag;

    /**
     * 列车品牌 0：GC-高铁/城际 1：D-动车 2：Z-直达 3：T-特快 4：K-快速 5：其他 6：复兴号 7：智能动车组
     */
    private String trainBrand;

    /**
     * 起始站
     */
    private String startStation;

    /**
     * 终点站
     */
    private String endStation;

    /**
     * 起始城市
     */
    private String startRegion;

    /**
     * 终点城市
     */
    private String endRegion;

    /**
     * 销售时间
     */
    private Date saleTime;

    /**
     * 销售状态 0：可售 1：不可售 2：未知
     */
    private Integer saleStatus;

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
        TTrain other = (TTrain) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTrainNumber() == null ? other.getTrainNumber() == null : this.getTrainNumber().equals(other.getTrainNumber()))
            && (this.getTrainType() == null ? other.getTrainType() == null : this.getTrainType().equals(other.getTrainType()))
            && (this.getTrainTag() == null ? other.getTrainTag() == null : this.getTrainTag().equals(other.getTrainTag()))
            && (this.getTrainBrand() == null ? other.getTrainBrand() == null : this.getTrainBrand().equals(other.getTrainBrand()))
            && (this.getStartStation() == null ? other.getStartStation() == null : this.getStartStation().equals(other.getStartStation()))
            && (this.getEndStation() == null ? other.getEndStation() == null : this.getEndStation().equals(other.getEndStation()))
            && (this.getStartRegion() == null ? other.getStartRegion() == null : this.getStartRegion().equals(other.getStartRegion()))
            && (this.getEndRegion() == null ? other.getEndRegion() == null : this.getEndRegion().equals(other.getEndRegion()))
            && (this.getSaleTime() == null ? other.getSaleTime() == null : this.getSaleTime().equals(other.getSaleTime()))
            && (this.getSaleStatus() == null ? other.getSaleStatus() == null : this.getSaleStatus().equals(other.getSaleStatus()))
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
        result = prime * result + ((getTrainNumber() == null) ? 0 : getTrainNumber().hashCode());
        result = prime * result + ((getTrainType() == null) ? 0 : getTrainType().hashCode());
        result = prime * result + ((getTrainTag() == null) ? 0 : getTrainTag().hashCode());
        result = prime * result + ((getTrainBrand() == null) ? 0 : getTrainBrand().hashCode());
        result = prime * result + ((getStartStation() == null) ? 0 : getStartStation().hashCode());
        result = prime * result + ((getEndStation() == null) ? 0 : getEndStation().hashCode());
        result = prime * result + ((getStartRegion() == null) ? 0 : getStartRegion().hashCode());
        result = prime * result + ((getEndRegion() == null) ? 0 : getEndRegion().hashCode());
        result = prime * result + ((getSaleTime() == null) ? 0 : getSaleTime().hashCode());
        result = prime * result + ((getSaleStatus() == null) ? 0 : getSaleStatus().hashCode());
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
        sb.append(", trainNumber=").append(trainNumber);
        sb.append(", trainType=").append(trainType);
        sb.append(", trainTag=").append(trainTag);
        sb.append(", trainBrand=").append(trainBrand);
        sb.append(", startStation=").append(startStation);
        sb.append(", endStation=").append(endStation);
        sb.append(", startRegion=").append(startRegion);
        sb.append(", endRegion=").append(endRegion);
        sb.append(", saleTime=").append(saleTime);
        sb.append(", saleStatus=").append(saleStatus);
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