package com.hieuvn.demoexpense.services;

import com.hieuvn.demoexpense.dto.ExpenseDto;
import com.hieuvn.demoexpense.entity.ExpenseEntity;
import com.hieuvn.demoexpense.repos.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpensesServiceImpl implements ExpenseService {
    /*
     * this is heart of the most application
     * most of the business logic goes into here (service class)
     * */
    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

//    @Override
//    public List<ExpenseDto> getAllExpenses() {
//        // call the repos to get all
//        List<ExpenseEntity> list = expenseRepository.findAll();
//        // convert this entity to DTO object
//        List<ExpenseDto> listOfExpenses = list.stream()
//                .map(expenseEntity -> mapToExpenseDTO(expenseEntity))
//                .collect(Collectors.toList());
//            return listOfExpenses;
//    }
@Override
public List<ExpenseDto> getAllExpenses() {
    // call the repos to get all
    List<ExpenseEntity> list = expenseRepository.findAll();

    if (list.isEmpty()) {
        log.warn("No expenses found in the database.");
        return List.of(); // Trả về danh sách rỗng
    }

    // convert this entity to DTO object
    return list.stream()
            .map(this::mapToExpenseDTO)
            .collect(Collectors.toList());
}

    private ExpenseDto mapToExpenseDTO(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpenseDto.class);
    }
}