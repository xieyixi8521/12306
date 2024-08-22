package ${package.Entity};

## 引入公共资源
#parse("templates/common.vm")
## 引入导包宏
#set($ignoreFieldList = ["id","createTime","updateTime","createBy","updateBy"] )
#importEntityPackage($ignoreFieldList)
import com.baomidou.mybatisplus.annotation.TableName;
## 实体公共父类，里面有"id","createTime","updateTime","createBy","updateBy"字段
import com.digital.framework.core.base.SuperCommomPO;
import lombok.Data;

/**
* $!{table.comment}
* @author ${author}
* @date ${date}
*/
@Data
@TableName("${schemaName}${table.name}")
public class ${entity} extends SuperCommomPO {
## ----------  BEGIN 字段循环遍历  ----------
#foreach($field in ${table.fields})
#if(${ignoreFieldList.contains($field.propertyName)})
## 如果是忽略字段什么都不干
#else
#if("$!field.comment" != "")

/**
* ${field.comment}
*/
#end
private ${field.propertyType} ${field.propertyName};
#end
#end
## ----------  END 字段循环遍历  ----------
}