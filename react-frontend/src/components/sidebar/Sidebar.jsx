import "./sidebar.css"
import { LocalHospital } from '@mui/icons-material';
import {Link} from "react-router-dom"


export default function Sidebar() {
  return (
    <div className="sidebar">
        <div className="sidebarWrapper">
          <div className="sidebarMenu">
            <h3  className="sidebarTitle">Hospitals</h3>
              <ul className="sidebarList">
              <li className="sidebarListItem active ">
                      <LocalHospital className="sidebarIcon"/>
                      <Link style={{ textDecoration:"none" }} to={{
                                                                        pathname:'/hospital',
                                                                        state: {title:'Jayadeva'}  
                                                                        }}>Jayadeva</Link>
                                                                        

                                                                        
                                                                        
                      

                </li>
                  <li className="sidebarListItem active ">
                      <LocalHospital className="sidebarIcon"/>
                      <Link style={{ textDecoration:"none" }} to={{
                                                                        pathname:'/hospital',
                                                                        state: {title:'Apollo'}  
                                                                        }}>Apollo</Link>

                </li>
                    
                    <li className="sidebarListItem active">
                      <LocalHospital className="sidebarIcon" />
                      <Link style={{ textDecoration:"none" }} to={{
                                                                        pathname:'/hospital',
                                                                        state: {title:'Forts'}  
                                                                        }}>Fortis</Link>
                </li>
                <li className="sidebarListItem">
                      <LocalHospital  className="sidebarIcon"/>
                      <Link style={{ textDecoration:"none" }} to={{
                                                                        pathname:'/hospital',
                                                                        state: {title:'Re-Live'}  
                                                                        }}>Re-Live</Link>
                     

                </li>
                <li className="sidebarListItem">
                      <LocalHospital className="sidebarIcon"/>
                      Life Care 

                </li>
                <li className="sidebarListItem">
                      <LocalHospital className="sidebarIcon" />
                      Manipal North Side 

                </li>
                <li className="sidebarListItem">
                      <LocalHospital className="sidebarIcon"/>
                      Silicon City 

                </li>
                <li className="sidebarListItem">
                      <LocalHospital className="sidebarIcon"/>
                      Sagar 

                </li>
                <li className="sidebarListItem">
                      <LocalHospital className="sidebarIcon"/>
                      People Tree 

                </li>
                <li className="sidebarListItem">
                      <LocalHospital className="sidebarIcon"/>
                      Columbia Asia 

                </li>
                <li className="sidebarListItem">
                      <LocalHospital className="sidebarIcon"/>
                      Belle Vue's Cambridge

                </li>
                <li className="sidebarListItem">
                      <LocalHospital className="sidebarIcon" />
                      Vikram 

                </li>
                 
                <li className="sidebarListItem">
                      <LocalHospital className="sidebarIcon"/>
                     CloudNine 

                </li>
                <li className="sidebarListItem">
                      <LocalHospital className="sidebarIcon"/>
                      Ssnmc Speciality 

                </li>
                <li className="sidebarListItem">
                      <LocalHospital className="sidebarIcon"/>
                      Fortis la Femme 

                </li>
                <li className="sidebarListItem">
                      <LocalHospital className="sidebarIcon"/>
                      Sparsh 

                </li>
                 
                       
              </ul>
          </div>
        </div>
      
    </div>
  )
}
