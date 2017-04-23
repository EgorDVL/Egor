package com.zhyzhko.controllers;

import com.zhyzhko.controllers.forms.ResponseCollectionCreateForm;
import com.zhyzhko.controllers.forms.ResponseCollectionShowForm;
import com.zhyzhko.dto.*;
import com.zhyzhko.service.FieldResponseService;
import com.zhyzhko.service.FieldService;
import com.zhyzhko.service.ResponseService;
import com.zhyzhko.service.TypeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Egor on 11.04.2017.
 */
@Controller
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private FieldService fieldService;

    @Autowired
    private FieldResponseService fieldResponseService;

    @Autowired
    private ResponseService responseService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showAllResponses(Model model) {
        List<FieldDto> fieldDtoList = fieldService.getAllField();
        List<FieldResponseDto> fieldResponseDtoList = fieldResponseService.getAllFieldResponse();
        model.addAttribute("responses", fieldResponseService.showAllResponses(fieldDtoList, fieldResponseDtoList));
        return "responses";
    }


    @RequestMapping(value = "/createPage", method = RequestMethod.GET)
    public String redirectToNewResponseCollecting(Model model) {
        List<FieldDto> fieldDtoList = fieldService.getAllField();
        model.addAttribute("createForm", fieldService.getResponseCollectionCreateForm(fieldDtoList));
        return "response-collecting";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createResponse(@ModelAttribute("createForm") ResponseCollectionCreateForm responseCollectionCreateForm) {
        List<ResponseCollectionShowForm> showFormList = responseCollectionCreateForm.getShowForms();
        ResponseDto responseDto = responseService.createResponse(new ResponseDto());
        fieldResponseService.createFieldResponseFromForm(showFormList, responseDto);

        return redirectToSuccessful();
    }

    @RequestMapping("/successful")
    public String redirectToSuccessful() {
        return "successful";
    }
}