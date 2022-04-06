import styled from "styled-components"

export const Container = styled.div`
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    background-color: #1E4F2A;

    @media screen and (max-width: 768px){
        width: 483px;
    }
`

export const CheckOutBox = styled.div`
    width: 450;
    max-width: 450px;
    border-radius: 15px;
    padding: 50px;
    margin-bottom: 100px;
    background-color: #01200F;
    box-shadow: 0px 3px 15px #FFF033;
    border: 2px solid #FFF033;
    text-align: center;
    margin-top: 150px;

    h2 {    
        font-weight: 500;
        margin-bottom: 50px;
    }

    span {
        display: block;
        margin-top: 40px;
        color: #888888;
        font-size: 14px;
    }

    a{
        margin-left: 4px;
        color: #2f8bfd;
    }

    @media screen and (max-width: 768px){
        width: 350px;
    }
`
export const CardContainer = styled.div`
    margin-bottom: 50px;
`

export const Inputs = styled.div`
    margin-bottom: 24px;
    width: 410px;

    p {
        color: red;
        font-size: 12px;
        margin-bottom: 30px;
    }

    @media screen and (max-width: 768px){
        width: 320px;
    }   
`

export const Input = styled.input`
    width: 350px;
    outline: none;
    padding: 8px 16px;
    border: 1px solid #e0e6e8;
    border-radius: 4px;
    font-size: 1rem;
    color: #7C7C7C;
    transition: box-shadow 0.2s;
    
    &::placeholder {
        color: #lightgrey;
    }

    &:focus {
        box-shadow: 0 0 0 2px rgb(169, 172, 255, 0.5); 
    }
`

export const InputBox = styled.div`
    width: 400px;
    display: flex;
    justify-content: space-between;
`

export const DateInput = styled.input`
    width: 150px;
    outline: none;
    padding: 8px 16px;
    border: 1px solid #e0e6e8;
    border-radius: 4px;
    font-size: 1rem;
    color: #7C7C7C;
    transition: box-shadow 0.2s;
    margin-left: 13px;

    &::placeholder {
        color: #lightgrey;
    }

    &:focus {
        box-shadow: 0 0 0 2px rgb(169, 172, 255, 0.5); 
    }
`

export const CVC = styled.input`
    width: 130px;
    outline: none;
    padding: 8px 16px;
    border: 1px solid #e0e6e8;
    border-radius: 4px;
    font-size: 1rem;
    color: #7C7C7C;
    transition: box-shadow 0.2s;

    &::placeholder {
        color: #lightgrey;
    }

    &:focus {
        box-shadow: 0 0 0 2px rgb(169, 172, 255, 0.5); 
    }
`

export const SubmitButton = styled.button`
font-size: 1rem;
padding: 0.25rem 0.5rem;
border: none;
background: #3A7D44;
color: #000;
transition: 0.2 ease-out;
border-radius: 4px;
outline: none;
cursor: pointer;    
text-decoration: none;
margin-left: 20px;
margin-right: 20px;
margin-top: 30px;
height: 40px;
width: 380px;

&:hover {
background: #fff;
transition: 0.2s ease-out;
cursor: pointer;
color: #000;

`