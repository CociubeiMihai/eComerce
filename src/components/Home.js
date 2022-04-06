import React from 'react'
import { HomePage, HomeText, HomeInfo } from '../styles/main.style'
import background from '../images/img3.jpg';
import styled, {css} from 'styled-components/macro'

const Bacground = styled.div`
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 100%;
  width: 100%;

`; 

const Home = () => {
  return (
    <HomePage>
    <Bacground style={{backgroundImage: `url(${background})`}}>
      <div style={{width: '100vh', height: '100vh'}}></div>
      <HomeText>
      <h1>Welcome!</h1>
      <HomeInfo>
        Bees feed exclusively on sugary nectar and protein-rich pollen 
        from flowering plants, unlike the carnivorous wasps from which they evolved.
      </HomeInfo>
      </HomeText>
    </Bacground>
    </HomePage>
  )
}

export default Home