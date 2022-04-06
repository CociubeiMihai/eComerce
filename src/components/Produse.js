import React, { useEffect, useState } from "react";
import { viewProducts, addToCartFun, findByValue, findByValueBetween, removeProduct } from "../service/ProductsService";
import {
  AddCart,
  TextFieldSearch,
  ElementTabel,
  ProduseTab,
  RandTabel,
  Tabel,
  TextFieldSearch2,
  SearchBtn,
  TextFieldSearch3,
  TextFieldSearch4,
  SearchBtn2,
  RemoveElement,
} from "../styles/main.style";

const Produse = ({}) => {
  const [content, setContent] = useState([]);
  const [id, setId] = useState([]);
  const [nume, setNume] = useState("");
  const [text2, setText2] = useState("");
  const rol = JSON.parse(localStorage.getItem('rol'));

  const [low, setLow] = useState("");
  const [high, setHigh] = useState("");

  useEffect(() => {
    setId(JSON.parse(localStorage.getItem("id")));
    viewProducts().then((res) => {
      setContent(res.data);
    });
  }, []);

  const searchHandler = () => {
    findByValue(nume, text2).then((res) => {
        setContent(res.data)});
  };

  const searchBetweenHandler = () => {
    findByValueBetween(low, high).then((res) => {
        setContent(res.data)});
  };

  return (
    (rol == "ADMIN") ? (
    <ProduseTab>
      <TextFieldSearch
        className="fill"
        type="text"
        name="username"
        value={nume}
        onChange={(e) => setNume(e.target.value)}
      />
     <TextFieldSearch2
        className="fill"
        type="text"
        name="username"
        value={text2}
        onChange={(e) => setText2(e.target.value)}
      />

     <SearchBtn onClick={searchHandler}>Search</SearchBtn>

     <TextFieldSearch3
        className="fill"
        type="text"
        name="username"
        value={low}
        onChange={(e) => setLow(e.target.value)}
      />
     <TextFieldSearch4
        className="fill"
        type="text"
        name="username"
        value={high}
        onChange={(e) => setHigh(e.target.value)}
      />

     <SearchBtn2 onClick={searchBetweenHandler}>Between</SearchBtn2>
    
      <Tabel>
        <tbody>
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
            <ElementTabel>
              <h6>Stoc</h6>
            </ElementTabel>
          </RandTabel>
          {content.map((pr) => (
            <RandTabel>
              <ElementTabel key="{pr.id}">{pr.nume}</ElementTabel>
              <ElementTabel>{pr.pret}</ElementTabel>
              <ElementTabel>{pr.descriere}</ElementTabel>
              <ElementTabel>{pr.recenzie}</ElementTabel>
              <ElementTabel>{pr.cantitate}</ElementTabel>
              <AddCart
                onClick={() => {
                  //console.log(pr.id, id);
                  addToCartFun(id, pr.id);
                }}
              >
                Add
              </AddCart>
              <RemoveElement onClick={() => {
                  removeProduct(pr.id);
                  window.location.reload(false);
                }}>Delete</RemoveElement>
            </RandTabel>
          ))}
        </tbody>
      </Tabel>
    </ProduseTab>):
    (    <ProduseTab>
        <TextFieldSearch
          className="fill"
          type="text"
          name="username"
          value={nume}
          onChange={(e) => setNume(e.target.value)}
        />
       <TextFieldSearch2
          className="fill"
          type="text"
          name="username"
          value={text2}
          onChange={(e) => setText2(e.target.value)}
        />
  
       <SearchBtn onClick={searchHandler}>Search</SearchBtn>
  
       <TextFieldSearch3
          className="fill"
          type="text"
          name="username"
          value={low}
          onChange={(e) => setLow(e.target.value)}
        />
       <TextFieldSearch4
          className="fill"
          type="text"
          name="username"
          value={high}
          onChange={(e) => setHigh(e.target.value)}
        />
  
       <SearchBtn2 onClick={searchBetweenHandler}>Between</SearchBtn2>
      
        <Tabel>
          <tbody>
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
              <ElementTabel>
                <h6>Stoc</h6>
              </ElementTabel>
            </RandTabel>
            {content.map((pr) => (
              <RandTabel>
                <ElementTabel key="{pr.id}">{pr.nume}</ElementTabel>
                <ElementTabel>{pr.pret}</ElementTabel>
                <ElementTabel>{pr.descriere}</ElementTabel>
                <ElementTabel>{pr.recenzie}</ElementTabel>
                <ElementTabel>{pr.cantitate}</ElementTabel>
                <AddCart
                  onClick={() => {
                    //console.log(pr.id, id);
                    addToCartFun(id, pr.id);
                  }}
                >
                  Add
                </AddCart>
              </RandTabel>
            ))}
          </tbody>
        </Tabel>
      </ProduseTab>)
  );
  
};

export default Produse;
