import axios  from "axios";

const API = "http://localhost:8080/card";

const plateste = (numar, cvc, idPersoana) => {
    return axios.post(API, { idPersoana: idPersoana, ccv: cvc, number: numar });
  };

export {plateste};