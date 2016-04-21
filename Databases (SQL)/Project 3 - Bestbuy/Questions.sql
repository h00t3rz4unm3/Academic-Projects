1. Identify customers who have not purchased a new television recently. Display the customer name and email address. You identify the criteria for a recent purchase. Use a nested select to answer the question.  

SELECT CUSTOMER_FIRST AS "First Name", CUSTOMER_LAST AS "Last Name", CUSTOMER_EMAIL AS "Email"
FROM CUSTOMERS
WHERE CUSTOMER_ID NOT IN (
	SELECT CUSTOMER_ID
	FROM TRANSACTIONS
	WHERE PRODUCT_ID IN (
		SELECT PRODUCT_ID
		FROM PRODUCTS
		WHERE PRODUCT_DESCRIPTION='TELEVISION' AND PRODUCT_ID IN (
			SELECT PRODUCT_ID
			FROM TRANSACTIONS
			WHERE TRANSACTION_DATE > '06/01/2015')))
		
		
2. Identify the highest rated computer game. The product needs at least 10 reviews from customers who live in NY. Display the product name, price and average rating.  Replace  “computer game”  and  “NY”  with  a  product  and  state  of  your  own   choosing.  


	SELECT P.PRODUCT_NAME AS "Product Name", P.PRODUCT_PRICE AS "Price", AVG(R.RATING) AS "Average Rating"
	FROM RATINGS R, TRANSACTIONS T, PRODUCTS P, LOCATIONS L
	WHERE R.TRANSACTION_ID = T.TRANSACTION_ID AND T.PRODUCT_ID = P.PRODUCT_ID 
	AND P.PRODUCT_DESCRIPTION = 'Video Game' AND L.LOCATION_STATE = 'NY' 
	AND L.LOCATION_ID = T.LOCATION_ID
	HAVING COUNT(R.RATING) > 10
	GROUP BY PRODUCT_NAME, PRODUCT_PRICE


			
3. Identify stores with the most sales in 2015. Display one row for each store. Display the store address, city, total revenue, smallest sale and largest sale. Use functions to answer this question. Rename the columns so they are descriptive. The store with the highest revenue will display first.

	SELECT LOCATION_ADDRESS AS "Store Address", LOCATION_CITY AS "Store City", 
	SUM(T.TRANSACTION_TOTAL) AS "Total Revenue", MIN(T.TRANSACTION_TOTAL) as "Smallest Sale", 
	MAX(T.TRANSACTION_TOTAL) AS "Largest Sale"
	FROM TRANSACTIONS T, LOCATIONS L
	WHERE T.LOCATION_ID = L.LOCATION_ID AND T.TRANSACTION_DATE > '1/01/2015'
	GROUP BY LOCATION_ADDRESS, LOCATION_CITY
	ORDER BY "Total Revenue" DESC

4. Decrease the price of all iPads in the NY stores by 20%. Identify the SQL commands  to  perform  this  operation.  Replace  “decrease  the  price”  with  your  own   increase or decrease operation.  

	UPDATE PRODUCTS
	SET PRODUCT_PRICE = PRODUCT_PRICE * 1.20
	WHERE PRODUCT_NAME LIKE '%iPad%' AND LOCATION_ID IN (
		SELECT LOCATION_ID
		FROM LOCATIONS
		WHERE LOCATION_STATE = 'NY')

5. HP Laptops need to be recalled due to a defective batteries. Identify laptops with a serial number starting with 998ER4 sold in the last 12 month in the US. Display the customer name and email address. Use a nested select to answer this question.  

SELECT CUSTOMER_FIRST AS "FIRST NAME", CUSTOMER_LAST AS "LAST NAME", CUSTOMER_EMAIL AS "EMAIL"
FROM CUSTOMERS
WHERE CUSTOMER_ID IN(
	SELECT CUSTOMER_ID
	FROM TRANSACTIONS
	WHERE PRODUCT_ID IN (
		SELECT PRODUCT_ID
		FROM PRODUCTS
		WHERE PRODUCTDETAILS_SERIAL LIKE '%998ER4%'))	

