import React from "react";
import {Link} from 'react-router-dom';

const dogTerm = (props) => {
    return (
        <tr>
            <td scope={"col"}>{props.term.dogName}</td>
            <td scope={"col"}>{props.term.age}</td>
            <td scope={"col"}>{props.term.race}</td>
            <td scope={"col"}>{props.term.gender}</td>
            {props.term.availableStatus && (
                <td scope={"col"}>Yes</td>
            )}
            {!props.term.availableStatus && (
                <td scope={"col"}>No</td>
            )}
            <td scope={"col"} className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id.id)}>
                    Delete
                </a>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id.id)}
                      to={`/dogs/edit/${props.term.id.id}`}>
                    Edit
                </Link>
                <a title={"Reserve"} className={"btn btn-success"}
                   onClick={() => props.onReservation(props.term.id.id)}>
                    Reserve
                </a>
            </td>
        </tr>
    )
}
export default dogTerm;
