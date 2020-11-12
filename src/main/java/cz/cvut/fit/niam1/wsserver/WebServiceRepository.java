package cz.cvut.fit.niam1.wsserver;

import https.courses_fit_cvut_cz.ni_am1.tutorials.web_services.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.ArrayList;
import java.util.List;

@Component
public class WebServiceRepository {

    private static final List<Booking> bookings = new ArrayList<>();

    @PostConstruct
    public void initRepo() throws DatatypeConfigurationException {
        Booking b1 = new Booking();
        b1.setPersonName("James Jameson");

        Transfer t11 = new Transfer();
        t11.setAirportFromCode("DME");
        t11.setAirportToCode("JFK");
        t11.setDate(DatatypeFactory.newInstance()
                .newXMLGregorianCalendar("2020-12-23"));

        Transfer t12 = new Transfer();
        t12.setAirportFromCode("JFK");
        t12.setAirportToCode("DME");
        t12.setDate(DatatypeFactory.newInstance()
                .newXMLGregorianCalendar("2021-01-10"));

        b1.setDeparture(t11);
        b1.setArrival(t12);

        bookings.add(b1);

        Booking b2 = new Booking();
        b2.setPersonName("Tyler David");

        Transfer t21 = new Transfer();
        t21.setAirportFromCode("PRG");
        t21.setAirportToCode("JFK");
        t21.setDate(DatatypeFactory.newInstance()
                .newXMLGregorianCalendar("2020-10-13"));

        Transfer t22 = new Transfer();
        t22.setAirportFromCode("JFK");
        t22.setAirportToCode("PRG");
        t22.setDate(DatatypeFactory.newInstance()
                .newXMLGregorianCalendar("2020-10-17"));

        b2.setDeparture(t21);
        b2.setArrival(t22);

        bookings.add(b2);
    }

    public List<Booking> getBooking(){
        return bookings;
    }

    public void addBooking(Booking t){
        if (bookings.stream().filter(o -> o.getPersonName().equals(t.getPersonName())).findFirst().isPresent())
            return;
        else bookings.add(t);
    }

    public void updateBooking(Booking t) {
        for (Booking elem : bookings){
            if (elem.getPersonName()==t.getPersonName())
                elem.setArrival(t.getArrival());
                elem.setDeparture(t.getDeparture());
                return;
        }
    }

    public void deleteBooking(String name){
        bookings.removeIf(t -> t.getPersonName().equals(name));
    }
}
