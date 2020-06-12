import React, {Component}from 'react'
import ReactDOM from 'react-dom';

import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableBody from '@material-ui/core/TableBody';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';

import Pagination from '@material-ui/lab/Pagination';

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
var url = document.location.href;
const num = url.split('/');
var param = num[num.length-1];
var param2 = num[num.length-2];

class PopularBoard extends Component {
    
    constructor(props){
        
        super(props);
        this.state = { popularBoard: [] , pageNum: 1 , count: 0, allCount:0};
        this.url = '/community/'+param2+'/'+param+'/axios?page='+(this.state.pageNum-1)+'&size='+10+'&sort="id"';
    }
    setUrl(){
        this.url = '/community/'+param2+'/'+param+'/axios?page='+(this.state.pageNum-1)+'&size='+10+'&sort="id"';
        
 
    }
    pagenation(e,page){
        //console.log(page)
        this.state.pageNum = page
        this.setUrl()   
        this.componentDidMount()
    }

    async componentDidMount(){
        
        let {data : popularBoard} = await axios.get(this.url)
        
        this.state.allCount = (popularBoard.pop())
        this.state.count = Math.ceil((this.state.allCount*1.0)/10)
        
        this.setState({popularBoard})

        console.log(popularBoard)



    }

    render() {
        
        return(
        <div>
            <Pagination count={this.state.count} page={this.state.pageNum} onChange={this.pagenation.bind(this)}> </Pagination>
 
                         <Paper >
                            <Table size="small" id="myTable">
                            <TableHead>
                                <TableRow>
                                            <TableCell>번호</TableCell>
                                            <TableCell>제목</TableCell>
                                            <TableCell>작성일</TableCell>
                                            <TableCell>조회수</TableCell>
                                            <TableCell>댓글수</TableCell>
                                            <TableCell>작성자</TableCell>
                                </TableRow>
                                </TableHead>
                                <TableBody>
                                             <Index   popularBoard={this.state.popularBoard} allCount={this.state.allCount} 
                                             pageNum={this.state.pageNum}/>   
                                </TableBody>
                                    </Table>
                                    </Paper> 

                                    <button type="button">글 등록</button>     
        </div> 
         )
    }
}
     
class Index extends Component{
    constructor(props){
        super(props);
       this.props.popularBoard
       this.props.allCount
       this.props.pageNum
       this.state = { modal : false , count:0};
  
       //document.getElementById("register_form").addEventListener("submit",this.result_submit.bind(this));
    }

    result_submit(e){
       
     alert("승인하였습니다.");
  
        
    } 

    sendSelect(c){
        const select  =  {"select" : c.c_id}
        if(!confirm(c.c_program+"을 등록하시겠습니까?")) return;
    
        axios.post('/userInfo/popularBoardConfirm/', select)
        .then((response)=>{
            if(response.data.errorMessage){
                alert(response.data.errorMessage);
                // window.location.href="/vote";
                window.location.reload();
            }else{
                alert(response.data.message);
                window.location.reload();
                
            }
        });

    };

    render(){
         //console.log(this.props.popularBoard)
         console.log(this.props.pageNum)
                    return  this.props.popularBoard.map((c,index)=>{
                       
                        return (
                            
                            <TableRow key={'div'+index}>

                                <TableCell key={index}>{c.rownum}</TableCell>
                                <TableCell><a href={`${param}/${c.id} `}>{c.title}</a></TableCell>
                                <TableCell>{c.date}</TableCell>
                                <TableCell>{c.viewCount} </TableCell>
                                <TableCell>{c.replyCount}</TableCell>
                                <TableCell>{c.r_id}</TableCell>
                             
                             </TableRow>
                             
                            
                        )
                           
                    })
                  
                   
                     
                }
            
        
    
}
  


ReactDOM.render(<PopularBoard/>,document.getElementById('popularBoard'));