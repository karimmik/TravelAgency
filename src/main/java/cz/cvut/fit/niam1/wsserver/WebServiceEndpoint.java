package cz.cvut.fit.niam1.wsserver;

import https.courses_fit_cvut_cz.ni_am1.tutorials.web_services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WebServiceEndpoint {

    @Autowired
    private WebServiceRepository repository;

    @PayloadRoot(namespace = "https://courses.fit.cvut.cz/NI-AM1/tutorials/web-services/", localPart = "getBookingRequest")
    @ResponsePayload
    public GetBookingResponse getBooking(@RequestPayload GetBookingRequest request) {
        GetBookingResponse response = new GetBookingResponse();
        response.getBooking().addAll(repository.getBooking());
        return response;
    }

    @PayloadRoot(namespace = "https://courses.fit.cvut.cz/NI-AM1/tutorials/web-services/", localPart = "addBookingRequest")
    @ResponsePayload
    public AddBookingResponse addBooking(@RequestPayload AddBookingRequest request) {
        AddBookingResponse response = new AddBookingResponse();
        repository.addBooking(request.getBooking());
        return response;
    }

    @PayloadRoot(namespace = "https://courses.fit.cvut.cz/NI-AM1/tutorials/web-services/", localPart = "updateBookingRequest")
    @ResponsePayload
    public UpdateBookingResponse updateBooking(@RequestPayload UpdateBookingRequest request) {
        UpdateBookingResponse response = new UpdateBookingResponse();
        repository.updateBooking(request.getBooking());
        return response;
    }

    @PayloadRoot(namespace = "https://courses.fit.cvut.cz/NI-AM1/tutorials/web-services/", localPart = "deleteBookingRequest")
    @ResponsePayload
    public DeleteBookingResponse getTours(@RequestPayload DeleteBookingRequest request) {
        DeleteBookingResponse response = new DeleteBookingResponse();
        repository.deleteBooking(request.getPersonName());
        return response;
    }
}
