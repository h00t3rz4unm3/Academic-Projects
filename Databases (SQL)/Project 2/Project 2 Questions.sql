QUESTION 1
Identify passengers on the 12:00 flight to Chicago on November 10, 2015. Display the
passenger name. Order the output by passenger last name. Use a nested select to
answer this question.

SELECT CUSTOMER_FIRST AS "FIRST NAME", CUSTOMER_LAST AS "LAST NAME"
FROM CUSTOMERS
WHERE CUSTOMER_ID IN (
	SELECT CUSTOMER_ID
	FROM RESERVATIONS
	WHERE DEPARTURE_DATE = TO_DATE('11/10/2015 12:00','MM/DD/YYYY HH24:MI'))
ORDER BY CUSTOMER_LAST DESC

====================================================================================

QUESTION 2
Identify passengers on the 12:00 flight to Chicago on November 10, 2015. Display the
passenger name, seat assignment and ticket price. Order the output by seat
number.

SELECT CUSTOMER_FIRST AS "FIRST NAME", CUSTOMER_LAST AS "LAST NAME", SEAT_NUMBER AS "SEAT NUMBER", SEAT_PRICE + FLIGHT_PRICE AS "TOTAL PRICE"
FROM CUSTOMERS, RESERVATIONS, SEATS, FLIGHTS
WHERE 
	FLIGHTS.DEPARTURE_DATE = TO_DATE('11/10/2015 12:00','MM/DD/YYYY HH24:MI') AND 
	RESERVATIONS.DEPARTURE_DATE = FLIGHTS.DEPARTURE_DATE AND
	RESERVATIONS.SEAT_ID = SEATS.SEAT_ID AND 
	CUSTOMERS.CUSTOMER_ID = RESERVATIONS.CUSTOMER_ID
ORDER BY SEAT_NUMBER DESC

====================================================================================

QUESTION 3
Identify the flight crew that will be passing through LGA today. Display the
names of the flight crew and their title. Order the output of staff last name.
		
SELECT STAFF_FIRST AS "First Name", STAFF_LAST AS "Last Name", STAFF_TITLE as "Position"
FROM STAFF
WHERE STAFF_ID IN
(
	SELECT STAFF_ID
	FROM FLIGHT_STAFF, FLIGHTS
	WHERE FLIGHTS.ARRIVAL_AIRPORT = 'IAH' AND 
	FLIGHTS.ARRIVAL_DATE BETWEEN '11/23/2015' AND '11/24/2015' AND
	FLIGHTS.AIRPLANE_TAG = FLIGHT_STAFF.AIRPLANE_TAG AND
	FLIGHTS.DEPARTURE_DATE = FLIGHT_STAFF.DEPARTURE_DATE
)
ORDER BY STAFF_LAST

====================================================================================
		
QUESTION 4
Identify airports with the most activity this week. Display two columns. The first
column is the long airport name. The second column is the number of flights.
Display one row for each airport.

CREATE TABLE TEST_FLIGHT_TABLE AS
   SELECT DEPARTURE_AIRPORT AS "AIRPORT_CODE"
   FROM FLIGHTS

INSERT INTO TEST_FLIGHT_TABLE (AIRPORT_CODE) 
   SELECT ARRIVAL_AIRPORT
   FROM FLIGHTS

SELECT AIRPORT_CODE AS "AIRPORT", COUNT(*) AS "# OF TRIPS"
FROM TEST_FLIGHT_TABLE
GROUP BY AIRPORT_CODE
ORDER BY "# OF TRIPS" DESC

====================================================================================

Question 5
Identify revenue by flight this week. Display three columns: The flight number,
destination airport and total revenue. There is one row for each flight number and
destination airport. Display the highest revenue first and the lowest revenue last.

SELECT RESERVATIONS.AIRPLANE_TAG AS "TAIL NUMBER", RESERVATIONS.DEPARTURE_DATE AS "DEPARTURE TIME", AIRPORTS.AIRPORT_NAME AS "DESTINATION", SUM(FLIGHTS.FLIGHT_PRICE + SEATS.SEAT_PRICE) AS "TOTAL"
FROM FLIGHTS, RESERVATIONS, SEATS, AIRPORTS
WHERE RESERVATIONS.DEPARTURE_DATE BETWEEN '11/15/2015' AND '11/22/2015' AND RESERVATIONS.SEAT_ID = SEATS.SEAT_ID AND 
RESERVATIONS.DEPARTURE_DATE = FLIGHTS.DEPARTURE_DATE AND RESERVATIONS.AIRPLANE_TAG = FLIGHTS.AIRPLANE_TAG AND FLIGHTS.ARRIVAL_AIRPORT = AIRPORTS.AIRPORT_CODE
GROUP BY RESERVATIONS.AIRPLANE_TAG, RESERVATIONS.DEPARTURE_DATE, AIRPORTS.AIRPORT_NAME
ORDER BY "TOTAL"

====================================================================================

Question 6
Identify flight crews with more than 15 hours of flight time this month. Display
the staff name, title and total flight time. Display the staff with the most hours
first.

