import React, { useEffect, useState } from 'react'
import { findOrdersPrimite } from '../service/ComenziService';
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

const ComenziPrimite = () => {

    const [content, setContent] = useState([]);
    const id = JSON.parse(localStorage.getItem('id'));


    useEffect(() => {
        findOrdersPrimite(id).then((res) => {
            setContent(res.data);
        });
    }, []);

    console.log(content);
  return (
    <OrdersContainer>
    <OrdersWrapper>
        <OrdersHeading> ORDERS </OrdersHeading>

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

export default ComenziPrimite