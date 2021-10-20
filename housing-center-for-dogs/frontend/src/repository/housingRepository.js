import axios from '../custom-axios/axios';

const HousingRepository = {
    getDogs: () => {
        return axios.get(`/dogs`)
    },
    deleteDog: (id) => {
        return axios.delete(`/dogs/delete/${id}`);
    },
    addDog: (name, age, race, gender, availableStatus) => {
        return axios.post("/dogs/add", {
            "dogName": name,
            "age": age,
            "race": race,
            "gender": gender,
            "availableStatus": availableStatus
        });
    },
    editDog: (id, name, age, race, gender, availableStatus) => {
        return axios.put(`/dogs/edit/${id}`, {
            "dogName": name,
            "age": age,
            "race": race,
            "gender": gender,
            "availableStatus": availableStatus
        })
    },
    get: (id) => {
        return axios.get(`/dogs/${id}`)
    },
    reserveDog: (id) => {
        return axios.get(`/dogs/${id}`)
    }
}
export default HousingRepository;