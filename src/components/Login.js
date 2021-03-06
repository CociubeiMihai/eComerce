import React, { useEffect } from "react";
import "../styles/LogIn.css";
import { useNavigate } from "react-router-dom";
import { authorize } from "../service/LoginService";
import { useState } from "react";
import background from "../images/img1.jpg";
import styled, { css } from "styled-components/macro";

const Bacground = styled.div`
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 100%;
  width: 100%;
`;

const Login = ({ usrLogg }) => {
  let navigate = useNavigate();
  const [nume, setNume] = useState("");
  const [parola, setParola] = useState("");
  const [rol, setRol] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    //console.log(nume, parola);
    authorize(nume, parola).then((res) => {
      if (res.data.rol === "ADMIN") {
        navigate("/admin");
        usrLogg(res.data.id);
        localStorage.setItem("rol", JSON.stringify("ADMIN"));
        localStorage.setItem("id", JSON.stringify(res.data.id));
      } else if (res.data.rol === "USER") {
        navigate("/user");
        usrLogg(res.data.id);
        localStorage.setItem("rol", JSON.stringify("USER"));
        localStorage.setItem("id", JSON.stringify(res.data.id));
      } else {
        alert("Gresit tati");
        setNume("");
        setParola("");
      }
    });
  };

  useEffect(() => {
    localStorage.setItem("rol", JSON.stringify(rol));
    localStorage.setItem("id", JSON.stringify(""));
  }, [rol]);

  return (
    <Bacground style={{ backgroundImage: `url(${background})` }}>
      <div style={{ width: "100vh", height: "100vh" }}>
        <form>
          <div class="center">
            <h1>Login</h1>
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
              <input type="submit" value="Login" onClick={handleSubmit}></input>
            </form>
          </div>
        </form>
      </div>
    </Bacground>
  );
};

export default Login;
