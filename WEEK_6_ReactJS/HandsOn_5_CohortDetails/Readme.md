# Cohort Details App

In this handsOn I have created the ```CohortDetails.module.css``` for styling and ```CohortDetails.js``` for rendering.

---

## Styling

As per the instrunctions I have added style to the ```box``` class and ```dt``` tag.

```CohortModule.css```

``` css

.box {
    width: 300px;
    display: inline-block;
    margin: 10px;
    padding: 10px 20px;
    border: 1px solid black;
    border-radius: 10px;
}

dt {
    font-weight: 500;
}

```

## CohortDetails Component

This component was used to render the details and set the tags and class name.

```CohortDetails.js```

``` js

import React from "react";
import styles from "./CohortDetails.module.css";

class CohortDetails extends React.Component {
    render() {
        const { cohort } = this.props;

        return (
        <div className={styles.box}>
            <h3 style={{ color: cohort.status === "Ongoing" ? "green" : "blue" }}>
            {cohort.title}
            </h3>

            <dl>
            <dt>Started On</dt>
            <dd>{cohort.startDate}</dd>

            <dt>Current Status</dt>
            <dd>{cohort.status}</dd>

            <dt>Coach</dt>
            <dd>{cohort.coach}</dd>

            <dt>Trainer</dt>
            <dd>{cohort.trainer}</dd>
            </dl>
        </div>
        );
    }
}

export default CohortDetails;

```

---

## Starting react app

I have started the react application using the following commmand.

``` bash

npm start

```