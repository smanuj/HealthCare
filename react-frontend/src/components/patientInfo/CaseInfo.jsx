import Chart from "../charts/Chart";
import Nurse from "../nurse/Nurse";
import PatientDiv from "../patientDivision/PatientDiv";


import "./caseInfo.css"

export default function CaseInfo() {
  return (
    <div className="case">
      <div className="row">
        <div className="col-12 col-xl-4">
        <div className="caseItem">
           <span className="caseTitle">Overall Case Handled</span>
           <div className="caseInform">
           <span className="caseTitles">16 
           </span>
           </div>
           </div>
           </div>


            <div className="col-12 col-xl-4">
           <div className="caseItem">
           <span className="caseTitle">Pending Cases</span>
           <div className="caseInform">
           <span className="caseTitles">4
           </span>
           </div>
           </div>
           </div>

            <div className="col-12 col-xl-4">
           <div className="caseItem">
           <span className="caseTitle">Total Cases</span>
           <div className="caseInform">
           <span className="caseTitles">20
           </span>
           </div>
           </div>
           </div>
           <div id="chart" className="col-12">
           <Chart />
           </div>
           <div  className="col col-md-6 col-xl-6 mainmargin" > 
           <Nurse />
           </div>
           <div  className="col col-md-6 col-xl-6 mainmargin" >
           <PatientDiv />
           </div>
           </div>


        </div>

  );
}
