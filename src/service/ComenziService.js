import axios from "axios";

const findOrders = (id) =>{
    return axios.get(`http://localhost:8080/comenzi/findOrders/${id}` );
};

const findOrdersPrimite = (id) =>{
    return axios.get(`http://localhost:8080/comenzi/primite/${id}` );
};


export {findOrders, findOrdersPrimite};