6. Identify neighborhoods with the most laptops sold in 2015. Display one row for each neighborhood. Use a function and nested select to answer this question. Display the neighborhood and number of phones sold. Rename the columns so they are descriptive. Display the neighborhood with the most laptops first.  


	SELECT LOCATION_CITY AS "Neighborhood", COUNT(TRANSACTION_ID) AS "Number of Laptops Sold in 2015"
	FROM LOCATIONS L, TRANSACTIONS T, PRODUCTS P
	WHERE L.LOCATION_ID = T.LOCATION_ID 
	AND P.PRODUCT_ID = T.PRODUCT_ID 
	AND T.TRANSACTION_DATE > '1/1/2015' 
	AND P.PRODUCT_ID IN
	(
		SELECT PRODUCT_ID
		FROM PRODUCTS
		WHERE PRODUCT_DESCRIPTION = 'Laptop'
	)
	GROUP BY LOCATION_CITY
	ORDER BY "Number of Laptops Sold in 2015" DESC

7. Purchase one television. Identify the SQL operations to perform this request.

INSERT INTO TRANSACTIONS(TRANSACTION_ID,TRANSACTION_DATE,PRODUCT_ID,STAFF_ID,LOCATION_ID,CUSTOMER_ID,TRANSACTION_TOTAL)
VALUES(36,TO_DATE('12/20/2015 14:17','MM/DD/YYYY HH24:MI'),22,11,1172,20,2174.99)
  

8. In one SQL window, change the iMac price for record 1. Don’t  commit.  In   another  SQL  window,  change  the  iMac  price  for  record  1.  Don’t  commit.  Explain   your results. Resolve the problem.  Disable the autocommit flag at the top of the windows before performing this operation. 

	SELECT *
	FROM PRODUCTS
	
	UPDATE PRODUCTS
	SET PRODUCT_PRICE = PRODUCT_PRICE * 1.20
	WHERE PRODUCT_ID = 1
	
	UPDATE PRODUCTS
	SET PRODUCT_PRICE = PRODUCT_PRICE * 0.8
	WHERE PRODUCT_ID = 1
 
 1299 * 1.20 = 1558.8
 1299 * 0.80 = 1039.2
 1558.8 * 0.80 = 1247.04
 
In my console window I ran the update price command to increase price by 20%. This went through, but I did not commit. I ran the select * command in the SQL window, and it showed the original price. In the window SQL, I then ran the update price command to decrease price by 20%, but the command never went through because ADMIN2 is updating the price and never commited.

In order to fix this, youd need to commit from the SQL command prompt or rollback before doing an update command from another user.

9. In one SQL window, delete all products.  Don’t  commit.  In  another  SQL  window,   increase  the  price  of  all  laptops  by  5%.  Don’t  commit.  Explain  your  results.   Resolve the problem. Create a backup of your table before implementing. To create a backup table, enter CREATE TABLE <NEWTABLE> AS SELECT * FROM <ORIGINALTABLE>; COMMIT; Then you can rename a table using the RENAME TABLE commit.  Disable the autocommit flag at the top of the windows before performing this operation. 

10. In  one  SQL  window,  decrease  the  price  of  all  products  by  20%.  Don’t  commit.  In another  SQL  window,  double  the  memory  in  all  computers.  Don’t  commit.  Quit   both Oracle sessions. Login to Oracle and display all information. Explain your results.  Disable the autocommit flag at the top of the windows before performing this operation. 

UPDATE PRODUCT_DETAILS
SET PRODUCTDETAILS_RAM = PRODUCTDETAILS_RAM * 2;

UPDATE PRODUCTS
SET PRODUCT_PRICE * PRODUCT_PRICE * 0.80;

Ran the update price command from ADMIN2, completed. Tried running update ram command from ADMIN1 OR SYSTEM, and it halted. 
11. Use the SQL DESCRIBE operation to list the table structure for all tables.  