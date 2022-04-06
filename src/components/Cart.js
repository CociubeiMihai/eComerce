import React, { useEffect, useState } from "react";
import { viewCart, emptyCart, totalCart, orderProducts } from "../service/CartService";
import {
  ElementTabel,
  ProduseTab,
  RandTabel,
  Tabel,
  ClearBtn,
  Total,
  OrderBtn,
  CardBtn,
} from "../styles/main.style";
import { useNavigate } from "react-router-dom";

const Cart = () => {

  let navigate = useNavigate(); 
  const [content, setContent] = useState([]);
  const [total, setTotal] = useState([]);
  const id = JSON.parse(localStorage.getItem("id"));
  useEffect(() => {
    viewCart(id).then((response) => {
      setContent(response.data);
    });
    totalCart(id).then((response)=> {
        setTotal(response.data);
    });
  }, []);

  const emptyCartHandler = () => {
    emptyCart(id);
    window.location.reload(false);
  };

  const orderHandler = () => {
    orderProducts(id);
    window.location.reload(false);
  };

  const routeChange = () =>{ 
    let path = `/card`; 
    navigate(path);
  }

  return (
    <div>
      <ClearBtn onClick={emptyCartHandler}>Clear</ClearBtn>
      <Total >Total: {total}</Total>
      <OrderBtn onClick={orderHandler}>Order</OrderBtn>
      <CardBtn  onClick={routeChange}>Plateste</CardBtn>
      <ProduseTab>
        <Tabel>
          <RandTabel>
            <ElementTabel>
              <h6>Nume</h6>
            </ElementTabel>
            <ElementTabel>
              <h6>Pret</h6>
            </ElementTabel>
            <ElementTabel>
              <h6>Descriere</h6>
            </ElementTabel>
            <ElementTabel>
              <h6>Recenzie</h6>
            </ElementTabel>
          </RandTabel>
          {content.map((pr) => (
            <RandTabel>
              <ElementTabel>{pr.nume}</ElementTabel>
              <ElementTabel>{pr.pret}</ElementTabel>
              <ElementTabel>{pr.descriere}</ElementTabel>
              <ElementTabel>{pr.recenzie}</ElementTabel>
            </RandTabel>
          ))}
        </Tabel>
      </ProduseTab>
    </div>
  );
};

export default Cart;
