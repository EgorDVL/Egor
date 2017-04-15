package com.zhyzhko.controllers;

import com.zhyzhko.controllers.forms.FieldForm;
import com.zhyzhko.dao.entity.Field;
import com.zhyzhko.dao.entity.Required;
import com.zhyzhko.dao.entity.enums.TypeEnum;
import com.zhyzhko.dto.*;
import com.zhyzhko.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Egor on 10.04.2017.
 */
@Controller
@RequestMapping("/field")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @Autowired
    private ResponseService responseService;

    @Autowired
    private TypeValueService typeValueService;

    @Autowired
    private FieldResponseService fieldResponseService;

    @Autowired
    HttpSession session;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showAllFields(Model model) {
        List<ResponseDto> allResponse = responseService.getAllResponse();
        session.setAttribute("response", allResponse.size());
        model.addAttribute("fields", fieldService.getAllField());
        return "fields";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteField(@RequestParam int fieldId, Model model) {
        fieldService.deleteFielde(fieldId);
        return showAllFields(model);
    }

    @RequestMapping(value = "/createPage", method = RequestMethod.GET)
    public String redirectToNewFieldPage(Model model) {
        model.addAttribute("typeEnum", TypeEnum.getEnumsValuesAsList());
        return "create-field";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createField(FieldForm fieldForm, Model model) {
        FieldDto fieldDto = fieldService.createField(fieldForm);

        List<ResponseDto> responseDtoList = responseService.getAllResponse();
        for (ResponseDto responseDto : responseDtoList) {
            fieldResponseService.createFieldResponse(new FieldResponseDto(responseDto.getId(), fieldDto, ""));
        }
        return showAllFields(model);
    }

    @RequestMapping(value = "/updatePage")
    public String redirectToUpdateFieldPage(@RequestParam int fieldId, Model model) {
        FieldDto field = fieldService.getField(fieldId);

        model.addAttribute("field", fieldService.getField(fieldId));
        model.addAttribute("oldTypeValues", typeValueService.getAllTypeValueByTypeId(field.getType().getId()));
        model.addAttribute("typeEnum", TypeEnum.getEnumsValuesAsList());
        return "update-field";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateField(FieldForm fieldForm, Model model) {
        fieldService.updateFieldStatusRequired(fieldForm);

        FieldDto fieldDto = fieldService.getField(fieldForm.getId());
        fieldService.updateFieldForm(fieldForm, fieldDto);
        return showAllFields(model);
    }
}