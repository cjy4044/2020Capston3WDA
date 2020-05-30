import React from 'react';
import ReactDOM from 'react-dom';
import ItemCard2 from './items/test.jsx';
import Section from './shop_layout';
const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');

class Asdf extends React.Component{
    constructor(props){
        super(props);
        this.state = {data:[]}
    }


    async componentDidMount(){
        let {data} = await axios.get("/shop/cart/axios");
        console.log(data);
        this.setState({data});
    }
    render(){
        return this.state.data.map((prd,index)=>{
            return (
                <ItemCard2 name={prd.name} price={prd.price} img={prd.img}></ItemCard2>
                <Section></Section>
                // <div key={"div"+index}>
                //     <div>{prd.name}</div>    
                //     <div>{prd.price}</div>    
                //     <div>{prd.img}</div>    
                // </div>
            )
        })
        
    }
}

ReactDOM.render(<Asdf/>,document.getElementById('asdf'));
