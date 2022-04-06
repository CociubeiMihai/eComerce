import React from 'react'
import Home from './components/Home';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from './components/Login';

function App() {
  return (
    // <Router>
    //   <Navbar />
    //   <div>
    //     <Routes>
    //       <Route exact path="/log-in" element={<Login />} />
    //     </Routes>
    //   </div>
    // </Router>
    <>
    <Navbar />
    </>

  );
}

export default App;
