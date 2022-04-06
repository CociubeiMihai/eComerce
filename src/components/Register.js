import React, { useEffect } from "react";
import "../styles/LogIn.css";
import { useState } from "react";
import background from "../images/img4.jpg";
import styled, { css } from "styled-components/macro";
import { register } from "../service/RegisterService";




const Bacground = styled.div`
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 100%;
  width: 100%;
`;


const Register = () => {

    const [nume, setNume] = useState("");
    const [parola, setParola] = useState("");

const handleSubmit = (e) => {
    e.preventDefault();
    //console.log(nume, parola);
    register(nume, parola);
    setNume("");
    setParola("");
  };

  return (
    <Bacground style={{ backgroundImage: `url(${background})` }}>
        <div style={{ width: "100vh", height: "100vh" }}>
        <form>
          <div class="center">
            <h1>Register</h1>
            <form method="post">
              <div class="txt_field">
                <input
                  className="fill"
                  type="text"
                  name="username"
                  value={nume}
                  onChange={(e) => setNume(e.target.value)}
                />
                <span></span>
                <label>Username</label>
              </div>

              <div class="txt_field">
                <input
                  className="fill"
                  type="password"
                  name="password"
                  value={parola}
                  onChange={(e) => setParola(e.target.value)}
                />
                <span></span>
                <label>Password</label>
              </div>
              <input type="submit" value="Register" onClick={handleSubmit}></input>
            </form>
          </div>
        </form>
        </div>
    </Bacground>
  )
}

export default Register