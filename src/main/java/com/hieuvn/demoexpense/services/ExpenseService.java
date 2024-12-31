package com.hieuvn.demoexpense.services;

import com.hieuvn.demoexpense.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {
    /*
    * it will fetch the data from the database
    * and return list of expense.
    * */
    List<ExpenseDto> getAllExpenses();
}
