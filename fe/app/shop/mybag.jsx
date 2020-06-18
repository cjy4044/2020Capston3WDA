import React from 'react';
import ReactDOM from 'react-dom';
import BagItem from './bagItem.jsx';
import Pagination from '@material-ui/lab/Pagination';

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
import jQuery from "jquery";
window.$ = window.jQuery = jQuery;

class Mybag extends React.Component {
    constructor(props){
        super(props)
        this.state = { mybags: [], pageNum: 1 , count: 0};
        this.url = '/shop/mybag/axios?page='+(this.state.pageNum-1)+'&size='+3+'&sort="id"';
    }
    setUrl(){
        this.url = '/shop/mybag/axios?page='+(this.state.pageNum-1)+'&size='+3+'&sort="id"';
    }
    async componentDidMount(){
        this.getMybags();
    }

    async getMybags(){ 
        let {data} = await axios.get(this.url)
        console.log("----------",data);
        this.state.count = Math.ceil((data.count*1.0)/3)
        this.setState({mybags : data.mybags})
    }

    pagenation(e,page){
        console.log(page)
        this.state.pageNum = page
        this.setUrl()   
        this.getMybags()
    }
    render() {
        
        return (
            <div>
                <div> 장바구니 </div>
                <BagItem data={this.state.mybags}/>
                <Pagination count={this.state.count} page={this.state.pageNum} onChange={this.pagenation.bind(this)}> </Pagination>
            </div>
            
        )
    }
}

ReactDOM.render(<Mybag/>,document.getElementById('mybag'));