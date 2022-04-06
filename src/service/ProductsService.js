import axios from "axios"

const API_VIEW_PRODUCTS ="http://localhost:8080/produs/";
const API_ADD_PRODUCT="http://localhost:8080/cart/addCart/";

const viewProducts = () =>{
    return axios.get(API_VIEW_PRODUCTS);
};

const addToCartFun = (idPers, idProdus) => {
    return axios.post(API_ADD_PRODUCT, { idPers: idPers, idProdus: idProdus });
}

const findByValue = (camp, valoare) => {
    return axios.get(`http://localhost:8080/produs/${camp}/${valoare}`);
}

const findByValueBetween = (low, high) => {
    return axios.get(`http://localhost:8080/produs/price/${low}/${high}`);
}

const removeProduct = (id) =>{
    return axios.put(`http://localhost:8080/produs/remove/${id}`);
}

export {viewProducts, addToCartFun, findByValue, findByValueBetween, removeProduct};