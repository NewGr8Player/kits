package ${package!};

import java.util.List;
import java.util.Map;
import com.sxkj.frame.utils.PageModel;

import ${(data.basePackage)!}${(data.domainPackage)!}.bean.${domainName!};

public interface ${domainName!}Dao {

    /**
     *
     * @Title: save
     * @author: ${(data.author)!}
     * @date: ${.now?date}
     * @Description: 保存${(table.tableComment)!}
     * @param: ${domainName?uncap_first!})
     * @return: void
     * @throws:
     */
    public void save(${domainName!} ${domainName?uncap_first!})) throws Exception;

    /**
     *
     * @Title: delete
     * @author: ${(data.author)!}
     * @date: ${.now?date}
     * @Description: 删除${(table.tableComment)!}
     * @param: id
     * @return: void
     * @throws:
     */
    public void delete(String id) throws Exception;

    /**
     *
     * @Title: update
     * @author: ${(data.author)!}
     * @date: ${.now?date}
     * @Description: 更新${(table.tableComment)!}
     * @param: ${domainName?uncap_first!})
     * @return: void
     * @throws:
     */
    public void update(${domainName!} ${domainName?uncap_first!})) throws Exception;

    /**
     *
     * @Title: update
     * @author: ${(data.author)!}
     * @date: ${.now?date}
     * @Description: 通过id查询${(table.tableComment)!}
     * @param: id
     * @return: ${domainName!}
     * @throws:
     */
    public ${domainName!} search(String id) throws Exception;

    /**
     *
     * @Title: searchList
     * @author: ${(data.author)!}
     * @date: ${.now?date}
     * @Description: 查询${(table.tableComment)!}列表
     * @param: ${domainName?uncap_first!})
     * @param: PageModel pageModel
     * @return: List<Map<String, Object>>
     * @throws:
     */
    public List<Map<String, Object>> searchList(${domainName!} ${domainName?uncap_first!}),  PageModel pageModel) throws Exception;
}