import React from 'react';
import Cards from 'react-credit-cards';
import 'react-credit-cards/es/styles-compiled.css';
import {Container,
    CheckOutBox,
    CardContainer,
    Inputs,
    Input,
    InputBox,
    DateInput,
    CVC,
    SubmitButton

}from '../styles/CheckOut.style';
import {useState, useEffect} from 'react'
import { plateste } from '../service/CheckOutService';


function CheckOut() {

    const id = JSON.parse(localStorage.getItem("id"));

    const [number, setNumber] = useState('');
    const [name, setName] = useState('');
    const [expiry, setExpiry] = useState('');
    const [cvc, setCvc] = useState('');
    const [focus, setFocus] = useState('');


    //ERRORS
    const [numberError, setNumberError] = useState('');
    const [nameError, setNameError] = useState('');
    const [dateError, setDateError] = useState('');
    const [cvcError, setCvcError] = useState('');

    const clearErrors = () => {
        setDateError('');
        setCvcError('');
        setNumberError('');
        setNameError('');
    }



    const addPrograms = () =>{
        clearErrors();
        
        if (number.length < 16){
            return setNumberError("Card number must be 16 digits!");
        }

        if (name === ''){
            return setNameError("Please introduce a valid name!")
        }

        if (expiry.length < 4){
            return setDateError("This field must have 4 digits!");
        }

        if(cvc.length < 3){
            return setCvcError("Please introduce a valid CVC");
        }
        plateste(number,cvc,id).then((res) =>{
            if(res.data.ccv == cvc){
                alert("A functionat");
            }
            else{
                alert("Ceva nu a mers bine");
            }
            setNumber("");
            setName("");
            setExpiry("");
            setCvc("");
            setFocus("");
        });

    }

return (
    <Container>
        <CheckOutBox>
            <CardContainer>    
                <Cards
                    cvc={cvc}
                    expiry={expiry}
                    focused={focus}
                    name={name}
                    number={number}
                />
            </CardContainer>
            <form onSubmit={(e) => e.preventDefault()}>
            <Inputs>
        	        <Input
                        type="text"
                        name="number"
                        value={number}
                        maxLength="16"
                        placeholder="CARD NUMBER"
                        onChange={e =>setNumber(e.target.value)}
                        onFocus={e =>setFocus(e.target.name)}
                        required
                    />
                    <p style={{marginRight: "215px"}}>{numberError}</p>
                    <Input
                        type="tel"
                        name="name"
                        value={name}
                        placeholder="NAME"
                        onChange={e =>setName(e.target.value)}
                        onFocus={e =>setFocus(e.target.name)}
                        required
                    />
                    <p style={{marginRight: "215px"}}>{nameError}</p>

                    <InputBox>
                        <DateInput 
                            type="tel"
                            name="expiry"
                            value={expiry}
                            maxLength="4"
                            placeholder="VALID THRU"
                            onChange={e =>setExpiry(e.target.value)}
                            onFocus={e =>setFocus(e.target.name)}
                            required
                        />
                        <CVC 
                            type="text"
                            name="cvc"
                            placeholder="CVC"
                            maxLength="3"
                            value={cvc}
                            onChange={e =>setCvc(e.target.value)}
                            onFocus={e =>setFocus(e.target.name)}
                            required
                        />
                        
                    </InputBox>
                    <div style={{marginBottom: "25px", display: 'flex', justifyContent: "center"}}>
                        <p style={{ marginRight: "15px"}}>{dateError}</p>
                        <p style={{ marginLeft: "215px"}}>{cvcError}</p>
                    </div> 
            </Inputs>
            </form>
            <SubmitButton onClick={addPrograms}> PAY </SubmitButton>
        </CheckOutBox>
    </Container>
    );
}

export default CheckOut