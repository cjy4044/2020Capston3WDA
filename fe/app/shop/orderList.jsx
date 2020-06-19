import React from 'react';
import ReactDOM from 'react-dom';
const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
import jQuery from "jquery";
window.$ = window.jQuery = jQuery;

import './css/show.css'



var url = document.location.href;
const num = url.split('/');
var param = num[num.length-1];

class OrderList extends React.Component {
    constructor(props){
        super(props)
        this.state ={sub:[], info:[],prd:{}, option:[], color:[],size:[], manager:{}};
        this.colorTag;
        
    }
    async componentDidMount(){    
        let {data} = await axios.get('/shop/orderList/axios');
        
    }
 
    render() {
        
        return (
            <div>
                
            </div>
            
        )
    }
}

ReactDOM.render(<OrderList/>,document.getElementById('orderList'));

