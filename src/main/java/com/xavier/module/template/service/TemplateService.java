package com.xavier.module.template.service;

import com.xavier.module.template.bean.TemplateDetails;

import java.util.List;

public interface TemplateService {

    /**
     * 模板目录
     */
    String TEMPLATE_PATH = "res/templates";

    List<TemplateDetails> getAllTemplates();
}
