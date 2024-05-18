
CREATE TABLE Customers
(
    customer_id                 int                                NOT NULL AUTO_INCREMENT,
    customer_name               varchar(255)                       NOT NULL,
    customer_status             ENUM('GOLD', 'SILVER', 'NONE')     NOT NULL,
    total_customer_milleage     int                                NOT NULL,
    PRIMARY KEY (customer_id)
);

CREATE TABLE Flights
(
    flight_id               int             NOT NULL AUTO_INCREMENT,
    flight_number           varchar(20)     NOT NULL,
    aircraft                varchar(20)     NOT NULL,
    total_aircraft_seats    int             NOT NULL,
    flight_milleage         int             NOT NULL,
    PRIMARY KEY (flight_id)
);

CREATE TABLE Flight_Bookings
(
    booking_id      int     NOT NULL AUTO_INCREMENT,
    customer_id     int     NOT NULL,
    flight_id       int     NOT NULL,
    PRIMARY KEY (booking_id),
    FOREIGN KEY (customer_id) REFERENCES Customers (customer_id),
    FOREIGN KEY (flight_id) REFERENCES Flights (flight_id)
);

INSERT INTO Customers (customer_name, customer_status, total_customer_milleage)
VALUES  ('Agustine Riviera', 'SILVER', 115235),
        ('Alaina Sepulvida', 'NONE', 6008),
        ('Tom Jones', 'GOLD', 205767),
        ('Sam Rio', 'NONE', 2653),
        ('Jessica James', 'SILVER', 127656),
        ('Ana Janco', 'SILVER', 136773),
        ('Jennifer Cortez', 'GOLD', 300582),
        ('Christian Janco', 'SILVER', 14642);

INSERT INTO Flights (flight_number, aircraft, total_aircraft_seats, flight_milleage)
VALUES  ('DL143', 'Boeing 747', 400, 135),
        ('DL122', 'Airbus A330', 236, 4370),
        ('DL53' , 'Boeing 777', 264, 2078),
        ('DL222', 'Boeing 777', 264, 1765),
        ('DL37' , 'Boeing 747', 400, 531);

INSERT INTO Flight_Bookings (customer_id, flight_id)
VALUES  (1, 1),
        (1, 2),
        (2, 2),
        (1, 1),
        (3, 2),
        (3, 3),
        (1, 1),
        (4, 1),
        (1, 1),
        (3, 4),
        (5, 1),
        (4, 1),
        (6, 4),
        (7, 4),
        (5, 2),
        (4, 5),
        (8, 4);


-- ########   EJERCICIOS   ########
-- Aviones cuyo nombre contenga "Boeing"
SELECT aircraft AS Nombres_Aviones_Boeing
FROM Flights
WHERE Flights.aircraft LIKE 'Boeing%';

-- 4. Vuelos con distancias mayores a 500 millas
SELECT flight_number as Numero_Vuelo, aircraft as Aeronave, flight_milleage as Distancia_Vuelo
FROM Flights
WHERE flight_milleage > 500;



