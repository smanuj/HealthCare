
import { NotificationsNone, Login } from "@mui/icons-material"
import "./topbar.css"

export default function Topbar() {
    return (
    <div className="topbar">
        <div className="topWrapper">
            <span className="logo">DoctorDashboard</span>
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
