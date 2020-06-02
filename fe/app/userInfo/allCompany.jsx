
import React, {Component}from 'react'
import ReactDOM from 'react-dom';

import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableBody from '@material-ui/core/TableBody';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';

import Pagination from '@material-ui/lab/Pagination';
import './../programRegister/Modal.css';

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
class AllCompany extends Component {
    
    constructor(props){
        super(props);
        this.state = { company: [] , pageNum: 1 , count: 0, modal : false };
        this.url = '/userInfo/axios3?page='+(this.state.pageNum-1)+'&size='+10+'&sort="id"';
    }

    setUrl(){
        this.url = '/userInfo/axios3?page='+(this.state.pageNum-1)+'&size='+10+'&sort="id"';
    }

    pagenation(e,page){
        console.log(page)
        this.state.pageNum = page
        this.setUrl()   
        this.componentDidMount()
    }
    


    async componentDidMount(){
        let {data : company} = await axios.get(this.url)
        this.state.count = Math.ceil((company.pop()*1.0)/10)
        this.setState({company})
        
    }
    
    render() {
        
        return(
                <div>
                    <Pagination count={this.state.count} page={this.state.pageNum} onChange={this.pagenation.bind(this)}> </Pagination>
 
                         <Paper >
                            <Table id="myTable">
                            <TableHead>
                                <TableRow>
                                            <TableCell>번호</TableCell>
                                            <TableCell>카테고리</TableCell>
                                            <TableCell>프로그램명</TableCell>
                                            <TableCell>예상시작기간</TableCell>
                                            <TableCell>예상종료기간</TableCell>
                                            <TableCell>회원번호</TableCell>
                                            <TableCell>사업자번호</TableCell>
                                            <TableCell>회사명</TableCell>
                                            <TableCell>회사정보</TableCell>
                                            <TableCell>대표자성함</TableCell>
                                            <TableCell>회사연락처</TableCell>
                                            <TableCell>예상금액</TableCell>
                                            <TableCell>승인여부</TableCell>
                                            <TableCell>승인</TableCell>
                                </TableRow>
                                </TableHead>
                                <TableBody>
                                             <Index   company={this.state.company}/>    
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
       this.props.company
       this.state = { modal : false };
  
       
    }

    handleOpenModal(){
        this.setState({modal:true});
      
      };
      handleCloseModal(){
        this.setState({modal:false});
      };
  

    render(){
         console.log(this.props.company)
                    return  this.props.company.map((c,index)=>{
                       
                        return (
                            
                            <TableRow key={'div'+index}>
                             
                                <TableCell key={index}>{index+1}</TableCell>
                                <TableCell>{c.c_category}</TableCell>
                                <TableCell> <a href="/"> {c.c_program}> </a> </TableCell>
                                <TableCell>{c.c_startdate}</TableCell>
                                <TableCell>{c.c_enddate}</TableCell>
                                <TableCell>{c.r_id}</TableCell>
                                <TableCell>{c.c_id}</TableCell>
                                <TableCell>{c.c_name}</TableCell>
                                <TableCell>{c.c_content}</TableCell>
                                <TableCell>{c.c_reader}</TableCell>
                                <TableCell>{c.c_phone}</TableCell>
                                <TableCell>{c.c_budget}</TableCell>
                                <TableCell>{c.c_confirm}</TableCell>
                                <TableCell><button onClick={this.handleOpenModal.bind(this)}>확인</button>
                               
                                 </TableCell>
                                 {this.state.modal && (  
                                 <div className="MyModal">
                                      <div className="content">
                                  <input type="hidden" value={c.c_id}></input>
                                  {c.c_name}을 등록하시겠습니까?
                                  
                                  <button className="submit_button" type="submit">신청하기</button> 
                                  <button onClick={this.handleCloseModal.bind(this)}>닫기</button>
                                  </div>
                                 </div>  )}{} 
                               
                             
                               
                             </TableRow>
                             
                            
                        )
                           
                    })
                  
                   
                     
                }
            
        
    
}


ReactDOM.render(<AllCompany/>,document.getElementById('allCompany'));
