import React from 'react'
import { menuData } from '../data/MenuData';
import  {Nav, NavMenu, NavMenuLinks, MeniuBar, NavBtn} from '../styles/navBar.style';
import { Button } from './Button';


const Navbar = () => {
  return (
    <Nav>
      <MeniuBar />
      <NavMenu>
        {menuData.map((item, index) => (
            <NavMenuLinks to= {item.link} key={index}>
              {item.title}
            </NavMenuLinks>
        ))}
      </NavMenu>
      <NavBtn>
        <Button to='/contact' primary='false'>Contact Us</Button>
      </NavBtn>
    </Nav>
  )
}

export default Navbar