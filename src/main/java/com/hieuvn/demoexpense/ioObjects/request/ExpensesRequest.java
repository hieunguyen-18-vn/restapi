package com.hieuvn.demoexpense.ioObjects.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
/*
Được sử dụng để xử lý request (đầu vào) và response (đầu ra) trong giao tiếp giữa client và server.
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpensesRequest {
    private String name;
    private String note;
    private String category;
    private Date date;
    private BigDecimal amount;
}
