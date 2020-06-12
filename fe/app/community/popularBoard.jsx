import React, {Component}from 'react'
import ReactDOM from 'react-dom';

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
class PopularBoard extends Component {
    
    constructor(props){
        
        super(props);
        this.state = { data: [] };
    }
    async componentDidMount(){

    }

    render() {
        
        return(
        <div>
sss
        </div> 
         )
    }
}
     
  


ReactDOM.render(<PopularBoard/>,document.getElementById('popularBoard'));
