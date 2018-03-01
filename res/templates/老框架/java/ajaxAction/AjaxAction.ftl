package ${basePackage}.ajax.action;

import java.util.*;
import com.google.gson.Gson;
import org.apache.struts2.json.annotations.JSON;

import ${basePackage}.${moduleName}.bean.${table.className};
import ${basePackage}.${moduleName}.service.${table.className}Service;
import com.sxkj.frame.utils.LogUtil;
import com.sxkj.frame.utils.PageModel;
import com.sxkj.frame.utils.SxkjAjaxAction;

@SuppressWarnings("serial")
public class Ajax${table.className}Action extends SxkjAjaxAction<${table.className}> {

    private ${table.className}Service ${moduleName}Service;
    private ${table.className} ${moduleName} = new ${table.className}();

    @JSON(serialize = false)
    public ${table.className} get${table.className}() {
        return ${moduleName};
    }

    public void set${table.className}(${table.className} ${moduleName}) {
        this.${moduleName} = ${moduleName};
    }

    public void set${table.className}Service(${table.className}Service ${moduleName}Service) {
        this.${moduleName}Service = ${moduleName}Service;
    }

    public ${table.className} getModel() {
        return this.${moduleName};
    }

    /**
     *
     * @Title: save
     * @author: ${author}
     * @date: ${.now}
     * @Description: 保存${table.remarks}
     * @return: String
     * @throws:
     */
    public String save() throws Exception {
        try {
            this.${moduleName}Service.save(${moduleName});
        } catch (Exception e) {
            LogUtil.exception(e);
            status = e.getMessage();
        }
        return SUCCESS;
    }

    /**
     *
     * @Title: update
     * @author: ${author}
     * @date: ${.now}
     * @Description: 更新${table.remarks}
     * @return: String
     * @throws:
     */
    public String update() throws Exception {
        try {
            ${moduleName}Service.update(${moduleName});
        }catch (Exception e) {
            LogUtil.exception(e);
            status = e.getMessage();
        }
        return SUCCESS;
    }

    /**
     *
     * @Title: delete
     * @author: ${author}
     * @date: ${.now}
     * @Description: 删除${table.remarks}
     * @return: String
     * @throws:
     */
    public String delete() throws Exception {
        try {
            ${moduleName}Service.delete(${moduleName}.getId());
        } catch (Exception e) {
            LogUtil.exception(e);
            status = e.getMessage();
        }
        return SUCCESS;
    }

    /**
    *
    * @Title: grid
    * @author: ${author}
    * @date: ${.now}
    * @Description: 分页显示${table.remarks}
    * @return: String
    * @throws:
    */
    public String grid() throws Exception {
        try {
            PageModel pageModel = new PageModel(pageSize);
            pageModel.setCurrPage(currPage);
            List<Map<String, Object>> list = ${moduleName}Service.searchList(${moduleName}, pageModel);
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("pager.pageNo", pageModel.getCurrPage());
            map.put("pager.totalRows",pageModel.getPageNum());
            map.put("pager.pageSize",pageModel.getPageSize());
            map.put("rows", list);
            gridJson = new Gson().toJson(map);
        } catch (Exception e) {
            LogUtil.exception(e);
            status = e.getMessage();
        }
        return SUCCESS;
    }
}