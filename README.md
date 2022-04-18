# Lab 3 shop server

## API endpoints

| Method     | HTTP request         | Description                                                     |
|------------|----------------------|-----------------------------------------------------------------|
| auth       | **POST** /auth       | Provides authorization for users                                |
| disconnect | **POST** /disconnect | Deletes user from list of active users in server                |
| add        | **POST** /add        | Adds product's name, price and amount to server list            |
| buy        | **POST** /buy        | Buys product with specified amount, price and name from server  |
|  list      | **GET** /list        | Gets name, amount and price of every product added to server    |

##Request format

Request format:

| Name     | Type                    | Description                                      |
|----------|-------------------------|--------------------------------------------------|
| products | List of Product objects | list of products information including username  |

Product class format:

| Name        | Type    | Description                                   |
|-------------|---------|-----------------------------------------------|
| username    | string  | Name of user, who uses the server             |
| productName | string  | Name of product user wants to buy/add         | 
| count       | integer | Amount of product units user wants to buy/add |
| price       | integer | Price of one product unit in rubles           |

##Response format

For /list request:

| Name     | Type                    | Description                                      |
|----------|-------------------------|--------------------------------------------------|
| products | List of Product objects | list of products information including username  |

For other requests:

| Name      | Type   | Description                                                   |
|-----------|--------|---------------------------------------------------------------|
| code      | enum   | Response code which means result of request of user in server |
| username  | string | Name of user who made the request                             |

Code enum values:

| Name                  | Description                                                                                         |
|-----------------------|-----------------------------------------------------------------------------------------------------|
| USER_AUTHORIZED       | Server result: user was authorized on server                                                        |
| USER_ADDED            | Server result: user was added to users list on server                                               |
| USER_NOT_ADDED        | Server result: user was not added to users list due to internal error                               |
| USER_DISCONNECTED     | Server result: user was disconnected                                                                |
| USER_NOT_FOUND        | Server result: user was not disconnected due to internal error or user was not added in first place |
| PRODUCT_ADDED         | Server result: product was added to server product list                                             |
| PRODUCT_NOT_ADDED     | Server result: product was not added to server product list due to internal error                   |
| PURCHASE_COMPLETE     | Server result: product was bought from server                                                       |
| PURCHASE_NOT_COMPLETE | Server result: product was not bought from server due to internal error                             |