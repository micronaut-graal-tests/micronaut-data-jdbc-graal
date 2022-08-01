package example.controllers;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import example.domain.Owner;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;

import java.util.List;

@MicronautTest
class OwnerControllerTest {

    @Inject
    @Client("/owners")
    RxHttpClient client;

    @Test
    void testListInitialOwners() {

        List<Owner> results = client.retrieve(HttpRequest.GET("/"), Argument.listOf(Owner.class)).blockingFirst();

        Assertions.assertEquals(
                2,
                results.size()
        );
    }
}