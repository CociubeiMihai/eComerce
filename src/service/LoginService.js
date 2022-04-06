import axios from "axios";

const API = "http://localhost:8080/login";


const authorize = (nume, parola) => {
  return axios.post(API, { nume: nume, parola: parola });
};



export { authorize };