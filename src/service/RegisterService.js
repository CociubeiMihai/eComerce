import axios from "axios";
const API = "http://localhost:8080/persoana/register";


const register = (nume, parola) => {
  console.log(nume, parola)
  return axios.post(API, { nume: nume, parola: parola });
};

export { register };