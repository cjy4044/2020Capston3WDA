import React from 'react';

import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';

class Customer extends React.Component {
render() {
    return (
       
              /* <CustomerProfile 
                id={this.props.id}
                profile={this.props.profile}
                username={this.props.username}
                userid={this.props.userid}
                userpw={this.props.userpw}
                nickname={this.props.nickname}
                />
                <CustomerInfo
                gender={this.props.gender}
                birth={this.props.birth}
                phone={this.props.phone}
                joindate={this.props.joindate}
                addr={this.props.addr}
                addr2={this.props.addr2}
                point={this.props.point}
                role={this.props.role}
                /> */

                <TableRow>
                <TableCell> {this.props.id}</TableCell>
                <TableCell> <img src={this.props.profile} alt="profile"/></TableCell>
                <TableCell> {this.props.username}</TableCell>
                <TableCell> {this.props.userid}</TableCell>
                <TableCell> {this.props.userpw}</TableCell>
                <TableCell> {this.props.nickname}</TableCell>
                <TableCell> {this.props.gender}</TableCell>
                <TableCell> {this.props.birth}</TableCell>
                <TableCell> {this.props.phone}</TableCell>
                <TableCell> {this.props.joindate}</TableCell>
                <TableCell> {this.props.addr}</TableCell>
                <TableCell> {this.props.addr2}</TableCell>
                <TableCell> {this.props.point}</TableCell>
                <TableCell> {this.props.role}</TableCell>
                </TableRow>
       
        )
    }
    
}

class CustomerProfile extends React.Component {
    render() {
    return (
    <div>
    <p>{this.props.id}</p>
    <img src={this.props.profile} alt="profile"/>
    <h2>{this.props.username}({this.props.userid})</h2>
    <p>{this.props.userpw}</p>
    <p>{this.props.nickname}</p>
    
    </div>
    )
    }
    }
    
    class CustomerInfo extends React.Component {
    render() {
    return (
    <div>
    <p>{this.props.gender}</p>
    <p>{this.props.birth}</p>
    <p>{this.props.phone}</p>
    <p>{this.props.joindate}</p>
    <p>{this.props.addr}</p>
    <p>{this.props.addr2}</p>
    <p>{this.props.point}</p>
    <p>{this.props.role}</p>
    </div>
    )
    }
    }
export default Customer;
