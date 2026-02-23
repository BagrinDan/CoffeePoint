CoffeeProject

University Project – TMPPP

Goal

    Design and implement a coffee shop management system using OOP, SOLID principles, and creational design patterns.

Project Scope

    This project demonstrates practical usage of design patterns in a real-world inspired scenario (coffee shop domain).

1. OOP & SOLID Principles:

       Single Responsibility Principle
    
       Open/Closed Principle
    
       Liskov Substitution Principle
    
       Interface Segregation Principle
    
       Dependency Inversion Principle

Clear separation of concerns between:

    Order management

    Product creation

    Payment handling

    Pricing logic

🏗 2. Factory Method (Implemented)

    Used for creating different types of coffee:
    
    Example:
    
    EspressoFactory
    
    LatteFactory
    
    CappuccinoFactory

Each factory creates a specific Coffee object without exposing instantiation logic.

Why?
To decouple object creation from business logic.