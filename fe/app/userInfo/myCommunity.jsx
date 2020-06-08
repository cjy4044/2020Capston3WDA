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

import "./myProgram.css";

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
class MyCommunity extends Component {
    
    constructor(props){
        super(props);
        this.state = { community: [] , pageNum: 1 , count: 0, modal : false };
     
        // document.getElementById("register_form").addEventListener("submit",this.result_submit.bind(this));

    }
 

 
    async componentDidMount(){
         let {data: community} = await axios.get('/userInfo/myCommunity/axios')
      
        this.setState({community})
        console.log({community})
        
    }
    result_submit(e){

        // if(!confirm("이미지를 변경 하시겠습니까?")) return;
 
    }
     insert(){
        // const select  =  {"select" : c.c_id}
        // if(!confirm(c.c_program+"을 등록하시겠습니까?")) return;
    
        // axios.post('/userInfo/communityConfirm/', select)
        // .then((response)=>{
        //     if(response.data.errorMessage){
        //         alert(response.data.errorMessage);
        //         // window.location.href="/vote";
        //         window.location.reload();
        //     }else{
        //         alert(response.data.message);
        //         window.location.reload();
                
        //     }
        // });

    };
   

    render() {
        return(
            <div id="tablebox">

              {/* <Pagination count={this.state.count} page={this.state.pageNum} onChange={this.pagenation.bind(this)}> </Pagination> */}

                <div>
                    
                    <Index community={this.state.community}/>    
             
                </div>
                            <a onClick={this.insert.bind(this)}>인기인 추가</a>
           



        </div>
        )
     
    }
}
class Index extends Component{
    constructor(props){
        super(props);
       this.props.community
       this.state = { modal : false };
  
      // document.getElementById("register_form").addEventListener("submit",this.result_submit.bind(this));
    }

    // result_submit(e){
       
    //  alert("승인하였습니다.");
  
        
    // } 
   


    handleOpenModal(c){
       this.setState({modal:true});
      
      };
      handleCloseModal(){
        this.setState({modal:false});
      };
  

    render(){
         console.log(this.props.community)
         return this.props.community.map((c,index)=>{
            if (c.name != 0){
                return (
                    <div key={c.name+index} className="card_div"> 
                        <ItemCard4 key={c.img} img={c.img} name={c.name}/>
                    </div>
                )
            }
        })
    }
        
    
}

ReactDOM.render(<MyCommunity/>,document.getElementById('my'));
