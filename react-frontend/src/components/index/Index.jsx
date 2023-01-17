import React from 'react'
import CaseInfo from '../patientInfo/CaseInfo'
import Sidebar from '../sidebar/Sidebar'
import "../../app.css"

export default function Index() {
  return (
    <div className="container1">
    <Sidebar/>
    <CaseInfo />
    </div>
  )
}
