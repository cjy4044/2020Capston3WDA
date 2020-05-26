
import React, {Component}from 'react'
import ReactDOM from 'react-dom';

import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableBody from '@material-ui/core/TableBody';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';

import Pagination from '@material-ui/lab/Pagination';

import 'bootstrap/dist/css/bootstrap.css';

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');

  
class UserIndex extends Component {
    constructor(props){
        super(props);
        this.state = { profile: [] , pageNum: 1 , count: 0};
        this.url = '/userProfile/axios?page='+(this.state.pageNum-1)+'&size='+10+'&sort="id"';
    }
    setUrl(){
        this.url = '/userProfile/axios?page='+(this.state.pageNum-1)+'&size='+10+'&sort="id"';
    }

    haha(e,page){
        console.log(page)
        this.state.pageNum = page
        this.setUrl()   
        this.componentDidMount()
    }

    async componentDidMount(){
        let {data : profile} = await axios.get(this.url)
        this.state.count = Math.ceil((profile.pop()*1.0)/10)
        this.setState({profile})
        
    }
    render() {
        return(
                <div>
                    <Pagination count={this.state.count} page={this.state.pageNum} onChange={this.haha.bind(this)}> </Pagination>
 
                         <Paper >
                            <Table>
                            <TableHead>
                                <TableRow>
                                            <TableCell>번호</TableCell>
                                            <TableCell>프로필사진</TableCell>
                                            <TableCell>성명</TableCell>
                                            <TableCell>아이디</TableCell>
                                            <TableCell>닉네임</TableCell>
                                            <TableCell>성별</TableCell>
                                            <TableCell>생년월일</TableCell>
                                            <TableCell>연락처</TableCell>
                                            <TableCell>가입일</TableCell>
                                            <TableCell>주소</TableCell>
                                            <TableCell>상세주소</TableCell>
                                            <TableCell>포인트</TableCell>
                                            <TableCell>권한번호</TableCell>
                                </TableRow>
                                </TableHead>
                                <TableBody>
                                             <Index profile={this.state.profile}/>    
                                </TableBody>
                                    </Table>
                                    </Paper>



                </div>
        )
     
    }
}
class Index extends Component{
    constructor(props){
        super(props);
       this.props.profile
       
    }

  

    render(){
         console.log(this.props.profile)
                    return  this.props.profile.map((p,index)=>{
                       
                        return (
                            
                            <TableRow key={'div'+index}>
                                <TableCell key={index}>{p.r_id}</TableCell>
                                <TableCell><img src={p.profile} alt="profile"/></TableCell>
                                <TableCell>{p.username}</TableCell>
                                <TableCell>{p.userid}</TableCell>
                                <TableCell>{p.nickname}</TableCell>
                                <TableCell>{p.gender}</TableCell>
                                <TableCell>{p.birth}</TableCell>
                                <TableCell>{p.phone}</TableCell>
                                <TableCell>{p.joindate}</TableCell>
                                <TableCell>{p.addr}</TableCell>
                                <TableCell>{p.addr2}</TableCell>
                                <TableCell>{p.point}</TableCell>
                                <TableCell>{p.role}</TableCell>
                            </TableRow>
                            
                        )
                    })
                }
            
        
    
}


ReactDOM.render(<UserIndex/>,document.getElementById('userIndex'));