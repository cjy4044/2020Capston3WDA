import React, {Component}from 'react'
import ReactDOM from 'react-dom';

import PopularItem from './popularItem.jsx';


const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');

var url = document.location.href;
const num = url.split('/');
var param = num[num.length-1];

class Index extends Component {
    
    constructor(props){
        super(props);
        this.state = { program:[], hotclib:[] , popular: [] };
    }

    async componentDidMount(){
        let {data: program} = await axios.get('/community/'+param+'/axios')
        this.setState({program})    
        console.log({program})
        

        let {data: popular} = await axios.get('/community/'+param+'/popular/axios')  
        this.setState({popular})
        console.log({popular})


    }

    render() {
        
        return(
        <div className="community_item">
            



            <div >
                    <PopularItem data={this.state.popular}/>
            </div>

         </div> )
    }
}
     
  


ReactDOM.render(<Index/>,document.getElementById('communityIndex'));
