package ${package!};

import java.util.List;
import java.util.Map;

import com.sxkj.frame.utils.LogUtil;
import com.sxkj.frame.utils.PageModel;
import com.sxkj.frame.utils.PrepareBeanSql;
import com.sxkj.frame.utils.StringUtil;
import com.sxkj.frame.core.hibernate.dao.HBaseDaoImpl;
import ${(data.basePackage)!}${(data.domainPackage)!}.bean.${domainName!};

public class ${domainName!}DaoImpl extends HBaseDaoImpl<${domainName!}> implements ${domainName!}Dao {

    public void save(${domainName!} ${domainName?uncap_first!}) throws Exception{
        super.save(${domainName?uncap_first!});
    }

    public void delete(String id) throws Exception {
        String sql = "delete from ${(table.tableName)!} where id='" + id + "'";
        super.executeSql(sql);
    }

    public void update(${domainName!} ${domainName?uncap_first!}) throws Exception {
        super.update(${domainName?uncap_first!});
    }
    
    public void formUpdate(${domainName!} ${domainName?uncap_first!}) throws Exception {
		String[] except = {};
		String sql = PrepareBeanSql.prepareUpdateSql("${domainName!}", ${domainName?uncap_first!}, except);
		LogUtil.warn(sql);
		super.executeHQLUpdate(sql, null);
	}

    public ${domainName!} search(String id) throws Exception{
        return super.searchById(id);
    }

    public List<Map<String, Object>>  searchList(${domainName!} ${domainName?uncap_first!},  PageModel pageModel) throws Exception {
        StringBuffer sql = new StringBuffer("select *");
		sql.append(" from ${(table.tableName)!} where status=1");
		if (StringUtil.isNOtNullAndBlank(${domainName?uncap_first!}.getId())){
			sql.append(" and id='").append(${domainName?uncap_first!}.getId()).append("'");
		} else {
			sql.append("");
		}
		sql.append(" order by createDate desc");
		return super.searchListPageMapBySql(sql.toString(), pageModel);
    }
}
