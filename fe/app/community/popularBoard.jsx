import React, {Component}from 'react'
import ReactDOM from 'react-dom';

import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableBody from '@material-ui/core/TableBody';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';

import Pagination from '@material-ui/lab/Pagination';

import TextField from '@material-ui/core/TextField';
import FilledInput from '@material-ui/core/FilledInput';

import './Modal.css';

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
var url = document.location.href;
const num = url.split('/');
var param = num[num.length-1];
var param2 = num[num.length-2];



class PopularBoard extends Component {
    
    constructor(props){
        
        super(props);
        this.state = { popularBoard: [] , pageNum: 1 , count: 0, allCount:0, modal : false, file : '', previewURL:''};
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
    handleOpenModal(){
        this.setState({modal:true});
      };
      handleCloseModal(){

        this.setState({modal:false});
      };  

      checkImage(event){

        event.preventDefault();
        let reader = new FileReader();
        let file = event.target.files[0];

        reader.onloadend = () => {
          this.setState({
            file : file,
            previewURL : reader.result
          })
        }
        reader.readAsDataURL(file);
      }

    render() {
        let profile_preview = null;
        if(this.state.file !== ''){
          profile_preview = <img  className='profile_preview' src={this.state.previewURL}></img>
        }
        
        return(
        <div>
            <Pagination count={this.state.count} page={this.state.pageNum} onChange={this.pagenation.bind(this)}> </Pagination>
 
                         <Paper >
                            <Table size="small" id="myTable">
                            <TableHead>
                                <TableRow>
                                            <TableCell>번호</TableCell>
                                            <TableCell>제목</TableCell>
                                            <TableCell>작성자</TableCell>
                                            <TableCell>댓글수</TableCell>
                                            <TableCell>조회수</TableCell>
                                            <TableCell>작성일</TableCell>

                                </TableRow>
                                </TableHead>
                                <TableBody>
                                             <Index   popularBoard={this.state.popularBoard} allCount={this.state.allCount} 
                                             pageNum={this.state.pageNum}/>   
                                </TableBody>
                                    </Table>
                                    </Paper> 
                                <button onClick={this.handleOpenModal.bind(this)}>등록</button>

                  {this.state.modal && (
                   <div className="MyModal"> 
                      <div className="content">

                      
                      
                      <TextField id="standard-secondary" fullWidth label="제목" color="primary" required />
                      {profile_preview}
                      <TextField
                            id="outlined-multiline-static"
                            // error={this.state.data.customer === "" ? true : false
                            label="내용"
                            multiline
                            rows={8}
                            fullWidth
                            placeholder="Default Value"
                            required
                            />
                        <input type="file" name="img2" accept="image/*" onChange={this.checkImage.bind(this)}/>
       
                                  
                        <button formAction={'/community/'+param2+'/'+param+'/create'} >등록</button>   
                        <button type="button" onClick={this.handleCloseModal.bind(this)}>닫기</button>
                     
                      </div>
                  </div> )}{""}   
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

    }


    render(){
         //console.log(this.props.popularBoard)
         console.log(this.props.pageNum)
                    return  this.props.popularBoard.map((c,index)=>{
                       
                        return (
                            
                            <TableRow key={'div'+index}>

                                <TableCell key={index}>{c.rownum}</TableCell>
                                <TableCell ><a href={`${param}/${c.id} `}>{c.title}</a></TableCell>
                                <TableCell>{c.nickname}</TableCell>
                                <TableCell>{c.replyCount}</TableCell>
                                <TableCell>{c.viewCount} </TableCell>
                                <TableCell>{c.date}</TableCell>
                             </TableRow>
                             
                            
                        )
                           
                    })
                  
                   
                     
                }
            
        
    
}
  


ReactDOM.render(<PopularBoard/>,document.getElementById('popularBoard'));