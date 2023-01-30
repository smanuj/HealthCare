import axios from 'axios';
import { Form } from "react-bootstrap";
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom'
import styles from './Login.css'
import NavBar from './NavBar';

function UpdateHospital() {
    const [name, setName] = useState('');
     const [location, setLocation] = useState('');
      const [pincode, setPincode] = useState('');
       const [bedAvailabilty, setBedAvailabilty] = useState('');
       
       
       const {id} = useParams ();
       
        const handleSubmit = async (event) => {
             event.preventDefault()
            

             try {
          
          
                 const res = axios.put("http://localhost:8003/api/v1/hospitals/"+id,{
                  name,
                   location,
                   pincode,
                   bedAvailabilty

            });
                     
                      alert("Updated successfully");  
                       } 
                       catch (err) {
                         console.error(err);
                          alert("Cannot update ");
                         }
                        }
                         const [hospital,setHospital]=useState(false);
                         useEffect( () => {
                             if(!hospital) {
                                 loadUsers();
                                }
                             });
                              const loadUsers=async () => {
                                const result=await axios.get("http://localhost:8003/api/v1/hospitals/"+id);
                              setHospital(result.data);
                             }
                              const handleReset = () =>
                              { setName('');
                                setLocation('');
                                 setPincode(''); setBedAvailabilty(''); }
                                  return ( 

                                    <Form onSubmit={handleSubmit} >
                                    <div className="main">
                                    <div >
                                      <div>
                                        <div>
                                          <h1>Update HOSPITAL</h1>
                                          
				                         <div className="second-input">
                                            
                                            <input type="text" defaultValue={hospital.name} className="name"   onChange={e => setName(e.target.value)} />
                                          </div>
                                       
                                          <div className="second-input">
                                          
                                            <input type="text" defaultValue={hospital.location} onChange={e => setLocation(e.target.value)}  className="name"  />
                                          </div>
                                          
                                          
                                          <div className="second-input">
                                          
                                            <input type="text" defaultValue={hospital.pincode} onChange={e => setPincode(e.target.value)}  className="name"  />
                                          </div>
                                          
                                          <div className="second-input">
                                          
                                          <input type="text" defaultValue={hospital.bedAvailabilty} onChange={e => setBedAvailabilty(e.target.value)}   className="name"  />
                                         
                                        </div>
                                        <br></br>
                                        
                                         
                                         <div className="login-button">
                                         <button  >Submit</button><br></br>
                                         <br></br>
                                         
                                         </div>
                                        
                                         </div>
                                        </div>
                                      
                                     
                               
                                    </div>
                                   </div> 
                                   </Form>
                                   
                                );
                            }
                     
     
                                        
                                       export default UpdateHospital;
