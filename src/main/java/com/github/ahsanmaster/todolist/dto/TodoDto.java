package com.github.ahsanmaster.todolist.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@NoArgsConstructor
@Data
public class TodoDto {

    private Long id;

    @NotEmpty
    private String description;

    private String username;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate targetDate;

}
