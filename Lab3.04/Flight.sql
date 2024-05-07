create table Flight
(
    flight_id            int auto_increment
        primary key,
    flight_number        varchar(255) not null,
    aircraft             varchar(255) not null,
    total_aircraft_seats int          not null,
    flight_mileage       int          not null
);

INSERT INTO Aerolines.Flight (flight_id, flight_number, aircraft, total_aircraft_seats, flight_mileage) VALUES (1, 'DL140', 'Boeing 747', 400, 135);
INSERT INTO Aerolines.Flight (flight_id, flight_number, aircraft, total_aircraft_seats, flight_mileage) VALUES (2, 'DL140', 'Boeing 747', 400, 135);
INSERT INTO Aerolines.Flight (flight_id, flight_number, aircraft, total_aircraft_seats, flight_mileage) VALUES (3, 'DL140', 'Boeing 747', 400, 135);
