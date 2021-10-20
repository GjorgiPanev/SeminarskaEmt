import React from "react";
import DogTerm from '../DogTerm/dogTerm';
import {Link} from 'react-router-dom';
import ReactPaginate from 'react-paginate';

class Dogs extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            page: 0,
            size: 4

        }
    }

    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.dogs.length / this.state.size);
        const dogs = this.getDogsPage(offset, nextPageOffset);

        return (
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <div className={"table-responsive"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Age</th>
                                <th scope={"col"}>Race</th>
                                <th scope={"col"}>Gender</th>
                                <th scope={"col"}>Available status</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            {dogs}
                            </tbody>
                        </table>
                    </div>
                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block btn-dark"} to={"/dogs/add"}>Add new
                                    dog</Link>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="col mb-5 mt-5 text-center" style={{background: "blue"}}>
                    <div className="row">
                        <div className="col-sm-12 col-md-12" style={{color: "white",fontSize: "3vh"}}>
                            {this.props.reservedMessage}
                        </div>
                    </div>
                </div>
                <ReactPaginate previousLabel={"back "}
                               nextLabel={" next"}
                               breakLabel={<a href="/#">...</a>}
                               breakClassName={"break-me"}
                               pageClassName={"ml-1"}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination m-4 justify-content-center"}
                               activeClassName={"active"}/>
            </div>
        )
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected
        })
    }

    getDogsPage = (offset, nextPageOffset) => {
        return this.props.dogs.map((term, index) => {
            return (
                <DogTerm term={term} onDelete={this.props.onDelete} onEdit={this.props.onEdit} onReservation={this.props.onReservation}/>
            );
        }).filter((product, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }

}

export default Dogs;