import axios from 'axios';

const HOSPITAL_API_BASE_URL="http://localhost:8003/api/v1/hospitals";

class HospitalService{
   
   
    deleteHospital(hospitalId){
        return axios.delete(HOSPITAL_API_BASE_URL+ '/' + hospitalId);
    }
}

export default new HospitalService();