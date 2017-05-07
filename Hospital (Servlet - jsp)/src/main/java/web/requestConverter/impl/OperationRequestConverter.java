package web.requestConverter.impl;

import bean.Operation;
import bean.enums.ComplexityEnum;
import bean.enums.OperationStatus;
import util.DateUtils;
import web.requestConverter.HttpRequestConverter;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Egor on 17.01.2017.
 */
public class OperationRequestConverter implements HttpRequestConverter<Operation> {
    private DateUtils dateUtils = new DateUtils(DateUtils.YEAR_MONTH_DAY);

    @Override
    public Operation fromRequest(HttpServletRequest req) {
        String nameOperation = req.getParameter("name");
        Date date = dateUtils.parse(req.getParameter("date"));
        ComplexityEnum complexity = ComplexityEnum.getValue(req.getParameter("complexity"));
        String operationId = req.getParameter("operationId");
        OperationStatus operationStatus = OperationStatus.getValue(req.getParameter("operationStatus"));

        if (operationId != null) {
            int operationIdInt = Integer.parseInt(operationId);
            return new Operation(operationIdInt, nameOperation, date, complexity, operationStatus);
        }
        return new Operation(nameOperation, date, complexity, operationStatus);

    }
}
