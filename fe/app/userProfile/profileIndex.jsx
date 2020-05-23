import React, {Component}from 'react'
import ReactDOM from 'react-dom';

import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableBody from '@material-ui/core/TableBody';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';



const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');

  
class UserIndex extends Component {
    constructor(props){
        super(props);
        this.state = { profile: [] };
    }

    async componentDidMount(){
        let {data : profile} = await axios.get('/userProfile/axios');

        this.setState({profile});
        
    }
    render() {
        const { profile } = this.state;
        return profile.map((tt,index)=>{
            return (
                
                <TableRow key={'div'+index}>
                    <TableCell key={index}>{tt.r_id}</TableCell>
                    <TableCell><img src={tt.profile} alt="profile"/></TableCell>
                    <TableCell>{tt.username}</TableCell>
                    <TableCell>{tt.userid}</TableCell>
                    <TableCell>{tt.nickname}</TableCell>
                    <TableCell>{tt.gender}</TableCell>
                    <TableCell>{tt.birth}</TableCell>
                    <TableCell>{tt.phone}</TableCell>
                    <TableCell>{tt.joindate}</TableCell>
                    <TableCell>{tt.addr}</TableCell>
                    <TableCell>{tt.addr2}</TableCell>
                    <TableCell>{tt.point}</TableCell>
                    <TableCell>{tt.role}</TableCell>


                </TableRow>
                 
            )
        })
      }
}
class Index extends Component{
    render(){
           return(
            <div>
                <Paper >
                  {/* className={classes.table} */}
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
                   <UserIndex/>
                   </TableBody>
                     </Table>
                     </Paper>

              
                  
            </div>
            
        )
    }
}


ReactDOM.render(<Index/>,document.getElementById('userIndex'));

