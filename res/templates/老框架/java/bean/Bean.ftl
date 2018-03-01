package ${package!};

<#list importType as im>
import ${im!};
</#list>
import javax.persistence.Column;
import javax.persistence.Table;

import com.sxkj.frame.utils.BeanSupport;

/**
 * @author: ${(data.author)!}
 * @data: ${.now?date}
 * @comment: ${(table.tableComment)!}
 */
@SuppressWarnings("serial")
@Table(name = "${table.tableName}")
public class ${domainName!} extends BeanSupport {

    <#list columnDatas as columnData>
    @Column(name = "${(columnData.column.columnComment)!}")
    private ${(columnData.type.javaType)!} ${(columnData.name)!};
    </#list>

    <#list columnDatas as columnData>
    public ${(columnData.type.javaType)!} get${(columnData.name)?cap_first!}() {
        return ${(columnData.name)!};
    }

    public void set${(columnData.name)?cap_first!}(${(columnData.type.javaType)!} ${(columnData.name)!}) {
        this.${(columnData.name)!} = ${(columnData.name)!};
    }
    
    </#list>
}
