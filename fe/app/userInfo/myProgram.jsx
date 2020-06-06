
import React, {Component}from 'react'
import ReactDOM from 'react-dom';

import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableBody from '@material-ui/core/TableBody';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';

import Pagination from '@material-ui/lab/Pagination';
import ItemCard3 from '../items/itemCard3_big.jsx';

import "./myProgram.css";
const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
class MyProgram extends Component {
    
    constructor(props){
        super(props);
        this.state = { program: [] };
     
        document.getElementById("register_form").addEventListener("submit",this.result_submit.bind(this));

    }
 

 
    async componentDidMount(){
        let {data: program} = await axios.get('/userInfo/myProgram/axios')
      
        this.setState({program})
        
    }
    result_submit(e){

        if(!confirm("이미지를 변경 하시겠습니까?")) return;
 
    }
   

    render() {
        console.log(this.state.program.id)
        return(
                <div>
                  
                            <div>
                            <span> 대표이미지 </span> 
                            <ItemCard3 name="file" img={this.state.program.img}/> 
                            <input type="file" name="file"></input>
                            </div>

                            <div>
                            <span> 프로그램명 </span> 
                            <input type="text" name="name" defaultValue={this.state.program.name}></input>
                            </div>
                           

                            <div>
                            <span> 카테고리 </span> 
                            <input type="text" name="category" defaultValue={this.state.program.category}></input>
                            
                            </div>
                            <input type="hidden" name="id" value={this.state.program.id}></input>
                            <input type="hidden" name="img" value={this.state.program.img}></input>

                            <button className="submit_button" type="submit">변경하기</button>
                            {/* <input type="submit" value="변경" onClick={this.update.bind(this,program)}></input> */}
                            
                           


                </div>
        )
     
    }
}
class Index extends Component{
    constructor(props){
        super(props);
       this.props.program
       
    }

  

    render(){
         console.log(this.props.program)
                    return  this.props.program.map((p,index)=>{
                       
                        return (
                            
                            <TableRow key={'div'+index}>
                                
                               
                                <TableCell> <ItemCard3 img={p.img}/></TableCell>
                                <TableCell >{p.name}</TableCell>
                                <TableCell >{p.category}</TableCell>
                            </TableRow>
                            
                        )
                    })
                }
            
        
    
}


ReactDOM.render(<MyProgram/>,document.getElementById('myprogram'));
