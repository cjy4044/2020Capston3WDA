
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

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
class MyProgram extends Component {
    
    constructor(props){
        super(props);
        this.state = { program: [] };
     
    }
 

 
    async componentDidMount(){
        let {data: program} = await axios.get('/userInfo/myProgram/axios')
      
        this.setState({program})
        
    }
    render() {
        
        return(
                <div>
                    
                         <Paper>
                            <Table id="myTable">
                            <TableHead>
                                <TableRow>
                                            <TableCell>프로그램프로필</TableCell>
                                            <TableCell>프로그램이름</TableCell>
                                            <TableCell>카테고리</TableCell>
                                            <TableCell>관리자이름</TableCell>
                                </TableRow>
                                </TableHead>
                                <TableBody>
                                            <TableCell> <ItemCard3 img={this.state.program.img}/></TableCell>
                                            <TableCell>{this.state.program.name}</TableCell>
                                            <TableCell>{this.state.program.category}</TableCell>
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
