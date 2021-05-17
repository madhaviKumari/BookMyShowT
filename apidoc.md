# BookMyShow 
## Document Data Model

Look at the following diagram to understand the document data model. It is using No-SQL database (MongoDB) but to show the relationship between different models following diagram is made. Various relationships among different entities are defined some of them are embedded relationship and some are data references. Selection of embedded and data reference is made with the consideration of performance, data duplicacy, to reduce number of aggregation and matching.   

![Alt text](/src/main/java/model.png?raw=true "Optional Title")

Following APIs are documented for Client/Customer side. Each API expect Login/Singup is protected with JWT bearer token so authorization header is required in all APIs as follow. <br/>

Header : 

```
Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYWRoYXZpQG91dGxvb2tpay5jb20iLCJpYXQiOjE2MjEwNjI2MDcsImV4cCI6MTYyMTE0OTAwN30.enDk0k0mWTsUcFgyJ6IJgcNpyxiQAGlsAF-0qLA3WXHK0MX2H9UqZFOKUkr8rqMmawj0zH2cu1_OnNljed381g
```

Admin APIs are not documented to see admin APIs look at [MasterDataController.java](/src/main/java/co/move/in/test/BookMyShow/controller/MasterDataController.java)<br/>
## API Documentation

### Client Sign-up
Resource Path : /api/auth/client/signup 
Method : POST <br/>
Request Data : <br/>

```
{
	"phone":"valid-phone",
	"email":"valid-email-address",
	"fullName":"valid-full-name",
	"password":"valid-string-password"
}
```
Response Data : 

```
{
   "status":"200/403/500",
   "message":"success/error message"

}
```
### Client/Admin Login
Resource Path : /api/auth/client/signin
Method : POST <br/>
Request Data : <br/>

```
{
	"username":"admin-username",
	"password":"password"
}

```
Response Data : 

```
{
    "id": "5ec813eef84f8a316ccd467c",
    "username": "admin-username",
    "email": "admin-email",
    "roles": [
        "ROLE_ADMIN"
    ],
    "tokenType": "Bearer",
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTU5MDE3MDY2MCwiZXhwIjoxNTkwMjU3MDYwfQ._OgwCmMjKDURaAfz7LLjFL1Iv2XGmHBa3y3z19hQjuNcY1LIYUBIJEZlfNWFYx-Ma3ogqBoQWaR3-oeG4Eko5Q"
}
```
## API Get All Theaters 
Resource Path : /api/theater/get
Method : GET <br/>

```
page:2
size:3
```
Response Data:

```
{
    "message": "success",
    "data": [
        {
            "id": "5004",
            "name": "Lakshmi Theatre",
            "address": {
                "street": "No.104/1, Balaji Layout, Tavarekere Road,",
                "city": "Banglore",
                "state": "karnataka",
                "country": "India",
                "pin": 560081
            }
        },
        {
            "id": "5005",
            "name": "Delite Cinema",
            "address": {
                "street": "Gate No.4 Pant Hospitals 1, G B, Asaf Ali Rd, Delhi Gate",
                "city": "New Delhi",
                "state": "Delhi",
                "country": "India",
                "pin": 110002
            }
        },
        {
            "id": "5006",
            "name": "The Movie Hall",
            "address": {
                "street": "AF Station shopping complex, 110003, Lok Kalyan Marg",
                "city": "New Delhi",
                "state": "Delhi",
                "country": "India",
                "pin": 110011
            }
        }
    ]
}
```

## API Get Theaters by city
Resource Path : /api/theater/get/city
Method : GET <br/>

```
city=city_name
```
Response Data:

