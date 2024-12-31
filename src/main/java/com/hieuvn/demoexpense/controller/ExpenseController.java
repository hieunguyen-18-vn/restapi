package com.hieuvn.demoexpense.controller;

import com.hieuvn.demoexpense.dto.ExpenseDto;
import com.hieuvn.demoexpense.ioObjects.response.ExpenseResponse;
import com.hieuvn.demoexpense.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;
    private final  ModelMapper modelMapper;



    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses(){
        log.info("api GET getAll finished");
        //call the service method
        List<ExpenseDto> list = expenseService.getAllExpenses();
        log.info("print data from expense service {}", list);
        //convert
        List<ExpenseResponse> listOfResponse = list.stream()
                .map(expenseDto -> {
                    return mapToExpenseResponse(expenseDto);
                })
                .collect(Collectors.toList());
                return listOfResponse;
    }

    private ExpenseResponse mapToExpenseResponse(ExpenseDto expenseDto) {
        return modelMapper.map(expenseDto, ExpenseResponse.class);
    }


}
