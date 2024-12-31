package com.hieuvn.demoexpense.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
@Entity
/*
* Xác định rằng class này là một JPA Entity
* nghĩa là nó sẽ được ánh xạ với một bảng trong cơ sở dữ liệu.
* */
@Table(name = "tbl_expenses")//Ở đây, class ExpenseEntity được ánh xạ tới bảng có tên tbl_expenses.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseEntity {
    @Id //Đánh dấu trường id là khóa chính (primary key) của bảng.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
/*
* Chỉ định rằng giá trị của khóa chính sẽ được tự động sinh ra bởi cơ sở dữ liệu.
GenerationType.IDENTITY thường dùng cho các cột có thuộc tính AUTO_INCREMENT.
* */

    private Long id;
    @Column(unique=true)
    private String expenseId;
    private String name;
    private String note;
    private String category;
    private Date date;
    private BigDecimal amount;

    @CreationTimestamp //Tự động thêm ngày và giờ hiện tại
    @Column(nullable = false,updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp //Tự động update ngày và giờ hiện tại
    private Timestamp updatedAt;
}
