import React from 'react'
import ReactDOM from 'react-dom';
import jQuery from "jquery";
import Graph from '../items/stateGraph.jsx'
import OrderStateItem from './orderStateItem.jsx'
window.$ = window.jQuery = jQuery;

import './orderState.css'

// npm i @bit/nexxtway.react-rainbow.chart
const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');


var stateData=
{
    labels: ['5 ~ 4달 전', '4 ~ 3달 전', '3 ~ 2달 전', '2 ~ 1달 전', '1달전 ~ 현재'],
    datasets: [

    ],
};


class ManageOrderState extends React.Component{
    constructor(props){
        super(props);
        this.state = {item:[],dataSetState:0}
    }
    async componentDidMount(){
        
        this.setData();

    }
    async setData(){
        let {data} = await axios.get('/userInfo/manage/manageOrderState/axios');
        console.log(data);

        data.map((state)=>{
            var color = '#'+Math.round(Math.random() * 0xffffff).toString(16);
            var set = {
                title: state.name,
                borderColor: color,
                values: [state.five,state.four,state.three,state.two,state.one]
            }
            
            stateData.datasets.push(set);
        })
        this.setState({item:data,dataSetState:0})
    }
    
    render() {
        // console.log(this.state.vote)
        return(
            <div>
                <div>주문추이</div>
                <div className="graphDiv">
                    <Graph data={stateData}/>
                </div>
                <div className="itemDiv">
                    <OrderStateItem data={this.state.item}/>
                </div>
                
            </div>
        )
    }
}




ReactDOM.render(<ManageOrderState/>, document.getElementById('manageOrderState'));