```
{
    "message": "success",
    "data": [
        {
            "id": "5005",
            "name": "Delite Cinema",
            "address": {
                "street": "Gate No.4 Pant Hospitals 1, G B, Asaf Ali Rd, Delhi Gate",
                "city": "New Delhi",
                "state": "Delhi",
                "country": "India",
                "pin": 110002
            }
        },
        {
            "id": "5006",
            "name": "The Movie Hall",
            "address": {
                "street": "AF Station shopping complex, 110003, Lok Kalyan Marg",
                "city": "New Delhi",
                "state": "Delhi",
                "country": "India",
                "pin": 110011
            }
        },
        {
            "id": "5007",
            "name": "PVR Vikaspuri",
            "address": {
                "street": "Community Centre, G 1, Vikaspuri",
                "city": "New Delhi",
                "state": "Delhi",
                "country": "India",
                "pin": 110018
            }
        },
        {
            "id": "5008",
            "name": "PPVR Prashant Vihar",
            "address": {
                "street": "C2nd Floor,Funcity Mall,Pvr Prashant Vihar Road,Prashant Vihar,Sector 14",
                "city": "New Delhi",
                "state": "Delhi",
                "country": "India",
                "pin": 110085
            }
        },
        {
            "id": "5009",
            "name": "Liberty Cinema",
            "address": {
                "street": "19-B, New Rohtak Rd, Block 21 B, Dev Nagar, Karol Bagh",
                "city": "New Delhi",
                "state": "Delhi",
                "country": "India",
                "pin": 110005
            }
        }
    ]
}
```


## API Get Theaters by Name
Resource Path : /api/theater/get/name
Method : GET <br/>

```
name=PVR
```
Response Data:

```
{
    "message": "success",
    "data": [
        {
            "id": "609f7c36df34622c98dd446f",
            "name": "PVR Orion",
            "address": {
                "street": "statee gdjdg",
                "city": "bangalore",
                "state": "karnataka",
                "country": "India",
                "pin": 560054
            }
        },
        {
            "id": "500",
            "name": "PVR Cinemas Orion Mall",
            "address": {
                "street": "Orion Mall, 3rd Floor, Brigade Gateway, Malleswaram",
                "city": "Banglore",
                "state": "karnataka",
                "country": "India",
                "pin": 560003
            }
        },
        {
            "id": "5000",
            "name": "PVR Cinemas Orion Mall 2",
            "address": {
                "street": "Orion Mall, 3rd Floor, Brigade Gateway, Malleswaram",
                "city": "Banglore",
                "state": "karnataka",
                "country": "India",
                "pin": 560003
            }
        },
        {
            "id": "5007",
            "name": "PVR Vikaspuri",
            "address": {
                "street": "Community Centre, G 1, Vikaspuri",
                "city": "New Delhi",
                "state": "Delhi",
                "country": "India",
                "pin": 110018
            }
        },
        {
            "id": "5008",
            "name": "PPVR Prashant Vihar",
            "address": {
                "street": "C2nd Floor,Funcity Mall,Pvr Prashant Vihar Road,Prashant Vihar,Sector 14",
                "city": "New Delhi",
                "state": "Delhi",
                "country": "India",
                "pin": 110085
            }
        }
    ]
}
```
## Search Movie shows by Language & Time range.

Resource Path : /api/shows/get <br/>
Method : GET <br/>
Params:

```
language:HINDI
start:19-May-2021 15:00:00
end:22-May-2021 22:00:00
```
Note : Date must in format dd-MMM-yyyy HH:mm:ss or MMM dd yyyy HH:mm:ss <br/>
Response Data:

```
{
    "message": "success",
    "data": [
        {
            "id": "60a208d451e25969df5130b1",
            "audi": {
                "id": "609fac56b8258f1931b0e7cc",
                "name": "Audi 2",
                "totalSeats": 45
            },
            "theater": {
                "id": "500",
                "name": "PVR Cinemas Orion Mall",
                "address": {
                    "street": "Orion Mall, 3rd Floor, Brigade Gateway, Malleswaram",
                    "city": "Banglore",
                    "state": "karnataka",
                    "country": "India",
                    "pin": 560003
                }
            },
            "movie": {
                "movieName": "Radhe",
                "movieId": "60a2085051e25969df5130b0",
                "durationInMin": 140,
                "language": "HINDI",
                "genre": {
                    "id": "609fe0af4ce65e350ce93a1a",
                    "category": "Romentic"
                },
                "releaseDate": "14/05/2021",
                "searchCount": 0,
                "bookedCount": 0,
                "thumbnail": "https://mediafilesgls.s3.ap-south-1.amazonaws.com/myfile.png"
            },
            "start": "2021-05-20T03:30:00.000+00:00",
            "end": "0201-12-31T06:30:00.000+00:00",
            "language": "HINDI"
        }
    ]
}

```

## Search Movie by Name.

Resource Path : /api/shows/movie/name <br/>
Method : GET <br/>
Params:

```
name:Radhe
```

