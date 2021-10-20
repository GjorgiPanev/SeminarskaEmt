import React from 'react';

import {useHistory} from 'react-router-dom';

const DogEdit = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        dogName: "",
        age: 0,
        race: 0,
        gender: "",
        availableStatus: false
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.dogName !== "" ? formData.dogName : props.dog.dogName;
        const age = formData.age !== 0 ? formData.age : props.dog.age;
        const race = formData.race !== 0 ? formData.race : props.dog.race;
        const gender = formData.gender !== "" ? formData.gender : props.dog.gender;
        const availableStatus = formData.availableStatus !== false ? formData.availableStatus : props.dog.availableStatus;

        console.log(props.dog?.id)
        console.log(props.dog?.id?.id)
        props.onEditDog(props.dog?.id?.id, name, age, race, gender, availableStatus);
        history.push("/dogs");
    }

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Dog name</label>
                        <input type="text"
                               className="form-control"
                               id="dogName"
                               name="dogName"
                               required
                               placeholder={props.dog.dogName}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="price">Age</label>
                        <input type="text"
                               className="form-control"
                               id="age"
                               name="age"
                               placeholder={props.dog.age}
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">Race</label>
                        <input type="text"
                               className="form-control"
                               id="race"
                               name="race"
                               placeholder={props.dog.race}
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">Gender</label>
                        <input type="text"
                               className="form-control"
                               id="gender"
                               name="gender"
                               placeholder={props.dog.gender}
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Available Status</label>
                        <select name="availableStatus" className="form-control" onChange={handleChange} required>
                            <option value={false}>Choose option</option>
                            <option value={true}>Yes</option>
                            <option value={false}>No</option>
                        </select>
                    </div>
                    <div className="mt-3">
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    )
}
export default DogEdit;