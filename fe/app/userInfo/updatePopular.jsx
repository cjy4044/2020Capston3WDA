import React, {Component}from 'react'
import ReactDOM from 'react-dom';

import ItemCard4 from '../items/itemCard4.jsx';

import jQuery from "jquery";

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
class UpdatePopular extends Component {
    
    constructor(props){
        super(props);
        this.state = {};
     
   

    }
 
    async componentDidMount(){
        
    }
    render() {


        return(
        <div id="tablebox">
              
                    test


        </div>
        )
     
    }
}

ReactDOM.render(<UpdatePopular/>,document.getElementById('popular'));
