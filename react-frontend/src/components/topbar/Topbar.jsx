import React from 'react'
import "./topbar.css"
import { NotificationsNone, Login } from '@mui/icons-material';

export default function Topbar() {
  return (
    <div className="topbar">
        <div className="topbarWrapper">
        
         <span className="logo">HomePage</span>
         

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
