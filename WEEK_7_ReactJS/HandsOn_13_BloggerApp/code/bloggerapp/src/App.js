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
