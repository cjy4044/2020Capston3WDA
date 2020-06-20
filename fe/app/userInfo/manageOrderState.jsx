import React from 'react'
import ReactDOM from 'react-dom';
import jQuery from "jquery";

window.$ = window.jQuery = jQuery;


const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');

class ManageOrderState extends React.Component{
    constructor(props){
        super(props);

    }
    async componentDidMount(){
        let {data} = await axios.get('/userInfo/manage/manageOrderState/axios');
        console.log(data);

        // data.map((item)=>{

        // })

    }
    
    render() {
        // console.log(this.state.vote)
        return(
               <div>주문추이</div>
        )
    }
}




ReactDOM.render(<ManageOrderState/>, document.getElementById('manageOrderState'));