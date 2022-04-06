import styled, {css} from 'styled-components/macro'
import { Link } from 'react-router-dom';


export const HomeSection = styled.section`
    height: 100vh;
    max-height: 1100px;
    possition: relative;
    overflow: hidden;
`;

export const HomeWrapper = styled.div`
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
    position: relative;
`;

export const Center= styled.div`
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 400px;
    background: white;
    border-radius: 10px;
    box-shadow: 10px 10px 15px rgba(0,0,0,0.05);
`;

export const TextField = styled.div`
    position: relative;
    border-bottom: 2px solid #adadad;
    margin: 30px 0;
`;

export const InputNume = styled.div`
    width: 100%;
    padding: 0 5px;
    height: 40px;
    font-size: 16px;
    border: none;
    background: none;
    outline: none;
`;
export const Space = styled.div``;
export const InputPass = styled.div``;

export const Label = styled.div`
    position: absolute;
    top: 50%;
    left: 5px;
    color: #adadad;
    transform: translateY(-50%);
    font-size: 16px;
    pointer-events: none;
    transition: .5s;
`;

export const HomePage = styled.div`
`;

export const HomeText = styled.div`
    position: absolute;
    top: 50%;
    left: 15%;
    transform: translate(-50%, -50%);
    width: 400px;
    height: 40vh;
`;

export const HomeInfo = styled.div``;

export const ColoaneTabel = styled.div`
    `;
export const CapTbel = styled.th``;
export const Tabel = styled.table`
    position: absolute;
    top: 20%
    
`;
export const ElementTabel= styled.td`
    height: 25px;
    width: 75px;
    h6{
        height: 30px;
    }

`;

export const Ceva = styled.td`
    height: 25px;
    width: 75px;
    display grid;
    h6{
        height: 30px;
    }
`;
export const RandTabel = styled.tr``;
export const ProduseTbel = styled.div``;
export const ProduseTab = styled.div`
`;

export const AddCart = styled.button`
border-radius: 4px;
background: #3A7D44;
padding: 10px 22px;
color: #8FBC94;
border: none;
outline: none;
cursor: pointer;
transition: all 0.2s ease-in-out;
text-decoration: none;
&:hover {
    transition: all 0.2s ease-in-out;
    background: #8FBC94;
    color: #0D6769;
}
`;

export const ClearBtn = styled.button`
    position: absolute;
    top: 15%;
    left: 5%;
    border-radius: 4px;
    background: #3A7D44;
    padding: 10px 22px;
    color: #01200F;
    border: none;
    outline: none;
    cursor: pointer;
    transition: all 0.2s ease-in-out;
    text-decoration: none;
    &:hover {
        transition: all 0.2s ease-in-out;
        background: #8FBC94;
        color: #0D6769;
    }
`;

export const Total = styled.div`
    position: absolute;
    top: 15%;
    left: 40%;
    border: 1px solid;
    padding: 10px;
    box-shadow: 5px 10px 8px #888888;
`;

export const OrderBtn = styled.button`
    position: absolute;
    top: 15%;
    left: 80%;
    border-radius: 4px;
    background: #3A7D44;
    padding: 10px 22px;
    color: #01200F;
    border: none;
    outline: none;
    cursor: pointer;
    transition: all 0.2s ease-in-out;
    text-decoration: none;
    &:hover {
        transition: all 0.2s ease-in-out;
        background: #8FBC94;
        color: #0D6769;
    }
`;

export const TextFieldSearch = styled.input`
    position: absolute;
    top: 12%;
    left: 10%; 
`;

export const TextFieldSearch2 = styled.input`
    position: absolute;
    top: 12%;
    left: 20%;
`;

export const SearchBtn = styled.button`
    position: absolute;
    top: 12%;
    left: 30%;
    border-radius: 4px;
    background: #3A7D44;
    padding: 10px 30px;
    color: #01200F;
    border: none;
    outline: none;
    cursor: pointer;
    transition: all 0.2s ease-in-out;
    text-decoration: none;
    &:hover {
        transition: all 0.2s ease-in-out;
        background: #8FBC94;
        color: #0D6769;
    }
`;

export const TextFieldSearch3 = styled.input`
    position: absolute;
    top: 17%;
    left: 10%; 
`;

export const TextFieldSearch4 = styled.input`
    position: absolute;
    top: 17%;
    left: 20%;
`;

export const SearchBtn2 = styled.button`
    position: absolute;
    top: 17%;
    left: 30%;
    border-radius: 4px;
    background: #3A7D44;
    padding: 10px 30px;
    color: #01200F;
    border: none;
    outline: none;
    cursor: pointer;
    transition: all 0.2s ease-in-out;
    text-decoration: none;
    &:hover {
        transition: all 0.2s ease-in-out;
        background: #8FBC94;
        color: #0D6769;
    }
`;

export const CardBtn = styled.button`
    position: absolute;
    top: 15%;
    left: 85%;
    border-radius: 4px;
    background: #3A7D44;
    padding: 10px 30px;
    color: #01200F;
    border: none;
    outline: none;
    cursor: pointer;
    transition: all 0.2s ease-in-out;
    text-decoration: none;
    &:hover {
        transition: all 0.2s ease-in-out;
        background: #8FBC94;
        color: #0D6769;
    }
`;

export const RemoveElement = styled.button`
    margin-left: 5px;
    border-radius: 4px;
    background: #3A7D44;
    padding: 10px 22px;
    color: #8FBC94;
    border: none;
    outline: none;
    cursor: pointer;
    transition: all 0.2s ease-in-out;
    text-decoration: none;
    &:hover {
        transition: all 0.2s ease-in-out;
        background: #8FBC94;
        color: #0D6769;
    }
`;
