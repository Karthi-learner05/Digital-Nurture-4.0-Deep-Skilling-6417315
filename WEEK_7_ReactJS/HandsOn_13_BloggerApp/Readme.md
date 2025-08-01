# Blogger App

In this handsOn I created a react application demonstrating various types of conditional rendering using three different components ```CourseDetails```, ```BookDetails```, and ```BlogDetails```.

----

## CourseDetails.js

``` js

import React from "react";

function CourseDetails() {
  return (
    <div>
      <h2>Course Details</h2>
      <ul>
        <li>React Basics - 4 Weeks</li>
        <li>React Advanced - 6 Weeks</li>
      </ul>
    </div>
  );
}

export default CourseDetails;

```

## BookDetails.js

``` js

import React from "react";

function BookDetails() {
  return (
    <div>
      <h2>Book Details</h2>
      <ul>
        <li>Title: React Essentials</li>
        <li>Author: John Doe</li>
      </ul>
    </div>
  );
}

export default BookDetails;

```

## BlogDetails.js

``` js

import React from "react";

function BlogDetails() {
  return (
    <div>
      <h2>Blog Details</h2>
      <ul>
        <li>React Hooks Explained</li>
        <li>JSX Deep Dive</li>
      </ul>
    </div>
  );
}

export default BlogDetails;

```

----

## App.js

``` js

import React, { useState } from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";
import "./App.css";

function App() {
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);
  const [showCourses, setShowCourses] = useState(true);

  return (
    <div style={{ textAlign: "center", marginTop: "30px" }}>
      <h1>Blogger App</h1>

      <div style={{ margin: "20px" }}>
        <button onClick={() => setShowCourses(!showCourses)}>Toggle Course</button>
        <button onClick={() => setShowBooks(!showBooks)}>Toggle Book</button>
        <button onClick={() => setShowBlogs(!showBlogs)}>Toggle Blog</button>
      </div>

      <div className="container">
        {showCourses && (
          <div className="column">
            <CourseDetails />
          </div>
        )}

        {(() => {
          if (showBooks) {
            return (
              <div className="column">
                <BookDetails />
              </div>
            );
          }
        })()}

        {
          showBlogs ? (
            <div className="column">
              <BlogDetails />
            </div>
          ) : null
        }
      </div>
    </div>
  );
}

export default App;

```