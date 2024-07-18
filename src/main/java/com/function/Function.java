package com.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.Optional;


public class Function {
    
    @FunctionName("hello")
    public HttpResponseMessage hello(
            @HttpTrigger(name = "req", 
            methods = {HttpMethod.GET, HttpMethod.POST}, 
            authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        String name = request.getBody().orElse("World");
        return request.createResponseBuilder(HttpStatus.OK).body("Hello, " + name).build();
    }
}
