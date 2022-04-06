import React from 'react'
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from './components/Login';
import About from './components/About';
import { useState, useEffect } from "react";
import Home from './components/Home';
import Produse from './components/Produse';
import Cart from './components/Cart';
import Register from './components/Register';
import Comenzi from './components/Comenzi';
import ComenziPrimite from './components/ComenziPrimite';
import CheckOut from './components/CheckOut';

function App() {

  const [idUser, setIdPersoana] = useState();

  const setTheId = (id) => {
    setIdPersoana(id);
    
  };
  

  return (
    <Router>
      <div>
      <Navbar />
        <Routes>
          <Route path="/about" element={<About />} />
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login usrLogg={setTheId}/>} />
          <Route path="/admin" element={<Home />} />
          <Route path="/user" element={<Home />} />
          <Route path="/products" element={<Produse />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/register" element={<Register />} />
          <Route path="/comenzi" element={<Comenzi />} />
          <Route path="/primite" element={<ComenziPrimite />} />
          <Route path="/card" element={<CheckOut />} />
        </Routes>
        </div>
    </Router>
  );
}

export default App;
