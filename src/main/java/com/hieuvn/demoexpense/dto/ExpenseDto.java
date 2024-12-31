package com.hieuvn.demoexpense.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

/*
* DTO: Khi cần truyền dữ liệu giữa các lớp/tầng bên trong ứng dụng
* (ví dụ: service layer tới controller layer).
* */
public class ExpenseDto {
    private String expenseId;
    private String name;
    private String note;
    private String category;
    private Date date;
    private BigDecimal amount;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