SELECT STAFF.STAFF_FIRST AS "FIRST NAME", STAFF.STAFF_LAST AS "LAST NAME", STAFF.STAFF_TITLE AS "POSITION", SUM(FLIGHTS.FLIGHT_TIME) AS "TOTAL FLIGHT TIME"
FROM STAFF, FLIGHT_STAFF, FLIGHTS
WHERE FLIGHTS.DEPARTURE_DATE BETWEEN '11/1/2015' AND '11/30/2015' AND FLIGHTS.AIRPLANE_TAG = FLIGHT_STAFF.AIRPLANE_TAG AND 
FLIGHTS.DEPARTURE_DATE = FLIGHT_STAFF.DEPARTURE_DATE AND FLIGHT_STAFF.STAFF_ID = STAFF.STAFF_ID
GROUP BY STAFF.STAFF_FIRST, STAFF.STAFF_LAST, STAFF.STAFF_TITLE
ORDER BY "TOTAL FLIGHT TIME"
HAVING SUM(FLIGHTS.FLIGHT_TIME) >= 15


====================================================================================

Question 7
Identify passengers with checked luggage, but did not board the flight. Display
the passenger name, flight number, date of departure and departure airport. Order
the output by passenger name.

SELECT CUSTOMERS.CUSTOMER_FIRST AS "FIRST NAME", CUSTOMERS.CUSTOMER_LAST AS "LAST NAME", RESERVATIONS.AIRPLANE_TAG AS "TAIL NUMBER", RESERVATIONS.DEPARTURE_DATE AS "TIME OF DEPARTURE", FLIGHTS.DEPARTURE_AIRPORT AS "DEPARTURE AIRPORT"
FROM CUSTOMERS, RESERVATIONS, FLIGHTS, CHECKIN
WHERE CUSTOMERS.CUSTOMER_ID = RESERVATIONS.CUSTOMER_ID AND RESERVATIONS.CHECKIN_ID = CHECKIN.CHECKIN_ID AND RESERVATIONS.AIRPLANE_TAG = FLIGHTS.AIRPLANE_TAG AND 
RESERVATIONS.DEPARTURE_DATE = FLIGHTS.DEPARTURE_DATE AND CHECKED_LUGGAGE = 'Y' AND BOARDED_PLANE = 'N'
ORDER BY CUSTOMERS.CUSTOMER_LAST

====================================================================================

Question 8
Identify planes with the most travel time and mileage in the last year. Display
three columns: The flight number, number of flights, total flight time, total
mileage. Display the flight with the most mileage first. Display one row for each
flight.

SELECT AIRPLANE_TAG AS "TAIL NUMBER", COUNT(DEPARTURE_DATE) AS "NUMBER OF FLIGHTS", SUM(FLIGHT_TIME) AS "TOTAL FIGHT TIME", SUM(FLIGHT_MILLAGE) AS "TOTAL MILLAGE"
FROM FLIGHTS
WHERE DEPARTURE_DATE BETWEEN '12/25/2014' AND '12/25/2015' 
GROUP BY AIRPLANE_TAG
ORDER BY SUM(FLIGHT_MILLAGE) DESC

====================================================================================

Question 9
Identify available seats on the flight departing JFK airport and traveling to Hawaii
today. Display the flight number, date of departure, departure airport, seat
number and cost. Display the cheapest seat first.

SELECT FLIGHTS.AIRPLANE_TAG AS "TAIL NUMBER", FLIGHTS.DEPARTURE_DATE AS "TIME OF DEPARTURE", FLIGHTS.ARRIVAL_AIRPORT AS "ARRIVAL AIRPORT", SEATS.SEAT_NUMBER AS "SEAT NUMBER", SEATS.SEAT_PRICE AS "SEAT PRICE"
FROM FLIGHTS, RESERVATIONS, SEATS
WHERE RESERVATIONS.DEPARTURE_DATE BETWEEN '11/16/2015' AND '11/17/2015' AND FLIGHTS.DEPARTURE_AIRPORT = 'IAH' AND FLIGHTS.ARRIVAL_AIRPORT = 'ORD' AND 
FLIGHTS.AIRPLANE_TAG = RESERVATIONS.AIRPLANE_TAG AND FLIGHTS.DEPARTURE_DATE = RESERVATIONS.DEPARTURE_DATE AND SEATS.SEAT_ID IN (
	SELECT SEAT_ID
	FROM SEATS
	WHERE SEAT_ID NOT IN ( 
		SELECT SEAT_ID
		FROM RESERVATIONS
		WHERE (AIRPLANE_TAG, DEPARTURE_DATE) IN (
			SELECT AIRPLANE_TAG, DEPARTURE_DATE
			FROM FLIGHTS
			WHERE DEPARTURE_AIRPORT = 'IAH' AND DEPARTURE_DATE BETWEEN '11/16/2015' AND '11/17/2015' AND ARRIVAL_AIRPORT = 'ORD')))
GROUP BY FLIGHTS.AIRPLANE_TAG, FLIGHTS.DEPARTURE_DATE, FLIGHTS.ARRIVAL_AIRPORT, SEATS.SEAT_NUMBER, SEATS.SEAT_PRICE, SEATS.SEAT_ID
ORDER BY SEATS.SEAT_PRICE, SEATS.SEAT_ID	
		
====================================================================================

Question 10
Identify customers who have not traveled in the last year. Display the customer
name. Order the output by customer name. Use a nested select to answer this
question.

SELECT CUSTOMER_FIRST AS "FIRST NAME", CUSTOMER_LAST AS "LAST NAME"
FROM CUSTOMERS
WHERE CUSTOMER_ID NOT IN
	(SELECT CUSTOMER_ID
	FROM CUSTOMERS
	WHERE CUSTOMER_ID IN
		(SELECT CUSTOMER_ID
		FROM RESERVATIONS
		WHERE DEPARTURE_DATE BETWEEN '11/16/2014' AND '11/16/2015'))
ORDER BY CUSTOMER_LAST
		
====================================================================================

Question 11
Use the SQL DESCRIBE operation to list the table structure for all tables.