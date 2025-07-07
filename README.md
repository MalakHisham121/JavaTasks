# E-Commerce Inventory and Cart Management System

## Overview

This Java-based project simulates a simple e-commerce system that manages product inventory, customer shopping carts, and shipping services. It allows customers to add products to their cart, check product availability, handle expiration dates for perishable goods, and process checkout with balance validation. The system also supports shipping calculations for products with weight attributes.

## Features

- **Product Management**: Supports products with optional expiration dates and weight attributes for shipping
- **Inventory Tracking**: Manages stock levels using a Stock class, with functionality to set and update product availability
- **Cart Operations**: Allows customers to add/remove items, check for expired products, and verify stock availability
- **Shipping Service**: Tracks shipped products and calculates total shipping weight in kilograms
- **Customer Checkout**: Processes payments, validates customer balance, and generates receipts with subtotal and shipping costs
- **Error Handling**: Includes checks for out-of-stock items, expired products, and insufficient customer balance

## Assumptions

- The system assumes a single stock inventory for all products
- The quantity attribute in the Product class represents the quantity purchased by the customer, not the stock available (which is managed by the Stock class)
- Products may have an expiration date (LocalDate), which is null if not applicable
- Multiple shipping services can exist, but the current implementation uses one
- Product weights are input in grams (g) and output in kilograms (kg) for shipping calculations

## Project Structure

### Main Class
- **Program.java**: Initializes products, sets up stock, and simulates customer interactions (adding items to cart, checking out, and displaying stock/shipping details)

### Core Classes

- **Product**: Base class for products with name, price, quantity, and optional expiration date
- **ShippingProduct**: Extends Product and implements IShippingProduct to include weight for shipping
- **Stock**: Manages inventory, tracking available quantities and removing expired products
- **Cart**: Handles adding/removing items, checking stock and expiration, and calculating total cost
- **Customer**: Manages customer balance, checkout process, and receipt generation
- **ShippingService**: Tracks shipped products and calculates total weight
- **IShippingProduct**: Interface for products that support shipping (with weight)

### Key Functionalities

- Add/remove products to/from cart with stock and expiration validation
- Display cart contents, stock availability, and shipping details
- Process checkout with or without shipping costs, ensuring sufficient customer balance

## Output

The program will output:
- Cart operations (adding items, handling errors like out-of-stock or expired products)
- Shipping details (list of shipped items and total weight in kg)
- Receipt details (subtotal, shipping cost, and total)
- Updated stock and customer balance after checkout

## Example Usage

1. Create products (e.g., Milk, Laptop, Scratch Card) with prices, weights, and optional expiration dates
2. Set initial stock quantities using `Stock.setProductAvailable()`
3. Add items to a customer's cart using `Cart.AddItemToCart()`, with or without a ShippingService
4. Call `Customer.Checkout()` to process the purchase, which validates stock, expiration, and balance
5. View stock status with `Stock.ShowStock()` and shipping details with `ShippingService.showShippingDetails()`

## Sample Output

```
Oh NO,The cart is empty!!!!!!!!!!!!
----------------------------------------------------------------------------------------
The Shipping products
3X Milk 1200.0g
1X Laptop 2500.0g
1X Headphones 100.0g
Total Shipping Weight 3.8 kg
----------------------------------------------------------------------------------------
Oh NO,The product is ran out of stock!!!!!!!!!!!!
Recipt Details:
Cart details:
1X scratch card 40.0
3X Milk 11.97
1X Laptop 999.99
1X Headphones 59.99
Subtotal: 1111.95
Shipping: 0.0
Total: 1111.95
The user balance now is 888.05
-------------------------------------------------------------------------------
0X Milk
6X Bread
1X Laptop
0X Headphones
3X scratch card
-------------------------------------------------------------------------------
Oh NO,The product is expired!!!!!!!!!!!!
-------------------------------------------------------------------------------
Oh NO,The cart is empty!!!!!!!!!!!!
------------------------------------------------------------------------------
Oh NO,The product is ran out of stock!!!!!!!!!!!!
Oh NO,The product is ran out of stock!!!!!!!!!!!!
Oh NO,The cart is empty!!!!!!!!!!!!
------------------------------------------------------------------------------
Oh NO,The cart is empty!!!!!!!!!!!!
```
