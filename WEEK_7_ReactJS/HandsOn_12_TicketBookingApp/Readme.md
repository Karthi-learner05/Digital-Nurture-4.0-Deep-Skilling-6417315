# Ticket Booking App

In this handsOn I have created simple ticket booking page where the guest user only browse through the page and the logged in user can browse the page as well as book their ticket.

---

## GuesPage

```GuestPage.js```

``` js

import React from "react";
import FlightList from "./FlightList";

function GuestPage() {
    return (
        <div>
        <h2>Please Signup</h2>
        <p>You can only browse flight details.</p>
        <FlightList canBook={false} />
        </div>
    );
}

export default GuestPage;

```

---

## UserPage

```UserPage.js```

``` js

import React from "react";
import FlightList from "./FlightList";

function UserPage() {
    return (
        <div>
        <h2>Welcome Back</h2>
        <p>You can now book your flight tickets.</p>
        <FlightList canBook={true} />
        </div>
    );
}

export default UserPage;

```

---

## FlightList

```FlightList.js```

``` js

import React from "react";
import "./FlightList.css"; // Import styles

import flight1 from "./flights/flight1.jpg";
import flight2 from "./flights/flight2.jpg";
import flight3 from "./flights/flight3.jpg";

const flights = [
    { id: 1, from: "Chennai", to: "Delhi", time: "10:00 AM", image: flight1 },
    { id: 2, from: "Mumbai", to: "Bangalore", time: "1:30 PM", image: flight2 },
    { id: 3, from: "Hyderabad", to: "Kolkata", time: "6:45 PM", image: flight3 },
    ];

    function FlightList({ canBook }) {
    return (
        <div className="flight-container">
        <h3>Available Flights</h3>
        <div className="flight-grid">
            {flights.map((flight) => (
            <div key={flight.id} className="flight-card">
                <img src={flight.image} alt="Flight" className="flight-image" />
                <div className="flight-details">
                <p><strong>{flight.from}</strong> to <strong>{flight.to}</strong></p>
                <p>Departure: {flight.time}</p>
                {canBook ? (
                    <button className="book-btn">Book</button>
                ) : (
                    <p className="disabled-msg">(Login to book)</p>
                )}
                </div>
            </div>
            ))}
        </div>
        </div>
    );
}

export default FlightList;

```

---

## App

```App.js```

``` js

import React, { useState } from "react";
import GuestPage from "./GuestPage";
import UserPage from "./UserPage";
import "./App.css"; // Add this line to include styles

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  let content = isLoggedIn ? <UserPage /> : <GuestPage />;

  return (
    <div className="app-container">
      <h1>Ticket Booking App</h1>
      {isLoggedIn ? (
        <button onClick={handleLogout}>Logout</button>
      ) : (
        <button onClick={handleLogin}>Login</button>
      )}
      {content}
    </div>
  );
}

export default App;

```