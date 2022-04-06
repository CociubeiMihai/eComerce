import React, { useEffect, useState } from 'react'
import { menuData, menuDataAdmin } from '../data/MenuData';
import { Nav, NavMenu, NavMenuLinks, MeniuBar, NavBtn } from '../styles/navBar.style';
import { Button } from './Button';

const Navbar = () => {

  const [rol, setRol] = useState([]);

  useEffect(() => {
  const rol = JSON.parse(localStorage.getItem('rol'));
    setRol(rol);

  }, [rol]);

  //console.log(rol)
  return (
    (rol == "ADMIN") ? (
      <Nav>
        <MeniuBar />
        <NavMenu>
          {menuDataAdmin.map((item, index) => (
            <NavMenuLinks to={item.link} key={index}>
              {item.title}
            </NavMenuLinks>
          ))}
        </NavMenu>
        <NavBtn>
          <Button to='/contact' primary='false'>Contact Us</Button>
        </NavBtn>
      </Nav>)
      : (
        <Nav>
        <MeniuBar />
        <NavMenu>
          {menuData.map((item, index) => (
            <NavMenuLinks to={item.link} key={index}>
              {item.title}
            </NavMenuLinks>
          ))}
        </NavMenu>
        <NavBtn>
          <Button to='/contact' primary='false'>Contact Us</Button>
        </NavBtn>
      </Nav>
      )
  )
}

export default Navbar