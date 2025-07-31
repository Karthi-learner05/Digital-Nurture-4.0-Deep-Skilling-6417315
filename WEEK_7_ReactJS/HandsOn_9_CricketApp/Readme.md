# Cricket App

In this handsOn I have craeted components `ListofPlayer.js` and `IndianPlayers.js`. These components are used to demonstrate the `map()` arrow functions, destructuring, merging arrays, and conditional rendering.

---

## ListofPlayer Component

```ListofPlayers.js```

``` js
import React from "react";

    const players = [
    { name: "Rohit", score: 88 },
    { name: "Virat", score: 65 },
    { name: "Gill", score: 70 },
    { name: "Rahul", score: 45 },
    { name: "Pant", score: 72 },
    { name: "Hardik", score: 50 },
    { name: "Jadeja", score: 90 },
    { name: "Ashwin", score: 30 },
    { name: "Shami", score: 75 },
    { name: "Bumrah", score: 60 },
    { name: "Surya", score: 95 },
    ];

    const ListofPlayers = () => {
    const below70 = players.filter((player) => player.score < 70);

    return (
        <div>
        <h2>All Players</h2>
        <ul>
            {players.map((player, idx) => (
            <li key={idx}>
                {player.name} - {player.score}
            </li>
            ))}
        </ul>

        <h2>Players with score below 70</h2>
        <ul>
            {below70.map((player, idx) => (
            <li key={idx}>
                {player.name} - {player.score}
            </li>
            ))}
        </ul>
        </div>
    );
};

export default ListofPlayers;

```

## IndianPlayers Component

```IndianPlayers.js```

``` js


import React from 'react';

const T20players = ['Rohit', 'Virat', 'Surya', 'Hardik'];
const RanjiTrophy = ['Jaiswal', 'Sarfaraz', 'Iyer'];

const IndianPlayers = () => {
    const allPlayers = [...T20players, ...RanjiTrophy];

    const oddPlayers = allPlayers.filter((_, i) => i % 2 === 1);
    const evenPlayers = allPlayers.filter((_, i) => i % 2 === 0);
    return (
        <div>
        <h2>All Players (Merged)</h2>
        <ul>
            {allPlayers.map((p, i) => <li key={i}>{p}</li>)}
        </ul>

        <h3>Odd Team Players</h3>
        <ul>
            {oddPlayers.map((p, i) => <li key={i}>{p}</li>)}
        </ul>

        <h3>Even Team Players</h3>
        <ul>
            {evenPlayers.map((p, i) => <li key={i}>{p}</li>)}
        </ul>
        </div>
    );
};

export default IndianPlayers;

```

---

## ```App.js```

``` js

import React from 'react';
import ListofPlayers from './components/ListofPlayers';
import IndianPlayers from './components/IndianPlayers';

function App() {
  const flag = false;

  return (
    <div className="App">
      <h1>🏏 Cricket App</h1>
      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;

```