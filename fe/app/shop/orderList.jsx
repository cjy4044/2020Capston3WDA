import React from 'react';
import ReactDOM from 'react-dom';
import Pagination from '@material-ui/lab/Pagination';
import jQuery from "jquery";
window.$ = window.jQuery = jQuery;

import OrderListItem from './orderListItem.jsx'


const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');


var url = document.location.href;
const num = url.split('/');
var param = num[num.length-1];

class OrderList extends React.Component {
    constructor(props){
        super(props)
        this.state = { item: [], pageNum: 1 , count: 0};

        this.url = '/shop/orderList/axios?page='+(this.state.pageNum-1)+'&size='+5+'&sort="id"';
    }

    setUrl(){
        this.url = '/shop/orderList/axios?page='+(this.state.pageNum-1)+'&size='+5+'&sort="id"';
    }
    async componentDidMount(){    
        this.getItems();
        
        
        
    }
    async getItems(){
        let {data} = await axios.get(this.url);
        console.log(data);
        this.state.count = Math.ceil((data.count*1.0)/5)
        this.setState({prd : data.orderList})
        // this.setState({item:d})
    }
    pagenation(e,page){
        console.log(page)
        this.state.pageNum = page
        this.setUrl()   
        this.getItems()
    }
 
    render() {
        
        return (
            <div>
                주문 리스트

                <OrderListItem data={this.state.prd}/>
                <Pagination count={this.state.count} page={this.state.pageNum} onChange={this.pagenation.bind(this)}> </Pagination>
            </div>
            
        )
    }
}

ReactDOM.render(<OrderList/>,document.getElementById('orderList'));

