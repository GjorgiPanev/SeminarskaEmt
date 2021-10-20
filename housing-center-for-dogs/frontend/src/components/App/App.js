import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Dogs from "../Dogs/DogList/dogs"
import DogAdd from "../Dogs/DogAdd/dogAdd";
import HousingRepository from "../../repository/housingRepository";
import HousingRepository2 from "../../repository/housingRepository2";
import DogEdit from "../Dogs/DogEdit/dogEdit";
import Header from "../Header/header"

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            dogs: [],
            selectedDog: {},
            reservedMessage: ""
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Route path={"/dogs"} exact
                               render={() => <Dogs dogs={this.state.dogs}
                                                   onDelete={this.deleteDog}
                                                   onReservation={this.reserveDog}
                                                   onEdit={this.getDog}
                                                   reservedMessage={this.state.reservedMessage}/>}/>
                        <Route path={"/dogs/add"} exact render={() => <DogAdd onAddDog={this.addDog}/>}/>
                        <Route path={"/dogs/edit/:id"} exact render={() => <DogEdit onEditDog={this.editDog} dog={this.state.selectedDog}/>}/>
                        <Redirect to={"/dogs"}/>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadDogs();
    }

    loadDogs = () => {
        HousingRepository.getDogs()
            .then((data) => {
                this.setState({
                    dogs: data.data
                })
            });
    }
    deleteDog = (id) => {
        HousingRepository.deleteDog(id)
            .then(() => {
                this.loadDogs();
            });
    }
    addDog = (dogName, age, race, gender, availableStatus) => {
        HousingRepository.addDog(dogName, age, race, gender, availableStatus)
            .then(() => {
                this.loadDogs();
            });
    }
    editDog = (id, name, age, race, gender, availableStatus) => {
        HousingRepository.editDog(id, name, age, race, gender, availableStatus)
            .then(() => {
                this.loadDogs();
            });
    }
    getDog = (id) => {
        HousingRepository.get(id)
            .then((data) => {
                this.setState({
                    selectedDog: data.data
                })
            })
    }
    reserveDog = (id) => {
        HousingRepository2.reserveDog(id)
            .then((data) => {
                console.log(data.data)
                this.setState({
                    reservedMessage: "Successfully reserved dog."
                })
                this.loadDogs()
            })
    }
}

export default App;