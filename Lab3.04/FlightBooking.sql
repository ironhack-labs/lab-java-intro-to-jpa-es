create table FlightBooking
(
    bookingId   int auto_increment
        primary key,
    customer_id int not null,
    flight_id   int not null,
    constraint flightbooking_ibfk_1
        foreign key (customer_id) references aerolines.Customer (customer_id),
    constraint flightbooking_ibfk_2
        foreign key (flight_id) references aerolines.Flight (flight_id)
);

create index customer_id
    on FlightBooking (customer_id);

create index flight_id
    on FlightBooking (flight_id);

