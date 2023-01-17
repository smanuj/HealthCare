import React from 'react'
import { useLocation } from 'react-router-dom';
export default function Hospital() {
    let location = useLocation();
  return (
    <div>
         {console.log(location.state)}
      Anmol
    </div>
  )
}
