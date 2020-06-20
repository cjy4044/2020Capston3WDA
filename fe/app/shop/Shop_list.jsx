import React, { Fragment } from 'react';
import ReactDOM from 'react-dom';
import Header_top from './Header_top.js';
import Header_middle from './Header_middle.js';
import Header_bottom from './Header_bottom.js';
import SliderFrame from './SliderFrame'
import Footer from './Footer.js';
import Footer2 from './Footer2.js';
import Chat from './Chat.jsx';
import Section from './Section.js'
const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
// import Section from './shop/section'
// import 'bootstrap/dist/css/bootstrap.min.css';
// import './css/animate.css';
// import './css/main.css';
// import './css/responsive.css';
// import './js/jquery';
class Shop_list extends React.Component {
    constructor(props) {
        super(props);
        this.state = { data: [], recommend: [] }
    }

    async componentDidMount() {
        // let { data } = await axios.get("/shop/index/axios");
        // console.log(data);
        // this.setState({ data });
    }

    render() {
            return (
                <Fragment>
                    <Header_top></Header_top>
                    <Header_middle></Header_middle>
                    <Header_bottom></Header_bottom>
                    <SliderFrame></SliderFrame>
                    {/* <Section data={this.state.data}></Section> */}
                    <Footer></Footer>
                    <Footer2></Footer2>
                    <Chat></Chat>
                </Fragment>
            )
        
    }
}



ReactDOM.render(<Shop_list />, document.getElementById('Shop_list'));