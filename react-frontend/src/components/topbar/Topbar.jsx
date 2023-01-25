import React from 'react'
import "./topbar.css"
import { NotificationsNone, Login } from '@mui/icons-material';
import {Navbar} from 'react-bootstrap';
import {Link} from 'react-router-dom';

export default function Topbar() {
  return (
    <div className="topbar">
        <div className="topbarWrapper">
        
    
         <Navbar bg="dark" variant="dark">
         
          
        </Navbar>

        <div className="topright">
            <div className="topbarIconContainer">
             <NotificationsNone />
            <span className="topIconBadge">8</span>
            </div>
            <div className="topbarIconContainer">
             <Login />
            </div>
            </div>
             </div>
             </div>
  );
}
