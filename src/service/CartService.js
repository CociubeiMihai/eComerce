import axios  from "axios";

const viewCart = (id) =>{
    return axios.get(`http://localhost:8080/cart/all/${id}` );
};

const emptyCart = (id) =>{
    return axios.post(`http://localhost:8080/cart/empty/${id}`);
};

const totalCart = (id) =>{
    return axios.get(`http://localhost:8080/cart/total/${id}`);
};

const orderProducts = (id) =>{
    return axios.post(`http://localhost:8080/comenzi/add/${id}`);
};
export {viewCart, emptyCart, totalCart, orderProducts};