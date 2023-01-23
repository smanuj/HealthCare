import axios from 'axios';

const HOSPITAL_API_BASE_URL="http://localhost:8080/api/v1/hospitals";

class HospitalService{
   
    getHospitalById(hospitalId){
        return axios.get(HOSPITAL_API_BASE_URL+ '/' + hospitalId);
    }

    updateHospital(hospital, hospitalId){
        return axios.put(HOSPITAL_API_BASE_URL + '/' + hospitalId, hospital);
    }

    deleteHospital(hospitalId){
        return axios.delete(HOSPITAL_API_BASE_URL+ '/' + hospitalId);
    }
}

export default new HospitalService();