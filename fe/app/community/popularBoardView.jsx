import React, {Component}from 'react'
import ReactDOM from 'react-dom';

import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableBody from '@material-ui/core/TableBody';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';

import Pagination from '@material-ui/lab/Pagination';
import ItemCard4 from '../items/itemCard4.jsx';

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
var url = document.location.href;
const num = url.split('/');
var param = num[num.length-1];
var param2 = num[num.length-2];
var param3 = num[num.length-3];

class PopularBoardView extends Component {
    
    constructor(props){
        
        super(props);
        this.state = { popularBoard: [] , pageNum: 1 , count: 0, allCount:0 ,board :"" , update:false,data:[]};
      }

    async componentDidMount(){
  
        let {data: data} = await axios.get(`/community/${param3}/${param2}/${param}/axios`)  

        this.state.popularBoard = (data.pop())
        this.setState({data})
        console.log(this.state.popularBoard);
        console.log(this.state.data);
        //this.setState({popularBoard})

        //this.state.board = `/community/${param3}/${param2}`
 

        

    }
    goBack(){
        location.href=this.state.board;

    }
    update(){
        this.setState({update:true});  
    }

    render() {
        
        return(
        <div>
              <Paper >
                            <Table size="small">
                            <TableHead>
                                <TableRow>
                                {this.state.update && <TableCell colSpan="5"><input type="text" name="name" defaultValue={this.state.popularBoard.title} required/></TableCell>}
                                {!this.state.update &&<TableCell colSpan="5">{this.state.popularBoard.title}</TableCell>}
                                </TableRow>  
                                </TableHead> 

                               

                                <TableBody>

                                <TableRow>
                                <TableCell>{this.state.popularBoard.nickname}</TableCell>
                                <TableCell>{this.state.popularBoard.date}</TableCell>
                                <TableCell>{this.state.popularBoard.mdate}</TableCell>
                                {/* {this.state.popularBoard.viewCount && this.state.popularBoard.viewCount }{} */}
                                <TableCell>{this.state.popularBoard.viewCount}</TableCell>
                                <TableCell>{this.state.popularBoard.replyCount}</TableCell>
                                </TableRow> 
                                
                                {/* <ItemCard4 key={c.img} img={c.img} name={c.name} /> */}
                                
                                
                                {this.state.data.map((c,index)=>{
                       
                                    return (
                                
                                        <TableRow key={'div'+index}>
                                                <ItemCard4 key={c.img} img={c.filename} />
                                          
                                        </TableRow>                                           
                                
                                        )
                                            
                                    })}
                                 {/* {this.state.data!=null && <TableCell colSpan="5">{this.state.data}</TableCell>}                      */}
                            
                               
                                <TableRow>
                                {this.state.update && <TableCell colSpan="5" rowSpan="200"><input type="text" name="name" defaultValue={this.state.popularBoard.content} required/></TableCell>}
                                {!this.state.update &&<TableCell colSpan="5" rowSpan="200">{this.state.popularBoard.content}</TableCell>}                             
                                </TableRow>  
                         

                                </TableBody>
                                    </Table>
                                    </Paper> 
                                <input type="hidden" value={this.state.popularBoard.id}/>
                                <input type="hidden" value={this.state.popularBoard.popular_id}/>
                               
                                
                                {/* 게시글작성자 or 관리자 or 매니저일경우 수정삭제가능 */}
                                {(this.state.popularBoard.r_id==this.state.popularBoard.sessionUser||
                                this.state.popularBoard.sessionRole==1||
                                this.state.popularBoard.sessionUser==this.state.popularBoard.managerId)&&
                                <div>
                               
                                <button type="button" onClick={this.update.bind(this)}>수정</button>
                                {this.state.update && <button formAction={'/community/'+param3+'/'+param2+'/create'} >확인</button>}
                                <button type="button">삭제</button>
                                </div>
                                 }{
                                 <div><button type="button" onClick={this.goBack.bind(this)}>글 목록</button></div>}
                               
                                  
        </div> 
         )
    }
}
  

ReactDOM.render(<PopularBoardView/>,document.getElementById('popularBoardView'));