Response Data:

```
{
    "message": "success",
    "data": [
        {
            "movieName": "Radhe",
            "movieId": "60a2085051e25969df5130b0",
            "durationInMin": 140,
            "language": "HINDI",
            "genre": {
                "id": "609fe0af4ce65e350ce93a1a",
                "category": "Romentic"
            },
            "releaseDate": "14/05/2021",
            "searchCount": 1,
            "bookedCount": 0,
            "thumbnail": "https://mediafilesgls.s3.ap-south-1.amazonaws.com/myfile.png"
        }
    ]
}
```
## Search Shows by Movie.
Resource Path : /api/shows/show/movie <br/>
Method : GET <br/>
Params:

```
movie:60a2085051e25969df5130b0
```

Response Data:

```
{
    "message": "success",
    "data": [
        {
            "id": "60a208d451e25969df5130b1",
            "audi": {
                "id": "609fac56b8258f1931b0e7cc",
                "name": "Audi 2",
                "totalSeats": 45
            },
            "theater": {
                "id": "500",
                "name": "PVR Cinemas Orion Mall",
                "address": {
                    "street": "Orion Mall, 3rd Floor, Brigade Gateway, Malleswaram",
                    "city": "Banglore",
                    "state": "karnataka",
                    "country": "India",
                    "pin": 560003
                }
            },
            "movie": {
                "movieName": "Radhe",
                "movieId": "60a2085051e25969df5130b0",
                "durationInMin": 140,
                "language": "HINDI",
                "genre": {
                    "id": "609fe0af4ce65e350ce93a1a",
                    "category": "Romentic"
                },
                "releaseDate": "14/05/2021",
                "searchCount": 1,
                "bookedCount": 0,
                "thumbnail": "https://mediafilesgls.s3.ap-south-1.amazonaws.com/myfile.png"
            },
            "start": "2021-05-20T03:30:00.000+00:00",
            "end": "0201-12-31T06:30:00.000+00:00",
            "language": "HINDI"
        }
    ]
}
```
## Get top searched movies.

Resource Path : /api/shows/movie/search/rating <br/>
Method : GET <br/>
Params:

```
page:0
size:5
```
Response Data:

```
{
    "message": "success",
    "data": [
        {
            "movieName": "Radhe",
            "movieId": "609fe0214ce65e350ce93a18",
            "durationInMin": 140,
            "language": HINDI,
            "genre": {
                "id": "609fd7af1facf547a998b1a8",
                "category": "Comedy"
            },
            "releaseDate": "14/05/2021",
            "searchCount": 5,
            "bookedCount": 0,
            "thumbnail": "https://mediafilesgls.s3.ap-south-1.amazonaws.com/myfile.png"
        },
        {
            "movieName": "Fast & F",
            "movieId": "609fe1104ce65e350ce93a1d",
            "durationInMin": 140,
            "language": null,
            "genre": {
                "id": "609fe0af4ce65e350ce93a1a",
                "category": "Romentic"
            },
            "releaseDate": "14/05/2021",
            "searchCount": 2,
            "bookedCount": 0,
            "thumbnail": "https://mediafilesgls.s3.ap-south-1.amazonaws.com/myfile.png"
        },
        {
            "movieName": "Fast & For",
            "movieId": "60a007110194660fc8f105d6",
            "durationInMin": 140,
            "language": "ENGLISH",
            "genre": {
                "id": "609fe0af4ce65e350ce93a1a",
                "category": "Romentic"
            },
            "releaseDate": "14/05/2021",
            "searchCount": 2,
            "bookedCount": 0,
            "thumbnail": "https://mediafilesgls.s3.ap-south-1.amazonaws.com/myfile.png"
        },
        {
            "movieName": "Radhe",
            "movieId": "60a2085051e25969df5130b0",
            "durationInMin": 140,
            "language": "HINDI",
            "genre": {
                "id": "609fe0af4ce65e350ce93a1a",
                "category": "Romentic"
            },
            "releaseDate": "14/05/2021",
            "searchCount": 1,
            "bookedCount": 0,
            "thumbnail": "https://mediafilesgls.s3.ap-south-1.amazonaws.com/myfile.png"
        },
        {
            "movieName": "Sample Movie",
            "movieId": "609fe0e84ce65e350ce93a1b",
            "durationInMin": 140,
            "language": null,
            "genre": {
                "id": "609fe0af4ce65e350ce93a1a",
                "category": "Romentic"
            },
            "releaseDate": "14/05/2021",
            "searchCount": 0,
            "bookedCount": 0,
            "thumbnail": "https://mediafilesgls.s3.ap-south-1.amazonaws.com/myfile.png"
        }
    ]
}
```
## Get available seats for the selected Show
API Path : /api/shows/get/seats
Method : GET <br/>
Param:

