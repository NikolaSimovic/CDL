# CDL
CDL Checkout System Kata

## Intro
This is a Java solution to the CDL Checkout System Kata problem. The app should process products, and generate a final amount to be paid, while keeping track of possible special offers, and ajusting the final amount according to them.

## Procedure
When run, the app will prompt a message in the console saying 
```
Scan product:
```
Where the user is supposed to enter a product SKU. Keep in mind that only sku values A, B, C and D will actually result in processing.
After you type the sku and hit enter, the console will promt a message with the total amount to be paid.
```
Total: 175.0
```
After every scanned product, the console will prompt a question asking the user if he wants to finish the purchase.
```
Finish purchase(y/n): 
```

## Technologies
```
Java 8, SpringBoot 2.2.5, Maven, JUnit
```
