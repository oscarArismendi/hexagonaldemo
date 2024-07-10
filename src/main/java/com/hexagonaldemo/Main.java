package com.hexagonaldemo;

import application.CreateUserUseCase;
import application.FindUserUseCase;
import domain.service.UserService;
import infrastructure.in.UserController;
import infrastructure.out.UserRepository;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserRepository();
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        FindUserUseCase findUserUseCase = new FindUserUseCase(userService);
        UserController consoleAdapter = new UserController(createUserUseCase,findUserUseCase);

        consoleAdapter.start();
    }
}