```
show:60a208d451e25969df5130b1
```
Response Data:

```
{
    "message": "success",
    "data": [
        {
            "id": "60a20afb51e25969df5130b3",
            "type": "ECONOMY",
            "status": "AVAILABLE",
            "price": 250.0,
            "seatNumber": 1
        },
        {
            "id": "60a20afb51e25969df5130b4",
            "type": "ECONOMY",
            "status": "AVAILABLE",
            "price": 250.0,
            "seatNumber": 2
        },
        {
            "id": "60a20afb51e25969df5130b5",
            "type": "ECONOMY",
            "status": "AVAILABLE",
            "price": 250.0,
            "seatNumber": 3
        },
        {
            "id": "60a20afb51e25969df5130b6",
            "type": "ECONOMY",
            "status": "AVAILABLE",
            "price": 250.0,
            "seatNumber": 4
        },
        {
            "id": "60a20afb51e25969df5130b7",
            "type": "ECONOMY",
            "status": "AVAILABLE",
            "price": 250.0,
            "seatNumber": 5
        },
        ...
       ]
     }
```
## Book seats
Resource Path : /api/booking/made <br/>
Method : POST<br/>
Request Body:

```
{
    "customerBokking":[
        {
            "name":"ABS User",
            "age":25,
            "seatId":"60a20afb51e25969df5130b3"
        },
        {
            "name":"XYZ user",
            "age":28,
            "seatId":"60a20afb51e25969df5130b4"
        }
    ],
    "totalPaidAmount":1000,
    "gstnNumber":"66778493GST",
    "paymentMethod":"UPI"
}
```
Response Data : 

```
{
    "status": 200,
    "bookingId": "60a216c851e25969df5130e2",
    "invoice": {
        "id": 223455,
        "totalPaidAmount": 1000.0,
        "gstnNumber": "66778493GST",
        "paymentMethod": "UPI",
        "generatedDate": "2021-05-17T07:10:00.715+00:00",
        "booking": {
        
            "id": "60a216c851e25969df5130e2",
            "customerBokking": [
                {
                    "name": "ABS User",
                    "age": 25,
                    "seatId": "60a20afb51e25969df5130b3"
                },
                {
                    "name": "XYZ user",
                    "age": 28,
                    "seatId": "60a20afb51e25969df5130b4"
                }
            ],
            "bookingDate": "17-May-2021 12:43:00GMT"
        }
    }
}
```
Note :  Booking API will lock the selected seats for 5min in case booking is fail then Seats will become available after 5min. <br/>

# Error Codes & Logging
Every API throws some error codes and every code is associates to dynamic message in DB. Currently it is implemented with direct DB but as an optimization step it must be done with some caching. Following APIs are supported at ADMIN side not at Customer/Client side.
## API to Add Error Code & Message 
API Path : /api/codes/add<br/>
Method : POST<br/>
Header : 

```
Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYWRoYXZpQG91dGxvb2tpay5jb20iLCJpYXQiOjE2MjEwNjI2MDcsImV4cCI6MTYyMTE0OTAwN30.enDk0k0mWTsUcFgyJ6IJgcNpyxiQAGlsAF-0qLA3WXHK0MX2H9UqZFOKUkr8rqMmawj0zH2cu1_OnNljed381g
```
Note: Token must be of ADMIn not of client<br/>
Request Data:

```
{
    "code":503,
    "msg":"You are attempting to book an unavailable seats"
}
```
Response :

```
{
    "status": 200,
    "message": "Error code and message added successfully"
}

```

## Few Error codes 
SeatNotAvailableException : 503<br/>
ShowOverlappedException : 407 <br/>
MovieNotFoundWithID : 203 <br/>
InvalidSeatSelectionException : 502 <br/>
etc.<br/>

Every Log is write to console and to Log file also using log4j Framework. <br/>


