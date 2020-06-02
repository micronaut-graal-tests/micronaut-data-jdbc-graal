package example.controllers;

import example.domain.Owner;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@MicronautTest
class OwnerControllerTest {
    @Inject
    @Client("/owners")
    RxHttpClient client;

    @Test
    void testListInitialOwners() {
        List<Owner> results = client.retrieve(HttpRequest.GET("/"), Argument.listOf(Owner.class)).blockingFirst();

        Assertions.assertEquals(2, results.size());
    }
}
