import React from 'react';
import {Navbar} from 'react-bootstrap';
import {Link} from 'react-router-dom';

export default class NavigationBar extends React.Component{
    render(){
        return ( 
            <Navbar bg="dark" variant="dark">
            <Link to={""} className="navbar-brand">
               &nbsp;&nbsp; Health Care Express
            </Link>
          
        </Navbar>
    );
}
}
