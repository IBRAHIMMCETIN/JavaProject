package com.turkcell.spring_cqrs.application.features.category.command.create;

import com.turkcell.spring_cqrs.core.mediator.cqrs.Command;

import com.turkcell.spring_cqrs.application.features.category.command.create.CreatedCategoryResponse;

public record CreateCategoryCommand(String name) implements Command<CreatedCategoryResponse> {

}
