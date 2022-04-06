import React, { useEffect, useState } from 'react'
import { findOrders } from '../service/ComenziService';
import { ElementTabel, ProduseTab, RandTabel, Tabel, Ceva } from '../styles/main.style';
import {
    OrdersContainer,
    OrdersWrapper,
    OrdersHeading,
    Wrapper,
    OrderList,
    OrderBox,
    OrderInfo,
    OrderID,
    BuyerEmail,
    Value,
    Program,
    ProgramList,
    Achitat
    } from '../styles/Comenzi.style';

const Comenzi = () => {

    const [content, setContent] = useState([]);
    const id = JSON.parse(localStorage.getItem('id'));


    useEffect(() => {
        findOrders(id).then((res) => {
            setContent(res.data);
        });
    }, []);

  return (
    <OrdersContainer>
    <OrdersWrapper>
        <OrdersHeading> MY ORDERS </OrdersHeading>

        <Wrapper>
            <OrderList>
                {content.map((order) => (
                    <OrderBox>
                        <OrderInfo>
                            <OrderID> <b>ID comanda: </b> {order.id}</OrderID>
                            <BuyerEmail><b>Data:</b>  {order.data} </BuyerEmail>
                            <Value> <b>Value:</b>  {order.total} $</Value>
                            <Achitat><b>Achitat:</b> {order.achitat} </Achitat>
                        </OrderInfo>
                        <ProgramList >
                            { order.produse.map((prod) => (
                                <Program >
                                    <b>Produs:</b> {prod.nume}
                                </Program>
                            ))}
                        </ProgramList>  
                    </OrderBox>
                ))}
            </OrderList>
        </Wrapper>

    </OrdersWrapper>
</OrdersContainer>
  )
}

export default Comenzi