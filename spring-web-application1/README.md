@RestController works with @RequestMapping
===============================
This is a sample project to show how to use @RestController with @RequestMapping.

The @RestController annotation is a convenience annotation that combines @Controller and @ResponseBody.

The @RequestMapping annotation provides “routing” information. It is used to map web requests to Spring Controller methods.

The @RequestMapping annotation can be applied to the class or to the method.

Methods in the controller class are mapped to the URL path specified in the @RequestMapping annotation.

RequestMethod.GET is the default value for the method attribute of the @RequestMapping annotation.

RequestMethod.POST is used to map HTTP POST requests.

RequestMethod.PUT is used to map HTTP PUT requests.

RequestMethod.DELETE is used to map HTTP DELETE requests.

HelloController.java

UserController.java

https://www.thymeleaf.org/

Spring Initializr: Add Starters..

Thymeleaf will automatically be added to the project.

xmlns is the namespace for the Thymeleaf template engine.

xmlns:th is the namespace for the Thymeleaf Standard Dialect.

th:text is the attribute that is used to set the text of an element.

th:each is the attribute that is used to iterate over a collection.

th:object is the attribute that is used to set the context object.

th:field is the attribute that is used to set the value of a form field.


