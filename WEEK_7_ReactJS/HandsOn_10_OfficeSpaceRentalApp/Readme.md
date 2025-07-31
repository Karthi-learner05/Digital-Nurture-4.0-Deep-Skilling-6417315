# Office Space Rental App

In this hands on I have created a react app named ```officespacerentalapp``` using JSX to display multiple office spaces using local images, dynamic data, and inline CSS styles.

---

## App.js

In that ```App.js``` I have done the following changes to meet the requirement:

->Created a JSX heading to display the page title.

->Displayed office space data using an array of objects.

->Used the map() method to render multiple office details.

->Added individual images for each office from a local folder.

->Applied inline CSS to highlight the rent:

    ->Rent is shown in red if it is below 60000

    ->Rent is shown in green if it is 60000 or above

->Wrapped each office block inside a bordered card layout using inline styles.

``` js

import './App.css';
import dbs from '../src/offices/dbs.png';
import wework from '../src/offices/wework.png';
import rmz from '../src/offices/rmz.png';
import tidelpark from '../src/offices/tidelpark.png';

function App() {
  const heading = <h1>Office Space , at Affordable Range</h1>;

  const offices = [
    {
      name: "DBS",
      rent: 50000,
      address: "Chennai",
      image: dbs
    },
    {
      name: "Tidel Park",
      rent: 75000,
      address: "Coimbatore",
      image: tidelpark
    },
    {
      name: "WeWork",
      rent: 60000,
      address: "Bangalore",
      image: wework
    },
    {
      name: "RMZ",
      rent: 45000,
      address: "Hyderabad",
      image: rmz
    }
  ];

  const officeCardStyle = {
    border: '2px solid #ccc',
    borderRadius: '10px',
    padding: '15px',
    margin: '20px auto',
    width: '60%',
    backgroundColor: '#f9f9f9',
    boxShadow: '0 0 10px rgba(0,0,0,0.1)'
  };

  const imageStyle = {
    width: '100%',
    height: 'auto',
    borderRadius: '5px'
  };

  return (
    <div style={{ textAlign: 'center', fontFamily: 'Arial' }}>
      {heading}

      {offices.map((office, index) => {
        const rentStyle = {
          color: office.rent < 60000 ? 'red' : 'green',
          fontWeight: 'bold'
        };

        return (
          <div key={index} style={officeCardStyle}>
            <img src={office.image} alt={office.name} style={imageStyle} />
            <h2>Name: {office.name}</h2>
            <p style={rentStyle}>Rent: Rs. {office.rent}</p>
            <p><strong>Address:</strong> {office.address}</p>
          </div>
        );
      })}
    </div>
  );
}

export default App;

```