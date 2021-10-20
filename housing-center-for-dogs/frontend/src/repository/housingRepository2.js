import axios from '../custom-axios/axios2';

const HousingRepository2 = {
    reserveDog: (id) => {
        return axios.get(`/dogs/${id}`)
    }
}
export default HousingRepository2;