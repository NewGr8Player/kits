package ${basePackage}.${moduleName}.service;

import java.util.List;
import java.util.Map;

import com.sxkj.frame.utils.PageModel;
import com.sxkj.frame.utils.UUIDGenerator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sxkj.frame.utils.LogUtil;
import ${basePackage}.${moduleName}.bean.${table.className};
import ${basePackage}.${moduleName}.dao.${table.className}Dao;

public class ${table.className}ServiceImpl implements ${table.className}Service {

    private ${table.className}Dao ${moduleName}Dao;

    public void set${table.className}Dao(${table.className}Dao ${moduleName}Dao) {
        this.${moduleName}Dao = ${moduleName}Dao;
    }

    public String save(${table.className} ${moduleName}) throws Exception {
    try {
        if(null == ${moduleName}.getId() || "".equals(${moduleName}.getId())) {
            ${moduleName}.setId(UUIDGenerator.generate().toString());
        }
        ${moduleName}.init();
        this.${moduleName}Dao.save(${moduleName});
        return "";
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.exception(e);
            throw e;
        }
    }
    public String delete(String id) throws Exception {
        try {
            this.${moduleName}Dao.delete(id);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.exception(e);
            throw e;
        }
    }

    public String update(${table.className} ${moduleName}) throws Exception {
        try {
            ${moduleName}.updateInit();
            this.${moduleName}Dao.update(${moduleName});
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.exception(e);
            throw e;
        }
    }

    public ${table.className} search(String id) throws Exception {
    	${table.className} ${moduleName} = new ${table.className}();
    	${moduleName}.setId(id);
        List<Map<String, Object>> list = this.${moduleName}Dao.searchList(${moduleName}, null);
		if (null != list && !list.isEmpty()) {
			String gridJson = new Gson().toJson(list.get(0));
			return new Gson().fromJson(gridJson, new TypeToken<${table.className}>() {
			}.getType());
		}
		return new ${table.className}();
    }

    public List<Map<String, Object>> searchList(${table.className} ${moduleName},  PageModel pageModel) throws Exception {
        return this.${moduleName}Dao.searchList(${moduleName}, pageModel);
    }

    public ${table.className} add() throws Exception {
        ${table.className} addMap = new ${table.className}();
        addMap.setId(UUIDGenerator.generate().toString());
        return addMap;
    }
}
