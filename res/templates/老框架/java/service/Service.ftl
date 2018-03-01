package ${basePackage}.${moduleName}.service;

import java.util.List;
import java.util.Map;

import com.sxkj.frame.utils.PageModel;
import ${basePackage}.${moduleName}.bean.${table.className};

public interface ${table.className}Service {

    /**
     *
     * @Title: add
     * @author: ${author}
     * @date: ${.now}
     * @Description: 添加${table.remarks}
     * @return: ${table.className}
     * @throws:
     */
    public ${table.className} add() throws Exception;

    /**
     *
     * @Title: save
     * @author: ${author}
     * @date: ${.now}
     * @Description: 保存${table.remarks}
     * @param: ${moduleName}
     * @return: void
     * @throws:
     */
    public String save(${table.className} ${moduleName}) throws Exception;

    /**
     *
     * @Title: delete
     * @author: ${author}
     * @date: ${.now}
     * @Description: 删除${table.remarks}
     * @param: id
     * @return: String
     * @throws:
     */
    public String delete(String id) throws Exception;

    /**
     *
     * @Title: update
     * @author: ${author}
     * @date: ${.now}
     * @Description: 更新${table.remarks}
     * @param: ${moduleName}
     * @return: String
     * @throws:
     */
    public String update(${table.className} ${moduleName}) throws Exception;

    /**
     *
     * @Title: search
     * @author: ${author}
     * @date: ${.now}
     * @Description: 通过id查询${table.remarks}
     * @param: id
     * @return: ${table.className}
     * @throws:
     */
    public ${table.className} search(String id) throws Exception;

    /**
     *
     * @Title: searchList
     * @author: ${author}
     * @date: ${.now}
     * @Description: 查看返回${table.remarks}列表
     * @param: ${moduleName}
     * @param: pageModel
     * @return: List<Map<String, Object>>
     * @throws:
     */
    public List<Map<String, Object>> searchList(${table.className} ${moduleName},  PageModel pageModel) throws Exception;
}