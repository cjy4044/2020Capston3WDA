import React, {Component}from 'react'
import ReactDOM from 'react-dom';

import PopularItem from './popularItem.jsx';


import Pagination from '@material-ui/lab/Pagination';

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');

var url = document.location.href;
const num = url.split('/');
var param = num[num.length-1];

class Index extends Component {
    
    constructor(props){
        super(props);
        this.state = { program:[], hotclib:[] , count: 0, popular: [] ,pageNum: 1 ,allCount:0};
        this.url = '/community/'+param+'/popular/axios?page='+(this.state.pageNum-1)+'&size='+10+'&sort="id"';
    }

    async componentDidMount(){
        
        let {data: program} = await axios.get('/community/'+param+'/axios')
        
        this.setState({program})    
        
                                
        let {data: popular} = await axios.get(this.url)
        this.state.allCount = (popular.pop())
        console.log(this.state.allCount)
        this.state.count = Math.ceil((this.state.allCount*1.0)/10)

        this.setState({popular})
        console.log(this.state.count)

    


    }
    setUrl(){
        this.url = '/community/'+param+'/popular/axios?page='+(this.state.pageNum-1)+'&size='+10+'&sort="id"';

    }
    pagenation(e,page){
        //console.log(page)
        this.state.pageNum = page
        this.setUrl()   
        this.componentDidMount()
    }

    render() {
        
        return(
        <div className="community_item">
            
            <div id="popular">
           
            <PopularItem data={this.state.popular}/>
            <Pagination count={this.state.count} page={this.state.pageNum} onChange={this.pagenation.bind(this)}> </Pagination>
                   
            </div>

         </div> )
    }
}
     
  


ReactDOM.render(<Index/>,document.getElementById('communityIndex'));
